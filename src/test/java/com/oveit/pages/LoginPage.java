package com.oveit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url: https://practicesoftwaretesting.com/auth/login
public class LoginPage {

    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    @FindBy(css = "input#email")
    private WebElement emailField;

    @FindBy(css = "input#password")
    private WebElement passwordField;

    @FindBy(css = "input[data-test=\"login-submit\"]")
    private WebElement loginButton;

    //Web elements that can be either css or xpath
    @FindBy(css = "form[data-test=\"login-form\"]")
    private WebElement authContainer;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public WebElement getAuthContainer() {
        return authContainer;
    }
}
