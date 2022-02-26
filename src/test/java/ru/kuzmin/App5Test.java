package ru.kuzmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App5Test extends AbstractTest{

    @Test
    @DisplayName("Тоггл экспресс-достака")
    @Tag ("pozitive")
    void toCompare () throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        jsExecutor.executeScript("window.scrollBy(0,1000)"); //скроллим вниз

        Thread.sleep(5000); //ждем 5сек

        new App5 (getDriver()).goToBoot();
        Assertions.assertTrue(getDriver()
                .getTitle().contains("Мужские ботинки"));
        new App5(getDriver()).clickToExp();

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions // явное ожидание
                .presenceOfElementLocated(By.xpath(".//a[@data-selenium=\"product-name\"]")));

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//span[@data-selenium=\"filter-title\"]"))
                .getText().contains("Экспресс")); // проверяем что появился текст "Экспресс"
    }



}
