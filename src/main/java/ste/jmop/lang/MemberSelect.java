package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.MemberSelectTree;

public class MemberSelect extends Expression<MemberSelectTree> {
    protected MemberSelect(MemberSelectTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExpression(), handle);
    }
    
    public Expression getExpression(){
	return make(getNode().getExpression());
    }
    
    public String getIdentifier(){
	return getNode().getIdentifier().toString();
    }
    
    
}