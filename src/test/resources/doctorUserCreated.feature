Feature: Doctor user is created

  Scenario Outline: Doctor is successfully created
    Given I want to access to the application
    When I create a new user with <username>, <password> and <role>
    Then the system create a new user <username>

    Examples:
      | username   | password     | role     |
      | "user"     | "password"   | "doctor" |