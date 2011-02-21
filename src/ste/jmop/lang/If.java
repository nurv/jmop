package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.IfTree;

public class If extends Statement<IfTree> {
    protected If(IfTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getCondition(), handle);
	make(getNode().getThenStatement(), handle);
	make(getNode().getElseStatement(), handle);
    }

}