package com.oveit.pages;

import com.oveit.utils.DataGeneration;
import org.knowm.xchart.internal.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// page_url: https://practicesoftwaretesting.com/account
public class MainPage {
    WebDriver driver;
    //helper
    DataGeneration data = DataGeneration.getInstance();
    @FindBy(css = "a[data-test=\"nav-menu\"]")
    private WebElement userNameLabel;
    @FindBy(xpath = "(//a[normalize-space()='Sign in'])[1]")
    private WebElement singInButton;
    @FindBy(xpath = "(//a[normalize-space()='Register your account'])[1]")
    private WebElement registerAccountButton;
    @FindBy(xpath = "(//a[normalize-space()='Home'])[1]")
    private WebElement homeButton;
    @FindBy(xpath = "(//h5[normalize-space()='Combination Pliers'])[1]")
    private WebElement firstItem;
    @FindBy(xpath = "//button[@id='btn-add-to-cart']")
    private WebElement addToCartButton;
    @FindBy(css = "input[data-test='category-01KDEE8B0NPKT84S2J486X7YNJ']")
    private WebElement sanderFilter;
    @FindBy(xpath = "//h5[normalize-space()='Sheet Sander']")
    private WebElement secondItem;
    @FindBy(xpath = "//a[normalize-space()='4']")
    private WebElement fourPage;
    @FindBy(xpath = "(//h5[normalize-space()='Protective Gloves'])[1]")
    private WebElement thirdItem;
    @FindBy(xpath = "//input[@id='search-query']")
    private WebElement searchBar;
    @FindBy(xpath = "//h5[normalize-space()='Mini Screwdriver']")
    private WebElement forthitem;
    @FindBy(xpath = "//select[@aria-label='sort']")
    private WebElement sortBar;
    @FindBy(xpath = "//option[text()='CO₂ Rating (A - E)']")
    private WebElement co2Option;
    @FindBy(xpath = "//h5[normalize-space()='Safety Goggles']")
    private WebElement fifthitem;
    @FindBy(xpath = "//span[@aria-label='ngx-slider']")
    private WebElement sliderMin;
    @FindBy(xpath = "//span[@aria-label='ngx-slider-max']")
    private WebElement sliderMax;
    @FindBy(xpath = "//button[normalize-space()='Search']")
    private WebElement searchButton;
    @FindBy(xpath = "//h5[normalize-space()='Random Orbit Sander']")
    private WebElement sixthItem;
    @FindBy(css = "a[data-test='nav-cart']")
    private WebElement cartLink;
    @FindBy(xpath = "(//button[@type='button'][normalize-space()='Proceed to checkout'])[1]")
    private WebElement proceedButton;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginFieldUser;
    @FindBy(xpath = "(//input[@id='password'])[1]")
    private WebElement loginpasswordField;
    @FindBy(xpath = "//div[@aria-label='Product added to shopping cart.']")
    private WebElement addedToCartAlert;
    @FindBy(xpath = "//select[@id='payment-method']")
    private WebElement paymentSelector;
    @FindBy(css = "option[value=\"cash-on-delivery\"]")
    private WebElement cashOnDeliveryoption;
    @FindBy(css = "button[data-test=\"finish\"]")
    private WebElement confirmButton;
    @FindBy(css = "button[data-test=\"proceed-2\"]")
    private WebElement proceed2;
    @FindBy(css = "button[data-test=\"proceed-3\"]")
    private WebElement proceed3;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(cartLink));
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", cart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cart);
    }
    private void waitAndScroll(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    private void scroll(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", element);
    }

    public void navigateToRegisterAccount() {
        singInButton.click();
        waitAndScroll(registerAccountButton);
        registerAccountButton.click();
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Așteaptă să fie vizibil și clicabil
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        // Scroll la element
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", button);

        // Click prin JS (mai sigur decât click normal)
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    //slider
    public void setNgxSlider(WebDriver driver, WebElement sliderMin, WebElement sliderMax, int targetMin, int targetMax) {
        int minValue = Integer.parseInt(sliderMin.getAttribute("aria-valuemin"));
        int maxValue = Integer.parseInt(sliderMax.getAttribute("aria-valuemax"));

        int currentMin = Integer.parseInt(sliderMin.getAttribute("aria-valuenow"));
        int currentMax = Integer.parseInt(sliderMax.getAttribute("aria-valuenow"));

        // lățimea totală slider (aproximativ din left max - left min sau din bară)
        int sliderWidth = sliderMax.getSize().width;

        // calculează offset proporțional
        int offsetMin = (int) ((double) (targetMin - currentMin) / (maxValue - minValue) * sliderWidth);
        int offsetMax = (int) ((double) (targetMax - currentMax) / (maxValue - minValue) * sliderWidth);

        Actions actions = new Actions(driver);

        // mută mânerele
        actions.clickAndHold(sliderMin).moveByOffset(offsetMin, 0).release().perform();
        actions.clickAndHold(sliderMax).moveByOffset(offsetMax, 0).release().perform();

        // declanșează change event dacă e nevoie
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'))", sliderMin);
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change'))", sliderMax);
    }

    public void sleep() {
        try {
            Thread.sleep(1000); // 1000 ms = 1 secundă
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // păstrează starea de întrerupere
            e.printStackTrace();
        }
    }


    public void firstItem() {
        homeButton.click();
        sleep(); // pauză după click pe Home

        waitAndScroll(firstItem);
        sleep(); // pauză după scroll
        firstItem.click();
        sleep(); // pauză după click pe produs

        clickAddToCart();
        sleep(); // pauză după click pe Add to Cart

        homeButton.click();
        sleep(); // pauză după click pe Home
    }

    public void seconditem() {
       waitAndScroll(sanderFilter);
       sleep();
       sanderFilter.click();
       waitAndScroll(secondItem);
        secondItem.click();
        sleep();
        waitAndScroll(addToCartButton);
        addToCartButton.click();
        sleep();
        waitAndScroll(homeButton);
        homeButton.click();

    }

    public void thirdItem() {
        waitAndScroll(fourPage);
        sleep();
        fourPage.click();
        sleep();

        waitAndScroll(thirdItem);
        sleep();
        thirdItem.click();
        sleep();

        clickAddToCart();
        sleep();

        homeButton.click();
        sleep();
    }

    public void fourthItem() {
        waitAndScroll(searchBar);
        sleep();
        searchBar.click();
        sleep();
        searchBar.sendKeys("mini");
        sleep();

        searchButton.click();
        sleep();

        waitAndScroll(forthitem);
        sleep();
        forthitem.click();
        sleep();

        clickAddToCart();
        sleep();

        homeButton.click();
        sleep();
    }

    public void fifthItem() {
        waitAndScroll(sortBar);
        sleep();
        sortBar.click();
        sleep();

        waitAndScroll(co2Option);
        sleep();
        co2Option.click();
        sleep();

        waitAndScroll(fifthitem);
        sleep();
        fifthitem.click();
        sleep();

        clickAddToCart();
        sleep();

        homeButton.click();
        sleep();
    }

    public void sixItem() {
        setNgxSlider(driver, sliderMin, sliderMax, 1500, 2000);
        sleep();

        waitAndScroll(sixthItem);
        sleep();
        sixthItem.click();
        sleep();
        waitAndScroll(addToCartButton);
        sleep();
        addToCartButton.click();

    }

    public void completeOrder() {
        // Scroll și click pe cart
        clickCart();
        sleep(); // pauză după click

        // Scroll și click pe Proceed to checkout
        waitAndScroll(proceedButton);
        sleep(); // pauză după scroll
        proceedButton.click();
        sleep(); // pauză după click
        waitAndScroll(proceed2);
        sleep(); // pauză după scroll
        proceed2.click();
        sleep(); // pauză după click
        waitAndScroll(proceed3);
        sleep(); // pauză după scroll
        proceed3.click();
        sleep(); // pauză după click
        Select select = new Select(paymentSelector);
        select.selectByValue("cash-on-delivery");

// Forțează trigger-ul eventului change
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }))",
                paymentSelector
        );
        confirmButton.click();

    }

        public void test()
    {
        firstItem();


        seconditem();


        thirdItem();


        fourthItem();

        fifthItem();


        sixItem();


        completeOrder();

    }
}
