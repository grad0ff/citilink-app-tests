package ru.citilink.managers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import ru.citilink.config.BrowserstackConfig;
import ru.citilink.drivers.BrowserstackMobileDriver;
import ru.citilink.utils.Attach;

import static io.restassured.RestAssured.given;

public class BrowserstackMobileWDManager extends AbstractWDManager {

    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static BrowserstackMobileWDManager create() {
        BrowserstackMobileDriver.config = config;

        return new BrowserstackMobileWDManager();
    }

    @Override
    public void configureBeforeAll() {
        Configuration.browser = BrowserstackMobileDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @Override
    public void configureAfterEach() {
        String sessionId = Attach.getSessionId();
        super.configureAfterEach();
        String videoUrl = getVideoUrl(sessionId);
        Attach.addVideo(videoUrl);
    }

    private String getVideoUrl(String sessionId) {
        String url = config.getVideoPath() + sessionId + ".json";

        return given()
                .auth().basic(config.getUser(), config.getKey())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
