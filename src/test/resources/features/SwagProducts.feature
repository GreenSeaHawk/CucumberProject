@regression
Feature: Swag Products

  Background: Logged in with standard_user
    Given I am on the login page
    When I enter a valid username
    And I enter a valid password
    And I click Login button
    Then I should be redirected to the products page

  Scenario: Sort by price low to high
    When I select Price low to high
    Then the products should be sorted from lowest to highest

  Scenario: Sort by price high to low
    When I select Price high to low
    Then the products should be sorted from highest to lowest