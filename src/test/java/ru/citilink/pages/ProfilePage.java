package ru.citilink.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends BasePage { // TODO: 04.09.2022

    public AuthorisationPopupComponent authPopup = new AuthorisationPopupComponent();
    public SelenideElement authButton = $(AppiumBy.id("ru.citilink:id/buttonProfileGuestHeaderAuth"));
    public SelenideElement userEmailLabel = $(AppiumBy.id("ru.citilink:id/textViewEmail"));

    public SelenideElement cityLabel = $(AppiumBy.id("ru.citilink:id/textViewProfileCityValue"));

    public void tapByAuthButton() {
        authButton.click();
    }

    public void tapByCityLabel() {
        cityLabel.click();
    }
}
