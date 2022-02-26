package ru.kuzmin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class App1Test extends AbstractTest {

    @Test
    @DisplayName("Добавление товара в корзину")
    @Tag("pozitive")
    void testCart() {

        new App1(getDriver()).goToChap();
        Assertions.assertTrue(getDriver().getTitle().contains("куртки"));
        new App1(getDriver()).goToProduct();
        Assertions.assertTrue(getDriver().getTitle().contains("мужская"));
        new App1(getDriver()).getSize();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("178638570299"));
        new App1(getDriver()).addToCart();

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//button[@data-selenium=\"goToCartButton\"]"))
                .getText().contains("В")); // проверяем что элемент содержит в себе текст "В"

    }
}
