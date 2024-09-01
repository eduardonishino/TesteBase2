package core;

import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class BasePage {

    // Tempos de espera (em segundos)
    public static final String SMALL = "10";
    public static final String MIDDLE = "30";
    public static final String BIG = "60";

    protected WebDriver driver;

    // Construtor
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para garantir que o WebDriver esteja inicializado
    public WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.getDriver();  // Use DriverFactory para obter o WebDriver
        }
        return driver;
    }

    // Espera por um elemento estar presente na página
    public Boolean esperarElemento(Elemento e, String tempo) {
        try {
            // Converte o tempo em segundos para uma Duration e passa para o WebDriverWait
            new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(tempo)))
                    .until(ExpectedConditions.presenceOfElementLocated(e.getBy()));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    // Valida se um elemento está clicável
    public Boolean validarElemento(Elemento e) {
        try {
            // Usando Duration.ofSeconds para especificar o tempo de espera
            new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(ExpectedConditions.elementToBeClickable(e.getBy()));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    // Navega até uma URL
    public Boolean navegar(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    // Clica em um elemento
    public Boolean clicar(Elemento e) {
        try {
            rolarAoElemento(e);
            e.click();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    // Escreve em um elemento
    public Boolean escrever(Elemento e, String texto) {
        try {
            rolarAoElemento(e);
            e.escrever(texto);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }

    // Troca para uma nova aba
    public Boolean trocarAba() {
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            if (tabs.size() > 1) {
                String handleName = "";
                for (String tab : tabs) handleName = tab;
                driver.switchTo().window(handleName);
                driver.manage().window().maximize();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // Rola a página até o elemento estar visível
    public void rolarAoElemento(Elemento e) {
        e.scrollToElement();
    }

    // Obtém um atributo de um elemento
    public String pegarInformacaoAtributo(Elemento e, String atributo) {
        return e.pegarAtributo(atributo);
    }

    // Fecha todas as abas abertas exceto a principal
    public void fecharAbas() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        if (tabs.size() > 1) {
            driver.close();
            trocarAba();
            fecharAbas();
        }
    }
}
