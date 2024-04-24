Feature: Doctor details are showed by DNI
  Scenario: Doctor details are successfully showed by username
    Given I want to see the doctor registered with username "josmar"
    When I look for the doctor
    Then the system shows the doctor in the database