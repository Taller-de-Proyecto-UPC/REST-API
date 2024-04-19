Feature: Admin user is created

  Scenario Outline: Admin is successfully created
    Given I want to access to the application
    When I create a new user admin with <username>, <password> and <role>
    Then the system create a new user <username>

    Examples:
      | username   | password     | role     |
      | "admin"     | "admin"     | "admin"  |
