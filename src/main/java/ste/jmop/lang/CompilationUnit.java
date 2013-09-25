package ste.jmop.lang;

import java.util.List;

import ste.jmop.handlers.CollectKindVisitor;
import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.CompilationUnitTree;

public class CompilationUnit extends MetaModel<CompilationUnitTree> {
    protected CompilationUnit(CompilationUnitTree node, MetaModel parent) {
        super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
        make(getNode().getPackageAnnotations(), handle);
        make(getNode().getImports(), handle);
        make(getNode().getTypeDecls(), handle);
        make(getNode().getPackageName(), handle);

    }

    public String getPackageName() {
        if (getNode().getPackageName() != null) {
            return getNode().getPackageName().toString();
        } else {
            return null;
        }
    }

    public List<Class> getClassDefs() {
        return make(getNode().getTypeDecls());
    }

    public List<Import> getImports() {
        return make(getNode().getImports());
    }

    public List<Class> getAllClassDefs() {
        CollectKindVisitor<Class> cuc = new CollectKindVisitor<Class>(Class.class);
        visit(cuc);
        return cuc.getCollected();
    }
}