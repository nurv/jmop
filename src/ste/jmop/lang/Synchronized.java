package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.SynchronizedTree;

public class Synchronized extends Statement<SynchronizedTree> {
    protected Synchronized(SynchronizedTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExpression(), handle);
	make(getNode().getBlock(), handle);
    }

}