package ru.kuzmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class App1 extends AbstractPage {

    @FindBy(xpath = ".//a[@class=\"bnt-color_b\"][@href=\"/catalog/muzhskaya_odezhda/kurtki/\"]")
    private WebElement jacket;

    @FindBy(xpath = ".//a[@href=\"/product/22648220299/\"]")
    private WebElement product;

    @FindBy(xpath = ".//div[@data-selenium=\"product-sizes-item\"]")
    private WebElement size;

    @FindBy(xpath = ".//button[@data-selenium=\"addToCartButton\"]")
    private WebElement cart;

    public App1(WebDriver driver) {
        super(driver);
    }

    public App1 goToChap() {
        jacket.click();
        return this;
    }

    public App1 goToProduct() {
        this.product.click();
        return this;
    }

    public App1 getSize() {
        this.size.click();
        return this;
    }

    public App1 addToCart() {
        this.cart.click();
        return this;
    }
}
