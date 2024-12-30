@REGRESSION
Feature: User Login
  As a registered user
  I want to log in to my account
  So that I can access to products

  Background:
    Given the user is on the login page

  @TCLG001
  Scenario Outline: Successful Login
    When the user enters a valid username and password
      |<username>|<password>|
    And the user clicks the Login button
    Then the user should be redirected to the dashboard page
    And the products should be visible
    Examples:
      |username     |password    |
      |standard_user|secret_sauce|

  @TCLG002
  Scenario Outline: Unsuccessful Login with Invalid Credentials
    When the user enters an invalid username or password
      |<username>|<password>|
    And the user clicks the Login button
    Then an error message should be displayed saying Invalid username or password
    And the user should remain on the login page
    Examples:
      |username     |password     |
      |standard_user|secret_sauce1|