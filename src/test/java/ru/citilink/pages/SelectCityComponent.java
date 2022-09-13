package ru.citilink.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Selenide.$;

public class SelectCityComponent {

    public SelenideElement searchIcon = $(AppiumBy.id("ru.citilink:id/searchMenu"));
    public SelenideElement inputField = $(AppiumBy.id("ru.citilink:id/search_src_text"));
    public SelenideElement searchingResult = $(AppiumBy.id("ru.citilink:id/textViewCityName"));

    public SelectCityComponent tapBySearchIcon() {
        searchIcon.click();

        return this;
    }

    public SelectCityComponent inputCityName(String value) {
        inputField.sendKeys(value);

        return this;
    }

    public SelectCityComponent tapBySearchingResult() {
        searchingResult.click();

        return this;
    }
}
