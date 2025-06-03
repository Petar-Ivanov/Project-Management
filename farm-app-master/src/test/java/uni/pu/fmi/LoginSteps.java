package uni.pu.fmi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import uni.pu.fmi.services.LoginService;

import static org.junit.Assert.assertEquals;

public class LoginSteps {
    WebDriver driver;

    @Given("потребителя отваря екарана за вход")
    public void openLoginScreen() {
       driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("потребителя въвежда парола {string}")
    public void addPassword(String password) {
        WebElement usernameField = driver.findElement(By.id("password"));
        usernameField.sendKeys(password);
    }

    @When("потребителя натиска бутона за вход")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @When("потребителя въвежда име {string}")
    public void addUsername(String username) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username);
    }

    @Then("визуализира се съобщение за грешка {string}")
    public void checkErrorMessage(String expectedMessage) {
        String errorMessage = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        assertEquals(expectedMessage, errorMessage);
    }

    @Then("отваря се URL: {string}")
    public void checkResultUrl(String expectedURL) {
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedURL,currentUrl);
    }
}
