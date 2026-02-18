 Passo a passo para criação de teste automatizados.

 1 Estruturar o PageObject de login.
  1.1 Criar um arquivo chamado LoginPO.java dentro da pasta page.
  1.2 Fazer herança do arquivo BsePO.java.
  1.3 Fazer o mapeamento de todos os elementos da tela de login.
   1.3.1 Criar os elementos com pageFactory.


2 Estruturar os arquivos de teste de lgin.
 2.1 Criar um arquivo chamado LoginTest.java.
 2.2 Fazer a herança do arquivo BaseTeste.java.
 2.3 Criar um metodo inicial que saiba instanciar um PO de login.
 2.4 Criar os testes baseados na planilha. 
  2.4.1 Não deve logar no sistema com usuario e senha brancos.
  2.4.2 Não deve logar mo sistema com usuario e senha vazio.
  2.4.3 Não deve logar no sistema com usuario vaziom e senha incorreta.
  


