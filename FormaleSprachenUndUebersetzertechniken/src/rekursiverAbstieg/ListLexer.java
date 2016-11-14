package rekursiverAbstieg;

/***
 * Excerpted from "Language Implementation Patterns", published by The Pragmatic
 * Bookshelf. Copyrights apply to this code. It may not be used to create
 * training material, courses, books, articles, and the like. Contact us if you
 * are in doubt. We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book
 * information.
 ***/
public class ListLexer extends Lexer {
	public static int NAME = 2;
	public static int COMMA = 3;
	public static int LBRACK = 4;
	public static int RBRACK = 5;
	public static String[] tokenNames = { "n/a", "<EOF>", "NAME", "COMMA", "LBRACK", "RBRACK" };

	@Override
	public String getTokenName(int x) {
		return tokenNames[x];
	}

	public ListLexer(String input) {
		super(input);
	}

	boolean isLETTER() {
		return this.c >= 'a' && this.c <= 'z' || this.c >= 'A' && this.c <= 'Z';
	}

	@Override
	public Token nextToken() {
		while (this.c != EOF) {
			switch (this.c) {
			case ' ':
			case '\t':
			case '\n':
			case '\r':
				WS();
				continue;
			case ',':
				consume();
				return new Token(COMMA, ",");
			case '[':
				consume();
				return new Token(LBRACK, "[");
			case ']':
				consume();
				return new Token(RBRACK, "]");
			default:
				if (isLETTER())
					return NAME();
				throw new Error("invalid character: " + this.c);
			}
		}
		return new Token(EOF_TYPE, "<EOF>");
	}

	/** NAME : ('a'..'z'|'A'..'Z')+; // NAME is sequence of >=1 letter */
	Token NAME() {
		StringBuilder buf = new StringBuilder();
		do {
			buf.append(this.c);
			consume();
		} while (isLETTER());
		return new Token(NAME, buf.toString());
	}

	/** WS : (' '|'\t'|'\n'|'\r')* ; // ignore any whitespace */
	void WS() {
		while (this.c == ' ' || this.c == '\t' || this.c == '\n' || this.c == '\r') {
			consume();
		}
	}
}