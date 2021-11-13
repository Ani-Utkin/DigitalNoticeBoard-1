package com.ualbany.digitalnoticeboard.model;

public enum UserRoleType {
	USER("user"),
	ADMIN("admin"),
	FACULTY("faculty"),
	STUDENT("student");
	
	private final String name;       

    private UserRoleType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
