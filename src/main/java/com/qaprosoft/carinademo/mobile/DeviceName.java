package com.qaprosoft.carinademo.mobile;

public enum DeviceName {

    IPHONE_14_PRO("iPhone 14 Pro");

    public final String displayName;

    DeviceName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
