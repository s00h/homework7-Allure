package ru.kuzmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class App2Test extends AbstractTest{

    @Test
    @DisplayName("Поиск на сайте")
    @Tag("pozitive")
    void searchIn() {
        new App2(getDriver()).searchIn("ботинки");

Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//h1[@class=\"sm-text sm-page-title__text sm-text-text-24 sm-text-medium\"]"))
            .getText().contains("запросу")); // проверяем что элемент содержит в себе текст "запросу"
}
}