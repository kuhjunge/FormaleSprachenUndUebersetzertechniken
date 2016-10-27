// Generated from C.g4 by ANTLR 4.5.3
package halstead.lexer;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPERATOR=1, IGNORE=2, OPERAND=3, RESERVED=4, OPERATORS=5, TYPE_QUAL=6, 
		SCSPEC=7, IGNORESYMBOLS2=8, CONSTANT=9, TYPESPEC=10, IDENTIFIER=11, FLOAT=12, 
		STRING=13, INT=14, LINE_COMMENT=15, COMMENT=16, INCLUDE=17, ALOTOFWHITESPACE=18, 
		IGNORESYMBOLS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"OPERATOR", "IGNORE", "OPERAND", "RESERVED", "OPERATORS", "TYPE_QUAL", 
		"SCSPEC", "IGNORESYMBOLS2", "CONSTANT", "TYPESPEC", "IDENTIFIER", "FLOAT", 
		"STRING", "INT", "LINE_COMMENT", "COMMENT", "INCLUDE", "ALOTOFWHITESPACE", 
		"IGNORESYMBOLS", "DIGIT", "LETTER", "LETTERBIG", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, "'do'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OPERATOR", "IGNORE", "OPERAND", "RESERVED", "OPERATORS", "TYPE_QUAL", 
		"SCSPEC", "IGNORESYMBOLS2", "CONSTANT", "TYPESPEC", "IDENTIFIER", "FLOAT", 
		"STRING", "INT", "LINE_COMMENT", "COMMENT", "INCLUDE", "ALOTOFWHITESPACE", 
		"IGNORESYMBOLS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public CLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "C.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u02ba\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\2\3\2\5\2\66\n\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3>\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4F\n\4\3\5\3\5\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0081\n\5\f\5\16\5\u0084"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0094"+
		"\n\5\f\5\16\5\u0097\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5\u00d9\n\5\f\5\16\5\u00dc\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u015c\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\5\6\u0199\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u01ae\n\7\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u01e3\n\b\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\7\n\u01eb\n\n\f\n\16\n\u01ee\13\n\3\n\6\n\u01f1\n\n\r\n"+
		"\16\n\u01f2\3\n\5\n\u01f6\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0228"+
		"\n\13\3\f\3\f\3\f\7\f\u022d\n\f\f\f\16\f\u0230\13\f\3\r\6\r\u0233\n\r"+
		"\r\r\16\r\u0234\3\r\3\r\7\r\u0239\n\r\f\r\16\r\u023c\13\r\3\r\3\r\6\r"+
		"\u0240\n\r\r\r\16\r\u0241\3\r\3\r\6\r\u0246\n\r\r\r\16\r\u0247\3\r\3\r"+
		"\7\r\u024c\n\r\f\r\16\r\u024f\13\r\5\r\u0251\n\r\3\16\3\16\7\16\u0255"+
		"\n\16\f\16\16\16\u0258\13\16\3\16\3\16\3\16\7\16\u025d\n\16\f\16\16\16"+
		"\u0260\13\16\3\16\5\16\u0263\n\16\3\17\6\17\u0266\n\17\r\17\16\17\u0267"+
		"\3\20\3\20\3\20\3\20\7\20\u026e\n\20\f\20\16\20\u0271\13\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\7\21\u0279\n\21\f\21\16\21\u027c\13\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22"+
		"\u028d\n\22\f\22\16\22\u0290\13\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\7\22\u029d\n\22\f\22\16\22\u02a0\13\22\3\22\5\22"+
		"\u02a3\n\22\3\22\3\22\3\23\6\23\u02a8\n\23\r\23\16\23\u02a9\3\23\3\23"+
		"\3\24\5\24\u02af\n\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\7\u0256\u025e\u027a\u028e\u029e\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\2+\2-\2/"+
		"\2\3\2\n\5\2AA]]``\6\2**==??\u0080\u0080\4\2\f\f\17\17\7\2))++<<^_\177"+
		"\177\3\2\62;\5\2C\\aac|\4\2C\\aa\5\2\13\f\17\17\"\"\u0338\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\3\65\3\2\2\2\5=\3\2\2\2\7E\3\2\2\2\t\u015b\3\2\2\2\13\u0198"+
		"\3\2\2\2\r\u01ad\3\2\2\2\17\u01e2\3\2\2\2\21\u01e4\3\2\2\2\23\u01f5\3"+
		"\2\2\2\25\u0227\3\2\2\2\27\u0229\3\2\2\2\31\u0250\3\2\2\2\33\u0262\3\2"+
		"\2\2\35\u0265\3\2\2\2\37\u0269\3\2\2\2!\u0274\3\2\2\2#\u02a2\3\2\2\2%"+
		"\u02a7\3\2\2\2\'\u02ae\3\2\2\2)\u02b2\3\2\2\2+\u02b4\3\2\2\2-\u02b6\3"+
		"\2\2\2/\u02b8\3\2\2\2\61\66\5\t\5\2\62\66\5\r\7\2\63\66\5\17\b\2\64\66"+
		"\5\13\6\2\65\61\3\2\2\2\65\62\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2\66\4"+
		"\3\2\2\2\67>\5\21\t\28>\5#\22\29>\5%\23\2:>\5!\21\2;>\5\37\20\2<>\5\'"+
		"\24\2=\67\3\2\2\2=8\3\2\2\2=9\3\2\2\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>\6"+
		"\3\2\2\2?F\5\25\13\2@F\5\27\f\2AF\5\35\17\2BF\5\31\r\2CF\5\33\16\2DF\5"+
		"\23\n\2E?\3\2\2\2E@\3\2\2\2EA\3\2\2\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2F\b"+
		"\3\2\2\2GH\7k\2\2HI\7h\2\2IM\3\2\2\2JL\5/\30\2KJ\3\2\2\2LO\3\2\2\2MK\3"+
		"\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2P\u015c\7*\2\2QR\7k\2\2R\u015c\7h"+
		"\2\2ST\7c\2\2TU\7u\2\2U\u015c\7o\2\2VW\7d\2\2WX\7t\2\2XY\7g\2\2YZ\7c\2"+
		"\2Z\u015c\7m\2\2[\\\7e\2\2\\]\7c\2\2]^\7u\2\2^\u015c\7g\2\2_`\7e\2\2`"+
		"a\7n\2\2ab\7c\2\2bc\7u\2\2c\u015c\7u\2\2de\7e\2\2ef\7q\2\2fg\7p\2\2gh"+
		"\7v\2\2hi\7k\2\2ij\7p\2\2jk\7w\2\2k\u015c\7g\2\2lm\7f\2\2mn\7g\2\2no\7"+
		"h\2\2op\7c\2\2pq\7w\2\2qr\7n\2\2r\u015c\7v\2\2st\7f\2\2tu\7g\2\2uv\7n"+
		"\2\2vw\7g\2\2wx\7v\2\2x\u015c\7g\2\2yz\7y\2\2z{\7j\2\2{|\7k\2\2|}\7n\2"+
		"\2}~\7g\2\2~\u0082\3\2\2\2\177\u0081\5/\30\2\u0080\177\3\2\2\2\u0081\u0084"+
		"\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0085\u015c\7*\2\2\u0086\u0087\7g\2\2\u0087\u0088\7n\2"+
		"\2\u0088\u0089\7u\2\2\u0089\u015c\7g\2\2\u008a\u008b\7g\2\2\u008b\u008c"+
		"\7p\2\2\u008c\u008d\7w\2\2\u008d\u015c\7o\2\2\u008e\u008f\7h\2\2\u008f"+
		"\u0090\7q\2\2\u0090\u0091\7t\2\2\u0091\u0095\3\2\2\2\u0092\u0094\5/\30"+
		"\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u015c\7*\2\2\u0099"+
		"\u009a\7i\2\2\u009a\u009b\7q\2\2\u009b\u009c\7v\2\2\u009c\u015c\7q\2\2"+
		"\u009d\u009e\7p\2\2\u009e\u009f\7g\2\2\u009f\u015c\7y\2\2\u00a0\u00a1"+
		"\7q\2\2\u00a1\u00a2\7r\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7t\2\2\u00a4"+
		"\u00a5\7c\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7q\2\2\u00a7\u015c\7t\2\2"+
		"\u00a8\u00a9\7r\2\2\u00a9\u00aa\7t\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac"+
		"\7x\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7v\2\2\u00ae\u015c\7g\2\2\u00af"+
		"\u00b0\7r\2\2\u00b0\u00b1\7t\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7v\2\2"+
		"\u00b3\u00b4\7g\2\2\u00b4\u00b5\7e\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7"+
		"\7g\2\2\u00b7\u015c\7f\2\2\u00b8\u00b9\7r\2\2\u00b9\u00ba\7w\2\2\u00ba"+
		"\u00bb\7d\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7k\2\2\u00bd\u015c\7e\2\2"+
		"\u00be\u00bf\7t\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7v\2\2\u00c1\u00c2"+
		"\7w\2\2\u00c2\u00c3\7t\2\2\u00c3\u015c\7p\2\2\u00c4\u00c5\7u\2\2\u00c5"+
		"\u00c6\7k\2\2\u00c6\u00c7\7|\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7q\2\2"+
		"\u00c9\u015c\7h\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd"+
		"\7t\2\2\u00cd\u00ce\7w\2\2\u00ce\u00cf\7e\2\2\u00cf\u015c\7v\2\2\u00d0"+
		"\u00d1\7u\2\2\u00d1\u00d2\7y\2\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7v\2\2"+
		"\u00d4\u00d5\7e\2\2\u00d5\u00d6\7j\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d9"+
		"\5/\30\2\u00d8\u00d7\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dd\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u015c\7*"+
		"\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7j\2\2\u00e0\u00e1\7k\2\2\u00e1\u015c"+
		"\7u\2\2\u00e2\u00e3\7w\2\2\u00e3\u00e4\7p\2\2\u00e4\u00e5\7k\2\2\u00e5"+
		"\u00e6\7q\2\2\u00e6\u015c\7p\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7c\2\2"+
		"\u00e9\u00ea\7o\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7u\2\2\u00ec\u00ed"+
		"\7r\2\2\u00ed\u00ee\7c\2\2\u00ee\u00ef\7e\2\2\u00ef\u015c\7g\2\2\u00f0"+
		"\u00f1\7w\2\2\u00f1\u00f2\7u\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7p\2\2"+
		"\u00f4\u015c\7i\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7t\2\2\u00f7\u015c"+
		"\7{\2\2\u00f8\u00f9\7e\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb\7v\2\2\u00fb"+
		"\u00fc\7e\2\2\u00fc\u015c\7j\2\2\u00fd\u00fe\7v\2\2\u00fe\u00ff\7j\2\2"+
		"\u00ff\u0100\7t\2\2\u0100\u0101\7q\2\2\u0101\u015c\7y\2\2\u0102\u0103"+
		"\7e\2\2\u0103\u0104\7q\2\2\u0104\u0105\7p\2\2\u0105\u0106\7u\2\2\u0106"+
		"\u0107\7v\2\2\u0107\u0108\7a\2\2\u0108\u0109\7e\2\2\u0109\u010a\7c\2\2"+
		"\u010a\u010b\7u\2\2\u010b\u015c\7v\2\2\u010c\u010d\7u\2\2\u010d\u010e"+
		"\7v\2\2\u010e\u010f\7c\2\2\u010f\u0110\7v\2\2\u0110\u0111\7k\2\2\u0111"+
		"\u0112\7e\2\2\u0112\u0113\7a\2\2\u0113\u0114\7e\2\2\u0114\u0115\7c\2\2"+
		"\u0115\u0116\7u\2\2\u0116\u015c\7v\2\2\u0117\u0118\7f\2\2\u0118\u0119"+
		"\7{\2\2\u0119\u011a\7p\2\2\u011a\u011b\7c\2\2\u011b\u011c\7o\2\2\u011c"+
		"\u011d\7k\2\2\u011d\u011e\7e\2\2\u011e\u011f\7a\2\2\u011f\u0120\7e\2\2"+
		"\u0120\u0121\7c\2\2\u0121\u0122\7u\2\2\u0122\u015c\7v\2\2\u0123\u0124"+
		"\7t\2\2\u0124\u0125\7g\2\2\u0125\u0126\7k\2\2\u0126\u0127\7|\2\2\u0127"+
		"\u0128\7p\2\2\u0128\u0129\7v\2\2\u0129\u012a\7g\2\2\u012a\u012b\7t\2\2"+
		"\u012b\u012c\7r\2\2\u012c\u012d\7t\2\2\u012d\u012e\7g\2\2\u012e\u012f"+
		"\7v\2\2\u012f\u0130\7a\2\2\u0130\u0131\7e\2\2\u0131\u0132\7c\2\2\u0132"+
		"\u0133\7u\2\2\u0133\u015c\7v\2\2\u0134\u0135\7v\2\2\u0135\u0136\7{\2\2"+
		"\u0136\u0137\7r\2\2\u0137\u0138\7g\2\2\u0138\u0139\7k\2\2\u0139\u015c"+
		"\7f\2\2\u013a\u013b\7v\2\2\u013b\u013c\7g\2\2\u013c\u013d\7o\2\2\u013d"+
		"\u013e\7r\2\2\u013e\u013f\7n\2\2\u013f\u0140\7c\2\2\u0140\u0141\7v\2\2"+
		"\u0141\u015c\7g\2\2\u0142\u0143\7g\2\2\u0143\u0144\7z\2\2\u0144\u0145"+
		"\7r\2\2\u0145\u0146\7n\2\2\u0146\u0147\7k\2\2\u0147\u0148\7e\2\2\u0148"+
		"\u0149\7k\2\2\u0149\u015c\7v\2\2\u014a\u014b\7v\2\2\u014b\u014c\7t\2\2"+
		"\u014c\u014d\7w\2\2\u014d\u015c\7g\2\2\u014e\u014f\7h\2\2\u014f\u0150"+
		"\7c\2\2\u0150\u0151\7n\2\2\u0151\u0152\7u\2\2\u0152\u015c\7g\2\2\u0153"+
		"\u0154\7v\2\2\u0154\u0155\7{\2\2\u0155\u0156\7r\2\2\u0156\u0157\7g\2\2"+
		"\u0157\u0158\7p\2\2\u0158\u0159\7c\2\2\u0159\u015a\7o\2\2\u015a\u015c"+
		"\7g\2\2\u015bG\3\2\2\2\u015bQ\3\2\2\2\u015bS\3\2\2\2\u015bV\3\2\2\2\u015b"+
		"[\3\2\2\2\u015b_\3\2\2\2\u015bd\3\2\2\2\u015bl\3\2\2\2\u015bs\3\2\2\2"+
		"\u015by\3\2\2\2\u015b\u0086\3\2\2\2\u015b\u008a\3\2\2\2\u015b\u008e\3"+
		"\2\2\2\u015b\u0099\3\2\2\2\u015b\u009d\3\2\2\2\u015b\u00a0\3\2\2\2\u015b"+
		"\u00a8\3\2\2\2\u015b\u00af\3\2\2\2\u015b\u00b8\3\2\2\2\u015b\u00be\3\2"+
		"\2\2\u015b\u00c4\3\2\2\2\u015b\u00ca\3\2\2\2\u015b\u00d0\3\2\2\2\u015b"+
		"\u00de\3\2\2\2\u015b\u00e2\3\2\2\2\u015b\u00e7\3\2\2\2\u015b\u00f0\3\2"+
		"\2\2\u015b\u00f5\3\2\2\2\u015b\u00f8\3\2\2\2\u015b\u00fd\3\2\2\2\u015b"+
		"\u0102\3\2\2\2\u015b\u010c\3\2\2\2\u015b\u0117\3\2\2\2\u015b\u0123\3\2"+
		"\2\2\u015b\u0134\3\2\2\2\u015b\u013a\3\2\2\2\u015b\u0142\3\2\2\2\u015b"+
		"\u014a\3\2\2\2\u015b\u014e\3\2\2\2\u015b\u0153\3\2\2\2\u015c\n\3\2\2\2"+
		"\u015d\u0199\7#\2\2\u015e\u015f\7#\2\2\u015f\u0199\7?\2\2\u0160\u0199"+
		"\7\'\2\2\u0161\u0162\7\'\2\2\u0162\u0199\7?\2\2\u0163\u0199\7(\2\2\u0164"+
		"\u0165\7(\2\2\u0165\u0199\7(\2\2\u0166\u0167\7(\2\2\u0167\u0199\7?\2\2"+
		"\u0168\u0199\7,\2\2\u0169\u016a\7,\2\2\u016a\u0199\7?\2\2\u016b\u0199"+
		"\7-\2\2\u016c\u016d\7-\2\2\u016d\u0199\7-\2\2\u016e\u016f\7-\2\2\u016f"+
		"\u0199\7?\2\2\u0170\u0199\4./\2\u0171\u0172\7/\2\2\u0172\u0199\7/\2\2"+
		"\u0173\u0174\7/\2\2\u0174\u0199\7?\2\2\u0175\u0176\7/\2\2\u0176\u0199"+
		"\7@\2\2\u0177\u0178\7\60\2\2\u0178\u0179\7\60\2\2\u0179\u0199\7\60\2\2"+
		"\u017a\u0199\7\61\2\2\u017b\u017c\7\61\2\2\u017c\u0199\7?\2\2\u017d\u017e"+
		"\7<\2\2\u017e\u0199\7<\2\2\u017f\u0199\7>\2\2\u0180\u0181\7>\2\2\u0181"+
		"\u0199\7>\2\2\u0182\u0183\7>\2\2\u0183\u0184\7>\2\2\u0184\u0199\7?\2\2"+
		"\u0185\u0186\7>\2\2\u0186\u0199\7?\2\2\u0187\u0188\7?\2\2\u0188\u0199"+
		"\7?\2\2\u0189\u0199\7@\2\2\u018a\u018b\7@\2\2\u018b\u0199\7?\2\2\u018c"+
		"\u018d\7@\2\2\u018d\u0199\7@\2\2\u018e\u018f\7@\2\2\u018f\u0190\7@\2\2"+
		"\u0190\u0199\7?\2\2\u0191\u0199\t\2\2\2\u0192\u0193\7`\2\2\u0193\u0199"+
		"\7?\2\2\u0194\u0199\7}\2\2\u0195\u0196\7~\2\2\u0196\u0199\7~\2\2\u0197"+
		"\u0199\t\3\2\2\u0198\u015d\3\2\2\2\u0198\u015e\3\2\2\2\u0198\u0160\3\2"+
		"\2\2\u0198\u0161\3\2\2\2\u0198\u0163\3\2\2\2\u0198\u0164\3\2\2\2\u0198"+
		"\u0166\3\2\2\2\u0198\u0168\3\2\2\2\u0198\u0169\3\2\2\2\u0198\u016b\3\2"+
		"\2\2\u0198\u016c\3\2\2\2\u0198\u016e\3\2\2\2\u0198\u0170\3\2\2\2\u0198"+
		"\u0171\3\2\2\2\u0198\u0173\3\2\2\2\u0198\u0175\3\2\2\2\u0198\u0177\3\2"+
		"\2\2\u0198\u017a\3\2\2\2\u0198\u017b\3\2\2\2\u0198\u017d\3\2\2\2\u0198"+
		"\u017f\3\2\2\2\u0198\u0180\3\2\2\2\u0198\u0182\3\2\2\2\u0198\u0185\3\2"+
		"\2\2\u0198\u0187\3\2\2\2\u0198\u0189\3\2\2\2\u0198\u018a\3\2\2\2\u0198"+
		"\u018c\3\2\2\2\u0198\u018e\3\2\2\2\u0198\u0191\3\2\2\2\u0198\u0192\3\2"+
		"\2\2\u0198\u0194\3\2\2\2\u0198\u0195\3\2\2\2\u0198\u0197\3\2\2\2\u0199"+
		"\f\3\2\2\2\u019a\u019b\7e\2\2\u019b\u019c\7q\2\2\u019c\u019d\7p\2\2\u019d"+
		"\u019e\7u\2\2\u019e\u01ae\7v\2\2\u019f\u01a0\7h\2\2\u01a0\u01a1\7t\2\2"+
		"\u01a1\u01a2\7k\2\2\u01a2\u01a3\7g\2\2\u01a3\u01a4\7p\2\2\u01a4\u01ae"+
		"\7f\2\2\u01a5\u01a6\7x\2\2\u01a6\u01a7\7q\2\2\u01a7\u01a8\7n\2\2\u01a8"+
		"\u01a9\7c\2\2\u01a9\u01aa\7v\2\2\u01aa\u01ab\7k\2\2\u01ab\u01ac\7n\2\2"+
		"\u01ac\u01ae\7g\2\2\u01ad\u019a\3\2\2\2\u01ad\u019f\3\2\2\2\u01ad\u01a5"+
		"\3\2\2\2\u01ae\16\3\2\2\2\u01af\u01b0\7c\2\2\u01b0\u01b1\7w\2\2\u01b1"+
		"\u01b2\7v\2\2\u01b2\u01e3\7q\2\2\u01b3\u01b4\7g\2\2\u01b4\u01b5\7z\2\2"+
		"\u01b5\u01b6\7v\2\2\u01b6\u01b7\7g\2\2\u01b7\u01b8\7t\2\2\u01b8\u01e3"+
		"\7p\2\2\u01b9\u01ba\7k\2\2\u01ba\u01bb\7p\2\2\u01bb\u01bc\7n\2\2\u01bc"+
		"\u01bd\7k\2\2\u01bd\u01be\7p\2\2\u01be\u01e3\7g\2\2\u01bf\u01c0\7t\2\2"+
		"\u01c0\u01c1\7g\2\2\u01c1\u01c2\7i\2\2\u01c2\u01c3\7k\2\2\u01c3\u01c4"+
		"\7u\2\2\u01c4\u01c5\7v\2\2\u01c5\u01c6\7g\2\2\u01c6\u01e3\7t\2\2\u01c7"+
		"\u01c8\7u\2\2\u01c8\u01c9\7v\2\2\u01c9\u01ca\7c\2\2\u01ca\u01cb\7v\2\2"+
		"\u01cb\u01cc\7k\2\2\u01cc\u01e3\7e\2\2\u01cd\u01ce\7v\2\2\u01ce\u01cf"+
		"\7{\2\2\u01cf\u01d0\7r\2\2\u01d0\u01d1\7g\2\2\u01d1\u01d2\7f\2\2\u01d2"+
		"\u01d3\7g\2\2\u01d3\u01e3\7h\2\2\u01d4\u01d5\7x\2\2\u01d5\u01d6\7k\2\2"+
		"\u01d6\u01d7\7t\2\2\u01d7\u01d8\7v\2\2\u01d8\u01d9\7w\2\2\u01d9\u01da"+
		"\7c\2\2\u01da\u01e3\7n\2\2\u01db\u01dc\7o\2\2\u01dc\u01dd\7w\2\2\u01dd"+
		"\u01de\7v\2\2\u01de\u01df\7c\2\2\u01df\u01e0\7d\2\2\u01e0\u01e1\7n\2\2"+
		"\u01e1\u01e3\7g\2\2\u01e2\u01af\3\2\2\2\u01e2\u01b3\3\2\2\2\u01e2\u01b9"+
		"\3\2\2\2\u01e2\u01bf\3\2\2\2\u01e2\u01c7\3\2\2\2\u01e2\u01cd\3\2\2\2\u01e2"+
		"\u01d4\3\2\2\2\u01e2\u01db\3\2\2\2\u01e3\20\3\2\2\2\u01e4\u01e5\7f\2\2"+
		"\u01e5\u01e6\7q\2\2\u01e6\22\3\2\2\2\u01e7\u01ec\5-\27\2\u01e8\u01eb\5"+
		"-\27\2\u01e9\u01eb\5)\25\2\u01ea\u01e8\3\2\2\2\u01ea\u01e9\3\2\2\2\u01eb"+
		"\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01f6\3\2"+
		"\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f1\5)\25\2\u01f0\u01ef\3\2\2\2\u01f1"+
		"\u01f2\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f6\3\2"+
		"\2\2\u01f4\u01f6\5\31\r\2\u01f5\u01e7\3\2\2\2\u01f5\u01f0\3\2\2\2\u01f5"+
		"\u01f4\3\2\2\2\u01f6\24\3\2\2\2\u01f7\u01f8\7d\2\2\u01f8\u01f9\7q\2\2"+
		"\u01f9\u01fa\7q\2\2\u01fa\u0228\7n\2\2\u01fb\u01fc\7e\2\2\u01fc\u01fd"+
		"\7j\2\2\u01fd\u01fe\7c\2\2\u01fe\u0228\7t\2\2\u01ff\u0200\7f\2\2\u0200"+
		"\u0201\7q\2\2\u0201\u0202\7w\2\2\u0202\u0203\7d\2\2\u0203\u0204\7n\2\2"+
		"\u0204\u0228\7g\2\2\u0205\u0206\7h\2\2\u0206\u0207\7q\2\2\u0207\u0208"+
		"\7n\2\2\u0208\u0209\7c\2\2\u0209\u0228\7v\2\2\u020a\u020b\7k\2\2\u020b"+
		"\u020c\7p\2\2\u020c\u0228\7v\2\2\u020d\u020e\7q\2\2\u020e\u020f\7p\2\2"+
		"\u020f\u0228\7i\2\2\u0210\u0211\7u\2\2\u0211\u0212\7j\2\2\u0212\u0213"+
		"\7q\2\2\u0213\u0214\7t\2\2\u0214\u0228\7v\2\2\u0215\u0216\7u\2\2\u0216"+
		"\u0217\7k\2\2\u0217\u0218\7i\2\2\u0218\u0219\7p\2\2\u0219\u021a\7g\2\2"+
		"\u021a\u0228\7f\2\2\u021b\u021c\7w\2\2\u021c\u021d\7p\2\2\u021d\u021e"+
		"\7u\2\2\u021e\u021f\7k\2\2\u021f\u0220\7i\2\2\u0220\u0221\7p\2\2\u0221"+
		"\u0222\7g\2\2\u0222\u0228\7f\2\2\u0223\u0224\7x\2\2\u0224\u0225\7q\2\2"+
		"\u0225\u0226\7k\2\2\u0226\u0228\7f\2\2\u0227\u01f7\3\2\2\2\u0227\u01fb"+
		"\3\2\2\2\u0227\u01ff\3\2\2\2\u0227\u0205\3\2\2\2\u0227\u020a\3\2\2\2\u0227"+
		"\u020d\3\2\2\2\u0227\u0210\3\2\2\2\u0227\u0215\3\2\2\2\u0227\u021b\3\2"+
		"\2\2\u0227\u0223\3\2\2\2\u0228\26\3\2\2\2\u0229\u022e\5+\26\2\u022a\u022d"+
		"\5+\26\2\u022b\u022d\5)\25\2\u022c\u022a\3\2\2\2\u022c\u022b\3\2\2\2\u022d"+
		"\u0230\3\2\2\2\u022e\u022c\3\2\2\2\u022e\u022f\3\2\2\2\u022f\30\3\2\2"+
		"\2\u0230\u022e\3\2\2\2\u0231\u0233\5)\25\2\u0232\u0231\3\2\2\2\u0233\u0234"+
		"\3\2\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236\3\2\2\2\u0236"+
		"\u023a\7\60\2\2\u0237\u0239\5)\25\2\u0238\u0237\3\2\2\2\u0239\u023c\3"+
		"\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u0251\3\2\2\2\u023c"+
		"\u023a\3\2\2\2\u023d\u023f\7\60\2\2\u023e\u0240\5)\25\2\u023f\u023e\3"+
		"\2\2\2\u0240\u0241\3\2\2\2\u0241\u023f\3\2\2\2\u0241\u0242\3\2\2\2\u0242"+
		"\u0251\3\2\2\2\u0243\u0245\7/\2\2\u0244\u0246\5)\25\2\u0245\u0244\3\2"+
		"\2\2\u0246\u0247\3\2\2\2\u0247\u0245\3\2\2\2\u0247\u0248\3\2\2\2\u0248"+
		"\u0249\3\2\2\2\u0249\u024d\7\60\2\2\u024a\u024c\5)\25\2\u024b\u024a\3"+
		"\2\2\2\u024c\u024f\3\2\2\2\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e"+
		"\u0251\3\2\2\2\u024f\u024d\3\2\2\2\u0250\u0232\3\2\2\2\u0250\u023d\3\2"+
		"\2\2\u0250\u0243\3\2\2\2\u0251\32\3\2\2\2\u0252\u0256\7$\2\2\u0253\u0255"+
		"\13\2\2\2\u0254\u0253\3\2\2\2\u0255\u0258\3\2\2\2\u0256\u0257\3\2\2\2"+
		"\u0256\u0254\3\2\2\2\u0257\u0259\3\2\2\2\u0258\u0256\3\2\2\2\u0259\u0263"+
		"\7$\2\2\u025a\u025e\7)\2\2\u025b\u025d\13\2\2\2\u025c\u025b\3\2\2\2\u025d"+
		"\u0260\3\2\2\2\u025e\u025f\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0261\3\2"+
		"\2\2\u0260\u025e\3\2\2\2\u0261\u0263\7)\2\2\u0262\u0252\3\2\2\2\u0262"+
		"\u025a\3\2\2\2\u0263\34\3\2\2\2\u0264\u0266\5)\25\2\u0265\u0264\3\2\2"+
		"\2\u0266\u0267\3\2\2\2\u0267\u0265\3\2\2\2\u0267\u0268\3\2\2\2\u0268\36"+
		"\3\2\2\2\u0269\u026a\7\61\2\2\u026a\u026b\7\61\2\2\u026b\u026f\3\2\2\2"+
		"\u026c\u026e\n\4\2\2\u026d\u026c\3\2\2\2\u026e\u0271\3\2\2\2\u026f\u026d"+
		"\3\2\2\2\u026f\u0270\3\2\2\2\u0270\u0272\3\2\2\2\u0271\u026f\3\2\2\2\u0272"+
		"\u0273\b\20\2\2\u0273 \3\2\2\2\u0274\u0275\7\61\2\2\u0275\u0276\7,\2\2"+
		"\u0276\u027a\3\2\2\2\u0277\u0279\13\2\2\2\u0278\u0277\3\2\2\2\u0279\u027c"+
		"\3\2\2\2\u027a\u027b\3\2\2\2\u027a\u0278\3\2\2\2\u027b\u027d\3\2\2\2\u027c"+
		"\u027a\3\2\2\2\u027d\u027e\7,\2\2\u027e\u027f\7\61\2\2\u027f\u0280\3\2"+
		"\2\2\u0280\u0281\b\21\2\2\u0281\"\3\2\2\2\u0282\u0283\7%\2\2\u0283\u0284"+
		"\7K\2\2\u0284\u0285\7P\2\2\u0285\u0286\7E\2\2\u0286\u0287\7N\2\2\u0287"+
		"\u0288\7W\2\2\u0288\u0289\7F\2\2\u0289\u028a\7G\2\2\u028a\u028e\3\2\2"+
		"\2\u028b\u028d\13\2\2\2\u028c\u028b\3\2\2\2\u028d\u0290\3\2\2\2\u028e"+
		"\u028f\3\2\2\2\u028e\u028c\3\2\2\2\u028f\u0291\3\2\2\2\u0290\u028e\3\2"+
		"\2\2\u0291\u02a3\7\f\2\2\u0292\u0293\7%\2\2\u0293\u0294\7k\2\2\u0294\u0295"+
		"\7p\2\2\u0295\u0296\7e\2\2\u0296\u0297\7n\2\2\u0297\u0298\7w\2\2\u0298"+
		"\u0299\7f\2\2\u0299\u029a\7g\2\2\u029a\u029e\3\2\2\2\u029b\u029d\13\2"+
		"\2\2\u029c\u029b\3\2\2\2\u029d\u02a0\3\2\2\2\u029e\u029f\3\2\2\2\u029e"+
		"\u029c\3\2\2\2\u029f\u02a1\3\2\2\2\u02a0\u029e\3\2\2\2\u02a1\u02a3\7\f"+
		"\2\2\u02a2\u0282\3\2\2\2\u02a2\u0292\3\2\2\2\u02a3\u02a4\3\2\2\2\u02a4"+
		"\u02a5\b\22\2\2\u02a5$\3\2\2\2\u02a6\u02a8\5/\30\2\u02a7\u02a6\3\2\2\2"+
		"\u02a8\u02a9\3\2\2\2\u02a9\u02a7\3\2\2\2\u02a9\u02aa\3\2\2\2\u02aa\u02ab"+
		"\3\2\2\2\u02ab\u02ac\b\23\2\2\u02ac&\3\2\2\2\u02ad\u02af\t\5\2\2\u02ae"+
		"\u02ad\3\2\2\2\u02af\u02b0\3\2\2\2\u02b0\u02b1\b\24\2\2\u02b1(\3\2\2\2"+
		"\u02b2\u02b3\t\6\2\2\u02b3*\3\2\2\2\u02b4\u02b5\t\7\2\2\u02b5,\3\2\2\2"+
		"\u02b6\u02b7\t\b\2\2\u02b7.\3\2\2\2\u02b8\u02b9\t\t\2\2\u02b9\60\3\2\2"+
		"\2&\2\65=EM\u0082\u0095\u00da\u015b\u0198\u01ad\u01e2\u01ea\u01ec\u01f2"+
		"\u01f5\u0227\u022c\u022e\u0234\u023a\u0241\u0247\u024d\u0250\u0256\u025e"+
		"\u0262\u0267\u026f\u027a\u028e\u029e\u02a2\u02a9\u02ae\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}