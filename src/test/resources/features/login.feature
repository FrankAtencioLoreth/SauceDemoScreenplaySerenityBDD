Feature: User Login
  As a registered user
  I want to log in to my account
  So that I can access to products

  @TCLG01
  Scenario: Successful Login
    Given the user is on the login page
    When the user enters a valid username and password
    And the user clicks the Login button
    Then the user should be redirected to the dashboard page
    And the products should be visible

  @TCLG02
  Scenario: Unsuccessful Login with Invalid Credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    And the user clicks the Login button
    Then an error message should be displayed saying Invalid username or password
    And the user should remain on the login page