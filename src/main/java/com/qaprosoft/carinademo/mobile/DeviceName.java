package com.qaprosoft.carinademo.mobile;

public enum DeviceName {

    IPHONE_14_PRO("iphone 14 pro");

    public final String displayName;

    DeviceName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
