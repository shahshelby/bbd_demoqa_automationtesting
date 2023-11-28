Feature: Saucedemo Social Media Links

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked


  Scenario: Verify Twitter Link Opens in a New Tab
    When the 'Twitter' link is clicked
    And Wait for '1' seconds
    Then a new tab should be opened


  Scenario: Verify Facebook Link Opens in a New Tab
    When the 'Facebook' link is clicked
    And Wait for '1' seconds
    Then a new tab should be opened


  Scenario: Verify LinkedIn Link Opens in a New Tab
    When the 'LinkedIn' link is clicked
    And Wait for '1' seconds
    Then a new tab should be opened

