@summary
Feature: Account Summary Page

  Background:
    Given the user in on the login page
    And the user enters the valid credentials
    When user on "Account Summary" page

  Scenario: Account summary page should have title Zero-Account Summary.
    Then the user should be able to see "Zero - Account Summary" title

 Scenario: Account Types
   Then Account Summary page should have following account types
        |Cash Accounts       |
        |Investment Accounts |
        |Credit Accounts     |
        |Loan Accounts       |

  Scenario: Credit accounts table must have following columns
    Then "Credit Accounts" table must have following columns
      |Account     |
      |Credit Card |
      |Balance     |
