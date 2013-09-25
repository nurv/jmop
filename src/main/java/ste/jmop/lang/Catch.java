package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.CatchTree;

public class Catch extends MetaModel<CatchTree> {
    protected Catch(CatchTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getParameter(), handle);
	make(getNode().getBlock(), handle);
    }
}