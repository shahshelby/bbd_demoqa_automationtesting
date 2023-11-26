package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingStepDefs extends AbstractStepDefs {
    @Given("the {string} is added to the cart")
    public void somethingIsAddedToTheCart(String item) {
        homePage.addItemToCart(item);
    }

    @Given("the {string} is removed from the cart")
    public void itemIsRemovedFromTheCart(String item) {
        homePage.removeItemFromCart(item);
    }

    @Then("the price should read {string}")
    public void thePriceShouldRead(String total) {
        assertEquals(total, homePage.getTotal());
    }

    @Then("the {string} checkout message is shown")
    public void theErrorMessageCheckoutMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getCheckoutErrorMessage());
    }

    @Then("the number of items on the cart should be {string}")
    public void theNumberOfItemsShouldBe(String num) {
        assertEquals(num, homePage.getNumOfItemInCart());
    }

}

