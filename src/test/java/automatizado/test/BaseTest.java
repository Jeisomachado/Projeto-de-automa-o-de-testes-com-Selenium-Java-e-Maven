package automatizado.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.nio.file.Paths;

public abstract class BaseTest {

    public WebDriver driver;

    @BeforeEach
    public void deve_iniciar() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Se estiver rodando no GitHub Actions, ativa headless
        if (System.getenv("CI") != null) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Caminho dinâmico que funciona no Windows e no Linux (GitHub)
        String caminho = Paths.get("sistema/login.html")
                .toAbsolutePath()
                .toUri()
                .toString();

        driver.get(caminho);
    }

    @AfterEach
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
