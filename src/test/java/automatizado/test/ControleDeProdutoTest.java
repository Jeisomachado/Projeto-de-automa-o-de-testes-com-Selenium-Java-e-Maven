package automatizado.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import automatizado.builder.ProdutoBuilder;
import automatizado.pages.ControleDeProdutoPO;
import automatizado.pages.LoginPO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ControleDeProdutoTest extends BaseTest {

    private LoginPO loginPage;
    private ControleDeProdutoPO controleProdutoPage;

    @BeforeEach
    public void prepararTest() {

        // 🔥 ABRE O LOGIN.HTML
        String caminho = System.getProperty("user.dir")
                + "/sistema/login.html";

        driver.get("file:///" + caminho.replace("\\", "/"));

        // Inicializa PageObjects
        loginPage = new LoginPO(driver);

        // Executa login
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        // Inicializa página de controle
        controleProdutoPage = new ControleDeProdutoPO(driver);

        // Valida que está na página correta
        assertEquals("Controle de Produtos",
                controleProdutoPage.obterTituloPagina());
    }
    @Test
    public void TC001_DeveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.buttonAdicionar.click();
        //*TODO:Remover esse click assim que corrigido */
        controleProdutoPage.buttonAdicionar.click();

        String titulo = controleProdutoPage.tituloModal.getText();

         assertEquals (titulo, "Produto");

         controleProdutoPage.buttonSair.click();
         controleProdutoPage.buttonSair.click();

    }

        @Test
    public void TC002_NaoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.cadastrarProduto("0001", "Martelo", "10", "59,90", "");

      

        //*/
        // Aquivamos capturar a mensagem de erro */
        String mensagem = controleProdutoPage.spamMensagem.getText();

assertEquals(
    "Todos os campos são obrigatórios para o cadastro!",
    mensagem
);

    }

            @Test
    public void TC003_DeveCadastrarProdutoComSucesso(){
        controleProdutoPage.buttonAdicionar.click();
        controleProdutoPage.buttonAdicionar.click();


        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
//**/
// Aqui ele cria o objeto para adicionar na tela  */
ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);

//**/
// Aqui estamos testando se o produto é adicionado sem codigo*/
produtoBuilder
.adicionarCodigo("")
.builder();


assertEquals(
    mensagem,
    controleProdutoPage.obterMensagem()
);

//**/
// Aqui estamos testando se o produto é adicionado sem quantidade */
produtoBuilder
.adicionarCodigo("0005")
.adicionarNome("Martelo")
.adicionarQuantidade((null))
.adicionarValore(50.40)
.builder();

assertEquals(
    mensagem,
    controleProdutoPage.obterMensagem()
);

produtoBuilder
.adicionarNome("Tijolo")
.adicionarQuantidade(15)
.adicionarValore(50.40)
.builder();


//**/
// Aqui estamos testando se o produto é adicionado sem valor */
produtoBuilder
.adicionarCodigo("0005")
.adicionarNome("Cimento")
.adicionarQuantidade((null))
.adicionarValore((null))
.builder();

assertEquals(
    mensagem,
    controleProdutoPage.obterMensagem()
);

//**/
// Aqui estamos testando se o produto é adicionado sem data */
produtoBuilder
.adicionarCodigo("0005")
.adicionarNome("Martelo")
.adicionarQuantidade(50)
.adicionarValore(50.40)
.adicionarData("")
.builder();

assertEquals(
    mensagem,
    controleProdutoPage.obterMensagem()
);

if (controleProdutoPage.tituloModal.isDisplayed()) {
    controleProdutoPage.clicarSair();
}





}



}