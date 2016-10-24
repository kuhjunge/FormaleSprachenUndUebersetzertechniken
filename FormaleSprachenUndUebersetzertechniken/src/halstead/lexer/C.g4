/**
 * Define a grammar called Expr 
 * Wihle und Do While erweiterung
 * JUNIT Test (JUNIT 5)
 * JUNIT Params Runner 
 * (TESTNG)
 */
grammar C;
r  : test+ ;        	// match keyword hello followed by an identifier

test: INT
	| FLOAT
	| OPERATOR
	| OPERAND
	| IGNORE
	;

IGNORE: IGNORESYMBOLS | INCLUDE | | WHITESPACE+ | COMMENT | LINE_COMMENT;
OPERATOR: OPERATORS | RESERVED | TYPE_QUAL | SCSPEC;
OPERAND: CONSTANT | TYPESPEC | IDENTIFIER;

OPERATORS : '!'|'!='|'%'|'%='|'&'|'&&'|'&='|'('|'*'|'*='
|'+'|'++'|'+='|','|'-'|'--'|'-='|'->'|'...'|'/'
|'/='|'::'|'<'|'<<'|'<<='|'<='|'=='|'>'|'>='|'>>'
|'>>='|'?'|'['|'^'|'^='|'{'|'||'|'='|'~'|';' ;

RESERVED : 'asm' | 'break'|
'case'| 'class'| 'continue'| 'default'| 'delete'| 'while('| 'else'| 'enum' | 'for(' |
'goto'| 'if('| 'new'| 'operator'| 'private'| 'protected'| 'public'| 'return'|
'sizeof'| 'struct'| 'switch('| 'this'| 'union'|'namespace'| 'using'| 'try'| 'catch'|
'throw'| 'const_cast'| 'static_cast'| 'dynamic_cast'| 'reiznterpret_cast'|
'typeid'| 'template'| 'explicit'| 'true'| 'false'| 'typename' ;

TYPE_QUAL: 'const'|'friend'|'volatile';

SCSPEC : 'auto'|'extern'|'inline'|'register'|'static'|'typedef'|'virtual'|'mutable';

CONSTANT: LETTERBIG(LETTERBIG|DIGIT)* | DIGIT+ | FLOAT ;

TYPESPEC: 'bool'|'char'|'double'|'folat'|'int'|'ong'|'short'|'signed'|'unsigned'|'void';

IDENTIFIER: LETTER(LETTER|DIGIT)*;

IGNORESYMBOLS: '}' |')'| ']' | ':' | 'do';
INCLUDE: '#INCLUDE'.*? '\n' ;

FLOAT: DIGIT+ '.' DIGIT* // match 1. 39. 3.14159 etc...
| '.' DIGIT+ // match .1 .14159
| '-' DIGIT+ '.' DIGIT* 
;

INT : DIGIT+;				// match 1 or more digits
LINE_COMMENT : '//' .*? '\n' -> skip ;
COMMENT : '/*' .*? '*/' -> skip ;
//IGNORE : ( WHITESPACE+ ) -> skip ; 	// skip spaces, tabs, newlines

fragment DIGIT : [0-9] ;	// match 1 digit
fragment LETTER: [a-zA-Z_];
fragment LETTERBIG: [A-Z_];
fragment WHITESPACE : [ \t\r\n]  ;

