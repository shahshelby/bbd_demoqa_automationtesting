Feature: Saucedemo Shopping Page

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked


  Scenario Outline: Purchase Flow with Checking out
    Given the '<item>' is added to the cart
    And the 'Cart' button is clicked
    And the 'Checkout' button is clicked
    And the 'First Name' field is filled with '<firstName>'
    And the 'Last Name' field is filled with '<lastName>'
    And the 'Zip Code' field is filled with '<zipcode>'
    When the 'Continue' button is clicked
    And Wait for '1' seconds
    Then the price should read '<total>'

    Examples:
      | item                              | firstName | lastName | zipcode | total         |
      | Sauce Labs Backpack               | Angel     | Dust     | 111     | Total: $32.39 |
      | Test.allTheThings() T-Shirt (Red) | Mickey    | Mouse    | 1010    | Total: $49.66 |
      | Sauce Labs Bolt T-Shirt           | Sponge    | Bob      | 4001    | Total: $66.93 |
      | Sauce Labs Bike Light             | Isaac     | Newton   | 3005    | Total: $77.72 |
      | Sauce Labs Fleece Jacket          | Ali       | Baba     | 803     | Total: $131.71|
      | Sauce Labs Onesie                 | Mohamed   | Mobi     | 1234    | Total: $140.34|

  Scenario Outline: Deleting Item In Cart
    Given the '<item>' is removed from the cart
    And Wait for '1' seconds
    Then the number of items on the cart should be '<number>'
    Examples:
      | item                                          | number |
      | Sauce Labs Bike Light Remove                  | 5      |
      | Sauce Labs Onesie Remove                      | 4      |
      | Sauce Labs Fleece Jacket Remove               | 3      |
      | Sauce Labs Backpack Remove                    | 2      |
      | Test.allTheThings() T-Shirt (Red) Remove      | 1      |


  Scenario Outline: Incorrect Checkout Information Given
    Given the '<item>' is added to the cart
    And the 'Cart' button is clicked
    And the 'Checkout' button is clicked
    And the 'First Name' field is filled with '<firstName>'
    And the 'Last Name' field is filled with '<lastName>'
    And the 'Zip Code' field is filled with '<zipcode>'
    When the 'Continue' button is clicked
    And Wait for '1' seconds
    Then the '<errorMessage>' checkout message is shown

    Examples:
      | item                              | firstName | lastName | zipcode | errorMessage                   |
      | Sauce Labs Onesie                 |           |          |         | Error: First Name is required  |
      | Sauce Labs Backpack               |           | Dust     | 111     | Error: First Name is required  |
      | Test.allTheThings() T-Shirt (Red) | Jeff      |          | 1010    | Error: Last Name is required   |
      | Sauce Labs Bike Light             | Sponge    | Bob      |         | Error: Postal Code is required |
