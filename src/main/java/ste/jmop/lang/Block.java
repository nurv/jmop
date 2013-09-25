package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.BlockTree;

public class Block extends Statement<BlockTree> implements HasStatements {
    protected Block(BlockTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    public void visitStatements(MetaModelVisitor handle) {
	make(getNode().getStatements(), handle);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getStatements(), handle);
    }
}