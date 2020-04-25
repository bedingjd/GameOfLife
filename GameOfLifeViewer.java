package lab20200416_GameOfLife2;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;


public class GameOfLifeViewer {

	public static final int BOX_SIZE = 20;
	public static final int BOARD_SIZE = 40;   // set to 40 for Gosper's Glider Gun
	public static final int frameWidth = (BOX_SIZE * BOARD_SIZE) + (2 * BOX_SIZE);
	public static final int frameHeight = (BOX_SIZE * BOARD_SIZE) + (4 * BOX_SIZE);
	public static final int MAX_COLOR_VALUE = 256;
	
	public static final int MAX_STEPS = 100;   // set to 100+ for Gosper's Glider Gun
	
	private static final int TIME_DELAY_IN_MILLISECONDS = 50;  // set to 100 for Gosper's Glider Gun
	
	

  
	public static void main(String[] args) {
		
		// set up the JFrame
		JFrame frame = new JFrame();
		frame.setSize(frameWidth,frameHeight);
		frame.setTitle("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// add component to JFrame
		GameBoard gb = new GameBoard();
		frame.add(gb);	
		
		frame.setVisible(true);
		

		// loop through each Game iteration until MAX_STEPS is reached
		for(int k = 0; k < GameOfLifeViewer.MAX_STEPS; k++) {
			System.out.println("Step Number: "+ k);
			//System.out.println("---old board: ");    // for testing
			gb.printBoard();  // for testing
			
			//System.out.println("---new board: ");    // for testing
			gb.repaint();
			gb.updateBoard();
			
			try {
				TimeUnit.MILLISECONDS.sleep(TIME_DELAY_IN_MILLISECONDS);
			} catch (InterruptedException ie) {
				System.out.println(ie);
			}
		}

	}

}
