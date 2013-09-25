package ste.jmop.handlers;

import ste.jmop.lang.Class;
import ste.jmop.lang.MetaModel;

public class FindClass extends SimpleKindVisitor{

    private Class foobar = null; 
    
    public FindClass() {
	super(Class.class);
    }

    @Override
    public void visit(MetaModel object) {
	this.setClazz((Class) object);
	stop();
    }

    private void setClazz(Class clazz) {
	this.foobar = clazz;
    }

    public Class getFoundClass() {
	return this.foobar;
    }
}
