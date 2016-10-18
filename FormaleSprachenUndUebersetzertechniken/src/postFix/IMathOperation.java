package postFix;

import collections.stack.Stack;

/**
 * The Command functional interface.<br/>
 */
@FunctionalInterface 
interface IMathOperation {
	void opOnStack(Stack<Double> s);
}