package ru.citilink.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage { // TODO: 04.09.2022

    public AuthorizationPopupComponent authPopup = new AuthorizationPopupComponent();
    public SelenideElement authButton = $(AppiumBy.id("ru.citilink:id/buttonProfileGuestHeaderAuth"));
    public SelenideElement userEmailLabel = $(AppiumBy.id("ru.citilink:id/textViewEmail"));

    public SelenideElement cityLabel = $(AppiumBy.id("ru.citilink:id/textViewProfileCityValue"));

    public ProfilePage tapByAuthButton() {
        authButton.click();

        return this;
    }

    public ProfilePage tapByCityLabel() {
        cityLabel.click();

        return this;
    }
}
