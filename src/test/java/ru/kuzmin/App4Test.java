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

        new App4(getDriver()).goToBoot(); //идем в раздел "Женские ботинки"
        Assertions.assertTrue(getDriver()
                .getTitle().contains("Женские ботинки")); //проверяем что title содержит "Женские ботинки"
        new App4(getDriver()).goToList(); //раскрываем фильтр
        new App4(getDriver()).selectNew(); //упорядочеваем по новинкам

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions // явное ожидание
                .presenceOfElementLocated(By.xpath(".//a[@data-selenium=\"product-name\"]")));

        Assertions.assertTrue(getDriver()
                .getCurrentUrl().contains("FIRST"));
        // проверяем что URL содержит в себе текст "NEWEST_FIRST"

    }


}

