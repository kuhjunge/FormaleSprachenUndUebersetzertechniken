package postFix;

import postFix.stack.IStackAdapter;
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
	void opOnStack(IStackAdapter<Double> s);
}