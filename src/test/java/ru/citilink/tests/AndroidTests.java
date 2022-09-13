package ru.citilink.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.citilink.base.TestBase;
import ru.citilink.enums.Cities;
import ru.citilink.pages.BasePage;
import ru.citilink.pages.ProfilePage;
import ru.citilink.pages.SelectCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("MOBILE")
@Owner("grad0ff")
@Feature("Work with App")
@DisplayName("Android mobile tests")
public class AndroidTests extends TestBase {

    @Test
    @Story("User authorizes in app by login and password")
    @Description("Check that user can authorize in app by login and password")
    @DisplayName("Authorization by login/password test")
    void editProfileSettingsTest() {
        ProfilePage profilePage = new ProfilePage();

        step("Run app", () -> {
            open();
            sleep(1000); // ждем, пока прогрузятся попапы
        });
        step("Close all popups if they visible", () -> {
            BasePage.updateLater();
            switchTo().alert().accept();
        });
        step("Tap by profile icon at footer", BasePage::tapByProfileIcon);
        step("Tap by login button'", profilePage::tapByAuthButton);
        step("Authorize in app by login and password", () -> {
            profilePage.authPopup
                    .tapByLoginWithPasswordLink()
                    .inputLoginAndPassword(credentialsConfig.getEmail(), credentialsConfig.getPassword())
                    .tapByEnterButton();
        });
        step("Check that user is successful authorized", () ->
                profilePage.userEmailLabel.shouldHave(text("@")));
    }

    @Test
    @Story("User change city in profile settings")
    @Description("Check that authorized user can change city in profile settings")
    @DisplayName("City changing test")
    void changeCityTest() {
        ProfilePage profilePage = new ProfilePage();
        SelectCityComponent cityComponent = new SelectCityComponent();
        String newCityName = Cities.getRandomCity().toString();

        step("Run app", () -> {
            open();
            sleep(1000); // ждем, пока прогрузятся попапы
        });
        step("Close all popups if they visible", () -> {
            BasePage.updateLater();
            switchTo().alert().accept();
        });
        step("Tap by profile icon at footer", BasePage::tapByProfileIcon);
        step("Tap by login button'", profilePage::tapByAuthButton);
        step("Authorize in app by login and password", () -> {
            profilePage.authPopup
                    .tapByLoginWithPasswordLink()
                    .inputLoginAndPassword(credentialsConfig.getEmail(), credentialsConfig.getPassword())
                    .tapByEnterButton();
            profilePage.userEmailLabel.shouldHave(text("@"));
        });
        step("Tap by current city link", profilePage::tapByCityLabel);
        step("Tap by search icon", cityComponent::tapBySearchIcon);
        step("Input text", () -> cityComponent.inputCityName(newCityName));
        step("Tap by found city name", cityComponent::tapBySearchingResult);
        step("Make sure that the name of the city has changed ", () ->
                profilePage.cityLabel.shouldHave(text(newCityName)));
    }
}
