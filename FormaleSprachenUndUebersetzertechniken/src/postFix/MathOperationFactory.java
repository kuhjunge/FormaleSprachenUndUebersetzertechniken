package postFix;

import java.util.HashMap;
import postFix.Exception.*;
import postFix.stack.IStackAdapter;

import java.util.Map;
import lexer.ExprLexer;

/**
 * The CommandFactory class.<br/>
 */
public final class MathOperationFactory {

	private final Map<Integer, IMathOperation> commandMap;

	/**
	 * Constructor
	 */
	private MathOperationFactory() {
		this.commandMap = new HashMap<>();
	}

	/**
	 * Fügt ein Kommando zur Factory hinzu
	 * 
	 * @param id
	 *            des Kommandos
	 * @param command
	 *            Lambda Ausdruck für die Operation
	 */
	public void addCommand(Integer id, IMathOperation command) {
		this.commandMap.put(id, command);
	}

	/**
	 * Führt Kommando für die ID aus
	 * 
	 * @param id
	 *            Hier ID des Token Typen, welche die Operation representiert
	 * @param s
	 */
	public void executeCommand(Integer id, IStackAdapter<Double> s) throws UnknownMathOperationException {
		if (this.commandMap.containsKey(id)) {
			this.commandMap.get(id).opOnStack(s);
		} else {
			throw new UnknownMathOperationException("Operation nicht bekannt");
		}
	}

	/**
	 * Factory pattern - https://en.wikipedia.org/wiki/Command_pattern
	 * 
	 * @return Command List mit allen Operationen
	 */
	public static MathOperationFactory init() {
		MathOperationFactory mof = new MathOperationFactory();
		mof.addCommand(ExprLexer.PLUS, (s) -> s.push(s.pop() + s.pop()));
		mof.addCommand(ExprLexer.MINUS, (s) -> s.push(s.pop2nd() - s.pop()));
		mof.addCommand(ExprLexer.INV, (s) -> s.push(-s.pop()));
		mof.addCommand(ExprLexer.MUL, (s) -> s.push(s.pop() * s.pop()));
		mof.addCommand(ExprLexer.DIV, (s) -> s.push(s.pop2nd() / s.pop()));
		mof.addCommand(ExprLexer.EXP, (s) -> s.push(Math.pow(s.pop2nd(), s.pop())));
		mof.addCommand(ExprLexer.FAC, (s) -> s.push(calcFac(s.pop())));
		return mof;
	}

	/**
	 * Hilfsmethode, berechnet Fakultät
	 * 
	 * @param var
	 * @return
	 */
	private static double calcFac(double var) {
		double erg = 1;
		for (double i = 1; i <= var; i++) {
			erg = erg * i;
		}
		return erg;
	}
}