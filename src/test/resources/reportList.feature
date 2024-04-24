Feature: Report list is showed
  Scenario: Report list is successfully showed
    Given I want to see all the reports created
    When I look to the report list
    Then the system shows all the reports in the database