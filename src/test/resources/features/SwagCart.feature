@smoke
Feature: Swag cart

  Background: Logged in with standard_user
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click Login button
    Then I should be redirected to the products page

  Scenario: Add product to cart
    When I click Add to cart
    Then the cart displays a 1
    And remove is displayed instead of Add to cart
    And item added to cart