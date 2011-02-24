package ste.jmop.intersect;

import ste.jmop.lang.Variable;

import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;

public class Inliner extends TreeTranslator {

    private Variable v;
    private String code;

    public Inliner(Variable v, String code) {
	this.v = v;
	this.code = code;
    }

    @Override
    public void visitVarDef(JCVariableDecl arg0) {
	super.visitVarDef(arg0);
	if (arg0 == v.getNode()) {
	    result = null;
	} 
    }
}
