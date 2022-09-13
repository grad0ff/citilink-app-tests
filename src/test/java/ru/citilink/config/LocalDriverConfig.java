package ru.citilink.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/LocalDriver.properties")
public interface LocalDriverConfig extends Config {

    @Key("apkPath")
    String getApkPath();

    @Key("serverUrl")
    String getServerUrl();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("realDevice")
    String getRealDevice();

    @Key("realDeviceOs")
    String getRealDeviceOs();

    @Key("emulatorDevice")
    String getEmulatorDevice();

    @Key("emulatorDeviceOs")
    String getEmulatorDeviceOs();
}
