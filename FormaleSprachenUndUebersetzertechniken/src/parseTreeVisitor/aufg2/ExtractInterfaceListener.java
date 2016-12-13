package parseTreeVisitor.aufg2;

/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;

import parseTreeVisitor.aufg2.grammar.*;
import parseTreeVisitor.aufg2.grammar.JavaParser.*;

public class ExtractInterfaceListener extends JavaBaseListener {
    JavaParser parser;
    public ExtractInterfaceListener(JavaParser parser) {this.parser = parser;}
    /** Listen to matches of classDeclaration */
    @Override
    public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx){
        System.out.println("interface I"+ctx.Identifier()+" {");
    }
    @Override
    public void exitClassDeclaration(ClassDeclarationContext ctx) {
        System.out.println("}");
    }
    
    @Override
    public void exitImportDeclaration(ImportDeclarationContext ctx) {
    	String s= "import ";
    	QualifiedNameContext qnc = ctx.qualifiedName();
		for (TerminalNode n :qnc.Identifier()){
			s += n.getText() + "." ;
		}
		System.out.println(s.substring(0, s.length()-1) + ";");
    }
    
    /** Listen to matches of methodDeclaration */
    @Override
    public void enterMethodDeclaration(
        JavaParser.MethodDeclarationContext ctx
    )
    {
        // need parser to get tokens
        TokenStream tokens = parser.getTokenStream();
        String type = "void";
        if ( ctx.type()!=null ) {
            type = tokens.getText(ctx.type());
        }
        String args = tokens.getText(ctx.formalParameters());
        System.out.println("\t"+type+" "+ctx.Identifier()+args+";");
    }
}
