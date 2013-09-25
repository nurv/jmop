package ste.jmop.handlers;

import ste.jmop.lang.HasStatements;
import ste.jmop.lang.MetaModel;
import ste.jmop.lang.Statement;
import ste.jmop.lang.Variable;

public class FindDeclaration extends SimpleVisitor {

    public final String name;
    private Variable variable;

    public FindDeclaration(String name) {
	this.name = name;
    }

    @Override
    public void visit(MetaModel object) {
	pause();
	if (object instanceof HasStatements) {
	    HasStatements hasStatements = (HasStatements) object;
	    hasStatements.visitStatements(this);
	} else if (object instanceof Statement) {
	    if (object instanceof Variable) {
		if (((Variable) object).getName().equals(name)) {
		    this.setVariable((Variable) object);
		    stop();
		}
	    }
	}
    }

    private void setVariable(Variable variable) {
	this.variable = variable;
    }

    public Variable getVariable() {
	return variable;
    }

}
