package pages;

import core.BasePage;
import core.Elemento;
import org.openqa.selenium.WebDriver;
import utils.ConfigLoader;

public class LoginPage extends BasePage {

    // Localizadores dos elementos da página encapsulados pela classe Elemento
    private Elemento usernameField;
    private Elemento passwordField;
    private Elemento enterButton;
    private Elemento errorMessage;
    private Elemento loggedName;

    public LoginPage(WebDriver driver) {
        super(driver); // Chama o construtor da classe BasePage

        // Inicializando os elementos da página
        usernameField = new Elemento(driver, "xpath", "//input[@placeholder='Nome de usuário']");
        enterButton = new Elemento(driver, "xpath", "//input[@type='submit']");
        passwordField = new Elemento(driver, "xpath", "//input[@placeholder='Senha']");
        errorMessage = new Elemento(driver, "xpath", "//div[@class='alert alert-danger']//p[1]");
        loggedName = new Elemento(driver, "xpath", "//span[normalize-space(text())='Eduardo_Nishino']");
    }

    // Método para abrir a página de login
    public void openLoginPage() {
        String url = ConfigLoader.getProperty("base.url");
        driver.get(url);
    }

    // Método para realizar o login
    public void login() {
        String username = ConfigLoader.getProperty("username");
        String password = ConfigLoader.getProperty("password");

        // Espera pelo campo de nome de usuário estar presente antes de interagir
        esperarElemento(usernameField, BasePage.SMALL);
        escrever(usernameField, username);
        esperarElemento(enterButton, BasePage.SMALL);
        clicar(enterButton);
        esperarElemento(passwordField, BasePage.SMALL);
        escrever(passwordField, password);
        esperarElemento(enterButton, BasePage.SMALL);
        clicar(enterButton);
    }

    // Método para login com credenciais inválidas
    public void loginError() {
        String username = "user";
        String password = "password";

        esperarElemento(usernameField, BasePage.SMALL);
        escrever(usernameField, username);
        esperarElemento(enterButton, BasePage.SMALL);
        clicar(enterButton);
        esperarElemento(passwordField, BasePage.SMALL);
        escrever(passwordField, password);
        esperarElemento(enterButton, BasePage.SMALL);
        clicar(enterButton);
    }

    // Verifique se o login foi bem-sucedido
    public boolean isLoginSuccessful() {
        esperarElemento(enterButton, BasePage.SMALL);
        return loggedName.pegarAtributo("textContent").equals("Eduardo_Nishino");
    }

    // Verifique se a mensagem de erro foi exibida
    public boolean isErrorMessageDisplayed() {
        return !errorMessage.pegarAtributo("textContent").isEmpty();
    }

    public void validarLogin() {
        if (isLoginSuccessful()) {
            System.out.println("Login foi bem-sucedido.");
        } else if (isErrorMessageDisplayed()) {
            System.out.println("Ocorreu um erro no login.");
        } else {
            System.out.println("Estado desconhecido após o login.");
        }
    }
}
