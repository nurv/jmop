package ste.jmop;

import ste.jmop.bootsrap.Bootstrap;
import ste.jmop.lang.Class;
import ste.jmop.reflect.Reflect;
import ste.jmop.test.Circle;

public class Main {

    public static void main(String[] args) {
        try {

            if (args.length < 1 || args[0] == null || args[0].trim().length() <= 0) {
                System.out.println("Please provide the java source file(s) " + "to be verified as argument");
                System.out.println("Usage: java Main {<comma separated list of source files>}");
                System.out.println("Exiting from the program");
                System.exit(0);
            } else {
                Bootstrap.bootstrap(args);
                Circle c = new Circle();
                c.x = 1;
                c.y = 1;

                Class cl = Reflect.about("ste.jmop.test.Circle");
                cl.getFields();
                java.lang.Class newCircle = cl.loadClass();

/*
		Class cl = DefPool.instance().getClassDef("ste.jmop.test.TestClass1");
		Method method = cl.getMethods("equals").get(0);

		CollectKindVisitor<Assignment> collector = new CollectKindVisitor<Assignment>(Assignment.class);
		method.visit(collector);
		Assignment a = collector.getCollected().get(0);
		System.out.println(a.findVariableDefinition());
		List<MethodInvocation> invoks = method.findMethodInvocation("xReference");

		for (MethodInvocation invok : invoks) {
		    System.out.println(invok.getInvokedMethod());
		}
		*/
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
