package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.InstanceOfTree;

public class InstanceOf extends Expression<InstanceOfTree> {
    protected InstanceOf(InstanceOfTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getType(), handle);
	make(getNode().getExpression(), handle);
    }

}