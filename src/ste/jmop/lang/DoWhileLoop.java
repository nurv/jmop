package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.DoWhileLoopTree;

public class DoWhileLoop extends Statement<DoWhileLoopTree> {
    protected DoWhileLoop(DoWhileLoopTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getStatement(), handle);
	make(getNode().getCondition(), handle);
    }
}