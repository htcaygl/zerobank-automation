Feature: Purchase Foreign Currency

  @wip
  Scenario: Available currencies
    Given the user in logged in
    And user on "Pay Bills" page
#    Given the user accesses the Purchase foreign currency cash tab. (I have one step which is below)
    And "Purchase Foreign Currency" tab
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
