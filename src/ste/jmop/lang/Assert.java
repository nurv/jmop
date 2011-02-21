package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.AssertTree;

public class Assert extends Statement<AssertTree> {
    protected Assert(AssertTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getCondition(), handle);
	make(getNode().getDetail(), handle);
    }
}