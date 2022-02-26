package ru.kuzmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class App2 extends AbstractPage {
    @FindBy(xpath = ".//input[@placeholder=\"Поиск\"]")
    private WebElement search;

    @FindBy(name = "search")
    private WebElement button;

    public App2 setWord(String search) {
        this.search.sendKeys(search);
        return this;
    }

    public App2 setSearch() {
        this.button.click();
        return this;
    }

    public App2(WebDriver driver) {
        super(driver);
    }

    public void searchIn(String search) {
        Actions searchIn = new Actions(getDriver());
        searchIn
                .sendKeys(this.search, search)
                .click(this.button)
                .build()
                .perform();

    }
}
