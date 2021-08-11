@payBills
Feature: Pay Bills

  Background:
    Given the user in on the login page
    And the user enters the valid credentials
    When user on "Pay Bills" page

  Scenario: Pay Bills page should have the title Zero - Pay Bills
    Then the user should be able to see "Zero - Pay Bills" title

  Scenario: When users completes a successful Pay operation, "The payment was successfully submitted" should be displayed.
    And user completes successfully Pay operation
    Then user should see "The payment was successfully submitted." message


    #Pdf msg was different. "Please fill out this field"
  Scenario: When user doesn't enter amount or date field, user should see "Please fill out this field message"
    And user doesn't enter amount or date and click pay button
    Then user should see "Please fill in this field." warning message

  Scenario: Date field should not accept alphabetical characters.
    When user tries to send alphabetical characters to date field
    Then user should not be able to sendkeys to date field
