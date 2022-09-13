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

@Tag("mobile")
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

        step("Run App", () -> {
            open();
            sleep(1000); // ждем, пока прогрузятся попапы
        });
        step("Close all popups if they visible", () -> {
            BasePage.updateLater();
            switchTo().alert().accept();
        });
        step("Tap by profile icon at footer", BasePage::tapByProfileIcon);
        step("Tap by login button'", profilePage::tapByAuthButton);
        step("Нажимаем на ссылку 'Вход по паролю'", () ->
                profilePage.authPopup.tapByLoginWithPasswordLink());
        step("Вводим логин и пароль", () ->
                profilePage.authPopup.inputLoginAndPassword(credentialsConfig.getEmail(), credentialsConfig.getPassword()));
        step("Нажимаем на кнопку 'Войти'", () ->
                profilePage.authPopup.tapByEnterButton());
        step("Проверяем, что пользователь авторизовался", () ->
                profilePage.userEmailLabel.shouldHave(text("@")));
    }

    @Test
    @Story("Пользователь меняет город в профиле")
    @Description("Пользователь авторизуется в мобильном приложении и меняет город")
    @DisplayName("Тест редактирования города пользователя в приложении")
    void changeCityTest() {
        ProfilePage profilePage = new ProfilePage();
        SelectCityComponent cityComponent = new SelectCityComponent();
        String newCityName = Cities.getRandomCity().toString();

        step("Запускаем приложение", () -> {
            open();
            sleep(1000); // ждем, пока прогрузятся все попапы
        });
        step("Закрываем все попапы на стартовой странице, если они появятся", () -> {
            BasePage.updateLater();
            switchTo().alert().accept();
        });
        step("Нажимаем на иконку профиля в футере", BasePage::tapByProfileIcon);
        step("Авторизуемся по логину и паролю", () -> {
            profilePage.tapByAuthButton();
            profilePage.authPopup
                    .tapByLoginWithPasswordLink()
                    .inputLoginAndPassword(credentialsConfig.getEmail(), credentialsConfig.getPassword())
                    .tapByEnterButton();
            profilePage.userEmailLabel.shouldHave(text("@"));
        });
        step("Нажимаем на ссылку с названием текущего города)", profilePage::tapByCityLabel);
        step("Нажимаем на иконку поиска", cityComponent::tapBySearchIcon);
        step("В поле поиска вводим текст", () -> cityComponent.inputCityName(newCityName));
        step("Заполняем поля личных данных", cityComponent::tapBySearchingResult);
        step("Проверяем, что название города в профиле изменилось на новое", () ->
                profilePage.cityLabel.shouldHave(text(newCityName)));
    }
}
