Feature: Validate Pages title

  ## For the website saucedemo.com, the page title remains constant across all functionalities or aspects of the website.
  Background:
    Given the home page is opened

  Scenario: Verify title of the Login Page
    Then the page title should be "Swag Labs"

  Scenario: Verify title of the Front Page
    Given the 'Username' field is filled with '<username>'
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    When the 'Login' button is clicked
    Then the page title should be "Swag Labs"

  ## Redundant testing