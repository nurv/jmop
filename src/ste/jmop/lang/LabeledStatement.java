package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.LabeledStatementTree;

public class LabeledStatement extends Statement<LabeledStatementTree> {
    protected LabeledStatement(LabeledStatementTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getStatement(), handle);
    }
}