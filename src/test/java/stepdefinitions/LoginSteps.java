package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://bugbash.syook.com/");
        loginPage = new LoginPage(driver);
    }

    @When("User enters valid email {string} and password {string}")
    @When("User enters invalid email {string} and password {string}")
    public void user_enters_credentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("User should be redirected to the dashboard")
    public void user_should_be_redirected_to_dashboard() {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
        driver.quit();
    }

    @Then("Error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.isLoginErrorDisplayed());
        driver.quit();
    }
}