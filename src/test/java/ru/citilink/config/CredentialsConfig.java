package ru.citilink.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/CredentialsConfig.properties")
public interface CredentialsConfig extends Config {

    @Key("email")
    String getEmail();

    @Key("password")
    String getPassword();
}
