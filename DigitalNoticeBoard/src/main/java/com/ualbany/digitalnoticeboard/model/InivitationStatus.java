package com.ualbany.digitalnoticeboard.model;

public enum InivitationStatus {
	PENDING("pending"),
	ACCEPTED("accepted"),
	DECLINED("declined");
	
	private final String name;       

    private InivitationStatus(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }

}
