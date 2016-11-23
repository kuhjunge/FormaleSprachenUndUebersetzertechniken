// Generated from Expr.g4 by ANTLR 4.4
package postFix.lexer;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FLOAT=1, INT=2, PLUS=3, MINUS=4, MUL=5, DIV=6, INV=7, EXP=8, FAC=9, IGNORE=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'"
	};
	public static final String[] ruleNames = {
		"FLOAT", "INT", "PLUS", "MINUS", "MUL", "DIV", "INV", "EXP", "FAC", "IGNORE", 
		"DIGIT", "LETTER", "WHITESPACE"
	};


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\f\u0089\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\6\2\37\n\2\r\2\16\2 \3\2\3\2\7\2%"+
		"\n\2\f\2\16\2(\13\2\3\2\3\2\6\2,\n\2\r\2\16\2-\3\2\3\2\6\2\62\n\2\r\2"+
		"\16\2\63\3\2\3\2\7\28\n\2\f\2\16\2;\13\2\5\2=\n\2\3\3\6\3@\n\3\r\3\16"+
		"\3A\3\3\3\3\6\3F\n\3\r\3\16\3G\5\3J\n\3\3\4\3\4\3\4\3\4\5\4P\n\4\3\5\3"+
		"\5\3\5\3\5\5\5V\n\5\3\6\3\6\3\6\3\6\5\6\\\n\6\3\7\3\7\3\7\3\7\5\7b\n\7"+
		"\3\b\3\b\3\b\3\b\5\bh\n\b\3\t\3\t\3\t\3\t\5\tn\n\t\3\n\3\n\3\n\3\n\5\n"+
		"t\n\n\3\13\6\13w\n\13\r\13\16\13x\3\13\6\13|\n\13\r\13\16\13}\5\13\u0080"+
		"\n\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\2\2\17\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\2\3\2\5\3\2\62;\4\2C\\c|\5\2\13"+
		"\f\17\17\"\"\u0099\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\3<\3\2\2\2\5I\3\2\2\2\7O\3\2\2\2\tU\3\2\2\2\13[\3\2\2\2\ra\3\2\2\2"+
		"\17g\3\2\2\2\21m\3\2\2\2\23s\3\2\2\2\25\177\3\2\2\2\27\u0083\3\2\2\2\31"+
		"\u0085\3\2\2\2\33\u0087\3\2\2\2\35\37\5\27\f\2\36\35\3\2\2\2\37 \3\2\2"+
		"\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"&\7\60\2\2#%\5\27\f\2$#\3\2\2\2%"+
		"(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'=\3\2\2\2(&\3\2\2\2)+\7\60\2\2*,\5\27"+
		"\f\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.=\3\2\2\2/\61\7/\2\2\60\62"+
		"\5\27\f\2\61\60\3\2\2\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\65"+
		"\3\2\2\2\659\7\60\2\2\668\5\27\f\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\2"+
		"9:\3\2\2\2:=\3\2\2\2;9\3\2\2\2<\36\3\2\2\2<)\3\2\2\2</\3\2\2\2=\4\3\2"+
		"\2\2>@\5\27\f\2?>\3\2\2\2@A\3\2\2\2A?\3\2\2\2AB\3\2\2\2BJ\3\2\2\2CE\7"+
		"/\2\2DF\5\27\f\2ED\3\2\2\2FG\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2I?\3"+
		"\2\2\2IC\3\2\2\2J\6\3\2\2\2KP\7-\2\2LM\7C\2\2MN\7F\2\2NP\7F\2\2OK\3\2"+
		"\2\2OL\3\2\2\2P\b\3\2\2\2QV\7/\2\2RS\7U\2\2ST\7W\2\2TV\7D\2\2UQ\3\2\2"+
		"\2UR\3\2\2\2V\n\3\2\2\2W\\\7,\2\2XY\7O\2\2YZ\7W\2\2Z\\\7N\2\2[W\3\2\2"+
		"\2[X\3\2\2\2\\\f\3\2\2\2]b\7\61\2\2^_\7F\2\2_`\7K\2\2`b\7X\2\2a]\3\2\2"+
		"\2a^\3\2\2\2b\16\3\2\2\2ch\7%\2\2de\7K\2\2ef\7P\2\2fh\7X\2\2gc\3\2\2\2"+
		"gd\3\2\2\2h\20\3\2\2\2in\7`\2\2jk\7G\2\2kl\7Z\2\2ln\7R\2\2mi\3\2\2\2m"+
		"j\3\2\2\2n\22\3\2\2\2ot\7#\2\2pq\7H\2\2qr\7C\2\2rt\7E\2\2so\3\2\2\2sp"+
		"\3\2\2\2t\24\3\2\2\2uw\5\31\r\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2"+
		"\2y\u0080\3\2\2\2z|\5\33\16\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2"+
		"~\u0080\3\2\2\2\177v\3\2\2\2\177{\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082"+
		"\b\13\2\2\u0082\26\3\2\2\2\u0083\u0084\t\2\2\2\u0084\30\3\2\2\2\u0085"+
		"\u0086\t\3\2\2\u0086\32\3\2\2\2\u0087\u0088\t\4\2\2\u0088\34\3\2\2\2\26"+
		"\2 &-\639<AGIOU[agmsx}\177\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}