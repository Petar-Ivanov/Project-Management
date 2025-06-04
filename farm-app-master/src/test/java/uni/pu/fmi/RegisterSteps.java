package uni.pu.fmi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.services.RegisterService;

import static org.junit.Assert.assertEquals;

public class RegisterSteps {

    private final MessageContext messageContext;
    private String username;

    private String password;

    private String password2;

    private String email;

    private RegisterService registerService;

    private String phone;

    public RegisterSteps(MessageContext messageContext) {
        this.messageContext = messageContext;
    }

    @Given("Потребителя отваря екрана за регистрация")
    public void openRegisterScreen() {
        registerService = new RegisterService();
    }

    @When("потребителя въвежда потребителско име {string}")
    public void addUsername(String username) {
        this.username = username;
    }

    @When("потребителя въвежда потребителака парола {string}")
    public void addPassword(String password) {
        this.password = password;
    }

    @When("потребителя въвежда потвърдена парола {string}")
    public void addSecondPassword(String pass2) {
        password2 = pass2;
    }

    @When("потребителя въвежда имейл {string}")
    public void addEmail(String email) {
        this.email = email;
    }

    @When("потребителя натиска бутона за регистрация")
    public void clickRegisterButton() {
        messageContext.setMessage(registerService.register(username, password, password2, email, phone));
    }

    @Then("визуализира се съобщение {string}")
    public void checkMessage(String expectedMessage) {
        assertEquals(expectedMessage, messageContext.getMessage());
    }

}
