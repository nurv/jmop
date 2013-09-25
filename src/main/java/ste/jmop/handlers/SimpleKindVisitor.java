package ste.jmop.handlers;

import ste.jmop.lang.MetaModel;

public abstract class SimpleKindVisitor extends KindVisitor<MetaModel> {

    public SimpleKindVisitor(Class kind) {
	super(kind);
    }

    public abstract void visit (MetaModel object);
    
    @Override
    public void onEnter(MetaModel object) {
	visit(object);
    }

    @Override
    public void onExit(MetaModel object) {
    }

}
