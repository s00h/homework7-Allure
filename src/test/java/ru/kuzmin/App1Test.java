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

public class App1Test extends AbstractTest {

    @Test
    @DisplayName("Добавление в корзину")
    @Description("Тест добавления товара в корзину")
    @Owner("Кузьмин Е.В.")
    @Severity(SeverityLevel.BLOCKER)
    @Tag("cart")
    void testCart() {

        new App1(getDriver()).goToCookie(); // принимаем куки
        new App1(getDriver()).goToChap(); // идем в раздел "Мужские куртки"
        Assertions.assertTrue(getDriver().getTitle().contains("куртки")); // проверяем что title содержит "куртки"
        new App1(getDriver()).goToProduct(); //идем в раздел с конкретным товаром
        Assertions.assertTrue(getDriver().getTitle().contains("мужская")); // проверяем что title содержит "мужская"
        new App1(getDriver()).closeAd(); // закрываем баннер
        new App1(getDriver()).getSize(); //выбираем размер
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("178638570299")); //проверяем что URL содержит текст
        new App1(getDriver()).addToCart(); //добавляем в корзину

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//button[@data-selenium=\"goToCartButton\"]"))
                .getText().contains("В")); // проверяем что элемент содержит в себе текст "В"

    }
}
