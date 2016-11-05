/**
 * Define a grammar called C 
 * Wihle und Do While erweiterung
 * JUNIT Test (JUNIT 5)
 * JUNIT Params Runner 
 * (TESTNG)
 */
grammar C;
r  : allTokens+ ;        	// match keyword hello followed by an identifier

allTokens: OPERATOR | OPERAND | IGNORE;

OPERATOR:  RESERVED | TYPE_QUAL | SCSPEC | OPERATORS;
IGNORE: IGNORESYMBOLS2 | INCLUDE |  ALOTOFWHITESPACE | COMMENT | LINE_COMMENT | IGNORESYMBOLS;
OPERAND:  TYPESPEC | IDENTIFIER | INT | FLOAT | STRING | CONSTANT;

RESERVED : 'if' WHITESPACE* '(' | 'if' | 'asm' | 'break'|
'case'| 'class'| 'continue'| 'default'| 'delete'| 'while' WHITESPACE* '('| 'else'| 'enum' | 'for' WHITESPACE* '(' |
'goto'|  'new'| 'operator'| 'private'| 'protected'| 'public'| 'return'|
'sizeof'| 'struct'| 'switch' WHITESPACE* '('| 'this'| 'union'|'namespace'| 'using'| 'try'| 'catch'|
'throw'| 'const_cast'| 'static_cast'| 'dynamic_cast'| 'reiznterpret_cast'|
'typeid'| 'template'| 'explicit'| 'true'| 'false'| 'typename' ;

OPERATORS : '!'|'!='|'%'|'%='|'&'|'&&'|'&='|'*'|'*='
|'+'|'++'|'+='|','|'-'|'--'|'-='|'->'|'...'|'/'
|'/='|'::'|'<'|'<<'|'<<='|'<='|'=='|'>'|'>='|'>>'
|'>>='|'?'|'['|'^'|'^='|'{'|'||'|'='|'~'|';' | '(' ;

TYPE_QUAL: 'const'|'friend'|'volatile';

SCSPEC : 'auto'|'extern'|'inline'|'register'|'static'|'typedef'|'virtual'|'mutable';

IGNORESYMBOLS2 : 'do';

CONSTANT: LETTERBIG(LETTERBIG|DIGIT)* | DIGIT+ | FLOAT ;

TYPESPEC: 'bool'|'char'|'double'|'folat'|'int'|'ong'|'short'|'signed'|'unsigned'|'void';

IDENTIFIER: LETTER(LETTER|DIGIT)*;

FLOAT: DIGIT+ '.' DIGIT* // match 1. 39. 3.14159 etc...
| '.' DIGIT+ // match .1 .14159
| '-' DIGIT+ '.' DIGIT* 
;

STRING : '"' .*? '"' | '\'' .*? '\'' ;
INT : DIGIT+;				// match 1 or more digits
LINE_COMMENT : '//' ~[\r\n]* -> skip;
COMMENT : '/*' .*? '*/' -> skip;
INCLUDE: ('#INCLUDE'.*? '\n' | '#include'.*? '\n') -> skip;
ALOTOFWHITESPACE: (WHITESPACE+) -> skip;
IGNORESYMBOLS: ('}' |')'| ']' | ':' | '\\' |['] ) -> skip;

fragment DIGIT : [0-9] ;	// match 1 digit
fragment LETTER: [a-zA-Z_];
fragment LETTERBIG: [A-Z_];
fragment WHITESPACE : [ \t\r\n] ;
