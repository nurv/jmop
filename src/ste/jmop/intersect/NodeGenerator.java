package ste.jmop.intersect;

import ste.jmop.lang.CompilationUnit;
import ste.jmop.lang.MetaModelFactory;
import ste.jmop.lang.Variable;

public class NodeGenerator {

    public static CompilationUnit createCompilationUnit (String code) {
	CharSequenceCompiler compiler = new CharSequenceCompiler(null, null);
	try {
	    return (CompilationUnit) MetaModelFactory.make(compiler.parse("foo", code, null, new java.lang.Class[] { Object.class }), null);
	} catch (Exception e){
	    throw new RuntimeException("problems creating compilation unit");
	}
	
    }
    
    public static Variable createField(String field){
	String code = "public class foo {" + field + "}";
	return createCompilationUnit(code).getAllClassDefs().get(0).getFields().get(0);
    }
    
}
