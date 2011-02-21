package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.PrimitiveTypeTree;

public class PrimitiveType extends MetaModel<PrimitiveTypeTree> {
    protected PrimitiveType(PrimitiveTypeTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
    }
    
    public String getName(){
	return getNode().getPrimitiveTypeKind().toString();
    }
}