# TesteBase2 - Projeto de Automação de Testes

Este é um projeto de automação de testes criado usando *Java* com *Selenium WebDriver, **JUnit* e *Maven*. O objetivo deste projeto é automatizar o processo de testes de uma aplicação web.

## Estrutura do Projeto

Abaixo está a estrutura básica do projeto e uma breve explicação de cada componente:

TesteBase2/ ├── src/ │ ├── main/ │ └── test/ │ ├── java/ │ │ ├── core/ │ │ │ ├── BasePage.java │ │ │ └── Elemento.java │ │ ├── pages/ │ │ │ ├── DashboardPage.java │ │ │ ├── LoginPage.java │ │ │ └── CreateTaskPage.java │ │ ├── runners/ │ │ │ └── TestRunner.java │ │ ├── tests/ │ │ │ └── CreateTaskTest.java │ │ └── utils/ │ │ ├── ConfigLoader.java │ │ ├── DriverFactory.java │ │ └── TestBase.java │ └── resources/ │ ├── config.properties │ └── logback.xml ├── .gitignore └── pom.xml

### Explicação dos Arquivos e Diretórios

- *core/*: Contém as classes base que facilitam a manipulação de elementos e ações no Selenium.
  - BasePage.java: Classe base para todas as páginas, contendo métodos comuns como clicar, escrever, e esperar por elementos.
  - Elemento.java: Classe que encapsula a manipulação de elementos do Selenium, facilitando a interação com eles.

- *pages/*: Contém as classes que representam as páginas da aplicação.
  - DashboardPage.java: Representa a página inicial do dashboard após o login.
  - LoginPage.java: Representa a página de login, com métodos para realizar login e verificar o sucesso.
  - CreateTaskPage.java: Representa a página de criação de tarefas, com métodos para preencher e submeter o formulário de criação de uma nova tarefa.

- *runners/*: Contém a classe responsável por executar os testes.
  - TestRunner.java: Classe que define quais testes devem ser executados pelo JUnit.

- *tests/*: Contém as classes de testes.
  - CreateTaskTest.java: Classe de teste que cobre o fluxo de login, criação de uma nova tarefa e verificação se a tarefa foi criada com sucesso.

- *utils/*: Contém classes utilitárias.
  - ConfigLoader.java: Classe responsável por carregar configurações do arquivo config.properties.
  - DriverFactory.java: Classe que gerencia a instância do WebDriver.
  - TestBase.java: Classe base para todos os testes, gerencia o ciclo de vida do WebDriver.

- *resources/*: Contém recursos como arquivos de configuração.
  - config.properties: Arquivo de configuração que armazena valores como URL base, credenciais e caminho para o WebDriver.
  - logback.xml: Arquivo de configuração para o Logback (se usado).

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte instalado em seu sistema:

- Java 11 ou superior
- Maven
- Git

## Configuração

1. Clone o repositório:

```bash
git clone https://github.com/eduardonishino/TesteBase2.git 

Navegue até o diretório do projeto:
cd TesteBase2

Configure o arquivo config.properties com suas informações:
properties

# Configurações básicas
base.url=http://mantis-prova.base2.com.br
username=seu_usuario
password=sua_senha

# Caminho do driver (se não estiver usando WebDriverManager)
chrome.driver.path=drivers/chromedriver.exe
Compile o projeto com Maven:

mvn clean install
Executando os Testes

Para executar os testes, você pode usar o Maven:

mvn test
