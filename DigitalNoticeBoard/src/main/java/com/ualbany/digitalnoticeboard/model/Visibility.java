package com.ualbany.digitalnoticeboard.model;

public enum Visibility {
	PUBLIC("public"),
	PRIVATE("private");
	
	private final String name;       

    private Visibility(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }

}
