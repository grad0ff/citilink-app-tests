package ru.citilink.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public static SelenideElement updatePopup = $(AppiumBy.id("ru.citilink:id/design_bottom_sheet"));
    public static SelenideElement profileIcon = $(AppiumBy.id("ru.citilink:id/profile_graph"));
    private static final SelenideElement updateLaterButton = $(AppiumBy.id("ru.citilink:id/buttonLater"));

    public static void updateLater() {
        if (updatePopup.is(exist)) {
            updateLaterButton.click();
        }
    }

    public static void tapByProfileIcon() {
        profileIcon.click();
    }
}
