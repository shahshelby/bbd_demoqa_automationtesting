Feature: Sorting Items on Shopping Website

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

  Scenario: Sort items by Price Low to High
    When I sort items by "Price (low to high)"
    And I wait for '1' seconds
    Then the items should be sorted by "Price (low to high)" in ascending order

  Scenario: Sort items by Price from High to Low
    When I sort items by "Price (high to low)"
    And I wait for '1' seconds
    Then the items should be sorted by "Price (high to low)" in descending order

  Scenario: Sort items by Name from Z to A
    When I sort items by "Name (Z to A)"
    And I wait for '1' seconds
    Then the items should be sorted by "Name (Z to A)" in Z to A

  Scenario: Sort items by Name from A to Z
    When I sort items by "Name (A to Z)"
    And I wait for '1' seconds
    Then the items should be sorted by "Name (A to Z)" in A to Z