package automatizado.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import automatizado.pages.GooglePO;


public class GoogleTest extends BaseTest {

    private GooglePO googlePage;

    @BeforeEach
    public void prepararTest() {
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deve_Pesquisar() {
        // Pesquisa "Batata frita"
        googlePage.pesquisar("Batata frita");

        // Valida o resultado
        assertTrue(googlePage.obterResultadoProtegido().contains("Protegido"));

        // Imprime no console
        System.out.println("Texto encontrado: " + googlePage.obterResultadoProtegido());
    }
}
