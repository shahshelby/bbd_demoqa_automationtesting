package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class AutomationPracticeSteps {
    private WebDriver driver;
    private HomePage homePage;

    @Given("the home page is opened")
    public void theHomePageIsOpened() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://ultimateqa.com/automation");
    }

    @Then("the current page URL should contain {string}")
    public void theCurrentPageURLShouldContain(String expectedURLPart) {
        assertTrue(driver.getCurrentUrl().contains(expectedURLPart));
        driver.quit();
    }

    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        assertEquals(expectedTitle, homePage.getTitle());
        driver.quit();
    }
}
