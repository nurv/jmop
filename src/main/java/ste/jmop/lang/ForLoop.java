package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ForLoopTree;

public class ForLoop extends Statement<ForLoopTree> implements HasStatements{
    protected ForLoop(ForLoopTree node, MetaModel parent) {
	super(node, parent);
    }


    @Override
    public void visitStatements(MetaModelVisitor handle) {
	make(getNode().getInitializer(), handle);
    }


    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getInitializer(), handle);
	make(getNode().getUpdate(), handle);
	make(getNode().getCondition(), handle);
	make(getNode().getStatement(), handle);
    }
}