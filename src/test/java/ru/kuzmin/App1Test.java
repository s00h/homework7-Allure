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
       getDriver()
               .findElement(By.xpath(".//a[@class=\"bnt-color_b\"][@href=\"/catalog/muzhskaya_odezhda/kurtki/\"]"))
               .click(); // Переходим в раздел "Мужские куртки"
       getDriver()
               .findElement(By.xpath(".//a[@href=\"/product/22648220299/\"]"))
               .click(); // Выбираем товар
       getDriver()
               .findElement(By.xpath(".//div[@data-selenium=\"product-sizes-item\"]"))
               .click(); // Выбираем любоый свободный размер
       getDriver()
               .findElement(By.xpath(".//button[@data-selenium=\"addToCartButton\"]"))
               .click(); //Кладем в корзину

// С экшенами не заработало
//        Actions inCart = new Actions(getDriver());
//        inCart
//                .click(getDriver().findElement(By.xpath(".//a[@class=\"bnt-color_b\"][@href=\"/catalog/muzhskaya_odezhda/kurtki/\"]")))
//                .click(getDriver().findElement(By.xpath(".//a[@href=\"/product/22648220299/\"]")))
//                .click(getDriver().findElement(By.xpath(".//div[@data-selenium=\"product-sizes-item\"]")))
//                .click(getDriver().findElement(By.xpath(".//button[@data-selenium=\"addToCartButton\"]")))
//                .build()
//                .perform();

        Assertions.assertTrue(getDriver()
                .findElement(By.xpath(".//button[@data-selenium=\"goToCartButton\"]"))
                .getText().contains("В")); // проверяем что элемент содержит в себе текст "В"
    }
}
