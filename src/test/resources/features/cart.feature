Feature: Shopping Cart and Payments on SauceDemo

  Background:
    Given the user is on the login page
    When the user enters a valid username and password
      |username     |password    |
      |standard_user|secret_sauce|
    And the user clicks the Login button
    Then the user should be redirected to the dashboard page
    And the products should be visible
    When the user adds a product to the cart

  @TCCART001
  Scenario: Add a product to the cart
    When the user clicks on the cart icon
    Then the product should appear in the cart with the quantity icon updated
    When the user clicks on the cart icon
    Then the user should see the added products with their prices and quantities

  @TCCART002
  Scenario: Proceed to checkout
    When the user clicks on the cart icon
    When the user clicks the Checkout button
    Then the user is redirected to the checkout information page
    When the user enters their personal data
      |fisrtname|lastname|postalcode|
      |Frank    |Atencio |123456    |
    Then the user is redirected to the order summary page
    And the user clicks the finish button
    Then the user sees the order confirmation page with a success message