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

public class App5Test extends AbstractTest {

    @Test
    @DisplayName("Экспресс-достака")
    @Description("Тест тоггла *экспресс доставка* в блоке фильтров")
    @Owner("Кузьмин Е.В.")
    @Severity(SeverityLevel.MINOR)
    @Tag("filter")
    void toCompare() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        jsExecutor.executeScript("window.scrollBy(0,1000)"); //скроллим вниз

        Thread.sleep(5000); //ждем 5сек

        new App1(getDriver()).goToCookie(); // принимаем куки
        new App5(getDriver()).goToBoot(); //идем в раздел "Мужские кроссовки"
        Assertions.assertTrue(getDriver()
                .getTitle().contains("Мужские кроссовки")); //проверяем что title сдержит "Мужские кроссовки"
        new App5(getDriver()).clickToExp(); //выбираем фильтр "Экспресс-доставка"

        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions // явное ожидание
                .presenceOfElementLocated(By.xpath(".//a[@data-selenium=\"product-name\"]")));

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//span[@data-selenium=\"filter-title\"]"))
                .getText().contains("Экспресс")); // проверяем что появился текст "Экспресс"
    }


}
