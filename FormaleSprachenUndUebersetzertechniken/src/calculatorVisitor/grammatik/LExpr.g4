grammar LExpr;

s :   e NEWLINE                 # printExpr
    |   ID '=' e NEWLINE        # assign
    |   NEWLINE                 # blank
    | 	c						# clean
    ;

c: CLEAR 						# clear
	;

e :  <assoc=right> e EXP e 		# exp
 	|   e SMA e					# sma
 	|   e GRE  e	 			# gre
 	|   e MUL e					# mul
  	|   e DIV e					# div
 	|   e ADD e 				# add
 	|   e SUB e  	    		# sub
    |   SUB e      				# minus
    |   INT                     # int
    |   ID                      # Id
    |   '(' e ')'            	# parens
    ;

CLEAR :	'#' ;
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
