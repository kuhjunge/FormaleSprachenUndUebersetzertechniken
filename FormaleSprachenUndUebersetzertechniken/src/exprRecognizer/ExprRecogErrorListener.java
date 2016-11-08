package exprRecognizer;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ExprRecogErrorListener extends BaseErrorListener {
	public static ExprRecogErrorListener INSTANCE = new ExprRecogErrorListener();
	public static boolean err = false;
	
	public static void clearErr(){
		err = false;
	}
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		String sourceName = recognizer.getInputStream().getSourceName();
		if (!sourceName.isEmpty()) {
			sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
		}
		err = true;
		System.err.println(sourceName + "line " + line + ":" + charPositionInLine + " " + msg);
	}
}
