Feature: Patient is created

  Scenario Outline: Patient is successfully created
    Given I want to create a patient
    When I create a new patient with <name>, <lastname>, <email>, <phone>, <address>, <birthday>, <dni>, <bloodType>, <diseases>, <height> and <weight>
    Then the system create a new patient <dni>

    Examples:
      | name         | lastname      | email            | phone       | address           | birthday   | dni        | bloodType | diseases | height | weight |
      | "Math123"    | "MP"          | "Theo@gmail.com" | "986532741" | "av. alcazar 452" | "03/04/98" | "98748478" | "B"       | "fiebre" | 1.72   | 70.0   |

