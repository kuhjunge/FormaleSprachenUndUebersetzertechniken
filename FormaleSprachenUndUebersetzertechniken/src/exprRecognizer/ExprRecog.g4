grammar ExprRecog;
/** The start rule; begin parsing here. */
stat: expr NEWLINE
| ID '=' expr NEWLINE
| NEWLINE
;
expr: <assoc=right> expr '^' expr  // ^ operator is right associative
| expr ('*'|'/') expr // match subexpressions joined with '*' operator
| expr ('+'|'-') expr // match subexpressions joined with '+' operator
| expr ('<'|'>') expr
| expr ('=') expr
| FLOAT
| INT
| ID
| '(' expr ')'
;

FLOAT: DIGIT+ '.' DIGIT* | '.' DIGIT+ | '-' DIGIT+ '.' DIGIT* ;
ID : [a-zA-Z]+ ; // match identifiers
INT : DIGIT+ ; // match integers
NEWLINE:'\r'? '\n' ; // return newlines to parser (end-statement signal)
WS : [ \t]+ -> skip ; // toss out whitespace

fragment DIGIT : [0-9] ; // match integers
