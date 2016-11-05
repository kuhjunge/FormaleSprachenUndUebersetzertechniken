grammar ExprRecog;
r  : allTokens+ ;
allTokens: IGNORE;

NL: [\n];  
IGNORE: ( WHITESPACE+ ) -> skip;  

fragment DIGIT : [0-9];	// match 1 digit
fragment LETTER: [a-zA-Z_];
fragment LETTERBIG: [A-Z_];
fragment WHITESPACE : [ \t\r];
