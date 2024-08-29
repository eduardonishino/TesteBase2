package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    // Método para navegar até uma URL
    protected void navigateTo(String url) {
        driver.get(url);
    }
}