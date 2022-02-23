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

        getDriver()
                .findElement(By.xpath(".//a[@class=\"bnt-color_b\"][@href=\"/catalog/muzhskaya_obuv/botinki/\"]"))
                .click(); // переходим в раздел "Мужские ботинки"
        getDriver()
                .findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/label/input"))
                .click(); // кликаем на тоггл "Экспресс доставка"

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions // явное ожидание
                .presenceOfElementLocated(By.xpath(".//a[@data-selenium=\"product-name\"]")));

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//span[@data-selenium=\"filter-title\"]"))
                .getText().contains("Экспресс")); // проверяем что появился текст "Экспресс"
    }



}
