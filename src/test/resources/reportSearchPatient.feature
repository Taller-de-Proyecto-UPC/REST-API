Feature: Report details are showed by DNI
  Scenario Outline: Report details are successfully showed by DNI
    Given I want to see the patient created by a <patientId>
    When I look for the report of patient
    Then the system shows the reports of the patient in the database

    Examples:
      | patientId |
      | 11        |