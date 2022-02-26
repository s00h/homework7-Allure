package ru.kuzmin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    static WebDriver webDriver;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.addArguments("disable-popup-blocking");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeEach
    void goTo() {
        Assertions.assertDoesNotThrow(() -> webDriver.navigate().to("https://new.sportmaster.ru"),
                "Страница не доступна");
    }

//    @AfterAll
//    static void close() {
//        driver.quit();
//    }

    public static WebDriver getDriver() {
        return webDriver;
    }

}
