Feature: Doctor is created

  Scenario Outline: Doctor is successfully created
    Given I want to access to the application
    When I create a new user with <username>, <password> and <role>
    Then The system create a new user

    Examples:
      | username | password   | role     |
      | "user"   | "password" | "doctor" |