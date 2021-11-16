Feature: Create different types of shipments

As a Customer
I want to register an account with my email address

  Background:
    Given I am on Salesforce page

  Scenario Outline: Load Shipment Page
    When I enter valid credentials <username> and <password>
    Then I go to <component> page
    And I confirm Shipment Page
    Examples:
      | username                                     |  | password               |  | component  |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |  | "Shipment" |


  Scenario Outline: Create a USPS Shipment
    When I enter valid credentials <username> and <password>
    Then I go to "Shipment" page
    And I confirm Shipment Page
    And I create a new "USPS" of shipment

    Examples:
      | username                                     |  | password               |  |  |  |  |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |  |  |  |  |


  Scenario Outline: Create a FedEx Shipment
    When I enter valid credentials <username> and <password>
    Then I go to "Shipment" page
    And I confirm Shipment Page
    And I create a new "FedEx" of shipment

    Examples:
      | username                                     |  | password               |  |  |  |  |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |  |  |  |  |