package ru.citilink.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/LocalDriver.properties")
public interface LocalDriverConfig extends Config {

    @Key("apkPath")
    String apkPath();

    @Key("serverUrl")
    String serverUrl();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("realDevice")
    String realDevice();

    @Key("realDeviceOs")
    String realDeviceOs();

    @Key("emulatorDevice")
    String emulatorDevice();

    @Key("emulatorDeviceOs")
    String emulatorDeviceOs();
}
