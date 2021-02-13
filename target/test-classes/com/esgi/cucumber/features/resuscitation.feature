Feature: Resuscitation

  Scenario: Management of resuscitation
    Given a grid of 6 by 6
    And a live cell at 0x4
    And a live cell at 0x5
    And a live cell at 1x5
    When we calculate the next generation of the grid for resuscitation
    Then the cell at 1x4 resuscitates

