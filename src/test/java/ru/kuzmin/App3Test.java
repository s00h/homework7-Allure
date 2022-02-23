package ru.kuzmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class App3Test extends AbstractTest {

    @Test
    @DisplayName("Фильтр по бренду")
    @Tag("pozitive")
    void toBrand() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        jsExecutor.executeScript("window.scrollBy(0,1100)"); //скроллим вниз

        Thread.sleep(5000); //ждем 5сек

        getDriver()
                .findElement(By.xpath(".//a[@class=\"bnt-color_b\"][@href=\"/catalog/muzhskaya_obuv/krossovki/\"]"))
                .click(); // Переходим в раздел "Мужские кроссовки"
        getDriver()
                .findElement(By.xpath(".//span[@class=\"sm-facet-value__caption\"][contains(.,'PUMA')]"))
                .click(); // Выбираем "PUMA"

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//span[@data-selenium=\"filter-title\"]"))
                .getText().contains("PUMA")); // проверяем что элемент содержит в себе текст "PUMA"
    }
}