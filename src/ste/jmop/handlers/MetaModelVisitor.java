package ste.jmop.handlers;

import ste.jmop.lang.MetaModel;

public abstract class MetaModelVisitor{
    
    private boolean pause = false;
    private boolean stop = false;
    
    protected void pause(){
	pause = true;
    }
    
    public void resetPause() {
	pause = false;
    }
    
    public boolean isPaused() {
	return pause;
    }
    
    protected void stop(){
	stop = true;
    }
    
    public final boolean isStoped(){
	return stop;
    }
    
    public boolean doVisit(MetaModel object){
	return true;
    }
    
    public abstract void onEnter (MetaModel object);
    public abstract void onExit (MetaModel object);
    
    
}
