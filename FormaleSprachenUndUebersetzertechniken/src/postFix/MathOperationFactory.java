package postFix;

import java.util.HashMap;
import java.util.Map;

import collections.stack.Stack;
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
	public void executeCommand(Integer id, Stack<Double> s) {
		if (this.commandMap.containsKey(id)) {
			this.commandMap.get(id).opOnStack(s);
		}
	}

	/**
	 * Factory pattern - https://en.wikipedia.org/wiki/Command_pattern
	 * 
	 * @return Command List mit allen Operationen
	 */
	public static MathOperationFactory init() {
		MathOperationFactory mof = new MathOperationFactory();
		mof.addCommand(ExprLexer.PLUS, (s) -> s.push(s.popTop() + s.popTop()));
		mof.addCommand(ExprLexer.MINUS, (s) -> s.push(s.pop2ndTop() - s.popTop()));
		mof.addCommand(ExprLexer.INV, (s) -> s.push(s.popTop() * (-1)));
		mof.addCommand(ExprLexer.MUL, (s) -> s.push(s.popTop() * s.popTop()));
		mof.addCommand(ExprLexer.DIV, (s) -> s.push(s.pop2ndTop() / s.popTop()));
		mof.addCommand(ExprLexer.EXP, (s) -> s.push(Math.pow(s.pop2ndTop(), s.popTop())));
		mof.addCommand(ExprLexer.FAC, (s) -> s.push(calcFac(s.popTop())));
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