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

    public void click() {
        createElement().click();
    }

    public void escrever(String texto) {
        WebElement e = createElement();
        e.click();
        e.clear();
        e.sendKeys(texto);
    }

    public String pegarAtributo(String atributo) {
        WebElement e = createElement();
        return e.getAttribute(atributo);
    }

    private WebElement createElement() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver não foi inicializado corretamente.");
        }
        return driver.findElement(getBy());
    }

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

    public void scrollToElement() {
        WebElement e = createElement();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
    }
}
