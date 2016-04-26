/**
 * Define a grammar called Hello
 */
 
grammar Hello;

vsc 
	: 'START PROG' (statement | function)* 'END PROG'
	;
	
function 
	: 'def' IDENTIFIER params body
	;
	
params 
	: '(' paramList? ')'
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
	| conditionalStatement 
	| loopStatement
	| expression
	| print
	| funcCall
	|'return'
	|'return' IDENTIFIER 
	;
	
funcCall
	: IDENTIFIER params;

	
print
	: 'display' IDENTIFIER 
	| 'display' message
	| 'display' DIGIT
	;
	
message
	: ' \" ( )*? \" '
	;

loopStatement
	: 'loop' parExpression loopStart (statement)* loopend
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
	: 'condition' parExpression conditionalStart (statement)* conditionalEnd ('else-condition' parExpression conditionalStart  (statement)* conditionalEnd)* ('else' conditionalStart (statement)* conditionalEnd)?
	;
	
conditionalStart
	:  '{'
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
	: IDENTIFIER '=' expression | IDENTIFIER '=' expression
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