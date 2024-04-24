Feature: Doctor list is showed
  Scenario: Doctor list is successfully showed
    Given I want to see all the doctors registered
    When I look to the doctors list
    Then the system shows all the doctors in the database