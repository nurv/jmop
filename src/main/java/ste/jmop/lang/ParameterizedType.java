package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ParameterizedTypeTree;

public class ParameterizedType extends MetaModel<ParameterizedTypeTree> {
    protected ParameterizedType(ParameterizedTypeTree node, MetaModel parent) {
	super(node, parent);
    }
    
    public String getType(){
	return null;
    }
    
    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getType(), handle);
	make(getNode().getTypeArguments(), handle);
    }

}