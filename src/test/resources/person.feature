Feature: Person is created

  Scenario Outline: Person is successfully created
    Given I want to create a person
    When I create a new person with <name>, <lastname>, <email>, <phone>, <address>, <birthday>
    Then the system create a new person

    Examples:
      | name     | lastname | email         | phone       | address           | birthday   |
      | "josmar" | "vela"   | "j@gmail.com" | "939260169" | "los molinos 639" | "03/04/98" |





