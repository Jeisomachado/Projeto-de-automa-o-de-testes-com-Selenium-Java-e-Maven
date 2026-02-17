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
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

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
