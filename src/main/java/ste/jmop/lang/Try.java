package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.TryTree;

public class Try extends Statement<TryTree> {
    protected Try(TryTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getBlock(), handle);
	make(getNode().getCatches(), handle);
	make(getNode().getFinallyBlock(), handle);
    }

}