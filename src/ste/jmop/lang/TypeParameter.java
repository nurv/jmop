package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.TypeParameterTree;

public class TypeParameter extends MetaModel<TypeParameterTree> {
    protected TypeParameter(TypeParameterTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getBounds(), handle);
    }
}