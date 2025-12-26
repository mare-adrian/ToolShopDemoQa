package com.oveit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

// page_url: https://practicesoftwaretesting.com/auth/register
public class RegistrationPage {

    //The driver
    WebDriver driver;
    @FindBy(css = "input[data-test=\"first-name\"]")
    private WebElement firstNameField;
    @FindBy(css = "input[data-test=\"last-name\"]")
    private WebElement lastNameField;
    @FindBy(css = "#dob")
    private WebElement dateOfBirthField;
    @FindBy(css = "input#street")
    private WebElement addressField;
    @FindBy(css = "input#postal_code")
    private WebElement postCodeField;
    @FindBy(css = "input[data-test=\"city\"]")
    private WebElement cityField;
    @FindBy(css = "input[formcontrolname=\"state\"]")
    private WebElement stateField;
    @FindBy(css = "select#country")
    private WebElement countrySelect;
    @FindBy(xpath = "//input[@data-test=\"phone\"]")
    private WebElement phoneField;
    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElement emailField;
    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    //Constructor for receiving the driver instance and initialising web elements
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Methods used for testing. Something quick and dirty for demonstration purposes
    public void fillClientInfo(String firstName, String lastName) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        dateOfBirthField.sendKeys("1994-12-12");
    }

    public void fillClientAddressInfo(String address, String postCode, String city, String state, int country, String phone) {
        addressField.sendKeys(address);
        postCodeField.sendKeys(postCode);
        cityField.sendKeys(city);
        stateField.sendKeys(state);

        Select select = new Select(countrySelect);
        select.selectByIndex(country);

        phoneField.sendKeys(phone);
    }

    public void fillClientAccountInfo(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}