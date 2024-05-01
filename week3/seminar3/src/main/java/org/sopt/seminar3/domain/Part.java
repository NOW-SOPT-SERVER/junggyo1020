package org.sopt.seminar3.domain;

public enum Part {

    SERVER("SERVER"),
    WEB("WEB"),
    ANDROID("ANDROID"),
    IOS("IOS"),
    DESIGN("DESIGN"),
    PLAN("PLAN"),
    ;
    public String part;

    Part(String part) {
        this.part = part;
    }

    public String getPart() {
        return this.part;
    }
}