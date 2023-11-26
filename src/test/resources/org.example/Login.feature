Feature: Demoqa Book Store Application Login

  Background:
    Given the home page is opened

  Scenario Outline: Incorrect login attempts
    Given the 'Book Store Application' button is clicked
    Given the 'Login Site' button is clicked
    Given the 'UserName' field is filled with '<username>'
    And the 'Password' field is filled with '<password>'
    When the 'Login' button is clicked
    And I wait for '<duration>' seconds
    Then the '<errorMessage>' login message is shown
    Examples:
      | username                  | password              | errorMessage                      | duration |
      | jeffcarlos                | 12345_5Aq             | Invalid username or password!     | 2        |
      | Alonso_David02            | adde_112A             | Invalid username or password!     | 2        |
      | finebyme441               | 0000_a$49             | Invalid username or password!     | 2        |
      | Combo22                   | a                     | Invalid username or password!     | 2        |

  Scenario Outline: Correct login attempts
    Given the 'Book Store Application' button is clicked
    Given the 'Login Site' button is clicked
    Given the 'UserName' field is filled with '<username>'
    And the 'Password' field is filled with '<password>'
    When the 'Login' button is clicked
    And I wait for '<duration>' seconds
    Then the user is directed to '<PAGE_URL>'
    And the 'Logout' button is clicked
    Examples:
      | username                            |  password         | duration | PAGE_URL                 |
      | shah714                             |  Chaos0931353300& | 2        | https://demoqa.com/books |
      | Jeff2243                            |  Z8UG4FSMQsrJmF2$ | 2        | https://demoqa.com/books |
      | anony_mousey77                      |  qSD6VdlSzdVGV1p! | 2        | https://demoqa.com/books |
      | seeath001                           |  aQRxY2LsfyCloDZ@ | 2        | https://demoqa.com/books |


