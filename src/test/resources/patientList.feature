Feature: Patient list is showed
  Scenario: Patient list is successfully showed
    Given I want to see all the patients registered
    When I look to the patient list
    Then the system shows all the patients in the database