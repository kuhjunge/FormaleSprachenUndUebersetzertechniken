package muell.exprLexer;

public class Token {
	private int type;
	private String text;
    
	public Token(int type, String text) {
   	 	this.type=type;
   	 	this.text=text;
   	}
    
   public int getType()		{ return this.type; }
    
   public String getText()	{ return this.text; }
    
   @Override
public String toString() {
   		String tname = ExprLexerOld.tokenNames[this.type];
   		return "<'"+this.text+"',"+tname+">";
   }
}