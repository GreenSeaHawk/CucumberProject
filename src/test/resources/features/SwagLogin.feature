@regression
Feature: Swag Login

  Scenario Outline: Successful Login
    Given I am on the login page
    When I enter a valid username "<username>"
    And I enter a valid password "<password>"
    And I click Login button
    Then I should be redirected to the products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Scenario: Locked Out Login
    Given I am on the login page
    When I enter a locked out username
    And I enter a locked out password
    And I click Login button
    Then I should have a locked out error message
