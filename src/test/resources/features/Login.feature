@login
Feature:Login Feature

  Background:
    Given the user in on the login page

  Scenario: Login with valid credentials
    When the user enters the valid credentials
    Then user should be able to login
    And Account summary page should be displayed

  Scenario: Do not login with invalid credentials
    When the user enters wrong username or wrong password
    Then user should not be able to login
    And user should see "Login and/or password are wrong." error message

Scenario: Do not login with blank username and valid password
  When the user enters blank username and valid password
  Then user should not be able to login
  And user should see "Login and/or password are wrong." error message

  Scenario: Do not login with valid username and blank password
    When the user enters valid username and blank password
    Then user should not be able to login
    And user should see "Login and/or password are wrong." error message
