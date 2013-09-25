package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.CompoundAssignmentTree;

public class CompoundAssignment extends Expression<CompoundAssignmentTree> {
    protected CompoundAssignment(CompoundAssignmentTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getVariable(), handle);
	make(getNode().getExpression(), handle);
    }
}