package ste.jmop.lang;

import javax.lang.model.type.TypeKind;

public enum PrimitiveElements {
    BYTE(1), CHAR(2), SHORT(3), INT(4), LONG(5), FLOAT(6), DOUBLE(7), BOOLEAN(8), VOID(9);
    private final int tag;

    PrimitiveElements(int tag) {
	this.tag = tag;
    }

    public int getTag() {
	return tag;
    }
}
