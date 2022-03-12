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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App4Test extends AbstractTest {

    @Test
    @DisplayName("Сортировка новинок")
    @Description("Тест сортировки товаров по новинкам")
    @Owner("Кузьмин Е.В.")
    @Severity(SeverityLevel.MINOR)
    @Tag("new")
    void testSort() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        jsExecutor.executeScript("window.scrollBy(0,1000)"); //скроллим вниз

        Thread.sleep(5000); //ждем 5сек

        new App1(getDriver()).goToCookie(); // принимаем куки
        new App4(getDriver()).goToBoot(); //идем в раздел "Женские кроссовки"
        Assertions.assertTrue(getDriver()
                .getTitle().contains("Женские кроссовки")); //проверяем что title содержит "Женские кроссовки"
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

