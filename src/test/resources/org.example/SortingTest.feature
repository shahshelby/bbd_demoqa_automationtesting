Feature: Saucedemo Sorting Items on Shopping Page

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

  Scenario: Sort items by Price Low to High
    When Selecting sort items by "Price (low to high)"
    And Wait for '1' seconds
    Then the items should be sorted by ascending order

  Scenario: Sort items by Price from High to Low
    When Selecting sort items by "Price (high to low)"
    And Wait for '1' seconds
    Then the items should be sorted by descending order

  Scenario: Sort items by Name from Z to A
    When Selecting sort items by "Name (Z to A)"
    And Wait for '1' seconds
    Then the items should be sorted from Z to A

  Scenario: Sort items by Name from A to Z
    When Selecting sort items by "Name (A to Z)"
    And Wait for '1' seconds
    Then the items should be sorted from A to Z