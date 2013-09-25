package ste.jmop.loaded;

import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaFileObject;

import com.sun.source.tree.AnnotationTree;
import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.ImportTree;
import com.sun.source.tree.LineMap;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

public class FakeCompilationUnit implements CompilationUnitTree {

    public final String fakePackage;
    public final Class aClass;
    
    public FakeCompilationUnit(String packageName, Class aClass) {
	fakePackage = packageName;
	this.aClass = aClass;
    }
    
    @Override
    public <R, D> R accept(TreeVisitor<R, D> arg0, D arg1) {
	return null;
    }

    @Override
    public Kind getKind() {
	return Kind.COMPILATION_UNIT;
    }

    @Override
    public List<? extends ImportTree> getImports() {
	return new ArrayList<ImportTree>();
    }

    @Override
    public LineMap getLineMap() {
	return null;
    }

    @Override
    public List<? extends AnnotationTree> getPackageAnnotations() {
	return new ArrayList<AnnotationTree>();
    }

    @Override
    public ExpressionTree getPackageName() {
	return new FakeIdentifier(fakePackage);
    }

    @Override
    public JavaFileObject getSourceFile() {
	return null;
    }

    @Override
    public List<? extends Tree> getTypeDecls() {
	List<Tree> list = new ArrayList<Tree>();
	list.add(new FakeClass(aClass));
	return list;
    }

}
