package automatizado.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePO {

    private WebDriver driver;

    public GooglePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Campo de pesquisa
    @FindBy(id = "searchbox_input")
    private WebElement inputPesquisa;

    // Elemento do resultado "Protegido"
    @FindBy(xpath = "//*[contains(text(),'Protegido')]")
    private WebElement resultadoProtegido;

    // Método para pesquisar
    public void pesquisar(String texto) {
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    // Método para obter o texto do resultado
    public String obterResultadoProtegido() {
        return resultadoProtegido.getText();
    }
}
