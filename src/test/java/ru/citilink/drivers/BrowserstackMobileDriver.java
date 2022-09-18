package ru.citilink.drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.citilink.config.BrowserstackConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static BrowserstackConfig config;

    private static URL getBrowserstackUrl() {
        try {
            return new URL(config.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        mutableCapabilities.setCapability("browserstack.user", config.user());
        mutableCapabilities.setCapability("browserstack.key", config.key());
        mutableCapabilities.setCapability("app", config.browserstackPath());
        mutableCapabilities.setCapability("device", config.device());
        mutableCapabilities.setCapability("os_version", config.osVersion());
        mutableCapabilities.setCapability("project", config.projectName());
        mutableCapabilities.setCapability("build", config.buildName());
        mutableCapabilities.setCapability("name", config.name());
        mutableCapabilities.setCapability("deviceOrientation", "portrait");

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }
}