package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.IdentifierTree;

public class Identifier extends Expression<IdentifierTree> {
    protected Identifier(IdentifierTree node, MetaModel parent) {
	super(node, parent);
    }

    public String getName() {
	return getNode().getName().toString();
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
    }
}