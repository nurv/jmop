package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.WildcardTree;

public class Wildcard extends MetaModel<WildcardTree> {
    protected Wildcard(WildcardTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getBound(), handle);
    }

}