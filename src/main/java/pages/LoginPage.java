package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(tagName = "button")
    WebElement loginButton;

    @FindBy(xpath = "//*[contains(text(), 'Dashboard')]")
    WebElement dashboardText;

    @FindBy(xpath = "//*[contains(text(), 'Invalid')]")
    WebElement errorText;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isDashboardDisplayed() {
        return dashboardText.isDisplayed();
    }

    public boolean isLoginErrorDisplayed() {
        return errorText.isDisplayed();
    }
}