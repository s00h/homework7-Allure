package ru.kuzmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class App3 extends AbstractPage {
    @FindBy(xpath = ".//a[@class=\"bnt-color_b\"][@href=\"/catalog/muzhskaya_obuv/krossovki/\"]")
    private WebElement sneak;

    @FindBy(xpath = ".//span[@class=\"sm-facet-value__caption\"][contains(.,'PUMA')]")
    private WebElement puma;

    public App3 goToSneak() {
        this.sneak.click();
        return this;
    }

    public App3 checkPuma() {
        this.puma.click();
        return this;
    }

    public App3(WebDriver driver) {
        super(driver);
    }
}
