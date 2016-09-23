package com.sbs.service;


public enum ResponseStatusType {

    OK (1, "OK"),
    ERROR (2, "ERROR");
    
    private final String name;
    private final int value;
    
    private ResponseStatusType(int v, String s) {
    
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
