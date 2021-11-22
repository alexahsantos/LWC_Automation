Feature: Create different types of shipments

As a Customer
I want to register an account with my email address

  Background:
    Given I am on Salesforce page

  Scenario Outline: Load Shipment Page
    When I enter valid credentials <username> and <password>
    Then I go to "Shipment" page
    And I change the list view
    Examples:
      | username                                     |  | password               |  |  |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |  |  |


 ############  USPS Provider  ############

  Scenario Outline: Create a USPS Shipment
    When I enter valid credentials <username> and <password>
    Then I go to "Shipment" page
    And I change the list view
    And I create a new "USPS" of shipment

    Examples:
      | username                                     |  | password               |  |  |  |  |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |  |  |  |  |


  Scenario Outline: Inspect a USPS Shipment Component
    When I enter valid credentials <username> and <password>
    Then I go to "Shipment" page
    And I change the list view
    And I inspect a "USPS" Shipment Component

    Examples:
      | username                                     |  | password               |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |

 ############  FedEx Provider  ############

  Scenario Outline: Create a FedEx Shipment
    When I enter valid credentials <username> and <password>
    Then I go to "Shipment" page
    And I change the list view
    And I create a new "FedEx" of shipment

    Examples:
      | username                                     |  | password               |  |  |  |  |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |  |  |  |  |


  Scenario Outline: Inspect a FedEx Shipment Component
    When I enter valid credentials <username> and <password>
    Then I go to "Shipment" page
    And I change the list view
    And I inspect a "FedEx" Shipment Component

    Examples:
      | username                                     |  | password               |
      | "alexandra.santos+lwcautomation2@oktana.com" |  | "testingautomation123" |
