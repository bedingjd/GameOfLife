package lab20200416_GameOfLife2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class GameBoard extends JComponent{
	
	/*
	// 5x5 board
	private int[][] board = {{0,0,0,0,0},
							 {0,0,0,0,0},
							 {0,1,1,1,0},
							 {0,0,0,0,0},
							 {0,0,0,0,0}};
	
	*/
	
	// Gosper's glider gun						0					0					0
	private int[][] board = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0},
							 {0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,1,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
							 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	
	private Organism[][] myBoard = new Organism[GameOfLifeViewer.BOARD_SIZE][GameOfLifeViewer.BOARD_SIZE];
	
	public GameBoard() {
		// create a new board of Organism objects
		// for now we'll just use the array above as the source
		//   later we'll read these values in from a file
	
		// for each row
		for(int i = 0; i< GameOfLifeViewer.BOARD_SIZE; i++){
			// for each column
			for(int j = 0; j < GameOfLifeViewer.BOARD_SIZE; j++){
				myBoard[i][j] = new Organism(board[i][j]);
			}  // end for j
		} // end for i
			
		// inform each Organism of their neighbors
		for(int row = 0; row< GameOfLifeViewer.BOARD_SIZE; row++){
			// for each column
			for(int col = 0; col < GameOfLifeViewer.BOARD_SIZE; col++){
				for(int i_offset = -1; i_offset <= 1; i_offset++){
					for(int j_offset = -1; j_offset <= 1; j_offset++){
						int i = row + i_offset;
						int j = col + j_offset;
						if((i >=0) && (i < GameOfLifeViewer.BOARD_SIZE)
							&&
							(j >= 0) && (j < GameOfLifeViewer.BOARD_SIZE)){
							//myBoard[row][col].addNeighbor(myBoard[i][j], i_offset + 1, j_offset + 1);  // added +1 since array is zero indexed
							myBoard[row][col].addNeighbor(myBoard[i][j]);
						}
					} // end for j_offset
				} // end for i_offfset
			} // end for j
		} // end for i
			
	} // end Constructor
	
	
	public int countNeighbors(int row, int col){
		// count the number of neighbors who are alive
		// we want to loop through all these, if they exist
		// (row-1,col-1)	(row-1,col)		(row-1,col+1)
		// (row,col-1)		(row,col)		(row,col+1)
		// (row+1,col+1)	(row+1,col+1)	(row+1,col+1)
						
		int numNeighbors = 0;
		
		for(int i_offset = -1; i_offset <= 1; i_offset++){
			for(int j_offset = -1; j_offset <= 1; j_offset++){
				int i = row + i_offset;
				int j = col + j_offset;
				if((i >=0) && (i < GameOfLifeViewer.BOARD_SIZE)
					&&
					(j >= 0) && (j < GameOfLifeViewer.BOARD_SIZE)){
					if(this.myBoard[i][j].getPastAliveStatus()){
						numNeighbors = numNeighbors + 1;
					}
				}
			} // end for j
		} // end for i
		
		if(this.myBoard[row][col].getPastAliveStatus()) {
			numNeighbors = numNeighbors - 1;   // subtract the cell we're counting
		}
		
		return numNeighbors;
	} // end countNeighbors
	
	
	public void updateBoard(){
		// iterate over tempBoard mutating board as we go
		// for each row
		for(int i = 0; i< GameOfLifeViewer.BOARD_SIZE; i++){
			// for each column
			for(int j = 0; j < GameOfLifeViewer.BOARD_SIZE; j++){
				int numNeighbors = this.countNeighbors(i, j);
				// apply the rules
				// 1. old cells die if they have fewer than 2 neighbors
				//	2. Living cells die if they have more than 3 neighbors	
				if((this.myBoard[i][j].getPastAliveStatus()) && ((numNeighbors < 2) || (numNeighbors > 3))){
					this.myBoard[i][j].setDead();
				}
				// 3. Dead cells that have 3 neighbors come alive
				else if((!this.myBoard[i][j].getPastAliveStatus()) && (numNeighbors == 3)){
					this.myBoard[i][j].setAlive();
				}
				// 4. Otherwise there is no change #stayhome
				else {
				}
			}
		}
		return;
	} // end update board
	
	
	public void paintComponent(Graphics g) {  // aka printBoard
		//recast as Graphics 2D
		Graphics2D g2 = (Graphics2D)g;

		// print board
		for(int i = 0; i < GameOfLifeViewer.BOARD_SIZE; i++) {
			for(int j = 0; j < GameOfLifeViewer.BOARD_SIZE; j++) {
				// next line for testing
				//System.out.print(this.myBoard[i][j].getPastAliveStatus() + ":" + this.myBoard[i][j].getCurrentAliveStatus() + " | ");
				
				Rectangle r = new Rectangle(j*GameOfLifeViewer.BOX_SIZE,
											i*GameOfLifeViewer.BOX_SIZE,
											GameOfLifeViewer.BOX_SIZE,
											GameOfLifeViewer.BOX_SIZE);
				if(this.myBoard[i][j].getCurrentAliveStatus()) {
					g2.setColor(new Color(0,0,0));
					g2.fill(r);
				}else {
					g2.setColor(new Color(255,255,255));
					g2.fill(r);
				}
				g2.setColor(Color.DARK_GRAY);
				g2.draw(r);
				
				// since we're here, let's set the old status to the current status,
				// so we're ready for the next round
				this.myBoard[i][j].setPastAliveStatus(this.myBoard[i][j].getCurrentAliveStatus());
				
			}  // end for j
			System.out.println();
		} // end for i
		System.out.println();		
	} // end paintComponent
	
	
	/**
	 * Helper function to assist in testing
	 * prints the board to the command line
	 * Each Organism is represented as: lastStatus | currentStatus
	 */
	public void printBoard(){
		// for each row
		for(int i = 0; i< GameOfLifeViewer.BOARD_SIZE; i++){
			// for each column
			for(int j = 0; j < GameOfLifeViewer.BOARD_SIZE; j++){
				System.out.print(this.myBoard[i][j].getPastAliveStatus() + ":" + this.myBoard[i][j].getCurrentAliveStatus() + " | ");
			}
			System.out.println();
		}
		System.out.println();
		
	}

}
