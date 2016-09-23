package com.sbs.persistence;

public enum EmpPosCatType {

	INDIRECT (1, "INDIRECT"),
	DIRECT (2, "DIRECT"),
    PROGRAM_MANAGER (3, "PROGRAM_MANAGER"),
    DIRECTOR (4, "DIRECTOR"),
    EXECUTIVE (5, "EXECUTIVE");
    
    private final String name;
    private final int value;
    
    private EmpPosCatType(int v, String s) {
    
        name = s;
        value = v;
    }
    
    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }
    
    public boolean equals(int v) {
        return (v == 0) ? false : value == v;
    }

    public String toString() {
       return this.name;
    }
    
    public int getValue() {
        return this.value;
    }

}
