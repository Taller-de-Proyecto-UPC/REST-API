Feature: Image is created

  Scenario Outline: Image is successfully created
    Given I want to create a image
    When I create a new image with <path> and <added>
    Then the system create a new image <path>

    Examples:
      | path                               | added         |
      | "C:Users/user/Pictures/Prototipo3" | "rostro2.png" |

