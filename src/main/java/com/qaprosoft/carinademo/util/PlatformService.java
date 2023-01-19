package com.qaprosoft.carinademo.util;

import com.qaprosoft.carina.core.foundation.webdriver.device.Device;
import com.zebrunner.carina.utils.factory.DeviceType;

public class PlatformService {

    public static DeviceType.Type getDeviceType() {
        return Device.currentDevice.get().getDeviceType();
    }

    public static String getDeviceName() {
        return Device.currentDevice.get().getName();
    }

    public static boolean isDevice(String deviceName) {
        return getDeviceName().equals(deviceName);
    }
}
