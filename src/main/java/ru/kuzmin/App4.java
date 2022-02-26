package ru.kuzmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class App4 extends AbstractPage {
    @FindBy(xpath = ".//a[@class=\"bnt-color_b\"][@href=\"/catalog/zhenskaya_obuv/botinki/\"]")
    private WebElement boot;

    @FindBy(xpath = ".//div[@class=\"sm-text sm-select__text sm-text-text-14 sm-text-regular\"]")
    private WebElement list;

    @FindBy(xpath = ".//span[@class=\"sm-text sm-select__option-text sm-text-text-14 sm-text-regular\"][contains(.,'Новинки')]")
    private WebElement bynew;

    public App4 goToBoot() {
        this.boot.click();
        return this;
    }

    public App4 goToList() {
        this.list.click();
        return this;
    }

    public App4 selectNew() {
        this.bynew.click();
        return this;
    }

    public App4(WebDriver driver) {
        super(driver);
    }
}
