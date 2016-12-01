package ast.visitor;

import static rekursiverAbstieg.RecursiveDecentLexer.*;
import ast.Add;
import ast.Div;
import ast.HeteroAST;
import ast.Int;
import ast.Mul;
import ast.Sub;
import ast.UMinus;

public class ToStringVisitorTT implements IVisitor<String> {

	public String visit(HeteroAST n) {
		String erg = "";
		switch (n.getToken().type) {
		case INTEGER:
			erg = visit((Int) n);
			break;
		case PLUS:
			erg = visit((Add) n);
			break;
		case MINUS:
			erg = visit((Sub) n);
			break;
		case UMINUS:
			erg = visit((UMinus) n);
			break;
		case MULTI:
			erg = visit((Mul) n);
			break;
		case DIV:
			erg = visit((Div) n);
			break;
		default:
			// catch unhandled node types
			throw new UnsupportedOperationException("Node " + n.getClass().getName() + " not handled");
		}
		return erg;
	}

	@Override
	public String visit(Add n) {
		return "(" + visit(n.getLeft()) + n.toString() + visit(n.getRight()) + ")";
	}

	@Override
	public String visit(Sub n) {
		return "(" + visit(n.getLeft()) + n.toString() + visit(n.getRight()) + ")";
	}

	@Override
	public String visit(UMinus n) {
		return "(" + n.toString() + visit(n.getLeft()) + ")";
	}

	@Override
	public String visit(Mul n) {
		return "(" + visit(n.getLeft()) + n.toString() + visit(n.getRight()) + ")";
	}

	@Override
	public String visit(Div n) {
		return "(" + visit(n.getLeft()) + n.toString() + visit(n.getRight()) + ")";
	}

	@Override
	public String visit(Int n) {
		return n.toString();
	}

}
