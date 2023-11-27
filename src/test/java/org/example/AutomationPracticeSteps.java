package org.example;

import io.cucumber.java.en.Then;
import static org.example.AbstractStepDefs.homePage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutomationPracticeSteps {

    // Testing title of webpage
    @Then("the page title should be {string}")
    public void thePageTitleShouldBe(String expectedTitle) {
        assertEquals(expectedTitle, homePage.getTitle());
    }
}

