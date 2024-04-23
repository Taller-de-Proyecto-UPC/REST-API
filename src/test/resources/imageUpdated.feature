Feature: Image is updated

  Scenario Outline: Image is successfully updated
    Given I want to updated a image
    When I updated a image with <path> and <added>
    Then the system updated the <path> and <added>

    Examples:
      | path                              | added      |
      | "C:/Users/user/Pictures/Melosita" | "Logo.png" |