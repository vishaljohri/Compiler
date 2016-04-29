__author__ = 'VISHAL'
import re
import shlex
import sys


class SymbolTable:
    def __init__(self, isProgORFunc = False):
        self.stack = []
        self.map = {}
        self.isProgORFunc = isProgORFunc


class LabelMap:
    def __init__(self, program, debug = True):
        self.labelAddress = {}
        self.program = program
        self.debug = debug

    def createMap(self):
        for ip in range(len(self.program)):
            line = self.program[ip]
            tokens = line.split()
            if tokens[0] == "START" and tokens[1] != "PROG":
                self.labelAddress["START_" + tokens[2]] = ip
            elif tokens[0] == "END" and tokens[1] != "PROG":
                self.labelAddress["END_" + tokens[1]] = ip
            if self.debug:
                print ip, " : ", line


class InterpreterFull:

    def __init__(self, program, debug = True):
        self.ip = 0
        self.ep = []
        self.listSymbolTable = []
        self.debug = debug
        self.program = program
        self.createMapForLabels = LabelMap(self.program, False)
        self.createMapForLabels.createMap()
        self.line = ""

    def step(self):
        self.line = self.program[self.ip]
        self.ip = self.ip + 1
        tokens = self.line.split()
        opcode = tokens.pop(0)
        if hasattr(self, opcode):
            getattr(self, opcode)(tokens)
        else:
            print "Program terminated. Bad opcode : ", opcode
        if self.debug:
            print self.ip, " : ", self.line, " : ", "stack values : ", self.listSymbolTable[0].stack, " variables: ", self.listSymbolTable[0].map

    def run(self):
        while self.ip < len(self.program):
            self.step()

    def START(self, args):
        if args[0] == "PROG":
            self.listSymbolTable.insert(0, SymbolTable(True))
        elif args[0] == "FUNC":
            self.ip = self.createMapForLabels.labelAddress["END_" + args[1]] + 1
        elif args[0] == "ELSE-IF" or args[0] =="ELSE":
            if self.listSymbolTable[len(self.listSymbolTable) - 1].map["GLOB_COND"] == 1:
                self.ip = self.createMapForLabels.labelAddress["END_" + args[1]] + 1
            else:
                self.listSymbolTable.insert(0, SymbolTable())
        else:
            self.listSymbolTable.insert(0, SymbolTable())

    def CALL(self, args):
        self.ep.insert(0, self.ip)
        self.ip = self.createMapForLabels.labelAddress["START_" + args.pop(0)] + 1
        tempStack = []
        while len(args) >= 1:
            val = args.pop()
            try:
                x = int(val)
                tempStack.insert(0, x)
            except ValueError:
                if val == "GLOB":
                    isPresent = self.findGlobal(args[0])
                    if isPresent == False:
                        print "Program terminated. Global variable not present: ", args[1]
                        exit()
                    tempStack.insert(0, self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[0]])
                    args.pop()
                else:
                    i = self.lookup(val)
                    if i >= 0:
                        tempStack.insert(0, self.listSymbolTable[i].map[val])
                    else:
                        print "Program terminated. Variable is undefined: ", val
                        exit()
        self.listSymbolTable.insert(0, SymbolTable(True))
        self.listSymbolTable[0].stack = tempStack

    def PARAMOVER(self, args):
        if len(self.listSymbolTable[0].stack) > 0:
            print "Program terminated. Invalid function call"
            exit()

    def ASK(self, args):
        inputList = []
        inputList.insert(0, raw_input())
        self.PUSH(inputList)

    def PUSH(self, args):
        if len(re.findall(r'\"(.+?)',args[0])) >= 1:
            str = shlex.split(self.line)
            self.listSymbolTable[0].stack.insert(0, str[1])
            return
        try:
            x = int(args[0])
            self.listSymbolTable[0].stack.insert(0, x)
        except ValueError:
            if args[0] == "True" or args[0] =="False":
                self.listSymbolTable[0].stack.insert(0, args[0])
            elif args[0] == "GLOB":
                isPresent = self.findGlobal(args[1])
                if isPresent == False:
                    print "Program terminated. Global variable not present: ", args[1]
                    exit()
                self.listSymbolTable[0].stack.insert(0, self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[1]])
            else:
                i = self.lookup(args[0])
                if i >= 0:
                    self.listSymbolTable[0].stack.insert(0, self.listSymbolTable[i].map[args[0]])
                else:
                    print "Program terminated. Local variable undefined: ", args[0]
                    exit()

    def findGlobal(self, var):
        if var in self.listSymbolTable[len(self.listSymbolTable) - 1].map:
            return True
        else:
            return False

    def lookup(self, x):
        i = 0
        foundFunc = 0
        while i < len(self.listSymbolTable):
            if foundFunc == 1:
                break
            if self.listSymbolTable[i].isProgORFunc == True:
                foundFunc = foundFunc + 1
            if x in self.listSymbolTable[i].map:
                return i
            i = i + 1
        return -1

    def ADD(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        self.listSymbolTable[0].stack.insert(0, a + b)

    def SUB(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        self.listSymbolTable[0].stack.insert(0, a - b)

    def MUL(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        self.listSymbolTable[0].stack.insert(0, a * b)

    def DIV(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        self.listSymbolTable[0].stack.insert(0, a / b)

    def GT(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        if a > b:
            self.listSymbolTable[0].stack.insert(0, 1)
        else:
            self.listSymbolTable[0].stack.insert(0, 0)

    def GTE(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        if a >= b:
            self.listSymbolTable[0].stack.insert(0, 1)
        else:
            self.listSymbolTable[0].stack.insert(0, 0)

    def LT(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        if a < b:
            self.listSymbolTable[0].stack.insert(0, 1)
        else:
            self.listSymbolTable[0].stack.insert(0, 0)

    def LTE(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        if a <= b:
            self.listSymbolTable[0].stack.insert(0, 1)
        else:
            self.listSymbolTable[0].stack.insert(0, 0)

    def EQ(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        if a == b:
            self.listSymbolTable[0].stack.insert(0, 1)
        else:
            self.listSymbolTable[0].stack.insert(0, 0)

    def NEQ(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        if a != b:
            self.listSymbolTable[0].stack.insert(0, 1)
        else:
            self.listSymbolTable[0].stack.insert(0, 0)

    def JMP(self, args):
        newIp = self.createMapForLabels.labelAddress[args[0]]
        self.ip = newIp
        if "LOOP" in self.program[self.ip]:
            self.ip = self.ip + 1

    def JNE(self, args):
        if self.listSymbolTable[0].stack[0] != 1:
            newIp = self.createMapForLabels.labelAddress[args[0]]
            self.ip = newIp

    def JE(self, args):
        if self.listSymbolTable[0].stack[0] == 1:
            newIp = self.createMapForLabels.labelAddress[args[0]]
            self.ip = newIp

    def RET(self, args):
        val = args[0]
        try:
            retValue = int(val)
        except ValueError:
            if args[0] == "GLOB":
                isPresent = self.findGlobal(args[1])
                if isPresent == False:
                    print "Program terminated. Global variable not present: ", args[1]
                    exit()
                retValue = self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[1]]
            else:
                i = self.lookup(args[0])
                if i >= 0:
                    retValue = self.listSymbolTable[i].map[args[0]]
                else:
                    print "Program terminated. Local variable undefined: ", args[0]
                    exit()
        while self.listSymbolTable[0].isProgORFunc != True:
            self.listSymbolTable.pop(0)
        self.ip = self.ep.pop(0)
        self.listSymbolTable.pop(0)
        self.listSymbolTable[0].stack.insert(0, retValue)


    def AND(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        if a == 1 and b == 1:
            self.listSymbolTable[0].stack.insert(0, 1)
        else:
            self.listSymbolTable[0].stack.insert(0, 0)

    def OR(self, args):
        a = self.listSymbolTable[0].stack[1]
        b = self.listSymbolTable[0].stack[0]
        if a == 1 or b == 1:
            self.listSymbolTable[0].stack.insert(0, 1)
        else:
            self.listSymbolTable[0].stack.insert(0, 0)

    def PEEK(self, args):
        if len(args) < 2:
            print "Program terminated. Invalid PEEK statement"
            exit()
        if args[1] == "GLOB":
            isPresent = self.findGlobal(args[2])
            if isPresent == False:
                print "Program terminated. Global stack variable not present: ", args[2]
                exit()
            list = self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[2]]
            if len(list) == 0:
                print "Program terminated. Empty stack variable:", args[2]
                exit()
            self.listSymbolTable[0].stack.insert(0, list[0])
        else:
            i = self.lookup(args[1])
            if i >= 0:
                list = self.listSymbolTable[i].map[args[1]]
                if len(list) == 0:
                    print "Program terminated. Empty stack variable:", args[1]
                    exit()
                self.listSymbolTable[0].stack.insert(0, list[0])
            else:
                print "Program terminated. Stack variable is undefined:", args[1]
                exit()

    def POP(self, args):
        if len(args) < 2:
            print "Program terminated. Invalid POP statement"
            exit()
        if args[1] == "GLOB":
            isPresent = self.findGlobal(args[2])
            if isPresent == False:
                print "Program terminated. Global stack variable not present: ", args[2]
                exit()
            list = self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[2]]
            if len(list) == 0:
                print "Program terminated. Empty stack variable:", args[2]
                exit()
            self.listSymbolTable[0].stack.insert(0, list.pop(0))
            self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[2]] = list
        else:
            self.listSymbolTable[0].stack = []
            if args[1] in self.listSymbolTable[0].map:
                list = self.listSymbolTable[0].map[args[1]]
                if len(list) == 0:
                    print "Program terminated. Empty stack variable:", args[1]
                    exit()
                self.listSymbolTable[0].stack.insert(0, list.pop(0))
                self.listSymbolTable[0].map[args[1]] = list
            if len(self.listSymbolTable) > 1:
                self.updateParentsRemoveValues(args[1])
            if len(self.listSymbolTable[0].stack) == 0:
                print "Program terminated. Stack variable not present:", args[1]
                exit()

    def updateParentsRemoveValues(self, var):
        if self.listSymbolTable[0].isProgORFunc != True:
            i = 1
            foundFunc = 0
            while i < len(self.listSymbolTable):
                if foundFunc == 1:
                    break
                if self.listSymbolTable[i].isProgORFunc == True:
                    foundFunc = foundFunc + 1
                if var in self.listSymbolTable[i].map:
                    list = self.listSymbolTable[i].map[var]
                    if len(list) == 0:
                        print "Program terminated. Empty stack variable:", var
                        exit()
                    self.listSymbolTable[0].stack.insert(0, list.pop(0))
                    self.listSymbolTable[i].map[var] = list
                i = i + 1

    def STORE(self, args):
        isStack = False
        if len(self.listSymbolTable[0].stack) < 1:
            print "Program terminated. Nothing in stack"
            exit()
        try:
            topValue = self.listSymbolTable[0].stack[0]
            val = int(self.listSymbolTable[0].stack.pop(0))
        except ValueError:
            self.listSymbolTable[0].stack.insert(0, topValue)
            if self.listSymbolTable[0].stack[0] == "True" or self.listSymbolTable[0].stack[0] == "False":
                val = self.listSymbolTable[0].stack.pop(0)
            else:
                print "Program terminated. Invalid Initialization"
                exit()
        if args[0] == "GLOB":
            isPresent = self.findGlobal(args[1])
            if isPresent == False:
                print "Program terminated. Global variable not present: ", args[1]
                exit()
            self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[1]] = val
        elif args[0] == "STACK":
            isStack = True
            if args[1] == "GLOB":
                isPresent = self.findGlobal(args[2])
                if isPresent == False:
                    print "Program terminated. Global stack variable not present: ", args[2]
                    exit()
                list = self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[2]]
                list.insert(0, val)
                self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[2]] = list
            else:
                if args[1] not in self.listSymbolTable[0].map:
                    list = []
                else:
                    list = self.listSymbolTable[0].map[args[1]]
                list.insert(0, val)
                self.listSymbolTable[0].map[args[1]] = list
                if len(self.listSymbolTable) > 1:
                    self.updateParentsAddValues(args[1], val, isStack)
        elif args[0] == "GLOB_COND":
            self.listSymbolTable[len(self.listSymbolTable) - 1].map[args[0]] = val
            self.listSymbolTable[0].stack.insert(0, val)
        else:
            self.listSymbolTable[0].map[args[0]] = val
            if len(self.listSymbolTable) > 1:
                self.updateParentsAddValues(args[0], val, isStack)

    def updateParentsAddValues(self, var, val, isStack):
        if self.listSymbolTable[0].isProgORFunc != True:
            i = 1
            foundFunc = 0
            while i < len(self.listSymbolTable):
                if foundFunc == 1:
                    break
                if self.listSymbolTable[i].isProgORFunc == True:
                    foundFunc = foundFunc + 1
                if var in self.listSymbolTable[i].map:
                    if isStack:
                        list = self.listSymbolTable[i].map[var]
                        list.insert(0, val)
                        self.listSymbolTable[i].map[var] = list
                        self.listSymbolTable[0].map[var] = list
                    else:
                        self.listSymbolTable[i].map[var] = val
                i = i + 1

    def DISP(self, args):
        if len(self.listSymbolTable[0].stack) == 0:
            print "Program terminated. Nothing to display"
        print self.listSymbolTable[0].stack.pop(0)

    def END(self, args):
        if args[0] == "PROG":
            exit()
        if self.listSymbolTable[0].isProgORFunc == True:
            self.ip = self.ep.pop(0)
        self.listSymbolTable.pop(0)

progName = sys.argv[1]
intermediateProg = [line.strip() for line in open(progName, 'r')]
test = InterpreterFull(intermediateProg, False)
test.run()