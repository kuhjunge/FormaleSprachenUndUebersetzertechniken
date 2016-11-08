grammar ExprRecog;
/** The start rule; begin parsing here. */
r  : stat+;
stat: expr NEWLINE
| ID '=' expr NEWLINE
| NEWLINE
;
expr:<assoc=right> expr '^' expr  // ^ operator is right associative
| expr ('*'|'/') expr // match subexpressions joined with '*' operator
| expr ('+'|'-') expr // match subexpressions joined with '+' operator
| expr ('<'|'>') expr
| expr ('=') expr
| INT
| ID
| '(' expr ')'
;

ID : [a-zA-Z]+ ; // match identifiers
INT : [0-9]+ ; // match integers
NEWLINE:'\r'? '\n' ; // return newlines to parser (end-statement signal)
WS : [ \t]+ -> skip ; // toss out whitespace
