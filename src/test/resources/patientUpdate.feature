Feature: Patient is updated

  Scenario Outline: Patient is successfully updated
    Given I want to updated a patient
    When I updated a new patient with <name>, <lastname>, <email>, <phone>, <address>, <birthday>, <bloodType>, <diseases>, <height> and <weight>
    Then the system updated the <name>, <lastname>, <email>, <phone>, <address>, <birthday>, <bloodType>, <diseases>, <height> and <weight>

    Examples:
      | name      | lastname      | email            | phone       | address        | birthday   | bloodType | diseases | height | weight |
      | "new"     | "newlast"     | "new@gmail.com"  | "123456789" | "av. new 452"  | "03/04/98" | "B"       | "fiebre" | 1.72   | 70.0   |

