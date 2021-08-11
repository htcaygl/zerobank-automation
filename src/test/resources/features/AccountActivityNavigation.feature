Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given the user in logged in
    When the user clicks on "Savings" link on the Account Summary page
    Then the user should be able to see "Zero - Account Activity" title
    And dropdown default option should be "Savings"

  Scenario: Brokerage account redirect
    Given the user in logged in
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the user should be able to see "Zero - Account Activity" title
    And dropdown default option should be "Brokerage"

  Scenario: Checking account redirect
    Given the user in logged in
    When the user clicks on "Checking" link on the Account Summary page
    Then the user should be able to see "Zero - Account Activity" title
    And dropdown default option should be "Checking"


  Scenario: Credit Card account redirect
    Given the user in logged in
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the user should be able to see "Zero - Account Activity" title
    And dropdown default option should be "Credit Card"


  Scenario: Loan account redirect
    Given the user in logged in
    When the user clicks on "Loan" link on the Account Summary page
    Then the user should be able to see "Zero - Account Activity" title
    And dropdown default option should be "Loan"


    @wip
#    This does same as above. I use scenario outline here
  Scenario Outline:<accountType>  Account redirect

    Given the user in logged in
    When the user clicks on "<accountType>" link on the Account Summary page
    Then the user should be able to see "Zero - Account Activity" title
    And dropdown default option should be "<accountType>"


    Examples:
      | accountType |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |
