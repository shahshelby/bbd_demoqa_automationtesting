Feature: Validate Automation Practice page

  Background:
    Given the home page is opened

  Scenario: Verify the URL of the Automation Practice page
    Then the current page URL should contain "https://ultimateqa.com/automation"

  Scenario: Verify title of the Automation Practice page
    Then the page title should be "Automation Practice - Ultimate QA"
