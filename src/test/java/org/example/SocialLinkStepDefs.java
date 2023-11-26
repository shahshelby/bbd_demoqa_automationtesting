package org.example;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.example.AbstractStepDefs.homePage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SocialLinkStepDefs {

    @When("the {string} link is clicked")
    public void theLinkIsClicked(String button) {
        homePage.clickLink(button);
    }
    @Then("a new tab should be opened")
    public void checkNewTabOpened() {
        boolean isNewTabOpened = homePage.isNewTabOpened();
        assertTrue(isNewTabOpened, "A new tab should have been opened");
    }
}
