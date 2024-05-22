package com.example.myapplicationapp;

public class Device {
    private String deviceName;
    private String deviceDescription;

    public Device(String deviceName, String deviceDescription) {
        this.deviceName = deviceName;
        this.deviceDescription = deviceDescription;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceDescription() {
        return deviceDescription;
    }
}
