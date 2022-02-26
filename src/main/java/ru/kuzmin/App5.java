package ru.kuzmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class App5 extends AbstractPage {

    @FindBy(xpath = ".//a[@class=\"bnt-color_b\"][@href=\"/catalog/muzhskaya_obuv/botinki/\"]")
    private WebElement boot;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[2]/div[1]/div/div[2]/div/div/div/label/input")
    private WebElement express;

    public App5 goToBoot() {
        this.boot.click();
        return this;
    }

    public App5 clickToExp() {
        this.express.click();
        return this;
    }


    public App5(WebDriver driver) {
        super(driver);
    }
}
