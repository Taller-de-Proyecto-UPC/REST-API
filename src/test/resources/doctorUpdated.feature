Feature: Doctor is updated

  Scenario Outline: Doctor is successfully updated
    Given I want to updated a doctor
    When I updated a new doctor with <name>, <lastname>, <email>, <phone>, <address>, <birthday>, <specialty>, <username>, <password>, <role>, <active> and <cip>
    Then the system updated the doctor <name>, <lastname>, <email>, <phone>, <address>, <birthday>, <specialty> and <cip>

    Examples:
      | name       | lastname | email          | phone       | address           | birthday   | specialty    | username | password | role     | active | cip    |
      | "Jorge"    | "Chon"   | "jc@gmail.com" | "987153624" | "av. alcazar 125" | "03/04/98" | "Radiología" | "dasdas" | "654"    | "doctor" | "true" | "1234" |

