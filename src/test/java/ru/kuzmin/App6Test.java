package ru.kuzmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class App6Test extends AbstractTest {

    @Test
    @DisplayName("Email подписка")
    @Tag("pozitive")
    void inMail() {
        getDriver().
                findElement(By.cssSelector("body"))
                .sendKeys(Keys.CONTROL, Keys.END);        // спускаемся вниз страницы

        Actions inMail = new Actions(getDriver());
        inMail
                .sendKeys(getDriver() // Вбиваем в поле e-mail
                        .findElement(By.xpath(".//input[@type=\"email\"]")), "mail@mail.ru")
                .click(getDriver() // нажимаем "Submit"
                        .findElement(By.xpath(".//button[@data-selenium=\"submit\"]")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//span[@class=\"sm-text sm-message__text sm-text-text-12 sm-text-regular sm-message__text--type--base\"]"))
                .getText().contains("вы успешно подписались")); // проверяем что появился текст "вы успешно подписались"

    }
}
