package ru.citilink.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/BaseConfig.properties")
public interface BaseConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();
}
