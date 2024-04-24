Feature: Doctor is created

  Scenario Outline: Doctor is successfully created
    Given I want to create a doctor
    When I create a new doctor with <name>, <lastname>, <email>, <phone>, <address>, <birthday>, <specialty>, <username>, <password>, <role>, <active> and <cip>
    Then the system create a new doctor <name>

    Examples:
      | name      | lastname | email          | phone       | address           | birthday   | specialty    | username | password | role     | active | cip    |
      | "Marco"   | "Huaman" | "mh@gmail.com" | "987452163" | "av. alcazar 125" | "03/04/98" | "Radiología" | "ls"     | "123"    | "doctor" | "true" | "1234" |

