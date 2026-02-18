package automatizado.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

     /**
     * Construtor padrão de uma nova instância da pagina de login
     *
     * @param driver WebDriver da pagina de login
     */
    @FindBy(id ="email")
    public WebElement inputEmail;

     @FindBy(id ="senha")
    public WebElement inputSenha;

    @FindBy(id ="btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id ="mensagem")
    public WebElement spamMensagem;
    

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    
    public String obterMensagem(){
        return this.spamMensagem.getText();
    }
        public void executarAcaoDeLogar(String email,String senha){

         escrever(inputEmail, email);
         escrever(inputSenha, senha);

             buttonEntrar.click();
    }

    public String obterTituloPagina(){
        return driver.getTitle();
    }

   
    
}
