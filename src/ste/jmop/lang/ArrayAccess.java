package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ArrayAccessTree;

public class ArrayAccess extends Expression<ArrayAccessTree> {
    protected ArrayAccess(ArrayAccessTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExpression(), handle);
	make(getNode().getIndex(), handle);
    }


}