package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ExpressionStatementTree;

public class ExpressionStatement extends Statement<ExpressionStatementTree> {
    protected ExpressionStatement(ExpressionStatementTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExpression(), handle);
    }

}