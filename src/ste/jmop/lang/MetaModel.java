package ste.jmop.lang;

import java.util.List;

import ste.jmop.defpool.DefPool;
import ste.jmop.handlers.CollectKindVisitor;
import ste.jmop.handlers.FindClass;
import ste.jmop.handlers.FindDeclaration;
import ste.jmop.handlers.MetaModelVisitor;
import ste.jmop.loaded.TreeFacade;

import com.sun.source.tree.Tree;

public abstract class MetaModel<T extends Tree> {

    private final T node;
    private MetaModel parent;

    public MetaModel(T node, MetaModel parent) {
	this.node = node;
	this.parent = parent;
    }

    public T getNode() {
	return node;
    }

    public MetaModel getParent() {
	return parent;
    }

    public void visitBottomTop(MetaModelVisitor handle) {
	boolean visit = handle.doVisit(this);
	if (handle.isStoped()) {
	    return;
	}
	if (visit) {
	    handle.onEnter(this);
	}
	if (handle.isStoped()) {
	    return;
	}
	if (getParent() != null) {
	    getParent().visitBottomTop(handle);
	}
	if (handle.isStoped()) {
	    return;
	}
	if (visit) {
	    handle.onExit(this);
	}
    }

    protected <T extends MetaModel> T make(Tree t) {
	return (T) MetaModelFactory.make(t, this);
    }

    protected void make(Tree t, MetaModelVisitor handle) {
	MetaModel o = MetaModelFactory.make(t, this);
	if (o != null && !handle.isPaused() && !handle.isStoped()) {
	    o.visit(handle);
	}
    }

    protected List make(List t) {
	return MetaModelFactory.make(t, this);
    }

    protected void make(List t, MetaModelVisitor handle) {
	if (t == null) {
	    return;
	}
	for (Object m : make(t)) {
	    if (handle.isStoped()) {
		break;
	    }
	    ((MetaModel) m).visit(handle);
	}
    }

    protected abstract void goDeep(MetaModelVisitor handle);

    public final void visit(MetaModelVisitor handle) {
	boolean visit = handle.doVisit(this);
	if (handle.isStoped()) {
	    return;
	}
	if (visit) {
	    handle.onEnter(this);
	}
	if (!handle.isPaused()) {
	    goDeep(handle);
	} else {
	    handle.resetPause();
	}
	if (visit) {
	    handle.onExit(this);
	}
    }

    @Override
    public String toString() {
	return getClass().getCanonicalName() + ": " + getNode().toString();
    }

    public CompilationUnit getCompilationUnit() {
	CollectKindVisitor<CompilationUnit> cuc = new CollectKindVisitor<CompilationUnit>(CompilationUnit.class);
	this.visitBottomTop(cuc);
	return cuc.getCollected().get(0);
    }

    public String resolveType(String type) {
	if (type.contains(".")) {
	    return type;
	}

	if (type.endsWith("[]")){
	    return resolveType(type.substring(0,type.indexOf("["))) + type.substring(type.indexOf("[")) ;
	}
	
	CompilationUnit cu = getCompilationUnit();

	for (Class cl : cu.getAllClassDefs()) {
	    if (cl.getName().equals(type)) {
		return cl.getCannonicalName();
	    }
	}

	for (Import aImport : cu.getImports()) {
	    if (aImport.isStatic()) {
		continue;
	    }

	    if (!aImport.hasWildcard()) {
		if (aImport.getClassName().equals(type)) {
		    return aImport.getName();
		}
	    } else {
		for (CompilationUnit otherCu : DefPool.instance().getCompilationUnitsInPackage(aImport.getPackage())) {
		    for (Class cl : otherCu.getAllClassDefs()) {
			if (cl.getName().equals(type)) { // TODO: modifiers private shouldn't return and inheritance based
			    return cl.getCannonicalName();
			}
		    }
		}
	    }
	}

	if (cu.getPackageName().length() > 0) {
	    for (CompilationUnit otherCu : DefPool.instance().getCompilationUnitsInPackage(cu.getPackageName())) {
		for (Class cl : otherCu.getAllClassDefs()) {
		    if (cl.getName().equals(type)) {
			return cl.getCannonicalName();
		    }
		}
	    }
	}

	return null;
    }
    
    public Class getFirstClass(){
	FindClass fc = new FindClass();
	this.visitBottomTop(fc);
	return fc.getFoundClass();
    }
    
    public Method resolveMethod(String methodName){
	List<Method> list = getFirstClass().getMethods(methodName);
	
	if (list.size() > 0 ){
	    return list.get(0);
	}
	
	// maybe static?
	CompilationUnit cu = getCompilationUnit();
	
	for (Import aImport : cu.getImports()) {
	    if (!aImport.isStatic()) {
		continue;
	    }

	    if (!aImport.hasWildcard()) {
		if (aImport.getMethod().equals(methodName)) {
		    return DefPool.instance().getClassDef(aImport.getClassName()).getMethods(methodName).get(0);
		}
	    } else {
		for (Method method : DefPool.instance().getClassDef(aImport.getClassName()).getMethods()) {
		    if (method.getName().equals(methodName)){
			return method;
		    }
		}
	    }
	}
	
	return null;
    }
    
    public Variable resolveVariable(String variable) {
	FindDeclaration fd = new FindDeclaration(variable);
	getParent().visitBottomTop(fd);
	return fd.getVariable();
    }
    
    public Method resolveMethod(String variable, String methodName){
	if (variable.equals("this")){
	    return resolveMethod(methodName);
	}
	Variable v = (Variable) resolveVariable(variable);
	String type = v.getType();
	Class cl = DefPool.instance().getClassDef(type);
	return cl.getMethods(methodName).get(0);
    }
    
    protected String normalTypeResolution(){
	if (this instanceof Identifier){
	    return ((Identifier) this).getName();
	}else if (this instanceof PrimitiveType){
	    return ((PrimitiveType) this).getName();
	}else if (this instanceof ParameterizedType){
	    return ((ParameterizedType) this).getType();
	}
	throw new RuntimeException("Missed Something");
    }
    
    public boolean isFacade(){
	return this.getNode().getClass().isAssignableFrom(TreeFacade.class);
    }
}