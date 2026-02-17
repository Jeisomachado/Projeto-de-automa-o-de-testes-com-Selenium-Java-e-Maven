package automatizado.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import automatizado.pages.GooglePO;

/**
 * Classe de testes automatizados responsável por validar
 * a funcionalidade de pesquisa no Google.
 *
 * <p>
 * Os testes utilizam Selenium WebDriver com JUnit 5
 * e seguem o padrão de testes funcionais.
 * </p>
 */
public class GoogleTest extends BaseTest {

    /**
     * Page Object responsável pelas interações
     * com a página de pesquisa do Google.
     */
    private GooglePO googlePage;

    /**
     * Método executado antes de cada teste.
     *
     * <p>
     * Responsável por inicializar o Page Object
     * utilizando o WebDriver configurado no BaseTest.
     * </p>
     */
    @BeforeEach
    public void prepararTest() {
        driver.get("https://duckduckgo.com/");
        googlePage = new GooglePO(driver);

    }

    /**
     * Cenário de teste que valida a pesquisa no Google.
     *
     * <p>
     * Fluxo:
     * <ul>
     *   <li>Realiza uma pesquisa pelo termo "Batata frita"</li>
     *   <li>Obtém o texto do resultado retornado</li>
     *   <li>Valida se o texto contém a palavra "Protegido"</li>
     * </ul>
     * </p>
     */
    @Test
    public void TC001_deve_Pesquisar() {
        googlePage.pesquisar("Batata frita");

        String resultado = googlePage.obterResultadoProtegido();

        assertTrue(resultado.contains("Protegido"));

        System.out.println("Texto encontrado: " + resultado);
    }

    /**
     * Cenário de teste que valida uma nova execução
     * da pesquisa no Google.
     *
     * <p>
     * O objetivo é garantir que o comportamento
     * continue funcionando corretamente em
     * múltiplas execuções.
     * </p>
     */
    @Test
    public void TC002_deve_PesquisarOutroValor() {
        googlePage.pesquisar("Batata frita");

        String resultado = googlePage.obterResultadoProtegido();

        assertTrue(resultado.contains("Protegido"));

        System.out.println("Texto encontrado: " + resultado);
    }
}
