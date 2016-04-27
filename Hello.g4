/**
 * Define a grammar called Hello
 */
 
grammar Hello;

vsc 
	: start_prog (statement | function)* end_prog
	;
	
start_prog
	: 'START PROG'
	;
	
end_prog
	: 'END PROG'
	;
	
function 
	: 'def' IDENTIFIER params body
	;

funcCall
	: IDENTIFIER paramsCall
	;
	
paramsCall
	: startbracket paramListCall? endbracket;
	
paramListCall
	: formalParameterCall (',' formalParameterCall)*
	;
	
formalParameterCall
	: IDENTIFIER
	| DIGIT;
	
startbracket
	: '('
	;

endbracket
	: ')'
	;
	
params 
	: startbracket paramList? endbracket
	;
	
paramList
	: formalParameter (',' formalParameter)*
	;

formalParameter
	: IDENTIFIER
	;
	
body 
	: functionStart statement* functionEnd
	;

functionStart
	: '{'
	;

functionEnd
	: '}'
	;
	
statement
	: varaiableInitialization 
	| funcCall
	| conditionalStatement 
	| loopStatement
	| expression
	| print
	| input
	| 'return' retValue?
	| stackOperation
	;
	
retValue
	: IDENTIFIER 
	| integerLiteral
	;

	
stackOperation
	: IDENTIFIER '.' 'push' '('integerLiteral')'
	| IDENTIFIER '.' 'push' '('IDENTIFIER')'
	| stackReturnOp
	;
	
stackReturnOp
	: IDENTIFIER '.' 'pop' '(' ')'
	| IDENTIFIER '.' 'peek' '(' ')'
	;

input
	: 'ask' IDENTIFIER
	;

print
	: 'display' message
	| 'display' IDENTIFIER 
	| 'display' DIGIT
	;
	
message
	: '\"' (.)*? '\"'
	;

loopStatement
	: loop parExpression loopStart (statement)* loopend
	;
	
parExpression
	: '(' expression ')'
	;
	
expression
	: expression relationalOp expression 
	| expression 'and' expression 
	| expression 'or' expression
	| term addOp expression
	| term
	;
	
term
	: factor mulOp term
	| factor;

factor
	: DIGIT
	| IDENTIFIER
	| '(' expression ')'
	;

relationalOp
	: '<'
	| '<='
	| '>'
	| '>='
	| '=='
	| '!='
	;

addOp
	: '+'
	| '-'
	;
	
mulOp
	: '*'
	| '/'
	;

primary
	: '(' expression ')' 
	| IDENTIFIER
	| integerLiteral 
	;
	
integerLiteral
	: (DIGIT)+
	;
	
DIGIT 
	: [0-9]+
	;

conditionalStatement
	: condition parExpression conditionalStart (statement)* conditionalEnd (conditionElse parExpression conditionalStart  (statement)* conditionalEnd)* (els '{' (statement)* conditionalEnd)?
	;

els
	: 'else'
	;
	
condition
	: 'condition'
	;

conditionElse
	: 'else-condition'
	;	
	
conditionalStart
	:  '{'
	;
	
loop
	: 'loop'
	;
	
loopStart
	:  '{'
	;
	
loopend
	:  '}'
	;

conditionalEnd
	: '}'
	;

varaiableInitialization
	: IDENTIFIER '=' funcCall
	| IDENTIFIER '=' expression 
	| IDENTIFIER '=' stackReturnOp 
	;


IDENTIFIER 
	: [a-z|A-Z|_][a-z|A-Z|0-9|_]* 
	;
	
WS 
	: [ \t\r\n]+ -> skip 
	;
	
/*
r  : 'hello' IDENTIFIER 'stop';         // match keyword hello followed by an IDENTIFIERentifier
IDENTIFIER : [a-z]+ ;             // match lower-case IDENTIFIERentifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
*/