# Estrutura para testes
Documentação Automação de Casos de Testes Java/Cucumber

Resumo: 
Desenvolvimento do escopo para automação de casos de testes utilizando a técnica BDD (Behavior Driven Development) ou Design/Desenvolvimento guiado por comportamento, no caso não será utilizado a técnica com a proposta a que foi criada, mais para gerar relatórios a partir de casos de testes criados pelo analista de testes, porém a técnica em si tem como premissa envolver analista de negócios escrevendo cenários antes do desenvolvimento, portanto em nosso escopo iremos desenvolver cenários(histórias) a partir de funcionalidades já criadas ao final gerar um relatório de testes executados e seus status.

### Tags ###

Para utilização de tags nas features, existe algumas nomenclaturas:

- Tag `@done` para cenários já automatizados e em execução
- Tag `@Web` cenario do desafio WEB
- Tag `@Api` cenario do desafio API


# Ferramentas utilizadas:
**IDE de desenvolvimento:** Eclipse

# Frameworks: 
- **Maven** – controle de versões.
- **Cucumber** – responsável interação das histórias com desenvolvimento.
- **Selenium Webdriver** – responsável pela manipulação de elementos Web.
- **Junit** -  indicado para criação de testes Unitários.

# Estrutura de pastas utilizadas:
O projeto contém a seguinte estrutura
- **Config** – Responsável pela configuração específicas do ambiente
	- **BrowserFactory** - Responsável pela instanciação do WebDriver e manter a instância do navegador, foi criada a Browser Factory.
	- **RunnersCucumber** -  configurações de execução do cucumber
 	- **Utils** – utilizado para armazenar métodos reutilizáveis.
- **Features** - Local onde são armazenadas as features do projeto 
- **PagesActions** – Armazena arquivos responsáveis pelas interações dos elementos mapeados.
- **StepsDefinitions** – Armazena arquivos gerados a partir das features criadas, fazendo a chamada das pages.


# Configuração Ambiente: 
- Instalar ambiente de desenvolvimento java "https://medium.com/beelabacademy/configurando-vari%C3%A1veis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26 ".
- Instalar ambiente Maven “https://maven.apache.org/download.cgi ”.
- Após instalação maven e colocar em variavel de ambiente tera acesso ao comando **"mvn"**
  - Adicionar dependências no arquivo “pom.xml”.
versões utilizadas na data da criação desta estrutura (01/02/2021).
    - cucumber-java - 1.2.6
    - selenium-java - 3.141.59
    - cucumber-junit - 1.2.6
    - extentreports - 4.0.9
    - commons-io - 2.6
	- rest-assured - 4.3.0
	- json-simple - 1.1.1
	
# Comando para Execução em linha de comando com MVN instalado

**mvn -Dtest**=TestRunner **-Dcucumber.options**="--tags @done --tags @Web" **test**
 
**-Dtest** -> Caminho do arquivo de execução TestRunner
**-Dcucumber.options** -> Tags selecionada para execução, obs: passando esta informação ele sobrepoe as tags setadas no arquivo TestRunner
**-Dambiente** -> ambiente selecionado para execução da automação.

# Execução via run eclipse arquivo TestRunner

Selecionar aquivo **TestRunner** e clicar em **run** via IDE
Para selecionar os cenario somente mudar a **TAG** do arquivo para **@Web** ou **@Api**

 
  
  

