package ste.jmop.lang;

import java.util.List;

import ste.jmop.handlers.MetaModelVisitor;

import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.Tree;
import com.sun.source.tree.TreeVisitor;

public class Arguments extends MetaModel<Tree>{
    private static final Tree NODE = new Tree(){

	@Override
	public <R, D> R accept(TreeVisitor<R, D> arg0, D arg1) {
	    throw new RuntimeException("Cannot visit a dummy node");
	}

	@Override
	public Kind getKind() {
	    throw new RuntimeException("Cannot visit a dummy node");
	}
	
    };
    
    private List<ExpressionTree> list;
    
    public Arguments(List<? extends ExpressionTree> list2, MetaModel parent) {
	super(NODE, parent);
	this.setExpressions(list2); 
    }

    @Override
    protected void goDeep(MetaModelVisitor handle) {
	make(getExpressions(),handle);
    }

    private void setExpressions(List<? extends ExpressionTree> list2) {
	this.list = (List<ExpressionTree>) list2;
    }

    public List<ExpressionTree> getExpressions() {
	return list;
    }
}
