package automatizado.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;

import automatizado.pages.LoginPO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest extends BaseTest {

    private LoginPO loginPage;

    @BeforeEach
    public void prepararTest() {
        loginPage = new LoginPO(driver);
    }

    @Test
    @Order(1)
    public void TC001_naoDeveLogarComEmailESenhaVazios() {

        loginPage.executarAcaoDeLogar("", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(
            "Informe usuário e senha, os campos não podem ser brancos.",
            mensagem.trim()
        );
    }

    @Test
    @Order(2)
    public void TC002_naoDeveLogarComEmailIncorretoESenhaVazia() {

        loginPage.executarAcaoDeLogar("teste", "");

        String mensagem = loginPage.obterMensagem();

        assertEquals(
            "Informe usuário e senha, os campos não podem ser brancos.",
            mensagem.trim()
        );
    }

    @Test
    @Order(3)
    public void TC003_naoDeveLogarComEmailVazioESenhaIncorreta() {

        loginPage.executarAcaoDeLogar("", "teste");

        String mensagem = loginPage.obterMensagem();

        assertEquals(
            "Informe usuário e senha, os campos não podem ser brancos.",
            mensagem.trim()
        );
    }

    @Test
    @Order(4)
    public void TC004_naoDeveLogarComEmailESenhaInvalidos() {

        loginPage.executarAcaoDeLogar("email@invalido.com", "123456");

        String mensagem = loginPage.obterMensagem();

        assertEquals(
            "E-mail ou senha inválidos",
            mensagem.trim()
        );
    }

        @Test
    @Order(7)
    public void TC007_DeveLogarNoSistemaComEmailESenhaCorretos() {

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

       assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");

        
    }
}
