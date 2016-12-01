// Generated from ExprRecog.g4 by ANTLR 4.4
package exprRecognizer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprRecogParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__9=1, T__8=2, T__7=3, T__6=4, T__5=5, T__4=6, T__3=7, T__2=8, T__1=9, 
		T__0=10, FLOAT=11, ID=12, INT=13, NEWLINE=14, WS=15;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'('", "')'", "'*'", "'+'", "'<'", "'-'", "'='", "'>'", 
		"'^'", "FLOAT", "ID", "INT", "NEWLINE", "WS"
	};
	public static final int
		RULE_stat = 0, RULE_expr = 1;
	public static final String[] ruleNames = {
		"stat", "expr"
	};

	@Override
	public String getGrammarFileName() { return "ExprRecog.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprRecogParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprRecogParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(ExprRecogParser.NEWLINE, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprRecogListener ) ((ExprRecogListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprRecogListener ) ((ExprRecogListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprRecogVisitor ) return ((ExprRecogVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stat);
		try {
			setState(13);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(4); expr(0);
				setState(5); match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(7); match(ID);
				setState(8); match(T__2);
				setState(9); expr(0);
				setState(10); match(NEWLINE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(12); match(NEWLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ExprRecogParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode INT() { return getToken(ExprRecogParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExprRecogParser.FLOAT, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExprRecogListener ) ((ExprRecogListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExprRecogListener ) ((ExprRecogListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprRecogVisitor ) return ((ExprRecogVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			switch (_input.LA(1)) {
			case FLOAT:
				{
				setState(16); match(FLOAT);
				}
				break;
			case INT:
				{
				setState(17); match(INT);
				}
				break;
			case ID:
				{
				setState(18); match(ID);
				}
				break;
			case T__8:
				{
				setState(19); match(T__8);
				setState(20); expr(0);
				setState(21); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(40);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(25);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(26); match(T__0);
						setState(27); expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(28);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(29);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__6) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(30); expr(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(31);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(32);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__3) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(33); expr(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(34);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(35);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__1) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(36); expr(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(37);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(38); match(T__2);
						}
						setState(39); expr(6);
						}
						break;
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 9);
		case 1: return precpred(_ctx, 8);
		case 2: return precpred(_ctx, 7);
		case 3: return precpred(_ctx, 6);
		case 4: return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21\60\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\20\n\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3\32\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\2\3\4\4\2\4\2\5\4\2\3\3\6"+
		"\6\4\2\7\7\t\t\4\2\b\b\13\13\67\2\17\3\2\2\2\4\31\3\2\2\2\6\7\5\4\3\2"+
		"\7\b\7\20\2\2\b\20\3\2\2\2\t\n\7\16\2\2\n\13\7\n\2\2\13\f\5\4\3\2\f\r"+
		"\7\20\2\2\r\20\3\2\2\2\16\20\7\20\2\2\17\6\3\2\2\2\17\t\3\2\2\2\17\16"+
		"\3\2\2\2\20\3\3\2\2\2\21\22\b\3\1\2\22\32\7\r\2\2\23\32\7\17\2\2\24\32"+
		"\7\16\2\2\25\26\7\4\2\2\26\27\5\4\3\2\27\30\7\5\2\2\30\32\3\2\2\2\31\21"+
		"\3\2\2\2\31\23\3\2\2\2\31\24\3\2\2\2\31\25\3\2\2\2\32,\3\2\2\2\33\34\f"+
		"\13\2\2\34\35\7\f\2\2\35+\5\4\3\13\36\37\f\n\2\2\37 \t\2\2\2 +\5\4\3\13"+
		"!\"\f\t\2\2\"#\t\3\2\2#+\5\4\3\n$%\f\b\2\2%&\t\4\2\2&+\5\4\3\t\'(\f\7"+
		"\2\2()\7\n\2\2)+\5\4\3\b*\33\3\2\2\2*\36\3\2\2\2*!\3\2\2\2*$\3\2\2\2*"+
		"\'\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\5\3\2\2\2.,\3\2\2\2\6\17\31"+
		"*,";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}