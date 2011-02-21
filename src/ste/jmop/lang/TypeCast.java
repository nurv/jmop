package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.TypeCastTree;

public class TypeCast extends Expression<TypeCastTree> {
    protected TypeCast(TypeCastTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getType(), handle);
	make(getNode().getExpression(), handle);
    }
}