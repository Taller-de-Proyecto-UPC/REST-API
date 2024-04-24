Feature: Report details are showed by DNI
    Scenario Outline: Report details are successfully showed by DNI
        Given I want to see the report created by a <doctorId>
        When I look for the report
        Then the system shows the report in the database

        Examples:
        | doctorId |
        | 9        |