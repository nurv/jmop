package ste.jmop.constructs;

import ste.jmop.lang.Class;
import ste.jmop.lang.Method;

public class MethodDeclaration {
    public final Class classDef;
    public final Method method;
    public MethodDeclaration(Class c, Method m){
	classDef = c;
	method = m;
    }
}
