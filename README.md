# GameOfLife
Conway's Game Of Life in Java

Set-up to display Gosper's glider gun for 100 generations

1. If you want to adjust the settings, or begin the Game of Life with a different board set-up, adjust the following:

- In GameBoard:
  -- update the private variable int[][] board to represent the board the game should begin with.  A 1 represents a living organism, a 0 represents an empty cell

- In GameOfLife Viewer update:
  -- BOARD_SIZE: to match the input array "board" above
  -- MAX_STEPS: the number of game generations
  -- TIME_DELAY_IN_MILLISECONDS: determines how fast the game display changes

2.  If you want to adjust the game rules, they are located in the GameBoard class, the updateBoard() method, lines 140-152

