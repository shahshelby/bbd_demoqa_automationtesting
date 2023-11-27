Feature: Saucedemo Social Media Links

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

  Scenario Outline: Verify Social Media Links Open in a New Tab
    When the '<social>' link is clicked
    And Wait for '1' seconds
    Then a new tab should be opened
    Examples:
      | social    |
      | Twitter   |
      | Facebook  |
      | Linkedin  |
