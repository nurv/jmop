package ste.jmop.test;

public final class TestClass1 {

    public int foo = 1;
    

    public static void main(String args[]) {
	TestClass1 t = new TestClass1();
	System.out.println(t.readTest(t.test(1, 2, 3)));
    }
    
    public String readTest (int i){
	return "result is" + i;
    }
    
    public int test (int a, int b, int c) {
        return 3;
    }
    
    public TestClass1 self(){
	return this;
    }
    
    @Override
    public boolean equals(Object obj) {
	Integer bar = 2;
	A d = null;
	bar = 3;
	this.test(1, 1, 1);
	this.self().test(1, 1, 1);
	d.xReference();
	test(1, 2, 3);
        return true;
    }
   
}
