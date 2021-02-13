Feature: Surviving

  Scenario: Management of surviving
    Given a grid of 4 by 4
    And a live cell at 3x2
    And a live cell at 1x3
    And a live cell at 2x3
    And a live cell at 3x3
    When we calculate the next generation of the grid for surviving
    Then the cells at 3x2, 2x3 and 3x3 survive

