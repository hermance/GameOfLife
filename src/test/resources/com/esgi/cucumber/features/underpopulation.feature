Feature: Underpopulation

  Scenario: Management of underpopulation
    Given a grid of 5 by 5
    And a live cell at 1x1
    And a live cell at 1x2
    When we calculate the next generation of the grid
    Then both of the cells die of underpopulation

