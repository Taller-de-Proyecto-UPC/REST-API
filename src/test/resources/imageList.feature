Feature: Image list is showed
  Scenario: Image list is successfully showed
    Given I want to see all the images registered
    When I look to the image list
    Then the system shows all the images in the database