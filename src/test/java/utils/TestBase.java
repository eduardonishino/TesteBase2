package utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver;

    //Este método é executado antes de cada teste. Ele é anotado com @Before, o que indica que ele deve ser executado antes de cada método de teste.
    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        if (driver == null) {
            throw new RuntimeException("O WebDriver não foi inicializado corretamente.");
        }
        driver.manage().window().maximize();
    }

    //Este método é executado após cada teste. Ele é anotado com @After, o que indica que ele deve ser executado após cada método de teste.
    @After
    public void tearDown() {
        if (driver != null) {
            DriverFactory.quitDriver();
        }
    }

    //Um método protegido que facilita a navegação para uma URL específica.
    protected void navigateTo(String url) {
        if (driver == null) {
            throw new RuntimeException("O WebDriver não está inicializado.");
        }
        driver.get(url);
    }
}
