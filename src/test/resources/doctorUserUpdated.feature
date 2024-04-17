Feature: Doctor user is updated

  Scenario Outline: Doctor is successfully updated
    Given I want to update a doctor user
    When I update a doctor user with <username> and <password>
    Then the system update the <username> and <password>

    Examples:
      | username      | password       |
      | "newUser"     | "newPassword"  |