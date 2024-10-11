Feature: FanCode Users Todo Completion

  Scenario: Verify FanCode users have more than 50% of their todos completed
    Given I have the list of all users
    When I filter users from FanCode city
    Then each FanCode user should have more than 50% of their todos completed