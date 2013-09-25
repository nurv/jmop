package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ArrayTypeTree;

public class ArrayType extends MetaModel<ArrayTypeTree> {
    protected ArrayType(ArrayTypeTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getType(), handle);
    }
}