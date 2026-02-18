package automatizado.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Classe base para criação das novas PagesObjects
 * Todas as pages devem herdar dessa classe
 */
public abstract class BasePO {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Construtor base para criação da fábrica de elementos (PageFactory)
     * @param driver Driver da página atual
     */
    public BasePO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Retorna o título da página atual
     */
    public String obterTituloPagina() {
        return driver.getTitle();
    }

    /**
     * Escreve em um campo após garantir que ele esteja visível
     */
    public void escrever(WebElement input, String texto) {
        wait.until(ExpectedConditions.visibilityOf(input));
        input.clear();
        input.sendKeys(texto);
        input.sendKeys(Keys.TAB);
    }

    /**
     * Clica em um elemento após garantir que ele esteja clicável
     */
    public void clicar(WebElement elemento) {
        wait.until(ExpectedConditions.elementToBeClickable(elemento));
        elemento.click();
    }

    /**
     * Retorna o texto de um elemento após garantir que esteja visível
     */
    public String obterTexto(WebElement elemento) {
        wait.until(ExpectedConditions.visibilityOf(elemento));
        return elemento.getText();
    }
}
