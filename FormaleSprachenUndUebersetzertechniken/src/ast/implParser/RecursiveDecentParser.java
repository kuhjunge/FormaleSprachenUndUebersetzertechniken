package ast.implParser;

import static rekursiverAbstieg.RecursiveDecentLexer.*;

import ast.Add;
import ast.Binary;
import ast.Div;
import ast.ExprNode;
import ast.HeteroAST;
import ast.Int;
import ast.Mul;
import ast.Sub;
import ast.UMinus;
import rekursiverAbstieg.Parser;
import rekursiverAbstieg.Token;
import rekursiverAbstieg.Lexer;

public class RecursiveDecentParser extends Parser {
	private ExprNode root;

	public RecursiveDecentParser(Lexer input) {
		super(input);
		this.root = null;
	}

	public HeteroAST statlist() {
		HeteroAST ast = null;
		do {
			ast = stat();
		} while (this.lookahead.type != EOF_TYPE);
		return ast;
	}

	public HeteroAST stat() {
		ExprNode ast = null;
		if (this.lookahead.type == NL) {
			match(NL);
		} else {
			ast = sum();
			match(NL);
		}
		return ast;
	}

	public ExprNode sum() {
		Binary node = null, oldNode = null, localRoot = null;
		ExprNode left = null, right = null;
		Token token = null;
		if (this.root == null) {
			this.root = node;
		}

		left = prod();
		while (this.lookahead.type == PLUS || this.lookahead.type == MINUS) {
			token = this.lookahead;
			if (this.lookahead.type == PLUS) {
				if (right != null) {
					if (localRoot == null) {
						localRoot = node;
					}
					oldNode = node;
					left = right;
					match(PLUS);
					node = new Add(left, token, right);
					oldNode.setRight(node);
				} else {
					match(PLUS);
					node = new Add(left, token, right);
				}
			} else if (this.lookahead.type == MINUS) {
				if (right != null) {
					if (localRoot == null) {
						localRoot = node;
					}
					oldNode = node;
					left = right;
					match(MINUS);
					node = new Sub(left, token, right);
					oldNode.setRight(node);
				} else {
					match(MINUS);
					node = new Sub(left, token, right);
				}
			} else {
				throw new Error("expecting PLUS or MINUS; found " + this.lookahead);
			}
			right = prod();
		}
		if (node == null) {
			return left;
		}
		node.setRight(right);
		if (localRoot == null) {
			return node;
		}
		return localRoot;
	}

	public ExprNode prod() {
		Binary node = null, oldNode = null, localRoot = null;
		ExprNode left = null, right = null;
		Token token = null;
		if (this.root == null) {
			this.root = node;
		}
		left = term();
		while (this.lookahead.type == MULTI || this.lookahead.type == DIV) {
			token = this.lookahead;
			if (this.lookahead.type == MULTI) {
				if (right != null) {
					if (localRoot == null) {
						localRoot = node;
					}
					oldNode = node;
					left = right;
					match(MULTI);
					node = new Mul(left, token, right);
					oldNode.setRight(node);
				} else {
					match(MULTI);
					node = new Mul(left, token, right);
				}
			} else if (this.lookahead.type == DIV) {
				if (right != null) {
					if (localRoot == null) {
						localRoot = node;
					}
					oldNode = node;
					left = right;
					match(DIV);
					node = new Div(left, token, right);
					oldNode.setRight(node);
				} else {
					match(DIV);
					node = new Div(left, token, right);
				}
			} else {
				throw new Error("expecting MULTI or DIV; found " + this.lookahead);
			}
			right = term();
		}
		if (node == null) {
			return left;
		}
		node.setRight(right);
		if (localRoot == null) {
			return node;
		}
		return localRoot;
	}

	public ExprNode term() {
		ExprNode node = null;
		Token token = this.lookahead;
		if (this.root == null) {
			this.root = node;
		}

		if (this.lookahead.type == LBRACK) {
			match(LBRACK);
			node = sum();
			match(RBRACK);
		} else if (this.lookahead.type == INTEGER) {
			match( INTEGER );
			node = new Int(token);
		} else if (this.lookahead.type == UMINUS) {
			match(UMINUS);
			Token i = this.lookahead;
			match(INTEGER);
			node = new UMinus(new Int(i), token);
		} else {
			throw new Error("expecting Integer RBRACK PLUS or MINUS; found " + this.lookahead);
		}
		return node;
	}
}
