/**
 * Define a grammar called Hello
 */
 
grammar Hello;

r 
	: (statement | function)* 
	;
	
function 
	: type? IDENTIFIER params body
	;
	
params 
	: '(' paramList? ')'
	;
	
paramList
	: formalParameter (',' formalParameter)*
	;

formalParameter
	: type IDENTIFIER
	;
	
body 
	: '{' statement* '}'
	;
	
statement
	: variableDeclaration 
	| varaiableInitialization 
	| conditionalStatement 
	| loopStatement
	| expression
	| print
	;
	
print
	: 'display' IDENTIFIER 
	| 'display' message
	;
	
message
	: ' \" ( )*? \" '
	;



loopStatement: 'loop' parExpression '{' (statement)* '}';
parExpression: '(' expression ')';
expression
	: primary 
	| expression relationalOp expression 
	| expression 'and' expression 
	| expression 'or' expression
	| expression arithmeticOp expression
	;
	
relationalOp
	: '<'
	| '<='
	| '>'
	| '>='
	| '=='
	| '!='
	;

arithmeticOp
	: '+'
	| '-'
	| '*'
	| '/'
	;
	
primary
	: '(' expression ')' 
	| IDENTIFIER
	| integerLiteral 
	;
	
integerLiteral
	: (digit)+
	;
	
digit 
	: '0' 
	| '1' 
	| '2' 
	| '3' 
	| '4' 
	| '5' 
	| '6' 
	| '7' 
	| '8' 
	| '9'
	;

conditionalStatement
	: 'condition' parExpression '{' (statement)* '}' ('else-condition' parExpression '{' (statement)* '}')? ('else' '{' (statement)* '}')?
	;

varaiableInitialization
	: type IDENTIFIER '=' expression | IDENTIFIER '=' expression
	;

variableDeclaration
	: type IDENTIFIER
	;
	
type
	: 'number'
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

