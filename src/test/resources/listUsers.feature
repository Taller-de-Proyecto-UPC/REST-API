Feature: User list is showed

  Scenario: User list is successfully showed
    Given I want to see all the users registered
    When I look to the user list
    Then the system shows all the users in the database