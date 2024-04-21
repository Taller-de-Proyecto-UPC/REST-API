Feature: Report is created

  Scenario Outline: Report is successfully created
    Given I want to create a report
    When I create a new report with <summary>, <description> and <comment>
    Then the system create a new report <summary>

    Examples:
      | summary       | description       | comment       |
      | "new summary" | "new description" | "new comment" |