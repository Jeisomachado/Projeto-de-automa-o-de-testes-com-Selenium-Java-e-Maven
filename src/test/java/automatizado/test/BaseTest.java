package automatizado.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {

    public WebDriver driver;

    @BeforeEach
    public void deve_iniciar() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  // usa o driver da classe, não cria local
        driver.manage().window().maximize();
        driver.get("file:///C:/SeleniumGoogle/automatizado/sistema/login.html");
        //**
        // driver.get("https://duckduckgo.com/");
    }

    @AfterEach
    public void finalizar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
