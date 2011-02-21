package ste.jmop.handlers;

import ste.jmop.lang.MetaModel;

public abstract class SimpleVisitor extends MetaModelVisitor{
    
    @Override
    public boolean doVisit(MetaModel object) {
        return true;
    }
    
    @Override
    public void onEnter(MetaModel object) {
	visit(object);
	
    }

    public abstract void visit(MetaModel object);
    
    @Override
    public void onExit(MetaModel object) {
    }

}
