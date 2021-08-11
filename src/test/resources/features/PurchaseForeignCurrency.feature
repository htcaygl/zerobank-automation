
Feature: Purchase Foreign Currency

  Background:
    Given the user in logged in
    And user on "Pay Bills" page
#    Given the user accesses the Purchase foreign currency cash tab. (I have one step which is below)
    And "Purchase Foreign Currency" tab

  Scenario: Available currencies
    Then following currencies should be available
      | Select One            |
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |

  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed


  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message should be displayed