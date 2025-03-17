Feature: As a user I should be able to register

  @registration @smoke
  Scenario: As a user I should be able create an account
    Given user is on the registration page
    And user fills registration form
    And user clicks Register button
    Then user sees message "Your account was created successfully. You are now logged in."

