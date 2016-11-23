package ast;

import rekursiverAbstieg.Token;

public class Div extends Binary {

	public Div(ExprNode left, Token addToken, ExprNode right) {
		super(left, addToken, right);	}

}