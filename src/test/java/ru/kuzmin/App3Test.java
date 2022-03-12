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
import org.openqa.selenium.JavascriptExecutor;

public class App3Test extends AbstractTest {

    @Test
    @DisplayName("Фильтр по бренду")
    @Description("Тест фильтра товаров по бренду PUMA")
    @Owner("Кузьмин Е.В.")
    @Severity(SeverityLevel.NORMAL)
    @Tag("brand")
    void toBrand() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        jsExecutor.executeScript("window.scrollBy(0,1100)"); //скроллим вниз

//        Thread.sleep(5000); //ждем 5сек
        new App1(getDriver()).goToCookie(); //принимаем куки
        new App3(getDriver()).goToSneak(); //идем в раздел "мужские кроссовки"
        Assertions.assertTrue(getDriver().getTitle().contains("кроссовки")); //проверяем что title содержит "кроссовки"
        new App3(getDriver()).checkPuma(); //выбираем фильтр по бренду "PUMA"
        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//span[@data-selenium=\"filter-title\"]"))
                .getText().contains("PUMA")); // проверяем что элемент содержит в себе текст "PUMA"

    }
}