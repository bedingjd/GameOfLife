# GameOfLife
Conway's Game Of Life in Java.
  For CS203. a port of the C code written in the Advanced Lab, in a slightly more Object Oriented approach

Set-up to display Gosper's glider gun for 100 generations

1. If you want to adjust the settings, or begin the Game of Life with a different board set-up, adjust the following:

  a. In GameBoard:
  
    (1) update the private variable int[][] board to represent the board the game should begin with.  A 1 represents a living organism, a 0 represents an empty cell

  b. In GameOfLife Viewer update:
  
      (1) BOARD_SIZE: to match the input array "board" above
      
      (2) MAX_STEPS: the number of game generations
      
      (3) TIME_DELAY_IN_MILLISECONDS: determines how fast the game display changes

2.  If you want to adjust the game rules, they are located in the GameBoard class, the updateBoard() method, lines 140-152

3.  There is a package name at the top of each file, and if you don't want to run / compile with packages, just comment out this line

