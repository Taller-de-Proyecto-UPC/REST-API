Feature: User is deactivated

  Scenario Outline: Deactivated successfully created
    Given I want to deactivate an user
    When I edit an existing user with <id>
    Then the system deactivate the user with <id>

    Examples:
      | id      |
      | 1       |