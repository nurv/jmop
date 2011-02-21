package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ParenthesizedTree;

public class Parenthesized extends Expression<ParenthesizedTree> {
    protected Parenthesized(ParenthesizedTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getExpression(), handle);
    }


}