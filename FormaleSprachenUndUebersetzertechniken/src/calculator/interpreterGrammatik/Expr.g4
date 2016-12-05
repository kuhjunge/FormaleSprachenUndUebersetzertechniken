/** Grammar from tour chapter augmented with actions */
grammar Expr;

@header {
import java.util.*;
}

@parser::members {
    /** "memory" for our calculator; variable/value pairs go here */
    Map<String, Integer> memory = new HashMap<String, Integer>();

    int eval(int left, int op, int right) {
        switch ( op ) {
            case MUL : return (left * right);
            case DIV : return left / right;
            case ADD : return (left + right);
            case SUB : return left - right;
            case GRE : if (left > right){return 1; } else {return 0;}
            case SMA : if (right > left){return 1; } else {return 0;}
            case EXP : return (int)Math.pow(left,right);
        }
        return 0;
    }
    
    int evalUnaer(int left, int op) {
        switch ( op ) {
            case SUB : return - left;
        }
        return 0;
    }
    
    int visitClear(){
		memory.clear();
		return 0;
	}
}

prog:   stat+ ;

stat:   e NEWLINE           {System.out.println($e.v);}
    |   ID '=' e NEWLINE    {memory.put($ID.text, $e.v);}
    |   NEWLINE                   
    | 	clear
    ;

clear: '#' {visitClear();};

e returns [int v]
    : <assoc=right>a=e op='^' b=e  {$v = eval($a.v, $op.type, $b.v);}
    | a=e op=('<'|'>') b=e  {$v = eval($a.v, $op.type, $b.v);}
    | a=e op=('*'|'/') b=e  {$v = eval($a.v, $op.type, $b.v);}
    | a=e op=('+'|'-') b=e  {$v = eval($a.v, $op.type, $b.v);}
    | op='-' a=e {$v = evalUnaer($a.v, $op.type);} 
    | INT                   {$v = $INT.int;}    
    | ID
      {
      String id = $ID.text;
      $v = memory.containsKey(id) ? memory.get(id) : 0;
      }
    | '(' e ')'             {$v = $e.v;}       
    ; 

SMA : '<' ;
GRE : '>' ;
EXP : '^' ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

ID  :   [a-zA-Z]+ ;      // match identifiers
INT :   [0-9]+ ;         // match integers
NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
WS  :   [ \t]+ -> skip ; // toss out whitespace
