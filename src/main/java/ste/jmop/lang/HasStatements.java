package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

public interface HasStatements{
    public void visitStatements(MetaModelVisitor handle);
}
