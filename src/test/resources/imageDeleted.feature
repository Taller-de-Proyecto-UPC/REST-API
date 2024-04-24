Feature: Image is deleted

  Scenario Outline: Image is successfully deleted
    Given I want to deleted a image
    When I deleted a image with <id>
    Then the system deleted the image

    Examples:
      | id |
      | 9  |