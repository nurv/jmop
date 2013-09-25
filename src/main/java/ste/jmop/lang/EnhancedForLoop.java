package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.EnhancedForLoopTree;

public class EnhancedForLoop extends Statement<EnhancedForLoopTree> {
    protected EnhancedForLoop(EnhancedForLoopTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getVariable(), handle);
	make(getNode().getExpression(), handle);
	make(getNode().getStatement(), handle);
    }
}