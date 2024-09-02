package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Elemento {
    private WebDriver driver;
    private String value, type;

    public Elemento(WebDriver driver, String type, String value) {
        this.driver = driver;
        this.type = type;
        this.value = value;
    }

    //Localiza o elemento e o clica, usando o método createElement() para encontrá-lo.
    public void click() {
        createElement().click();
    }

    //Este método localiza o elemento, clica nele, limpa o campo (se for um campo de texto) e depois insere o texto passado como parâmetro.
    public void escrever(String texto) {
        WebElement e = createElement();
        e.click();
        e.clear();
        e.sendKeys(texto);
    }

    //Retorna o valor de um atributo específico do elemento. Por exemplo, se o atributo for "class", ele retornará o valor da classe do elemento.
    public String pegarAtributo(String atributo) {
        WebElement e = createElement();
        return e.getAttribute(atributo);
    }

    //Esse método privado é responsável por localizar o elemento na página, usando o driver.findElement(getBy()) baseado no tipo e no valor fornecidos.
    private WebElement createElement() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver não foi inicializado corretamente.");
        }
        return driver.findElement(getBy());
    }

    //Converte o tipo e valor fornecidos em uma instância da classe By, que é usada pelo Selenium para localizar elementos. Ele suporta localizadores como XPath, ID, Classe e Texto Parcial do Link.
    public By getBy() {
        if ("xpath".equalsIgnoreCase(type))
            return By.xpath(value);
        if ("id".equalsIgnoreCase(type))
            return By.id(value);
        if ("class".equalsIgnoreCase(type))
            return By.className(value);
        if ("text".equalsIgnoreCase(type))
            return By.partialLinkText(value);
        return null;
    }

    //Este método usa JavaScript para rolar a página até que o elemento esteja visível na tela, usando o método scrollIntoViewIfNeeded.
    public void scrollToElement() {
        WebElement e = createElement();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
    }
}
