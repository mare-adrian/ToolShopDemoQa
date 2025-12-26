package com.oveit.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url: https://practicesoftwaretesting.com/account
public class AccountPage {
    WebDriver driver;
    @FindBy(css = "a[data-test=\"nav-menu\"]")
    private WebElement userNameLabel;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String extractUsernameText() {
        return userNameLabel.getText();
    }
}
