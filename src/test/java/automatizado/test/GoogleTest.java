package automatizado.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import automatizado.pages.GooglePO;

/**
 * Classe de testes automatizados responsável por validar
 * a funcionalidade de pesquisa no DuckDuckGo.
 */
public class GoogleTest extends BaseTest {

    private GooglePO googlePage;

    @BeforeEach
    public void prepararTest() {
        driver.get("https://duckduckgo.com/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deve_Pesquisar() {

        googlePage.pesquisar("Batata frita");

        // Validação profissional e estável
        assertTrue(driver.getCurrentUrl().contains("q=Batata+frita"));

        System.out.println("Pesquisa realizada com sucesso.");
    }

    @Test
    public void TC002_deve_PesquisarOutroValor() {

        googlePage.pesquisar("Selenium WebDriver");

        assertTrue(driver.getCurrentUrl().contains("q=Selenium+WebDriver"));

        System.out.println("Pesquisa realizada com sucesso.");
    }
}
