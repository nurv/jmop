package ste.jmop.lang;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ImportTree;

public class Import extends MetaModel<ImportTree> {
    protected Import(ImportTree node, MetaModel parent) {
	super(node, parent);
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getNode().getQualifiedIdentifier(), handle);
    }
    
    public String getName(){
	return getNode().getQualifiedIdentifier().toString();
    }
    
    public String getPackage(){
	String name = getName();
	if (isStatic()){
	    return name.substring(0, name.lastIndexOf(".")).substring(0,name.lastIndexOf("."));
	}else{
	    return name.substring(0,name.lastIndexOf("."));
	}
    }
    
    public String getClassName(){
	String name = getName();
	if (isStatic()){
	    return name.substring(0, name.lastIndexOf(".")).substring(name.lastIndexOf(".") + 1);
	}else{
	    return name.substring(name.lastIndexOf(".") + 1);
	}
    }
    
    public String getMethod(){
	String name = getName();
	return name.substring(name.lastIndexOf(".") + 1);
    }
    
    public boolean isStatic(){
	return getNode().isStatic();
    }
    public boolean hasWildcard(){
	return getName().contains("*");
    }
}