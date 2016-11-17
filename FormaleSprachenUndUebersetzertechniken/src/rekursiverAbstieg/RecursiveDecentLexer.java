package rekursiverAbstieg;

/**
 * 
 * @author Kuhjunge
 *
 */
public class RecursiveDecentLexer extends Lexer {

	public static int INTEGER = 2;
	public static int PLUS = 3;
	public static int MINUS = 4;
	public static int MULTI = 5;
	public static int DIV = 6;
	public static int LBRACK = 7;
	public static int RBRACK = 8;
	public static int NL = 9;

	public static String[] tokenNames = { "e/a", "EOF", "INTEGER", "PLUS", "MINUS", "MULTI", "DIV", "LBRACK",
			"RBRACK", "NL" };

	public RecursiveDecentLexer(String input) {
		super(input);
	}

	/** Move one character; detect "end of file" */
	@Override
	public void consume() {
		this.p++;
		if (this.p >= this.input.length()) {
			this.c = EOF;
		} else {
			this.c = this.input.charAt(this.p);
		}
	}

	@Override
	public Token nextToken() {
		while (this.c != EOF) {
			switch (this.c) {
			case ' ':
			case '\t':
			case '\r':
				WS();
				continue;
			case '[':
				consume();
				return new Token(LBRACK, "[");
			case ']':
				consume();
				return new Token(RBRACK, "]");
			case '+':
				consume();
				return new Token(PLUS, "+");
			case '-':
				consume();
				return new Token(MINUS, "-");
			case '*':
				consume();
				return new Token(MULTI, "*");
			case '/':
				consume();
				return new Token(DIV, "/");
			case '(':
				consume();
				return new Token(LBRACK, "(");
			case ')':
				consume();
				return new Token(RBRACK, ")");
			case '\n':
				consume();
				return new Token(NL, "\\n");
			default:
				if (isNUMBER()) {
					return INTEGER();
				}
				throw new Error("invalid character: " + this.c);
			}
		}
		return new Token(EOF_TYPE, "<EOF>");
	}

	@Override
	public String getTokenName(int tokenType) {
		return tokenNames[tokenType];
	}

	private Token INTEGER() {
		StringBuilder buf = new StringBuilder();
		do {
			buf.append(this.c);
			consume();
		} while (isNUMBER());
		return new Token(INTEGER, buf.toString());
	}

	private boolean isNUMBER() {
		return (this.c >= '0' && this.c <= '9');
	}

	/** WS : (' '|'\t'|'\r')* ; // ignore any whitespace */
	private void WS() {
		while (this.c == ' ' || this.c == '\t' || this.c == '\r')
			consume();
	}
}
