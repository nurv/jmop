package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.NewClassTree;

public class NewClass extends Expression<NewClassTree> {
    protected NewClass(NewClassTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getArguments(), handle);
	make(getNode().getTypeArguments(), handle);
	make(getNode().getEnclosingExpression(), handle);
	make(getNode().getClassBody(), handle);
    }

}