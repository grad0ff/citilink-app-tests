package ru.citilink.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class AuthorisationPopupComponent {

    public final SelenideElement loginWithPasswordLink = $(AppiumBy.id("ru.citilink:id/buttonAuthPhoneAuthByPassword"));
    public final SelenideElement loginInputField = $(AppiumBy.id("ru.citilink:id/editTextAuthPasswordLogin"));
    public final SelenideElement passwordInputField = $(AppiumBy.id("ru.citilink:id/editTextAuthPasswordPass"));
    public final SelenideElement enterButton = $(AppiumBy.id("ru.citilink:id/buttonAuthPassword"));

    public AuthorisationPopupComponent tapByLoginWithPasswordLink() {
        loginWithPasswordLink.click();

        return this;
    }

    public AuthorisationPopupComponent inputLoginAndPassword(String login, String password) {
        loginInputField.sendKeys(login);
        passwordInputField.sendKeys(password);

        return this;
    }

    public AuthorisationPopupComponent tapByEnterButton() {
        enterButton.click();

        return this;
    }
}
