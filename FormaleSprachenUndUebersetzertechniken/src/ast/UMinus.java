package ast;

import rekursiverAbstieg.Token;

public class UMinus extends Unary {

	public UMinus(ExprNode left, Token token) {
		super(left, token);
	}
}