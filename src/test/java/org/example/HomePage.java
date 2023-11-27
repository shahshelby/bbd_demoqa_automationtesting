package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HomePage {
    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    private WebElement loginErrorMessage;
    @FindBy(css = "#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3")
    private WebElement checkoutErrorMessage;
    @FindBy(css = "#checkout_summary_container > div > div.summary_info > div.summary_info_label.summary_total_label")
    private WebElement totalPrice;
    @FindBy(css = "#shopping_cart_container > a > span")
    private WebElement numberOfItemsInCart;

    private static final Map<String, By> textFields = Map.of(
            "Username", By.id("user-name"),
            "Password", By.id("password"),
            "First Name", By.id("first-name"),
            "Last Name", By.id("last-name"),
            "Zip Code", By.id("postal-code")
    );

    private static final Map<String, By> ItemButtons = Map.of(
            "Sauce Labs Backpack", By.id("add-to-cart-sauce-labs-backpack"),
            "Sauce Labs Bike Light", By.id("add-to-cart-sauce-labs-bike-light"),
            "Sauce Labs Bolt T-Shirt", By.id("add-to-cart-sauce-labs-bolt-t-shirt"),
            "Sauce Labs Fleece Jacket", By.id("add-to-cart-sauce-labs-fleece-jacket"),
            "Sauce Labs Onesie", By.id("add-to-cart-sauce-labs-onesie"),
            "Test.allTheThings() T-Shirt (Red)", By.id("add-to-cart-test.allthethings()-t-shirt-(red)")
    );

    private static final Map<String, By> RemoveItem = Map.of(
            "Sauce Labs Bike Light Remove", By.id("remove-sauce-labs-bike-light"),
            "Sauce Labs Backpack Remove", By.id("remove-sauce-labs-backpack"),
            "Sauce Labs Bolt T-Shirt", By.id("remove-sauce-labs-bolt-t-shirt"),
            "Sauce Labs Fleece Jacket Remove", By.id("remove-sauce-labs-fleece-jacket"),
            "Sauce Labs Onesie Remove", By.id("remove-sauce-labs-onesie"),
            "Test.allTheThings() T-Shirt (Red) Remove", By.id("remove-test.allthethings()-t-shirt-(red)")
    );

    private static final Map<String, By> navigationButtons = Map.of(
            // Login Page
            "Login", By.id("login-button"),
            // Front Page
            "Cart", By.className("shopping_cart_link"),
            // Cart Page
            "Checkout", By.id("checkout"),
            // Checkout Information Page
            "Continue", By.id("continue"),

            // Dropdown Button
            "Dropdown", By.id("react-burger-menu-btn"),
            // Dropdown Menus
            "All Items", By.id("inventory_sidebar_link"),
            "About", By.id("about_sidebar_link"),
            "Logout", By.id("logout_sidebar_link"),
            "Reset App State", By.id("#reset_sidebar_link")
    );

    private static final Map<String, By> navigationLinks = Map.of(
            // Footer Area Social Links
            "Twitter", By.cssSelector("#page_wrapper > footer > ul > li.social_twitter > a"),
            "Facebook", By.cssSelector("#page_wrapper > footer > ul > li.social_facebook > a"),
            "Linkedin", By.cssSelector("#page_wrapper > footer > ul > li.social_linkedin > a")
    );

    private static final Map<String, By> sortingOptions = Map.of(
            "Name (A to Z)", By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(1)"),
            "Name (Z to A)", By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(2)"),
            "Price (low to high)", By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(3)"),
            "Price (high to low)", By.cssSelector("#header_container > div.header_secondary_container > div > span > select > option:nth-child(4)")
    );

    public void selectSortingOption(String option) {
        driver.findElement(sortingOptions.get(option)).click();
    }

    public List<Double> getAllItemPrices() {
        List<Double> itemPrices = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            WebElement itemPriceElement = driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(" + i + ") > div.inventory_item_description > div.pricebar > div"));
            String priceString = itemPriceElement.getText().replace("$", "");
            double price = parsePrice(priceString);
            itemPrices.add(price);
        }
        return itemPrices;
    }

    private double parsePrice(String priceString) {
        return Double.parseDouble(priceString.trim());
    }

    public List<String> getItemNames() {
        List<String> itemNames = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            WebElement itemElement = driver.findElement(By.cssSelector("#item_" + i + "_title_link > div"));
            itemNames.add(itemElement.getText());
        }
        return itemNames;
    }

    public void addItemToCart(String item) {
        driver.findElement(ItemButtons.get(item)).click();
    }

    public void removeItemFromCart(String item) {
        driver.findElement(RemoveItem.get(item)).click();
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    // Check new tab open for navigationLinks
    public boolean isNewTabOpened() {
        return driver.getWindowHandles().size() > 1;
    }

    public void closePage() {
        driver.quit();
    }

    public void fillOutField(String field, String text) {
        driver.findElement(textFields.get(field)).sendKeys(text);
    }

    public void clickButton(String button) {
        driver.findElement(navigationButtons.get(button)).click();
    }

    public void clickLink(String button) {
        driver.findElement(navigationLinks.get(button)).click();
    }


    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }
    public String getCheckoutErrorMessage() {
        return checkoutErrorMessage.getText();
    }
    public String getTotal() {
        return totalPrice.getText();
    }

    public String getNumOfItemInCart() {
        return numberOfItemsInCart.getText();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() { return driver.getTitle();
    }
}
