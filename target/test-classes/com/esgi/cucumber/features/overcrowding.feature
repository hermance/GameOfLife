Feature: Overcrowding

  Scenario: Management of overcrowding
    Given a grid of 3 by 3
    And a live cell at 0x0
    And a live cell at 0x1
    And an alive cell at 1x1
    And an alive cell at 1x0
    And a live cell at 0x2
    When we calculate the next generation of the grid for overcrowding
    Then the cell at 0x1 dies

