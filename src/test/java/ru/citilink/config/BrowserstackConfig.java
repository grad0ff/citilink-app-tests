package ru.citilink.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/Browserstack.properties")
public interface BrowserstackConfig extends Config {

    @Key("user")
    String getUser();

    @Key("key")
    String getKey();

    @Key("serverUrl")
    String getServerUrl();

    @Key("browserstackPath")
    String getBrowserstackPath();

    @Key("videoPath")
    String getVideoPath();

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getOsVersion();

    @Key("project")
    String getProjectName();

    @Key("build")
    String getBuildName();

    @Key("name")
    String getName();
}
