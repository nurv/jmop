package ste.jmop.lang;

import com.sun.source.tree.StatementTree;

public abstract class Statement<T extends StatementTree> extends MetaModel<T>{

    public Statement(T node, MetaModel parent) {
	super(node, parent);
    }

}
