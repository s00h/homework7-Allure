package ru.kuzmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class App6Test extends AbstractTest {

    @Test
    @DisplayName("Email подписка")
    @Tag("pozitive")
    void inMail() {
        new App6(getDriver()).goDown(); //спускаемся вниз страницы
        new App6(getDriver())
                .emailSubmit("mail@mail.ru"); // находим поле для ввода e-mail, вводим почту и нажимаем submit
        Assertions.assertTrue(getDriver()
                .findElement(By.xpath((".//span[@class=\"sm-text sm-message__text sm-text-text-12 sm-text-regular sm-message__text--type--base\"]")))
                .getText().contains("вы успешно подписались")); // проверяем что появился текст "вы успешно подписались"

    }
}
