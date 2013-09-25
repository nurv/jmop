package ste.jmop.lang;

import ste.jmop.defpool.DefPool;
import ste.jmop.handlers.FindDeclaration;
import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.MethodInvocationTree;

public class MethodInvocation extends Expression<MethodInvocationTree> {
    protected MethodInvocation(MethodInvocationTree node, MetaModel parent) {
	super(node, parent);
    }

    public Expression getMethodSelect() {
	return make(getNode().getMethodSelect());
    }

    public Arguments getArguments() {
	return new Arguments(getNode().getArguments(), this);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	getArguments().visit(handle);
	make(getNode().getTypeArguments(), handle);
	make(getNode().getMethodSelect(), handle);
    }
    
    public String getMethodName() {
	if (getMethodSelect() instanceof MemberSelect) {
	    return ((MemberSelect) getMethodSelect()).getIdentifier();
	}else if (getMethodSelect() instanceof Identifier) {
	    return ((Identifier) getMethodSelect()).toString();
	}
	throw new RuntimeException("Maybe missing something here");
    }

    public Method getInvokedMethod(){
	if (getMethodSelect() instanceof MemberSelect) {
	    MemberSelect ms = ((MemberSelect) getMethodSelect());
	    if (ms.getExpression() instanceof Identifier) {
		return resolveMethod(((Identifier) ms.getExpression()).getName(), ms.getIdentifier());
	    }else if (ms.getExpression() instanceof MethodInvocation) {
		Method method = ((MethodInvocation) ms.getExpression()).getInvokedMethod();
		Class cl = method.getReturnClass();
		return cl.getMethods(ms.getIdentifier()).get(0);
	    }
	}else if (getMethodSelect() instanceof Identifier){
	    return resolveMethod(((Identifier) getMethodSelect()).getName()); 
	}
	return null;
    }
}