package automatizado.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

public abstract class BaseTest {

    public WebDriver driver;

    @BeforeEach
    public void deve_iniciar() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Caminho dinâmico do projeto (funciona Windows e Linux)
        String caminho = System.getProperty("user.dir") + File.separator + 
                         "sistema" + File.separator + "login.html";

        driver.get("file:///" + caminho);
    }

    @AfterEach
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
