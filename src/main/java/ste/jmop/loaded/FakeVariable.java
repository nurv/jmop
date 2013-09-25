package ste.jmop.loaded;

import javax.lang.model.element.Name;

import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.ModifiersTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;
import com.sun.source.tree.VariableTree;

public class FakeVariable implements VariableTree, TreeFacade{

    public final Class type;

    public final String name;
    
    public FakeVariable(Class type, String name) {
	this.type = type;
	this.name = name;
    }

    @Override
    public <R, D> R accept(TreeVisitor<R, D> arg0, D arg1) {
	return null;
    }

    @Override
    public Kind getKind() {
	return Kind.VARIABLE;
    }

    @Override
    public ExpressionTree getInitializer() {
	return null;
    }

    @Override
    public ModifiersTree getModifiers() {
	return null;
    }

    @Override
    public Name getName() {
	return new FakeName(name);
    }

    @Override
    public Tree getType() {
	return new FakeIdentifier(type.getCanonicalName());
    }
    
    @Override
    public String toString() {
        return type.getCanonicalName() + " " + name;
    }

}
