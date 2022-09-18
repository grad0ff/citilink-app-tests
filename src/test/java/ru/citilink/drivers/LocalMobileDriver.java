package ru.citilink.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import ru.citilink.config.LocalDriverConfig;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalMobileDriver implements WebDriverProvider {

    public static LocalDriverConfig config;
    public static Boolean isRealDevice;

    private static URL getAppiumServerUrl() {
        try {
            return new URL(config.serverUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = new File(config.apkPath());
        String device;
        String deviceOs;
        if (isRealDevice) {
            device = config.realDevice();
            deviceOs = config.realDeviceOs();
        } else {
            device = config.emulatorDevice();
            deviceOs = config.emulatorDeviceOs();
        }
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setDeviceName(device);
        options.setPlatformVersion(deviceOs);
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setPlatformName("Android");
        options.setApp(app.getAbsolutePath());
        options.setAppPackage(config.appPackage());
        options.setAppActivity(config.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }
}