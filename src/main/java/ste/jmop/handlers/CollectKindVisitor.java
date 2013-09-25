package ste.jmop.handlers;

import java.util.ArrayList;
import java.util.List;

import ste.jmop.lang.MetaModel;

public class CollectKindVisitor<T extends MetaModel> extends KindVisitor<T> {

    private ArrayList<T> list = new ArrayList<T>();

    public CollectKindVisitor(Class kind) {
	super(kind);
    }

    @Override
    public void onEnter(MetaModel object) {
	list.add((T)object);
    }

    @Override
    public void onExit(MetaModel object) {
    }
    
    public List<T> getCollected(){
	return list;
    }
}
