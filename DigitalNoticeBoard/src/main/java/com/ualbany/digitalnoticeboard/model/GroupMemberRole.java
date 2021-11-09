package com.ualbany.digitalnoticeboard.model;

public enum GroupMemberRole {
	MEMBER("member"),
	ADMIN("Admin"),
	AUTHOR("Author");
	
	private final String name;       

    private GroupMemberRole(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
