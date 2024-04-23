Feature: Report is updated

  Scenario Outline: Report is successfully updated
    Given I want to updated a report
    When I updated a report with <summary>, <description> and <comment>
    Then the system updated the <summary>, <description> and <comment>

    Examples:
      | summary     | description   | comment          |
      | "nuevo sum" | "nuevo des"   | "nuevo comment"  |
