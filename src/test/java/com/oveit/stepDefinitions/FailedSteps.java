package com.oveit.stepDefinitions;

import com.oveit.pages.LoginPage;
import com.oveit.pages.RegistrationPage;
import com.oveit.utils.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FailedSteps {

    WebDriver driver = Hooks.driver;

    @When("i click on submit button")
    public void iClickOnSubmitButton() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.clickSubmit();
    }

    @Then("i fail test")
    public void iFailTest() {
        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.getAuthContainer().isDisplayed());
    }
}
