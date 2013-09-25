package ste.jmop.intersect;

import ste.jmop.lang.MetaModel;

import com.sun.tools.javac.tree.JCTree;

public class ReplaceNode extends Modifier{

    public MetaModel before;
    public MetaModel after;
    
    public ReplaceNode(MetaModel before, MetaModel after) {
	this.before = before;
	this.after = after;
    }
    
    @Override
    public void doSomething(JCTree tree) {
	if (tree == before.getNode()){
	    result = (JCTree) after.getNode();
	}
    }

}
