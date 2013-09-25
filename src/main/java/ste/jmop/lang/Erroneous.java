package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ErroneousTree;

public class Erroneous extends Expression<ErroneousTree> {
    protected Erroneous(ErroneousTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getErrorTrees(), handle);
    }
}