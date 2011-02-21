package ste.jmop.loaded;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Name;

import com.sun.source.tree.ClassTree;
import com.sun.source.tree.ModifiersTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;
import com.sun.source.tree.TypeParameterTree;

public class FakeClass implements ClassTree, TreeFacade {

    public final Class aClass;

    public FakeClass(Class theClass) {
	aClass = theClass;
    }

    @Override
    public Kind getKind() {
	return Kind.CLASS;
    }

    @Override
    public <R, D> R accept(TreeVisitor<R, D> arg0, D arg1) {

	return null;
    }

    @Override
    public List<? extends TypeParameterTree> getTypeParameters() {
	return new ArrayList<TypeParameterTree>();
    }

    @Override
    public Name getSimpleName() {
	return new FakeName(aClass.getSimpleName());
    }

    @Override
    public ModifiersTree getModifiers() {
	return new FakeModifiers(aClass.getModifiers());
    }

    @Override
    public List<? extends Tree> getMembers() {
	List<Tree> list = new ArrayList<Tree>();

	for (Method method : aClass.getMethods()) {
	    list.add(new FakeMethod(method));
	}
	
	for (Field field : aClass.getFields()){
	    list.add(new FakeVariable(field.getType(), field.getName()));
	}
	return list;
    }

    @Override
    public List<? extends Tree> getImplementsClause() {
	List<FakeIdentifier> result = new ArrayList<FakeIdentifier>();
	for (Class cl : aClass.getInterfaces()) {
	    result.add(new FakeIdentifier(cl.getCanonicalName()));
	}
	return result;
    }

    @Override
    public Tree getExtendsClause() {
	// TODO Auto-generated method stub
	return new FakeIdentifier(aClass.getSuperclass().getCanonicalName());
    }

}
