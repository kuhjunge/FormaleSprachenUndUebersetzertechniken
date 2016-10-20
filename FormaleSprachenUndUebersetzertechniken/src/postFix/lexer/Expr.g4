/**
 * Define a grammar called Expr
 */
grammar Expr;
r  : test+ ;        	// match keyword hello followed by an identifier

test: INT
	| FLOAT
	| PLUS
	| MINUS
	| MUL
	| DIV
	| INV
	| EXP
	| FAC
	| IGNORE
	;

FLOAT: DIGIT+ '.' DIGIT* // match 1. 39. 3.14159 etc...
| '.' DIGIT+ // match .1 .14159
| '-' DIGIT+ '.' DIGIT*
;

INT : DIGIT+ | '-'DIGIT+;				// match 1 or more digits
PLUS : '+' ;
MINUS : '-' ;
MUL : '*' ;
DIV : '/' ;
INV : '#' ;
EXP : '^' ;
FAC : '!' ;
//LINE_COMMENT : '//' .*? '\n' -> skip ;
//COMMENT : '/*' .*? '*/' -> skip ;
IGNORE : ( LETTER+ | WHITESPACE+ ) -> skip ; 	// skip spaces, tabs, newlines

fragment DIGIT : [0-9] ;	// match 1 digit
fragment LETTER: [a-zA-Z];
fragment WHITESPACE : [ \t\r\n]  ;