package org.example;

import com.google.common.collect.Ordering;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortingSteps extends AbstractStepDefs {

    @When("I sort items by {string}")
    public void sortItemsBy(String option) {
        homePage.selectSortingOption(option);
    }

    @Then("the items should be sorted by {string} in ascending order")
    public void verifyItemsSortedByAscendingOrder(String option) {
        List<Double> itemPrices = homePage.getAllItemPrices();

        boolean isSorted = Ordering.natural().isOrdered(itemPrices);
        assertTrue(isSorted, "Items are sorted by price (low to high)");
    }

    @Then("the items should be sorted by {string} in descending order")
    public void verifyItemsSortedByDescendingOrder(String option) {
        List<Double> itemPrices = homePage.getAllItemPrices();

        boolean isSorted = Ordering.natural().reverse().isOrdered(itemPrices);
        assertTrue(isSorted, "Items are sorted by price (high to low)");
    }

    @Then("the items should be sorted by {string} in Z to A")
    public void verifyItemsSortedByZtoA(String option) {
        List<String> itemNames = homePage.getItemNames();

        // Compare adjacent items to ensure Z to A sorting
        boolean isSorted = true;
        for (int i = 0; i < itemNames.size() - 1; i++) {
            String currentItem = itemNames.get(i);
            String nextItem = itemNames.get(i + 1);
            if (currentItem.compareTo(nextItem) < 0) {
                isSorted = false;
                break;
            }
        }
        assertFalse(isSorted, "Items are sorted by name (Z to A)");
    }

    @Then("the items should be sorted by {string} in A to Z")
    public void verifyItemsSortedByAtoZ(String option) {
        List<String> itemNames = homePage.getItemNames();

        // Compare adjacent items to ensure A to Z sorting
        boolean isSorted = true;
        for (int i = 0; i < itemNames.size() - 1; i++) {
            String currentItem = itemNames.get(i);
            String nextItem = itemNames.get(i + 1);
            if (currentItem.compareTo(nextItem) > 0) {
                isSorted = false;
                break;
            }
        }
        assertFalse(isSorted, "Items are sorted by name (A to Z)");
    }
}
