package ast;

import rekursiverAbstieg.Token;

public class USubNode extends UnaryNode {

	public USubNode(ExprNode left, Token token) {
		super(left, token);
	}
}