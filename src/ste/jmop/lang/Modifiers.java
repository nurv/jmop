package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ModifiersTree;

public class Modifiers extends MetaModel<ModifiersTree> {
    protected Modifiers(ModifiersTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getAnnotations(), handle);
    }

}