Feature: Saucedemo Login Page

  Background:
    Given the home page is opened

  Scenario Outline: Incorrect login attempts
    Given the 'Username' field is filled with '<username>'
    And the 'Password' field is filled with '<password>'
    When the 'Login' button is clicked
    Then the '<errorMessage>' login message is shown
    Examples:
      | username        | password       | errorMessage                                                              |
      |                 |                | Epic sadface: Username is required                                        |
      | standard_user   |                | Epic sadface: Password is required                                        |
      | standard_user   | wrong_password | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |


  Scenario Outline: Correct login attempts
    Given the 'Username' field is filled with '<username>'
    And the 'Password' field is filled with '<password>'
    When the 'Login' button is clicked
    Then the user is directed to '<PAGE_URL>'
    Examples:
      | username                 | password      | PAGE_URL                                                 |
      | standard_user            |  secret_sauce | https://www.saucedemo.com/inventory.html                 |
      | problem_user             |  secret_sauce | https://www.saucedemo.com/inventory.html                 |
      | performance_glitch_user  |  secret_sauce | https://www.saucedemo.com/inventory.html                 |
      | error_user               |  secret_sauce | https://www.saucedemo.com/inventory.html                 |
      | visual_user              |  secret_sauce | https://www.saucedemo.com/inventory.html                 |




