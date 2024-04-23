Feature: Person list is showed
  Scenario: Person list is successfully showed
    Given I want to see all the persons registered
    When I look to the person list
    Then the system shows all the persons in the database