package postFix;

import collections.stack.Stack;

/**
 * The Command functional interface.<br/>
 */
@FunctionalInterface
interface IMathOperation {
	/**
	 * F�hrt Operation auf Stack aus
	 * 
	 * @param s
	 *            der Stack
	 */
	void opOnStack(Stack<Double> s);
}