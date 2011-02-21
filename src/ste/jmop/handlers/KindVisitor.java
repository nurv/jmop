package ste.jmop.handlers;

import ste.jmop.lang.MetaModel;

public abstract class KindVisitor<T extends MetaModel> extends MetaModelVisitor{
    private final Class kind;
    
    public KindVisitor(Class kind){
	this.kind = kind;
    }
    
    @Override
    public boolean doVisit(MetaModel object) {
        if (object.getClass().isAssignableFrom(kind)){
            return true;
        }else{
            return false;
        }
    }
    
    public Class<T> getKind() {
	return kind;
    }
}
