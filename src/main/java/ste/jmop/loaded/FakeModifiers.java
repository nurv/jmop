package ste.jmop.loaded;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Modifier;

import com.sun.source.tree.AnnotationTree;
import com.sun.source.tree.ModifiersTree;
import com.sun.source.tree.TreeVisitor;

public class FakeModifiers implements ModifiersTree, TreeFacade {

    public final int flags;

    public FakeModifiers(int flags) {
	this.flags = flags;
    }

    @Override
    public <R, D> R accept(TreeVisitor<R, D> arg0, D arg1) {
	return null;
    }

    @Override
    public Kind getKind() {
	return Kind.MODIFIERS;
    }

    @Override
    public List<? extends AnnotationTree> getAnnotations() {
	return null;
    }

    @Override
    public Set<Modifier> getFlags() {
	HashSet<Modifier> result = new HashSet<Modifier>();

	if (java.lang.reflect.Modifier.isAbstract(flags)) {
	    result.add(Modifier.ABSTRACT);
	}

	if (java.lang.reflect.Modifier.isFinal(flags)) {
	    result.add(Modifier.FINAL);
	}

	if (java.lang.reflect.Modifier.isNative(flags)) {
	    result.add(Modifier.NATIVE);
	}

	if (java.lang.reflect.Modifier.isPrivate(flags)) {
	    result.add(Modifier.PRIVATE);
	}

	if (java.lang.reflect.Modifier.isPublic(flags)) {
	    result.add(Modifier.PUBLIC);
	}

	if (java.lang.reflect.Modifier.isProtected(flags)) {
	    result.add(Modifier.PROTECTED);
	}

	if (java.lang.reflect.Modifier.isStatic(flags)) {
	    result.add(Modifier.STATIC);
	}

	if (java.lang.reflect.Modifier.isSynchronized(flags)) {
	    result.add(Modifier.SYNCHRONIZED);
	}

	if (java.lang.reflect.Modifier.isTransient(flags)) {
	    result.add(Modifier.TRANSIENT);
	}

	if (java.lang.reflect.Modifier.isVolatile(flags)) {
	    result.add(Modifier.VOLATILE);
	}

	return result;
    }

}
