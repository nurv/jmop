package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ReturnTree;

public class Return extends Statement<ReturnTree> {
    protected Return(ReturnTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExpression(), handle);
    }


}