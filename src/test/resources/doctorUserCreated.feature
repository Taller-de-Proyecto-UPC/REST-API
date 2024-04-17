Feature: Doctor user is created

  Scenario Outline: Doctor is successfully created
    Given I want to access to the application
    When I create a new user with <username>, <password> and <role>
    Then the system create a new user <username>

    Examples:
      | username   | password     | role     |
      | "user"     | "password"   | "doctor" |

Feature: Doctor user is updated

  Scenario Outline: Doctor is successfully updated
    Given I want to update a doctor user
    When I update a doctor user with <username> and <password>
    Then the system update the <username> and <password>

    Examples:
      | username   | password    |
      | "newUser"     | "newPassword"  |