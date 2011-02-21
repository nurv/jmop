package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.SwitchTree;

public class Switch extends Statement<SwitchTree> {
    protected Switch(SwitchTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExpression(), handle);
	make(getNode().getCases(), handle);
    }
}