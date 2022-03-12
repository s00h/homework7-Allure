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

public class App6Test extends AbstractTest {

    @Test
    @DisplayName("Email подписка")
    @Description("Тест email подписки")
    @Owner("Кузьмин Е.В.")
    @Severity(SeverityLevel.NORMAL)
    @Tag("email")
    void inMail() {
        new App1(getDriver()).goToCookie(); // принимаем куки
        new App6(getDriver()).goDown(); //спускаемся вниз страницы
        new App6(getDriver()).goSubscribe(); // кликаем по полю email
        new App6(getDriver())
                .emailSubmit("mail@mail.ru"); // вводим почту и нажимаем submit
        Assertions.assertTrue(getDriver()
                .findElement(By.xpath((".//span[@class=\"sm-text sm-message__text sm-text-text-12 sm-text-regular sm-message__text--type--base\"]")))
                .getText().contains("вы успешно подписались")); // проверяем что появился текст "вы успешно подписались"

    }
}
