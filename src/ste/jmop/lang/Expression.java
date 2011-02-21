package ste.jmop.lang;

import com.sun.source.tree.ExpressionTree;

public abstract class Expression<T extends ExpressionTree> extends MetaModel<T>{

    public Expression(T node, MetaModel parent) {
	super(node, parent);
    }
}
