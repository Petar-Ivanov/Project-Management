package uni.pu.fmi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import uni.pu.fmi.services.TaskService;

import static org.junit.Assert.assertEquals;

public class ChangeStatusSteps {
    MessageContext messageContext = new MessageContext();

    private String taskTitle;

    private String userName;

    private String newStatus;

    TaskService taskService;

    @Given("^потребителя отваря екарана за промяна на статус на задача$")
    public void openChangeProjectStatusScreen() {
        taskService = new TaskService();
    }

    @When("системата приема името на задачата {string}")
    public void addTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    @And("системата приема името на потребителя {string}")
    public void addUserName(String userName) {
        this.userName = userName;
    }

    @And("системата приема статус {string}")
    public void addNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    @Then("визуализира се съобщение за сменен статус {string}")
    public void checkSuccessMessage(String message) {
        assertEquals(message, messageContext.getMessage());
    }

    @Then("визуализира се съобщение за неуспешна смяна {string}")
    public void checkFailureMessage(String message) {
        assertEquals(message, messageContext.getMessage());
    }

    @And("потребителя натиска бутона за промяна на статуса на задачата")
    public void clickChangeProjectStatusButton() {
        messageContext.setMessage(taskService.changeStatus(taskTitle, userName, newStatus));
    }
}
