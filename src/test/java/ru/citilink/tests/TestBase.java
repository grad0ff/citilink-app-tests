package ru.citilink.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.citilink.config.CredentialsConfig;
import ru.citilink.managers.AbstractWDManager;
import ru.citilink.managers.BrowserstackMobileWDManager;
import ru.citilink.managers.LocalMobileWDManager;

public class TestBase {

    protected static CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);
    private static final AbstractWDManager manager;

    static {
        String deviceHost = System.getProperty("deviceHost", "browserstack");
        switch (deviceHost) {
            case "browserstack":
                manager = BrowserstackMobileWDManager.create();
                break;
            case "emulator":
                manager = LocalMobileWDManager.create(false);
                break;
            case "real":
                manager = LocalMobileWDManager.create(true);
                break;
            default:
                throw new RuntimeException("Device Host is not defined!");
        }
    }

    @BeforeAll
    public static void beforeAll() {
        manager.configureBeforeAll();
    }

    @BeforeEach
    public void beforeEach() {
        manager.configureBeforeEach();
    }

    @AfterEach
    public void afterEach() {
        manager.configureAfterEach();
    }

    @AfterAll
    public static void afterAll() {
        manager.configureAfterAll();
    }
}
