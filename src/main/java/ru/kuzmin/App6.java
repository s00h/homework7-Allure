package ru.kuzmin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class App6 extends AbstractPage {
    @FindBy(css = "body")
    private WebElement body;

    @FindBy(xpath = ".//input[@type=\"email\"]")
    private WebElement mail;

    @FindBy(xpath = ".//button[@data-selenium=\"submit\"]")
    private WebElement submit;

    @FindBy(xpath = ".//input[@type=\"email\"]")
    private WebElement subscribe;

    public App6 goSubscribe() {
        this.subscribe.click();
        return this;
    }

    public App6 goDown() {
        this.body.sendKeys(Keys.CONTROL, Keys.END);
        return this;
    }

    public App6 buttonClick() {
        this.submit.click();
        return this;
    }

    public App6(WebDriver driver) {
        super(driver);
    }

    public void emailSubmit(String email) {
        Actions emailSumbit = new Actions(getDriver());
        emailSumbit
                .sendKeys(this.mail, email)
                .click(this.submit)
                .build()
                .perform();
    }
}
