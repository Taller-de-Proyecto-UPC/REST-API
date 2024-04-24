Feature: Create a medical report

  Scenario: Successful creation of a medical report
    Given a doctor with ID "9" and a patient with ID "11"
    When a POST request is sent to create a medical report
    Then an successful response with status code 200 is expected
    And the medical report is created correctly