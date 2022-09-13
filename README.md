<a href="https://www.citilink.ru/"><img alt="citilink.ru" height="50" src="readme_files/citilink.gif"/></a>
# Сitilink App. Автотесты на Java

## Содержание :bookmark_tabs:

* <a href="#stack">Cтек технологий</a>
* <a href="#objects">Объекты тестирования</a>
* <a href="#console">Запуск тестов из консоли</a>
* <a href="#code">Код</a>
  + <a href="#intelij">InteliJ IDEA, Java, JUnit 5, Selenide</a>
  + <a href="#gradle">Gradle</a>
* <a href="#screenshot">Скриншоты и видео</a>
  + <a href="#appium">Appium</a>
  + <a href="#browserstack">Browserstack</a>
  + <a href="#jenkins">Jenkins</a>
  + <a href="#allure_testops">Allure TestOps</a>
  + <a href="#allure">Allure</a>
  + <a href="#notificatios">Уведомления</a>



<a id="stack"></a>
## Cтек технологий :hammer_and_wrench:
<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="readme_files/technologies/intelij_idea.svg" width="50"/></a>
<a href="https://www.java.com/"><img alt="Java" height="50" src="readme_files/technologies/Java.svg" width="50"/></a>
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="readme_files/technologies/JUnit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="readme_files/technologies/selenide.svg" width="50"/></a>
<a href="https://appium.io/"><img alt="Appium" height="50" src="readme_files/technologies/appium.svg" width="50"/></a>
<a href="https://www.browserstack.co"><img alt="Browserstack" height="50" src="readme_files/technologies/browserstack.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="readme_files/technologies/Gradle.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="readme_files/technologies/Jenkins.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="readme_files/technologies/allure_testops.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure" height="50" src="readme_files/technologies/Allure.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="readme_files/technologies/GitHub.svg" width="50"/></a>
</div>



<a id="objects"></a>
## Объекты тестирования :mag:
Разработаны автотесты для проверок:

:white_check_mark: авторизации пользователя в приложении

:white_check_mark: смены пользователем текущего города



<a id="console"></a>
## Запуск тестов из консоли :computer:
```bash
gradle clean test
-DdeviceHost=${DEVICE_HOST}
```
> `${DEVICE_HOST}` - устройство для прогона тестов [ browserstack <sub>(default)</sub> , *emulator* , *real*  ]



## Код :floppy_disk:
<a id="code"></a>
#### <img alt="InteliJ IDEA" height="50" src="readme_files/technologies/intelij_idea.svg" width="50"/>InteliJ IDEA</a><img alt="Java" height="50" src="readme_files/technologies/java.svg" width="50"/>Java</a><img alt="JUnit 5" height="50" src="readme_files/technologies/junit5.svg" width="50"/>JUnit 5</a><img alt="Selenide" height="50" src="readme_files/technologies/selenide.svg" width="50"/>Selenide</a>
> *Оформление кода автотестов*

```java
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
      sleep(1000);
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
}
```



<a id="gradle"></a>
#### <img alt="Gradle" height="50" src="readme_files/technologies/Gradle.svg" width="50"/>Gradle</a>
> *Автоматическая сборка проекта и управление зависимостями*

```groovy
plugins {
  id 'java-library'
  id 'io.qameta.allure' version '2.10.0'
}

repositories {
  mavenCentral()
}

def jUnitVersion = '5.8.2',
    appiumVersion = "8.0.0",
    selenideVersion = '6.5.2',
    restAssuredVersion = '5.1.1',
    ownerVersion = '1.0.12',
    allureVersion = '2.18.1',
    commonsIoVersion = "2.11.0",
    slf4jVersion = '1.7.36'

dependencies {
  testImplementation(
          "org.junit.jupiter:junit-jupiter:$jUnitVersion",
          "io.appium:java-client:$appiumVersion",
          "com.codeborne:selenide:$selenideVersion",
          "io.rest-assured:rest-assured:$restAssuredVersion",
          "org.aeonbits.owner:owner:$ownerVersion",
          "io.qameta.allure:allure-selenide:$allureVersion",
          "io.qameta.allure:allure-rest-assured:$allureVersion",
          "commons-io:commons-io:$commonsIoVersion",
          "org.slf4j:slf4j-simple:$slf4jVersion",
  )
}
```



<a id="appium"></a>
#### ><img alt="Appium" height="50" src="readme_files/technologies/appium.svg" width="50"/>Appium</a>
> *Обчепечение прогона автотестов на эмуляторе или реальном устройстве*

<img src="#" alt="Appium">



<a id="jenkins"></a>
####  <a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="readme_files/technologies/Jenkins.svg" width="50"/>Jenkins</a>
> *Решение комплекса задач по сборке проекта, прогону автотестов, получению отчетов и отправке уведомлений по результатам сборки*
  
<a href="https://jenkins.autotests.cloud/job/013-grad0ff-14-itoolabs/">
<img src="https://user-images.githubusercontent.com/72714071/177363720-95c14959-fac7-4af4-9145-eb1987631229.png" alt="Jenkins">
</a>



<a id="allure"></a>
#### <img alt="Allure" height="50" src="readme_files/technologies/allure_testops.svg" width="50"/>Allure TestOps</a><img alt="Allure" height="50" src="readme_files/technologies/allure.svg" width="50"/>Allure</a>
> *Формирование отчетов по результам прогона автотестов*

<table>
    <tr>
        <td>
        <a href="https://jenkins.autotests.cloud/job/013-grad0ff-14-itoolabs/allure/#">
        <img src="https://user-images.githubusercontent.com/72714071/177333637-beabaa93-b50e-414e-a879-7a2c3ecdef56.png">
        </a>
        </td>
        <td>
        <a href="https://jenkins.autotests.cloud/job/013-grad0ff-14-itoolabs/allure/#suites/3fe6c9430eeb6f86d0ad005f3508c577/ab463357776f237c/">
        <img src="https://user-images.githubusercontent.com/72714071/177332881-fcefcefe-eb14-41a1-baab-70c52ffb344c.png">
        </a>
        </td>
    </tr>
        <tr>
        <td>
        <a href="https://jenkins.autotests.cloud/job/013-grad0ff-14-itoolabs/allure/#behaviors">
        <img src="https://user-images.githubusercontent.com/72714071/177333506-c7517b6e-7c80-4600-970c-21e36a38bb1d.png">
        </a>
        </td>
        <td>
        <a href="https://jenkins.autotests.cloud/job/013-grad0ff-14-itoolabs/allure/#suites/3fe6c9430eeb6f86d0ad005f3508c577/ab463357776f237c/">
        <img src="https://user-images.githubusercontent.com/72714071/177361087-a7047f2e-c7e1-4291-a255-5b189c40a0d2.png">*
        </a>
        </td>
    </tr>
    <tr>
        <td>
        <a href="https://jenkins.autotests.cloud/job/013-grad0ff-14-itoolabs/allure/#suites/3fe6c9430eeb6f86d0ad005f3508c577/8d36d319e2132404/">
        <img src="https://user-images.githubusercontent.com/72714071/177543609-abcd962c-f5e8-4d0c-9e85-423901e7b0f5.png">
        </a>
        </td>
        <td>
        <a href="">
        <img src="https://user-images.githubusercontent.com/72714071/177543805-4028d54c-4654-43b3-b052-9af01cf8e243.png">
        </a>
        </td>
    </tr>
</table>



<a id="telegram"></a>
#### <img alt="Telegram" height="50" src="readme_files/technologies/telegram.svg" width="50"/></a> <img alt="Email" height="50" src="#" width="50"/></a>
> *Предоставление оперативной информации о результатах прогона автотестов*


![Telegram](https://user-images.githubusercontent.com/72714071/177325044-c147556f-d2d6-498b-8397-bb016aa9927d.png)
