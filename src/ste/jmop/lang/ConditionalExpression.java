package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ConditionalExpressionTree;

public class ConditionalExpression extends Expression<ConditionalExpressionTree> {
    protected ConditionalExpression(ConditionalExpressionTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getCondition(), handle);
	make(getNode().getTrueExpression(), handle);
	make(getNode().getFalseExpression(), handle);
    }
}