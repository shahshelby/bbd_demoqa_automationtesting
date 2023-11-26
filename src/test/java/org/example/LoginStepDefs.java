package org.example;

import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefs extends AbstractStepDefs {
    @Then("the {string} login message is shown")
    public void theErrorMessageMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getLoginErrorMessage());
    }
}
