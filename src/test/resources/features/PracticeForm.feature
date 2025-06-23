@form @smoke
Feature: Practice Form

  Scenario Outline: Successful Form completion
    Given the user is on the practice form page
    And cookies are accepted
    When the user enters valid first name "<first name>"
    And the user enters valid last name "<last name>"
    And the user clicks on gender "<gender>" button
    And the user clicks on yrs of exp "<yrs of exp>" button
    And the user enters valid date "<date>"
    And the user clicks on profession "<professions>"
    And the user clicks on continent "<continent>" in continents dropdown
    And the user clicks on upload image and uploads "<file>"
    And the user clicks on submit button
    Then the practice form should be submitted successfully

    Examples:
      | first name | last name | gender | yrs of exp | date     | professions        | continent     | file                                                     |
      | Andrew     | Boyce     | Male   | 2          | 19/06/25 | Automation, Manual | Asia          | /Users/andrew.boyce/Documents/Screenshots/TestResult.png |
      | Ellie      | Bishop    | Female | 3          | 20/06/25 | Manual             | South America | /Users/andrew.boyce/Documents/Screenshots/TestResult.png |
#      |            |           |        |            |          |            |           |                |




