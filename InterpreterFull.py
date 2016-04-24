__author__ = 'VISHAL'
import re
import shlex

'''
High level:-
-----------

number a=10
number b=20
condition(b>a)
{
    display b
}
else
{
	display a
}
'''

program = """START PROG
PUSH 10
STORE A
PUSH 1
STORE B
PUSH 0
STORE GLOB_COND
START IF ID1
PUSH B
PUSH A
GT
STORE GLOB_COND
JNE END_ID1
PUSH B
DISP
END ID1
START ELSE-IF ID2
PUSH B
PUSH A
EQ
STORE GLOB_COND
JNE END_ID2
PUSH 1
DISP
END ID2
START ELSE ID3
PUSH A
DISP
END ID3
END PROG""".split('\n')

'''
High level:-
-----------

read x
number i = x
number fact = 1
while(i > 1)
{
    fact = fact * i
    i = i - 1
}
display fact
'''

program1 = """START PROG
ASK
STORE I
PUSH 1
STORE fact
START LOOP ID1
PUSH I
PUSH 1
GT
JNE END_ID1
PUSH fact
PUSH I
MUL
STORE fact
PUSH I
PUSH 1
SUB
STORE I
JMP START_ID1
END ID1
PUSH fact
DISP
END PROG""".split('\n')

programTest = """START PROG
PUSH 1
STORE I
START FUNC TEST
PUSH 7
STORE I
END TEST
START FUNC TEST1
PUSH I
DISP I
END TEST1
PUSH "Test         display"
DISP
END PROG""".split('\n')

programFunc = """START PROG
START FUNC HELLO
STORE I
PARAMOVER
PUSH I
PUSH 1
GT
JNER 1
PUSH I
PUSH 1
SUB
STORE Y
CALL HELLO Y
STORE K
PUSH I
PUSH K
MUL
STORE R
RET R
END HELLO
CALL HELLO 5
STORE F
PUSH "Factorial is:"
DISP
PUSH F
DISP
END PROG""".split('\n')

programFuncRetTest = """START PROG
START FUNC TEST
STORE I
PARAMOVER
START LOOP ID1
PUSH I
PUSH 1
ADD
STORE I
PUSH I
PUSH 5
EQ
JER I
PUSH I
PUSH 7
LT
JNE END_ID1
JMP START_ID1
END ID1
END TEST
CALL TEST 1
STORE J
PUSH J
DISP
END PROG""".split('\n')


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
        # tokens = shlex.split(line)
        opcode = tokens.pop(0)
        if hasattr(self, opcode):
            getattr(self, opcode)(tokens)
        else:
            print "bad opcode : ", opcode

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
            if self.listSymbolTable[0].map["GLOB_COND"] == 1:
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
                i = self.lookup(val)
                if i >= 0:
                    tempStack.insert(0, self.listSymbolTable[i].map[val])
                else:
                    print val, " is undefined"
                    exit()
        self.listSymbolTable.insert(0, SymbolTable(True))
        self.listSymbolTable[0].stack = tempStack

    def PARAMOVER(self, args):
        if len(self.listSymbolTable[0].stack) > 0:
            print "invalid function call"
            exit()

    def ASK(self, args):
        self.PUSH(raw_input())

    def PUSH(self, args):
        if len(re.findall(r'\"(.+?)',args[0])) >= 1:
            str = shlex.split(self.line)
            self.listSymbolTable[0].stack.insert(0, str[1])
            return
        try:
            x = int(args[0])
            self.listSymbolTable[0].stack.insert(0, x)
        except ValueError:
            i = self.lookup(args[0])
            if i >= 0:
                self.listSymbolTable[0].stack.insert(0, self.listSymbolTable[i].map[args[0]])
            else:
                print args[0], " is undefined"
                exit()

    def lookup(self, x):
        i = 0
        foundFunc = 0
        while i < len(self.listSymbolTable):
            if self.listSymbolTable[i].isProgORFunc == True:
                foundFunc = foundFunc + 1
            if foundFunc > 1:
                break
            if x in self.listSymbolTable[i].map:
                return i
            i = i + 1

        if x in self.listSymbolTable[len(self.listSymbolTable) - 1].map:
            return len(self.listSymbolTable) - 1
        else:
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

    def JNE(self, args):
        if self.listSymbolTable[0].stack[0] != 1:
            newIp = self.createMapForLabels.labelAddress[args[0]]
            self.ip = newIp

    def JE(self, args):
        if self.listSymbolTable[0].stack[0] == 1:
            newIp = self.createMapForLabels.labelAddress[args[0]]
            self.ip = newIp

    def JNER(self, args):
        if self.listSymbolTable[0].stack[0] != 1:
            self.RET(args)

    def JER(self, args):
        if self.listSymbolTable[0].stack[0] == 1:
            self.RET(args)

    def RET(self, args):
        val = args[0]
        try:
            retValue = int(val)
        except ValueError:
            i = self.lookup(val)
            if i >= 0:
                retValue = self.listSymbolTable[i].map[val]
            else:
                print val, " is undefined"
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

    def STORE(self, args):
        if len(self.listSymbolTable[0].stack) < 1:
            print "Nothing in stack!"
            exit()
        try:
            val = int(self.listSymbolTable[0].stack.pop(0))
        except ValueError:
            print "Invalid Initialization"
            exit()
        self.listSymbolTable[0].map[args[0]] = val
        if len(self.listSymbolTable) > 1:
            self.updateGlobal(args[0], val)

    def updateGlobal(self, var, val):
        globalSymbolTable = self.listSymbolTable[len(self.listSymbolTable) - 1]
        if var in globalSymbolTable.map:
            globalSymbolTable.map[var] = val

    def DISP(self, args):
        print self.listSymbolTable[0].stack.pop(0)

    def END(self, args):
        if args[0] == "PROG":
            exit()
        if self.listSymbolTable[0].isProgORFunc == True:
            self.ip = self.ep.pop(0)
        self.listSymbolTable.pop(0)

test = InterpreterFull(programFunc, False)
test.run()
