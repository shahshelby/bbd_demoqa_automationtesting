Feature: Saucedemo Dropdown Menu

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

  Scenario Outline: Dropdown Menu Functionality
    Given the 'Dropdown' button is clicked
    And Wait for '1' seconds
    When the '<selection>' button is clicked
    Then the user is directed to '<PAGE_URL>'
    Examples:
      | selection   | PAGE_URL                                 |
      | All Items   | https://www.saucedemo.com/inventory.html |
      | About       | https://saucelabs.com/                   |
      | Logout      | https://www.saucedemo.com/               |



