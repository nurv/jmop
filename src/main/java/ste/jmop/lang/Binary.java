package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.BinaryTree;

public class Binary extends Expression<BinaryTree> {
    protected Binary(BinaryTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getLeftOperand(), handle);
	make(getNode().getRightOperand(), handle);
    }
}