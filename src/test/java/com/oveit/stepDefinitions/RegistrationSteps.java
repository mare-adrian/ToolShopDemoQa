package com.oveit.stepDefinitions;

import com.oveit.pages.AccountPage;
import com.oveit.pages.LoginPage;
import com.oveit.pages.MainPage;
import com.oveit.pages.RegistrationPage;
import com.oveit.utils.DataGeneration;
import com.oveit.utils.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class RegistrationSteps {

    DataGeneration data = DataGeneration.getInstance();

    WebDriver driver = Hooks.driver;
    MainPage mainPage=new MainPage(driver);



    @When("i register a new account")
    public void iFillAllNecessaryInformationAndClickRegister() {

        RegistrationPage clientRegistrationPage = new RegistrationPage(driver);
        mainPage.navigateToRegisterAccount();
        clientRegistrationPage.fillClientInfo(data.firstName, data.lastName);
        clientRegistrationPage.fillClientAddressInfo(data.address, data.postCode, data.city, data.state, data.country, data.phone);
        clientRegistrationPage.fillClientAccountInfo(data.email, data.password);
        clientRegistrationPage.clickSubmit();
        System.out.println(data.email);
        System.out.println(data.password);


    }

    @Then("i should be successfully registered")
    public void iShouldBeSuccessfullyRegistered() {
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        Assertions.assertTrue(loginPage.getAuthContainer().isDisplayed());

        loginPage.login(data.email, data.password);

        Assertions.assertEquals(accountPage.extractUsernameText(), data.firstName + " " + data.lastName);
    }

    @Given("i am on the main page")
    public void iAmOnTheMainPage() {
        driver.get("https://practicesoftwaretesting.com/");

    }


    @Then("i test all filters")
    public void iTestAllFilters() {
        mainPage.test();
    }
}
