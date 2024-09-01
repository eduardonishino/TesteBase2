package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.CreateTaskPage;
import pages.DashboardPage;
import pages.LoginPage;
import utils.TestBase;

public class CreateTaskTest extends TestBase {

    @Test
    public void testCreateTask() {
        // Passo 1: Realizar login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.login();
        Assert.assertTrue("Login não foi bem-sucedido.", loginPage.isLoginSuccessful());

        // Passo 2: Acessar o Dashboard e clicar em criar nova tarefa
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickCreateTask();

        // Passo 3: Preencher o formulário de criação de tarefas
        CreateTaskPage createTaskPage = new CreateTaskPage(driver);
        String taskDescription = "Descrição da tarefa de teste";
        String taskCategory = "General";
        String taskFrequency = "sempre";
        String taskGravidade = "recurso";
        String taskPrioridade = "nenhuma";
        createTaskPage.createTask(taskDescription, taskCategory,taskFrequency, taskGravidade, taskPrioridade);

        // Passo 4: Validar se a nova tarefa foi criada no Dashboard
        String taskText = createTaskPage.isTaskCreated();
        Assert.assertEquals("Esperado que a tarefa seja criada.", taskCategory, taskText);
        }
}
