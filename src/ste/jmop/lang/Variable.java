package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.VariableTree;

public class Variable extends Statement<VariableTree> {
    protected Variable(VariableTree node, MetaModel parent) {
	super(node,parent);
    }
    
    public String getName() {
	return getNode().getName().toString();
    }
    
    public String getType(){
	MetaModel m = make(getNode().getType());
	return m.normalTypeResolution();
    }
    
    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getModifiers(), handle);
	make(getNode().getType(), handle);
	make(getNode().getInitializer(), handle);
    }
}