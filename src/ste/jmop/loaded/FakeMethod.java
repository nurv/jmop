package ste.jmop.loaded;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Name;

import com.sun.source.tree.BlockTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.ModifiersTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;
import com.sun.source.tree.TypeParameterTree;
import com.sun.source.tree.VariableTree;

public class FakeMethod implements MethodTree, TreeFacade {

    public final Method method;
    
    public Method getMethod() {
        return method;
    }


    public FakeMethod(Method method) {
	this.method = method;
	
    }
    	
    
    @Override
    public <R, D> R accept(TreeVisitor<R, D> arg0, D arg1) {
	return null;
    }
    
    @Override
    public Kind getKind() {
	return Kind.METHOD;
    }

    @Override
    public BlockTree getBody() {
	throw new RuntimeException("Cannot inspect a loaded class method body");
    }

    @Override
    public Tree getDefaultValue() {
	return new FakeIdentifier(method.getDefaultValue());
    }

    @Override
    public ModifiersTree getModifiers() {
	return new FakeModifiers(method.getModifiers());
    }

    @Override
    public Name getName() {
	return new FakeName(method.getName());
    }

    @Override
    public List<? extends VariableTree> getParameters() {
	List<VariableTree> result = new ArrayList<VariableTree>();
	Class[] list = method.getParameterTypes();
	int i = 0;
	for (Class cl : list){
	    result.add(new FakeVariable(cl, "arg" + i));
	}
	return result;
    }

    @Override
    public Tree getReturnType() {
	return new FakeIdentifier(method.getReturnType().getCanonicalName());
    }

    @Override
    public List<? extends ExpressionTree> getThrows() {
	List<ExpressionTree> result = new ArrayList<ExpressionTree>();
	for (Class cl : method.getExceptionTypes()){
	       result.add(new FakeIdentifier(cl.getCanonicalName()));
	}
	return result;
    }

    @Override
    public List<? extends TypeParameterTree> getTypeParameters() {
	throw new RuntimeException("Not Implemented Yet");
    }
    
    @Override
    public String toString() {
        return method.toString() + "{\n\t[JVM bytecode]\n}";
    }
}
