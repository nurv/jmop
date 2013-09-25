package ste.jmop.lang;

import ste.jmop.handlers.FindDeclaration;
import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.AssignmentTree;

public class Assignment extends Expression<AssignmentTree> {
    protected Assignment(AssignmentTree node, MetaModel parent) {
	super(node, parent);
    }
    
    public Expression getVariable(){
	return make(getNode().getVariable());
    }
    
    public Expression getExpression(){
	return make(getNode().getExpression());
    }
    
    public boolean isLocal(){
	return getVariable() instanceof Identifier;
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getVariable(), handle);
	make(getNode().getExpression(), handle);
    }

    public Variable findVariableDefinition() {
	return this.resolveVariable(((Identifier)getVariable()).getName());
    }
}