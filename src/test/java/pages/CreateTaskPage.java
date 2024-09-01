package pages;

import core.BasePage;
import core.Elemento;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigLoader;

import java.io.File;

public class CreateTaskPage extends BasePage {

    private Elemento selectCategoria;
    private Elemento optionsCategoria;
    private Elemento selectFrequencia;
    private Elemento selectGravidade;
    private Elemento selectPrioridade;
    private Elemento selectResumo;
    private Elemento selectDescricao;
    private Elemento buttonCreate;

    private Elemento taskcreate;

    private Elemento dropzoneUpload;

    public CreateTaskPage(WebDriver driver) {
        super(driver);
        selectCategoria = new Elemento(driver, "xpath", "//table[contains(@class,'table table-bordered')]/tbody[1]/tr[1]/td[1]/select[1]");
        optionsCategoria = new Elemento(driver, "xpath", "//option[normalize-space()='[Todos os Projetos] categoria teste']");
        selectFrequencia = new Elemento(driver, "xpath", "//table[contains(@class,'table table-bordered')]");
        selectGravidade = new Elemento(driver, "xpath", "//select[@id='severity']");
        selectPrioridade = new Elemento(driver, "xpath", "//select[@id='priority']");
        selectResumo = new Elemento(driver, "xpath", "//input[@id='summary']");
        selectDescricao = new Elemento(driver, "xpath", "//textarea[@id='description']");
        buttonCreate = new Elemento(driver, "xpath", "//input[@value='Criar Nova Tarefa']");
        taskcreate = new Elemento(driver, "xpath", "//td[@class='bug-description']");
        dropzoneUpload = new Elemento(driver, "xpath", "//table[contains(@class,'table table-bordered')]");
    }

    // Método para preencher o formulário de criação de tarefa e submeter
    public void createTask(String summary, String description, String frequency,String gravidade, String prioridade) {
        selecionarCategoria();
        selecionarFrequencia(frequency);
        selecionarGravidade(gravidade);
        selecionarPrioridade(prioridade);
        esperarElemento(selectResumo, SMALL);
        escrever(selectResumo, summary);
        esperarElemento(selectDescricao, SMALL);
        escrever(selectDescricao, description);
        //uploadFile();
        esperarElemento(buttonCreate, SMALL);
        clicar(buttonCreate);
    }

    // Método auxiliar para selecionar uma categoria no dropdown
    private void selecionarCategoria() {
        esperarElemento(selectCategoria, SMALL);
        clicar(selectCategoria);
        esperarElemento(optionsCategoria, SMALL);
        clicar(optionsCategoria);
    }

    // Métodos auxiliares para selecionar outras opções
    public void selecionarFrequencia(String frequencia) {
        esperarElemento(selectFrequencia, SMALL);
        clicar(selectFrequencia);
        Elemento option = new Elemento(driver, "xpath", "//option[normalize-space()='" + frequencia + "']");
        esperarElemento(option, SMALL);
        clicar(option);
    }

    public void selecionarGravidade(String gravidade) {
        esperarElemento(selectGravidade, SMALL);
        clicar(selectGravidade);
        Elemento option = new Elemento(driver, "xpath", "//option[normalize-space()='" + gravidade + "']");
        esperarElemento(option, SMALL);
        clicar(option);
    }

    public void selecionarPrioridade(String prioridade) {
        esperarElemento(selectPrioridade, SMALL);
        clicar(selectPrioridade);
        Elemento option = new Elemento(driver, "xpath", "//option[normalize-space()='" + prioridade + "']");
        esperarElemento(option, SMALL);
        clicar(option);
    }

    // Método para realizar o upload do arquivo
   /* private void uploadFile() {
        // Caminho do arquivo que você deseja carregar
        String filePath = ConfigLoader.getProperty("upload.file.path");
        File file = new File(filePath);

        if (file.exists()) {
            dropzoneUpload.escrever(file.getAbsolutePath());
        } else {
            throw new RuntimeException("Arquivo para upload não encontrado: " + filePath);
        }
    }*/

    // Método para verificar se a tarefa foi criada e retornar o texto
    public String isTaskCreated() {
        esperarElemento(taskcreate, BasePage.MIDDLE);
        return taskcreate.pegarAtributo("textContent");
    }
}
