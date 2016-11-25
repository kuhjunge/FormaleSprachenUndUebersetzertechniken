package ast.visitor;

import static rekursiverAbstieg.RecursiveDecentLexer.DIV;
import static rekursiverAbstieg.RecursiveDecentLexer.INTEGER;
import static rekursiverAbstieg.RecursiveDecentLexer.MINUS;
import static rekursiverAbstieg.RecursiveDecentLexer.MULTI;
import static rekursiverAbstieg.RecursiveDecentLexer.PLUS;
import static rekursiverAbstieg.RecursiveDecentLexer.UMINUS;

import ast.Add;
import ast.Div;
import ast.HeteroAST;
import ast.Int;
import ast.Mul;
import ast.Sub;
import ast.UMinus;

public class evalVisitorNT implements IVisitor<Double> {
	
	public Double evalNodeType(HeteroAST n){
		return n.accept(this);
	}
	
    public Double evalTokenType(HeteroAST n) { // Token Type
    	Double erg = 0.0;
        switch ( n.getToken().type ) {
            case INTEGER :   erg = visit((Int)n); break;
            case PLUS:   	 erg = visit((Add)n); break;
            case MINUS :     erg = visit((Sub)n); break;
            case UMINUS :    erg = visit((UMinus)n); break;
            case MULTI :     erg = visit((Mul)n); break;
            case DIV :       erg = visit((Div)n); break;
            default :
                // catch unhandled node types
                throw new UnsupportedOperationException("Node "+
                          n.getClass().getName()+ " not handled");
        }
        return erg;
    }

	@Override
	public Double visit(HeteroAST en) {
		return 0.0;
	}

	@Override
	public Double visit(Add n) {
		return  n.getLeft().accept(this) + n.getRight().accept(this);
	}

	@Override
	public Double visit(Sub n) {
		return  n.getLeft().accept(this) - n.getRight().accept(this);
	}

	@Override
	public Double visit(UMinus n) {
		return  - n.getLeft().accept(this);
	}

	@Override
	public Double visit(Mul n) {
		return n.getLeft().accept(this) * n.getRight().accept(this);
	}

	@Override
	public Double visit(Div n) {
		return n.getLeft().accept(this) / n.getRight().accept(this);
	}

	@Override
	public Double visit(Int n) {
		return (double) n.getValue();
	}

}
