Feature: As a user I should be able to log in to have access to my bank accounts

  @login @smoke
  Scenario: User should be able to log in with valid credentials
    Given user is on the main page
    When user enters valid credentials
    Then user logs in successfully

  Scenario: User should not be able to log in with invalid credentials
    Given user is on the main page
    When user enters invalid credentials
    Then user sees message "The username and password could not be verified."

