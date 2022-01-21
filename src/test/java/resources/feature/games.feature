Feature: Testing the functionality of Get Bingo Lobby Feed

  @SMOKE @REGRESSION
  Scenario: Verify that the 'non-null' game frequency has been set to 300,000
    When User sends a GET request to the Get Bingo Lobby Feed end point
    Then verifies that the non-null game frequency has been set to 300000

  @SANITY @REGRESSION
  Scenario: Verify that the start time for 'Streams' is a future time stamp
    When User sends a GET request to the Get Bingo Lobby Feed end point
    Then verifies that the start time for Streams is a future time stamp


