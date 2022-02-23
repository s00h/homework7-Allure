package ru.kuzmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App4Test extends AbstractTest {

    @Test
    @DisplayName("Сортировка новинок")
    @Tag("pozitive")
    void testSort() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        jsExecutor.executeScript("window.scrollBy(0,1000)"); //скроллим вниз

        Thread.sleep(5000); //ждем 5сек

        getDriver()
                .findElement(By.xpath(".//a[@class=\"bnt-color_b\"][@href=\"/catalog/zhenskaya_obuv/botinki/\"]"))
                .click(); // Переходим в раздел "Женские ботинки"
        getDriver()
                .findElement(By.xpath(".//div[@class=\"sm-text sm-select__text sm-text-text-14 sm-text-regular\"]"))
                .click(); // Раскрываем список
        getDriver()
                .findElement(By.xpath(".//span[@class=\"sm-text sm-select__option-text sm-text-text-14 sm-text-regular\"][contains(.,'Новинки')]"))
                .click(); // Выбираем "Новинки"

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions // явное ожидание
                .presenceOfElementLocated(By.xpath(".//a[@data-selenium=\"product-name\"]")));

        Assertions.assertTrue(getDriver()
                .getCurrentUrl().contains("FIRST"));
        // проверяем что URL содержит в себе текст "NEWEST_FIRST"


    }


}

