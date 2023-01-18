package com.qaprosoft.carinademo.util;

import com.qaprosoft.carina.core.foundation.webdriver.device.Device;
import com.zebrunner.carina.utils.factory.DeviceType;

public class PlatformService {

    public static DeviceType.Type getDeviceInformation(){
        return Device.currentDevice.get().getDeviceType();
    }
}
