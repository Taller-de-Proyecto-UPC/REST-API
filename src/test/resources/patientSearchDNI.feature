Feature: Patient details are showed by DNI
  Scenario: Patient details are successfully showed by DNI
    Given I want to see the patient registered with DNI "72903404"
    When I look for the patient
    Then the system shows the patient in the database