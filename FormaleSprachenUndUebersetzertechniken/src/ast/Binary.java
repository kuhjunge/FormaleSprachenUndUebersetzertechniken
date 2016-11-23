package ast;

import rekursiverAbstieg.Token;

public class Binary extends ExprNode {
	ExprNode left, right; // named, node-specific, irregular children

	public Binary(ExprNode left, Token addToken, ExprNode right) {
		super(addToken);
		this.left = left;
		this.right = right;
	}

	@Override
	public String toStringTree() {
		if (this.left == null || this.right == null)
			return this.toString();
		StringBuilder buf = new StringBuilder();
		buf.append("(");
		buf.append(this.toString());
		buf.append(' ');
		buf.append(this.left.toStringTree());
		buf.append(' ');
		buf.append(this.right.toStringTree());
		buf.append(")");
		return buf.toString();
	}

	public void setRight(ExprNode r) {
		this.right = r;
	}
	
	/**
	 * @return the left
	 */
	public ExprNode getLeft() {
		return this.left;
	}

	/**
	 * @return the right
	 */
	public ExprNode getRight() {
		return this.right;
	}
}
