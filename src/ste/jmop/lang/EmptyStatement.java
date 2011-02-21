package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.EmptyStatementTree;

public class EmptyStatement extends Statement<EmptyStatementTree> {
    protected EmptyStatement(EmptyStatementTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
    }
}