package org.example;

import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefs extends AbstractStepDefs {

    @Then("the user is directed to {string}")
    public void theURLIsDirectedToPAGE_URL(String PAGE_URL) {
        assertEquals(PAGE_URL,homePage.getPageUrl());
    }

    @Then("the {string} login message is shown")
    public void theLoginErrorMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getLoginErrorMessage());
    }
}
