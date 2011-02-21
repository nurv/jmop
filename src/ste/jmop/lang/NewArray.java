package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.NewArrayTree;

public class NewArray extends Expression<NewArrayTree> {
    protected NewArray(NewArrayTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getDimensions(), handle);
	make(getNode().getInitializers(), handle);
    }

}