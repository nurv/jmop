package ste.jmop.lang;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import ste.jmop.defpool.DefPool;
import ste.jmop.handlers.CollectKindVisitor;
import ste.jmop.handlers.FindClass;
import ste.jmop.handlers.MetaModelVisitor;
import ste.jmop.loaded.FakeMethod;

import com.sun.source.tree.MethodTree;

public class Method extends MetaModel<MethodTree> {
    protected Method(MethodTree node, MetaModel parent) {
	super(node, parent);
    }

    public String getName() {
	return getNode().getName().toString();
    }

    public List<Annotation> getAnnotation() {
	return (ArrayList<Annotation>) MetaModelFactory.make(getNode().getModifiers().getAnnotations(), this);
    }

    public void findUseOf(Class c) {
	
    }

    public Block getBody(){
	return (Block) make(getNode().getBody());
    }

    public String getReturnType(){
	MetaModel m = make(getNode().getReturnType());
	return m.normalTypeResolution();
    }
    
    public Class getReturnClass(){
	MetaModel m = make(getNode().getReturnType());
	return DefPool.instance().getClassDef(m.resolveType(m.normalTypeResolution()));
    }
    
    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getReturnType(), handle);
	make(getNode().getTypeParameters(), handle);
	make(getNode().getDefaultValue(), handle);
	make(getNode().getParameters(), handle);
	make(getNode().getThrows(), handle);
	make(getNode().getBody(), handle);
    }
    
    public List<MethodInvocation> findMethodInvocation (String method){
	CollectKindVisitor<MethodInvocation> methodInvocations = new CollectKindVisitor<MethodInvocation>(MethodInvocation.class);
	this.visit(methodInvocations);
	
	ArrayList<MethodInvocation> result = new ArrayList<MethodInvocation>();
	for (MethodInvocation methodInvoke : methodInvocations.getCollected()){
	    Expression expr = methodInvoke.getMethodSelect();
	    if (expr instanceof Identifier){
		Identifier identifier = (Identifier) expr;
		if (identifier.getName().equals(method)){
		    result.add(methodInvoke);
		}
	    }else if (expr instanceof MemberSelect){
		MemberSelect memberSelect = (MemberSelect) expr;
		if (memberSelect.getIdentifier().equals(method)){
		    result.add(methodInvoke);
		}
	    }
	}
	return result;
    }
    
    public Class getClassDef(){
	FindClass fc = new FindClass();
	this.visitBottomTop(fc);
	return fc.getFoundClass();
    }
    
    public Object call(Object receiver, Object ... args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, ClassNotFoundException{
	if (isFacade()){
	    java.lang.reflect.Method aMethod = ((FakeMethod)getNode()).getMethod();
	    return aMethod.invoke(receiver, args);
	}else{
	    java.lang.Class cl = getClassDef().getReflectClass();
	    
	    throw new RuntimeException("Not Implemented Yet");
	}
	
    }
}