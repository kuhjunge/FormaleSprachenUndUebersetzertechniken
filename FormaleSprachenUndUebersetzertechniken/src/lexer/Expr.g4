/**
 * Define a grammar called Hello
 */
grammar Expr;
r  : test+ ;        	// match keyword hello followed by an identifier

test: INT
	| ID
	| PLUS
	| MINUS
	| MUL
	| DIV
	| INV
	| EXP
	| FAC
	| WS
	;

ID : [a-z]+ ;             	// match lower-case identifiers
INT : DIGIT+;				// match 1 or more digits
fragment DIGIT : [0-9] ;	// match 1 digit
PLUS : '+' ;
MINUS : '-' ;
MUL : '*' ;
DIV : '/' ;
INV : '#' ;
EXP : '^' ;
FAC : '!' ;
//LINE_COMMENT : '//' .*? '\n' -> skip ;
//COMMENT : '/*' .*? '*/' -> skip ;
WS : [ \t\r\n]+ -> skip ; 	// skip spaces, tabs, newlines
