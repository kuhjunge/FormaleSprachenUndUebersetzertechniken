/**
 * Define a grammar called Expr 
 * Wihle und Do While erweiterung
 * JUNIT Test (JUNIT 5)
 * JUNIT Params Runner 
 * (TESTNG)
 */
grammar C;
r  : allTokens+ | ignoreThings+;        	// match keyword hello followed by an identifier

allTokens: OPERATOR | OPERAND;
ignoreThings: IGNORE;

OPERATOR:  RESERVEDT | TYPE_QUAL | SCSPEC | OPERATORS;
OPERAND: CONSTANT | TYPESPEC | IDENTIFIER;
IGNORE: IGNORESYMBOLS | INCLUDE |  WHITESPACEP | COMMENT | LINE_COMMENT | INT | FLOAT;

RESERVEDT : 'if(' | 'asm' | 'break'|
'case'| 'class'| 'continue'| 'default'| 'delete'| 'while('| 'else'| 'enum' | 'for(' |
'goto'|  'new'| 'operator'| 'private'| 'protected'| 'public'| 'return'|
'sizeof'| 'struct'| 'switch('| 'this'| 'union'|'namespace'| 'using'| 'try'| 'catch'|
'throw'| 'const_cast'| 'static_cast'| 'dynamic_cast'| 'reiznterpret_cast'|
'typeid'| 'template'| 'explicit'| 'true'| 'false'| 'typename' ;

OPERATORS : '!'|'!='|'%'|'%='|'&'|'&&'|'&='|'*'|'*='
|'+'|'++'|'+='|','|'-'|'--'|'-='|'->'|'...'|'/'
|'/='|'::'|'<'|'<<'|'<<='|'<='|'=='|'>'|'>='|'>>'
|'>>='|'?'|'['|'^'|'^='|'{'|'||'|'='|'~'|';'|'(' ;

TYPE_QUAL: 'const'|'friend'|'volatile';

SCSPEC : 'auto'|'extern'|'inline'|'register'|'static'|'typedef'|'virtual'|'mutable';

CONSTANT: LETTERBIG(LETTERBIG|DIGIT)* | DIGIT+ | FLOAT ;

TYPESPEC: 'bool'|'char'|'double'|'folat'|'int'|'ong'|'short'|'signed'|'unsigned'|'void';

IDENTIFIER: LETTER(LETTER|DIGIT)*;

FLOAT: DIGIT+ '.' DIGIT* // match 1. 39. 3.14159 etc...
| '.' DIGIT+ // match .1 .14159
| '-' DIGIT+ '.' DIGIT* 
;

INT : DIGIT+;				// match 1 or more digits
LINE_COMMENT : '//' ~[\r\n]* -> skip;
COMMENT : '/*' .*? '*/' -> skip;
IGNORESYMBOLS: '}' |')'| ']' | ':' | 'do' -> skip;
INCLUDE: '#INCLUDE'.*? '\n' -> skip;
WHITESPACEP: (WHITESPACE+) -> skip;

fragment DIGIT : [0-9] ;	// match 1 digit
fragment LETTER: [a-zA-Z_];
fragment LETTERBIG: [A-Z_];
fragment WHITESPACE : [ \t\r\n] ;
