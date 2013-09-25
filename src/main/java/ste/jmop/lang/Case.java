package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.CaseTree;

public class Case extends MetaModel<CaseTree> implements HasStatements{
    protected Case(CaseTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    public void visitStatements(MetaModelVisitor handle) {
	make(getNode().getStatements(), handle);
	
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExpression(), handle);
	make(getNode().getStatements(), handle);
    }
}