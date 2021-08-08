@activity
Feature: Account Activity

  Background:
    Given the user in on the login page
    And the user enters the valid credentials
    When user on "Account Activity" page

  Scenario: Account Activity page should have title Zero-Account Activity.
    Then the user should be able to see "Zero - Account Activity" title

  Scenario: Account dropdown default option should be Savings.
    Then dropdown default option should be "Savings"


    #this scenario failed
  Scenario: Account dropdown should have following options.
    Then dropdown should have following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transaction table should have column names Date, Description,Deposit,Withdrawal.
    Then  Transaction table should have following column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
