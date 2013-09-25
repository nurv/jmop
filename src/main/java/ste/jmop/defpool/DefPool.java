package ste.jmop.defpool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import ste.jmop.lang.Class;
import ste.jmop.lang.CompilationUnit;
import ste.jmop.lang.MetaModelFactory;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.tools.internal.ws.processor.modeler.annotation.MakeSafeTypeVisitor;

import ste.jmop.lang.*;
import ste.jmop.loaded.FakeClass;
import ste.jmop.loaded.FakeCompilationUnit;

public class DefPool {
    private final static DefPool instance = new DefPool();

    public static DefPool instance() {
        return instance;
    }

    public static HashSet<String> packages = new HashSet<String>();

    private final ArrayList<CompilationUnit> list = new ArrayList<CompilationUnit>();

    public void addCompilationUnit(CompilationUnitTree tree) {
        CompilationUnit cu = (CompilationUnit) MetaModelFactory.make(tree, null);
        packages.add(cu.getPackageName());
        list.add(cu);
    }

    public Class getClassDef(String className) {
        String packageName = "";
        String cName = className;
        if (className.contains(".")) {
            packageName = className.substring(0, className.lastIndexOf("."));
            cName = className.substring(className.lastIndexOf(".") + 1);
        }

        for (CompilationUnit cu : getCompilationUnitsInPackage(packageName)) {
            for (Class clazz : cu.getClassDefs()) {
                if (clazz.getName().equals(cName)) {
                    return clazz;
                }
            }
        }

        className = translatePrimitiveToType(className);

        try {
            java.lang.Class rtClass = java.lang.Class.forName(className);
            if (rtClass != null) {
                String name;
                if (rtClass.getPackage() == null) {
                    name = "";
                } else {
                    name = rtClass.getPackage().getName();
                }
                return (Class) MetaModelFactory.make(new FakeClass(rtClass),
                        MetaModelFactory.make(new FakeCompilationUnit(name, rtClass), null));
            }
        } catch (ClassNotFoundException e) {
            java.lang.Class rtClass;
            try {
                rtClass = java.lang.Class.forName("java.lang." + className);
                if (rtClass != null) {
                    return (Class) MetaModelFactory.make(new FakeClass(rtClass),
                            MetaModelFactory.make(new FakeCompilationUnit(rtClass.getPackage().getName(), rtClass), null));
                }
            } catch (ClassNotFoundException e1) {
            }
        }

        return null;
    }

    private String translatePrimitiveToType(String type) {
        if (type.equals("boolean")) {
            return "java.lang.Boolean";
        }
        if (type.equals("char")) {
            return "java.lang.Character";
        }
        if (type.equals("byte")) {
            return "java.lang.Byte";
        }
        if (type.equals("short")) {
            return "java.lang.Short";
        }
        if (type.equals("int")) {
            return "java.lang.Integer";
        }
        if (type.equals("long")) {
            return "java.lang.Long";
        }
        if (type.equals("float")) {
            return "java.lang.Float";
        }
        if (type.equals("double")) {
            return "java.lang.Double";
        }
        if (type.equals("void")) {
            return "java.lang.Void";
        }
        if (type.endsWith("[]")) {
            String typeCopy = new String(type);
            String finalType = type.substring(0, type.indexOf("["));
            int charCount = count(type, '[');
            String result = "";
            for (int i = 0; i < charCount; i++) {
                result += "[";
            }
            if (finalType.equals("boolean")) {
                return result + "Z";
            } else if (finalType.equals("char")) {
                return result + "C";
            } else if (finalType.equals("byte")) {
                return result + "B";
            } else if (finalType.equals("short")) {
                return result + "S";
            } else if (finalType.equals("int")) {
                return result + "I";
            } else if (finalType.equals("long")) {
                return result + "J";
            } else if (finalType.equals("float")) {
                return result + "B";
            } else if (finalType.equals("double")) {
                return result + "D";
            } else {
                return result + "L" + finalType + ";";
            }
        }

        return type;
    }

    private static int count(final String s, final char c) {
        final char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                count++;
            }
        }
        return count;
    }

    public List<CompilationUnit> getCompilationUnitsInPackage(String packageName) {

        if (packageName.length() == 0) {
            return list;
        }

        ArrayList<CompilationUnit> units = new ArrayList<CompilationUnit>();
        for (CompilationUnit cu : list) {
            if (cu.getPackageName().equals(packageName)) {
                units.add(cu);
            }
        }
        return units;
    }

    public ArrayList<CompilationUnit> getCompilationUnits() {
        return list;
    }
}
