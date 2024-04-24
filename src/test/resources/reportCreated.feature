Feature: Report is created

  Scenario Outline: Report is successfully created
    Given I doctor "9" want to create a report by patient "11"
    When I create a new report with <summary>, <description>, <comment>, <path> and <addded>
    Then the system create a new report <summary>

    Examples:
      | summary       | description       | comment       | path                              | addded     |
      | "new summary" | "new description" | "new comment" | "C:/Users/user/Pictures/Melosita" | "Logo.png" |


