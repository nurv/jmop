package ste.jmop.handlers;

import ste.jmop.lang.Class;
import ste.jmop.lang.CompilationUnit;
import ste.jmop.lang.MetaModel;

public class CreateCannonicalNameForClass extends SimpleVisitor{

    private String name = "";
    
    @Override
    public void visit(MetaModel object) {
	if (object instanceof Class){
	    if (getName() != "") {
		    setName("." + getName()); 
	    }
	    Class cl = (Class) object;
	    setName(cl.getName() + getName());
	
	}else if (object instanceof CompilationUnit){
	    CompilationUnit cl = (CompilationUnit) object;
	    if (cl.getPackageName().length() != 0){
		setName(cl.getPackageName() + "." + getName());
	    	stop();
	    }
	}
    }

    private void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    
}
