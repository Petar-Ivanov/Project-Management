package uni.pu.fmi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.services.ProjectService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class CreateProjectSteps {
    MessageContext messageContext = new MessageContext();

    private String title;

    private String description;

    private LocalDateTime finalDate;

    private LocalDateTime createdOn;

    private String creatorUsername;

    ProjectService projectService;

    @Given("потребителя отваря екарана за създаване на проект")
    public void openNewProjectScreen() {
        projectService = new ProjectService();
    }

    @When("потребителя въвежда заглавие {string}")
    public void addTitle(String title) {
        this.title = title;
    }

    @And("потребителя натиска бутона за създаване на нов проект")
    public void clickNewProjectButton() {
        messageContext.setMessage(projectService.createProject(title, description, finalDate, LocalDateTime.now(), creatorUsername));
    }

    @And("системата приема името на създателя {string}")
    public void addCreatorName(String name) {
        this.creatorUsername = name;
    }

    @Then("визуализира се съобщение за успех {string}")
    public void checkSuccessMessage(String message) {
        assertEquals(message, messageContext.getMessage());
    }

    @Then("визуализира се съобщение за неуспех {string}")
    public void checkFailureMessage(String message) {
        assertEquals(message, messageContext.getMessage());
    }

    @And("потребителя въвежда описание {string}")
    public void addDescription(String description) {
        this.description = description;
    }

    @And("потребителя въвежда крайна дата {string}")
    public void addEndDate(String endDateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.finalDate = LocalDateTime.parse(endDateString, formatter);
    }
}
