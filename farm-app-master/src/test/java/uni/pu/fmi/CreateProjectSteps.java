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
    private MessageContext messageContext = new MessageContext();
    private ProjectService projectService;

    private String title;
    private String description;
    private LocalDateTime finalDate;
    private String creatorUsername;

    @Given("потребителя отваря екрана за създаване на проект")
    public void openNewProjectScreen() {
        projectService = new ProjectService();

        title = null;
        description = null;
        finalDate = null;
        creatorUsername = null;
    }

    @When("потребителя въвежда заглавие {string}")
    public void addTitle(String title) {
        this.title = title.isEmpty() ? null : title;
    }

    @And("системата приема името на създателя {string}")
    public void addCreatorName(String name) {
        this.creatorUsername = name.isEmpty() ? null : name;
    }

    @And("потребителя въвежда описание {string}")
    public void addDescription(String description) {
        this.description = description.isEmpty() ? null : description;
    }

    @And("потребителя въвежда крайна дата {string}")
    public void addEndDate(String endDateString) {
        if (endDateString.isEmpty()) {
            this.finalDate = null;
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            this.finalDate = LocalDateTime.parse(endDateString, formatter);
        }
    }

    @And("потребителя натиска бутона за създаване на нов проект")
    public void clickNewProjectButton() {
        String resultMessage = projectService.createProject(
                title,
                description,
                finalDate,
                LocalDateTime.now(),
                creatorUsername
        );
        messageContext.setMessage(resultMessage);
    }

    @Then("визуализира се съобщение за успех {string}")
    public void checkSuccessMessage(String message) {
        assertEquals(message, messageContext.getMessage());
    }

    @Then("визуализира се съобщение за неуспех {string}")
    public void checkFailureMessage(String message) {
        assertEquals(message, messageContext.getMessage());
    }


}