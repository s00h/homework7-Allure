package ru.kuzmin;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class App2Test extends AbstractTest {

    @Test
    @DisplayName("Поиск")
    @Description("Тест поиска на сайте по ключевому слову")
    @Owner("Кузьмин Е.В.")
    @Severity(SeverityLevel.CRITICAL)
    @Tag("search")
    void searchIn() {
        new App2(getDriver()).searchIn("ботинки");
        //через экшн находим поле для поиска и вбиваем "ботинки"

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//h1[@class=\"sm-text sm-page-title__text sm-text-text-24 sm-text-medium\"]"))
                .getText().contains("запросу")); // проверяем что элемент содержит в себе текст "запросу"
    }
}