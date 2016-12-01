package ast.visitor;

import static rekursiverAbstieg.RecursiveDecentLexer.*;

import ast.Add;
import ast.Div;
import ast.HeteroAST;
import ast.Int;
import ast.Mul;
import ast.Sub;
import ast.UMinus;

public class evalVisitorTT implements IVisitor<Double> {

	@Override
	public Double visit(HeteroAST n) {
		Double erg = 0.0;
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
	public Double visit(Add n) {
		return visit(n.getLeft()) + visit(n.getRight());
	}

	@Override
	public Double visit(Sub n) {
		return visit(n.getLeft()) - visit(n.getRight());
	}

	@Override
	public Double visit(UMinus n) {
		return -visit(n.getLeft());
	}

	@Override
	public Double visit(Mul n) {
		return visit(n.getLeft()) * visit(n.getRight());
	}

	@Override
	public Double visit(Div n) {
		return visit(n.getLeft()) / visit(n.getRight());
	}

	@Override
	public Double visit(Int n) {
		return (double) n.getValue();
	}

}
