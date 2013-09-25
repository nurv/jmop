package ste.jmop.lang;

import java.util.ArrayList;
import java.util.List;

import javax.tools.Diagnostic;

import ste.jmop.handlers.CreateCannonicalNameForClass;
import ste.jmop.handlers.MetaModelVisitor;
import ste.jmop.reflect.CharSequenceCompiler;
import ste.jmop.reflect.CharSequenceCompilerException;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.Tree;

public class Class extends Statement<ClassTree> implements HasStatements {
    protected Class(ClassTree node, MetaModel parent) {
	super(node, parent);
    }

    public String getName() {
	return getNode().getSimpleName().toString();
    }

    public String getCannonicalName() {
	CreateCannonicalNameForClass ccnfc = new CreateCannonicalNameForClass();
	visitBottomTop(ccnfc);
	return ccnfc.getName();
    }

    public ParameterizedType getExtends() {
	return (ParameterizedType) MetaModelFactory.make(getNode().getExtendsClause(), this);
    }

    public List<ParameterizedType> getImplements() {
	ArrayList<ParameterizedType> m = new ArrayList<ParameterizedType>();

	for (Tree t : getNode().getImplementsClause()) {
	    m.add((ParameterizedType) MetaModelFactory.make(t, this));
	}
	return m;
    }

    public List<MetaModel> getMembers() {
	ArrayList<MetaModel> m = new ArrayList<MetaModel>();

	for (Tree t : getNode().getMembers()) {
	    m.add(MetaModelFactory.make(t, this));
	}
	return m;
    }

    public List<Method> getMethods() {
	ArrayList<Method> m = new ArrayList<Method>();
	for (MetaModel metaModel : getMembers()) {
	    if (metaModel instanceof Method) {
		m.add((Method) metaModel);
	    }
	}
	return m;
    }

    public List<Method> getMethods(String name) {
	ArrayList<Method> m = new ArrayList<Method>();
	for (MetaModel metaModel : getMembers()) {
	    if (metaModel instanceof Method) {
		Method method = (Method) metaModel;
		if (method.getName().equals(name)) {
		    m.add(method);
		}
	    }
	}
	return m;
    }

    public List<Variable> getFields() {
	ArrayList<Variable> m = new ArrayList<Variable>();
	for (MetaModel metaModel : getMembers()) {
	    if (metaModel instanceof Variable) {
		m.add((Variable) metaModel);
	    }
	}
	return m;
    }

    public Variable getField(String name) {
	for (MetaModel metaModel : getMembers()) {
	    if (metaModel instanceof Variable) {
		Variable v = (Variable) metaModel;
		if (v.getName().equals(name)) {
		    return v;
		}
	    }
	}
	return null;
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExtendsClause(), handle);
	make(getNode().getImplementsClause(), handle);
    }

    @Override
    public void visitStatements(MetaModelVisitor handle) {
	for (MetaModel m : getMembers()) {
	    m.visit(handle);
	}
    }

    public java.lang.Class getReflectClass() throws ClassNotFoundException {
	return java.lang.Class.forName(getCannonicalName());
    }

    public java.lang.Class loadClass() throws ClassCastException, CharSequenceCompilerException {
	if (this.getNode() instanceof ste.jmop.loaded.TreeFacade){
	    throw new RuntimeException(getCannonicalName() + " is frozen");
	}
	
	// also OK
	CharSequenceCompiler compiler = new CharSequenceCompiler(null, null);
	return compiler.compile(getCannonicalName(), getCompilationUnit().getNode().toString(),
		    null,new java.lang.Class[]{Object.class});

    }
}