package automatizado.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object responsável pela página de pesquisa do Google.
 */
public class GooglePO {

    public WebDriver driver;

    /**
     * Construtor responsável por inicializar a página do Google
     * e seus elementos.
     *
     * @param driver WebDriver utilizado nos testes
     */
    public GooglePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Campo de pesquisa do Google.
     */
  @FindBy(name = "q")
private WebElement inputPesquisa;


    /**
     * Elemento que representa o resultado contendo o texto "Protegido".
     */
    @FindBy(xpath = "//*[contains(text(),'Protegido')]")
    private WebElement resultadoProtegido;

    /**
     * Realiza uma pesquisa no Google com base no texto informado.
     *
     * @param texto texto que será pesquisado
     */
    public void pesquisar(String texto) {
        inputPesquisa.sendKeys(texto + Keys.ENTER);
    }

    /**
     * Obtém o texto do resultado protegido exibido na página.
     *
     * @return texto encontrado no resultado da pesquisa
     */
    public String obterResultadoProtegido() {
        return resultadoProtegido.getText();
    }
}
