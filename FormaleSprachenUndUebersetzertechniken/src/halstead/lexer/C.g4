/**
 * Define a grammar called C 
 */
lexer grammar C;
/*r  : allTokens+ ;        	// match keyword hello followed by an identifier

allTokens: OPERATOR | OPERAND | IGNORE;*/

OPERATOR:  RESERVED | TYPE_QUAL | SCSPEC | OPERATORS;
IGNORE: (COMMENT | LINE_COMMENT | IGNORESYMBOLS2 | IGNORESYMBOLS | INCLUDE | ALOTOFWHITESPACE )
	 -> skip;
OPERAND:  TYPESPEC | IDENTIFIER | INT | FLOAT | CONSTANT | STRING ;

fragment RESERVED : 'if' WHITESPACE* '(' | 'if' | 'asm' | 'break'|
 'case'| 'class'| 'continue'| 'default'| 'delete'| 'while' WHITESPACE* '('| 'else'|
 'enum' | 'for' WHITESPACE* '(' | 'goto'|  'new'| 'operator'| 'private'| 'protected'|
 'public'| 'return'|'sizeof'| 'struct'| 'switch' WHITESPACE* '('| 'this'| 'union'|
 'namespace'| 'using'| 'try'| 'catch'|'throw'| 'const_cast'| 'static_cast'|
 'dynamic_cast'| 'reiznterpret_cast'|'typeid'| 'template'| 'explicit'| 'true'|
 'false'| 'typename';

fragment OPERATORS :  '!'|'!='|'%'|'%='|'&'|'&&'|'&='|'*'|'*='|'+'|'++'|'+='|','|'-'|
 '--'|'-='|'->'|'...'|'/'|'/='|'::'|'<'|'<<'|'<<='|'<='|'=='|'>'|'>='|'>>'|'>>='|'?'|
 '['|'^'|'^='|'{'|'||'|'='|'~'|';' | '(' ;

fragment TYPE_QUAL: 'const'|'friend'|'volatile';
fragment SCSPEC : 'auto'|'extern'|'inline'|'register'|'static'|'typedef'|'virtual'|'mutable';
fragment IGNORESYMBOLS2 : 'do';
fragment CONSTANT: LETTERBIG(LETTERBIG|DIGIT)* | DIGIT+ | FLOAT ;
fragment TYPESPEC: 'bool'|'char'|'double'|'folat'|'int'|'ong'|'short'|'signed'|'unsigned'|'void';
fragment IDENTIFIER: LETTER(LETTER|DIGIT)*;
fragment FLOAT: DIGIT+ '.' DIGIT* | '.' DIGIT+ | '-' DIGIT+ '.' DIGIT* ;

fragment STRING : '"' .*? '"' | '\'' .*? '\'' ;
fragment INT : DIGIT+;
fragment LINE_COMMENT : '//' ~[\r\n]*;
fragment COMMENT : '/*' .*? '*/';
fragment INCLUDE: ('#INCLUDE'.*? '\n' | '#include'.*? '\n');
fragment ALOTOFWHITESPACE: (WHITESPACE+);
fragment IGNORESYMBOLS: ('}' |')'| ']' | ':' | '\\' |['] );

fragment DIGIT : [0-9] ;
fragment LETTER: [a-zA-Z_];
fragment LETTERBIG: [A-Z_];
fragment WHITESPACE : [ \t\r\n] ;