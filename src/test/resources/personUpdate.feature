Feature: Person is updated

  Scenario Outline:
    Given I want to update a person
    When I update a person with <name>, <lastname>, <email>, <phone>, <address> and <birthday>
    Then the system update the <name>, <lastname>, <email>, <phone>, <address> and <birthday>

    Examples:
      | name      | lastname        | email           | phone       | address           | birthday   |
      | "newName" | "newLastName"   | "new@gmail.com" | "987654322"  | "av. alcazar"     | "13/01/00" |