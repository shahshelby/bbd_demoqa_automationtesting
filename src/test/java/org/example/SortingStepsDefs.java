package org.example;

import com.google.common.collect.Ordering;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SortingStepsDefs extends AbstractStepDefs {

    @When("Selecting sort items by {string}")
    public void sortItemsBy(String option) {
        homePage.selectSortingOption(option);
    }

    @Then("the items should be sorted by ascending order")
    public void verifyItemsSortedByAscendingOrder() {
        List<Double> itemPrices = homePage.getAllItemPrices();

        boolean isSorted = Ordering.natural().isOrdered(itemPrices);
        assertTrue(isSorted, "Items are sorted by price (low to high)");
    }

    @Then("the items should be sorted by descending order")
    public void verifyItemsSortedByDescendingOrder() {
        List<Double> itemPrices = homePage.getAllItemPrices();

        boolean isSorted = Ordering.natural().reverse().isOrdered(itemPrices);
        assertTrue(isSorted, "Items are sorted by price (high to low)");
    }

    @Then("the items should be sorted from Z to A")
    public void verifyItemsSortedByZtoA() {
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

    @Then("the items should be sorted from A to Z")
    public void verifyItemsSortedByAtoZ() {
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
