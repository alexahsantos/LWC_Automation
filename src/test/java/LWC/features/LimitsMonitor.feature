Feature: Testing Limits Monitor

  As a Customer
  I want to test Limits Monitor Component

  Background:
    Given I am on Salesforce page

  Scenario Outline: Load Limits Monitor Page
    When I enter valid credentials <username> and <password>
    Then I go to "Limits Monitor" page
    And I check it the page Limits Monitor

    Examples:
      | username                                     |  | password               |  |  |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |  |  |

