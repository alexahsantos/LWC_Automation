Feature: Create different types of shipments

As a Customer
I want to register an account with my email address

  Background:
    Given I am on Salesforce page

  Scenario Outline: Create an account
    When I enter valid credentials <username> and <password>
    Then I go to <component> page
    And I confirm Shipment Page
#    And I should see the successful message on the Confirmation page

    Examples:
      | username                                     |  | password               |  | component  |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |  | "Shipment" |