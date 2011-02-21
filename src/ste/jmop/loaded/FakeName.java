package ste.jmop.loaded;

import javax.lang.model.element.Name;

public class FakeName implements Name, TreeFacade {

    private final String name;
    
    public FakeName(String name) {
	this.name = name;
    }
    
    @Override
    public char charAt(int index) {
	return this.name.charAt(index);
    }

    @Override
    public int length() {
	// TODO Auto-generated method stub
	return this.name.length();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
	// TODO Auto-generated method stub
	return this.name.subSequence(start, end);
    }

    @Override
    public boolean contentEquals(CharSequence cs) {
	// TODO Auto-generated method stub
	return this.name.contentEquals(cs);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.name.equals(obj);
    }
    
    @Override
    public String toString() {
        return name;
    }
}
