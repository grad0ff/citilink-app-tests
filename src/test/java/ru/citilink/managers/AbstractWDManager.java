package ru.citilink.managers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import ru.citilink.utils.Attach;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public abstract class AbstractWDManager {

    public void configureBeforeAll() {
    }

    public void configureBeforeEach() {
        addListener("AllureSelenide", new AllureSelenide());
    }

    public void configureAfterEach() {
        Attach.addPageSource();
        Attach.addScreenshot();
        Selenide.closeWebDriver();
    }

    public void configureAfterAll() {
    }
}
