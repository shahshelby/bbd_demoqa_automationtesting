Feature: Saucedemo Shopping Page

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked


  Scenario Outline: Purchase Flow and Checkout
    Given the '<item>' is added to the cart
    And the 'Cart' button is clicked
    And the 'Checkout' button is clicked
    And the 'First Name' field is filled with '<firstName>'
    And the 'Last Name' field is filled with '<lastName>'
    And the 'Zip Code' field is filled with '<zipcode>'
    When the 'Continue' button is clicked
    And Wait for '1' seconds
    Then the price should read '<total price>'
    Examples:
      | item                              | firstName | lastName | zipcode | total price        |
      | Sauce Labs Backpack               | Logan     | Clark    | 233     | Total: $32.39      |
      | Test.allTheThings() T-Shirt (Red) | Jeff      | Trueman  | 714     | Total: $49.66      |
      | Sauce Labs Bolt T-Shirt           | Carlos    | Junes    | 223     | Total: $66.93      |
      | Sauce Labs Bike Light             | Walter    | White    | 377     | Total: $77.72      |
      | Sauce Labs Fleece Jacket          | Jesse     | Pinkman  | 8233    | Total: $131.71     |
      | Sauce Labs Onesie                 | Don       | Eladio   | 50      | Total: $140.34     |


  Scenario Outline: Verifying Number of Item After Removing Items From Cart
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


  Scenario Outline: Verifying Number of Item After Adding Items To Cart
    Given the '<item>' is added to the cart
    And Wait for '1' seconds
    Then the number of items on the cart should be '<number>'
    Examples:
      | item                                          | number |
      | Sauce Labs Bike Light                         | 2      |
      | Sauce Labs Onesie                             | 3      |
      | Sauce Labs Fleece Jacket                      | 4      |
      | Sauce Labs Backpack                           | 5      |
      | Test.allTheThings() T-Shirt (Red)             | 6      |


  Scenario Outline: Incorrect Checkout Information
    Given the 'Cart' button is clicked
    And the 'Checkout' button is clicked
    And the 'First Name' field is filled with '<firstName>'
    And the 'Last Name' field is filled with '<lastName>'
    And the 'Zip Code' field is filled with '<zipcode>'
    When the 'Continue' button is clicked
    And Wait for '1' seconds
    Then the '<errorMessage>' checkout message is shown
    Examples:
      | firstName | lastName | zipcode | errorMessage                   |
      |           |          |         | Error: First Name is required  |
      |           | Shah     | 553     | Error: First Name is required  |
      | Mike      |          | 441     | Error: Last Name is required   |
      | Sarah     | Keriann  |         | Error: Postal Code is required |
