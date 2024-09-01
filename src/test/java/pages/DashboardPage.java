package pages;

import core.BasePage;
import core.Elemento;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private Elemento createTaskButton;
    private Elemento createdTask;

    public DashboardPage(WebDriver driver) {
        super(driver);
        createTaskButton = new Elemento(driver, "xpath", "//a[normalize-space(text())='Criar Tarefa']");
    }

    // Método para clicar no botão de criar tarefa
    public void clickCreateTask() {
        esperarElemento(createTaskButton, SMALL);
        clicar(createTaskButton);
    }

    // Método para verificar se a tarefa foi criada
    public boolean isTaskCreated(String taskSummary) {
        Elemento task = new Elemento(driver, "xpath", "//td[@class='task-summary' and text()='" + taskSummary + "']");
        return esperarElemento(task, SMALL);
    }
}
