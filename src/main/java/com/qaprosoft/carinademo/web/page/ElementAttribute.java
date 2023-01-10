package com.qaprosoft.carinademo.web.page;

public enum ElementAttribute {

    VALUE("value");

    private final String displayName;

    ElementAttribute(String displayAttribute) {
        this.displayName = displayAttribute;
    }

    public String getDisplayName() {
        return displayName;
    }
}
