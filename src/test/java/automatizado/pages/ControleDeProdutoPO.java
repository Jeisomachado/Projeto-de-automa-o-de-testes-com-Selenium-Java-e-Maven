package automatizado.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automatizado.builder.ProdutoBuilder;

public class ControleDeProdutoPO extends BasePO {

    private WebDriverWait wait;

    public ControleDeProdutoPO(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdicionar;

    @FindBy(css = "div.modal-header>h4")
    public WebElement tituloModal;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "btn-sair")
    public WebElement buttonSair;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "mensagem")
    public WebElement spamMensagem;

    /* =========================
       MÉTODOS DE AÇÃO
       ========================= */

    public void clicarAdicionar() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdicionar)).click();
        wait.until(ExpectedConditions.visibilityOf(tituloModal));
    }

    public void clicarSalvar() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSalvar)).click();
    }

    public void clicarSair() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSair)).click();
        wait.until(ExpectedConditions.invisibilityOf(tituloModal));
    }

    public void cadastrarProduto(String codigo,
                                 String nome,
                                 String quantidade,
                                 String valor,
                                 String data) {

        wait.until(ExpectedConditions.visibilityOf(inputCodigo));

        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade);
        escrever(inputValor, valor);
        escrever(inputData, data);

        clicarSalvar();
    }

    public void cadastrarProduto(ProdutoBuilder produtoBuilder) {
        produtoBuilder.builder();
        clicarSalvar();
    }

    public String obterMensagem() {
        wait.until(ExpectedConditions.visibilityOf(spamMensagem));
        return spamMensagem.getText();
    }

    public String obterTituloPagina() {
        return driver.getTitle();
    }
}
