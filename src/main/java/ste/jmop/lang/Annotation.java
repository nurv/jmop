package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.AnnotationTree;
import com.sun.source.tree.ExpressionTree;

public class Annotation extends Expression<AnnotationTree> {
    protected Annotation(AnnotationTree node, MetaModel parent) {
	super(node, parent);
    }

    public void goDeep(MetaModelVisitor handle) {
	make(getNode().getAnnotationType(), handle);
	make(getNode().getArguments(), handle);
    }
}