package ru.citilink.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/Browserstack.properties")
public interface BrowserstackConfig extends Config {

    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("serverUrl")
    String serverUrl();

    @Key("browserstackPath")
    String browserstackPath();

    @Key("videoPath")
    String videoPath();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String name();
}
