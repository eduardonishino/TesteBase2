package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        if (driver == null) {
            throw new RuntimeException("O WebDriver não foi inicializado corretamente.");
        }
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            DriverFactory.quitDriver();
        }
    }

    protected void navigateTo(String url) {
        if (driver == null) {
            throw new RuntimeException("O WebDriver não está inicializado.");
        }
        driver.get(url);
    }
}
