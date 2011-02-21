package ste.jmop.test;

import ste.jmop.*;

public class A {

    public class B {
	public class C {
	    public void make() {
		System.out.println(this.getClass().getCanonicalName());

	    }
	}

	public void make() {
	    new C().make();
	    System.out.println(this.getClass().getCanonicalName());
	}

    }

    public static void main(String[] args) {
	A a = new A();
	a.new B().make();
    }
    
    public String xReference() {
	return "YES";
    }
}
