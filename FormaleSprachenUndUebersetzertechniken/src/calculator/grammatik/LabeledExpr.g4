grammar LabeledExpr; // rename to distinguish from Expr.g4

prog:   stat+ ;

stat:   expr NEWLINE                # printExpr
    |   ID '=' expr NEWLINE         # assign
    |   NEWLINE                     # blank
    | 	clear						# clean
    ;
 
clear: '#' ;
 
expr: 
 	 <assoc=right> expr op='^' expr # exp
 	|   expr op=('<'|'>') expr		# SmaGre
 	|   expr op=('*'|'/') expr		# MulDiv
 	|   expr op=('+'|'-') expr      # AddSub
    |   op='-' expr      			# sub
    |   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;

SMA :	'<' ;
GRE :   '>' ;
EXP :   '^' ;
MUL :   '*' ; // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
