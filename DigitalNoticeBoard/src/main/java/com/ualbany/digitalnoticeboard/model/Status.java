package com.ualbany.digitalnoticeboard.model;

public enum Status {
	ACTIVE("active"),
	DELETED("deleted");
	
	private final String name;       

    private Status(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }

}
