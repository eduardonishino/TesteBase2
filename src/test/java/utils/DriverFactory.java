package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static WebDriver driver;

    //responsável por inicializar e retornar uma instância do WebDriver, especificamente o ChromeDriver, usado para automação de navegadores em testes automatizados com Selenium. Ele também utiliza o arquivo de configuração para obter o caminho do driver.
    public static WebDriver getDriver() {
        if (driver == null) {
            String driverPath = ConfigLoader.getProperty("chrome.driver.path");
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        }
        return driver;
    }

    //Responsável por finalizar a sessão do WebDriver e liberar os recursos associados ao navegador.
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
