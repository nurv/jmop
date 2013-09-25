package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.WhileLoopTree;

public class WhileLoop extends Statement<WhileLoopTree> {
    protected WhileLoop(WhileLoopTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getCondition(), handle);
	make(getNode().getStatement(), handle);
    }

}