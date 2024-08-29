package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private String url = "http://mantis-prova.base2.com.br"; // URL da página de login

    // Localizadores dos elementos da página
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector(".login-button");
    private By errorMessage = By.cssSelector(".error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para abrir a página de login
    public void openLoginPage() {
        driver.get(url);
    }

    // Método para realizar o login
    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    // Verifique se o login foi bem-sucedido
    public boolean isLoginSuccessful() {
        return driver.getTitle().contains("Dashboard");
    }

    // Verifique se a mensagem de erro foi exibida
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}