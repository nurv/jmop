package ste.jmop.loaded;

import javax.lang.model.element.Name;

import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.TreeVisitor;

public class FakeIdentifier implements IdentifierTree, TreeFacade {

    private final String id;
    
    public FakeIdentifier(String id) {
	this.id = id;
    }
    
    public FakeIdentifier(Object object) {
	this(object.toString());
    }

    @Override
    public <R, D> R accept(TreeVisitor<R, D> arg0, D arg1) {
	return null;
    }

    @Override
    public Kind getKind() {
	return Kind.IDENTIFIER;
    }

    @Override
    public Name getName() {
	return new FakeName(id);
    }
    @Override
    public String toString() {
        return id;
    }
}
