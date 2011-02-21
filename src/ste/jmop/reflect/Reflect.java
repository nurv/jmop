package ste.jmop.reflect;

import ste.jmop.defpool.DefPool;

public class Reflect {
    
    public static ste.jmop.lang.Class over (Object obj){
	return DefPool.instance().getClassDef(obj.getClass().getCanonicalName());
    }
    
    public static ste.jmop.lang.Class about (Class clazz){
	return DefPool.instance().getClassDef(clazz.getCanonicalName());
    }
    public static ste.jmop.lang.Class about (String clazz){
	return DefPool.instance().getClassDef(clazz);
    }
}
