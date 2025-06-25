@smoke
Feature: Swag cart alternative users

  Scenario Outline: Add to cart with different logins
    Given I am on the login page
    When I enter a valid username "<username>"
    And I enter a valid password "<password>"
    And I click Login button
    And I click Add to cart
    Then the cart displays a 1
    And remove is displayed instead of Add to cart
    And item added to cart

    Examples:
      | username               | password     |
      | standard_user          | secret_sauce |
      | locked_out_user        | secret_sauce |
      | problem_user           | secret_sauce |
      | performance_glitch_user| secret_sauce |
      | error_user             | secret_sauce |
      | visual_user            | secret_sauce |
      | standard_user          | secret_sauce |

