package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class HomePage {

    private static final String PAGE_URL = "https://demoqa.com/";

    private final WebDriver driver;

    @FindBy(css = "#name")
    private WebElement loginErrorMessage;


    private static final Map<String, By> textFields = Map.of(
            "UserName", By.id("userName"),
            "Password", By.id("password")
    );

    private static final Map<String, By> navigationButtons = Map.of(
            "Book Store Application", By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(6) > div"),
            "Login Site", By.cssSelector("#login"),
            "Logout", By.id("submit"),

            // login page
            "Login", By.cssSelector("#login")
            // expand sign out option

    );

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void closePage() {
        driver.quit();
    }

    public void fillOutField(String field, String text) {
        driver.findElement(textFields.get(field)).sendKeys(text);
    }

    public void clickButton(String button) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Adjust the timeout as needed
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(navigationButtons.get(button)));
        element.click();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

}
