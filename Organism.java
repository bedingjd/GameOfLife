package GameOfLife;

import java.util.ArrayList;

public class Organism {
	
	private boolean isAlive = false;
	private boolean wasAlive = false;
	
	//private Organism[][] myNeighbors = new Organism[3][3];
	private ArrayList<Organism> myNeighbors2 = new ArrayList<Organism>();
	
	public Organism(int isAlive) {
		// set our initial state, and past state
		if(isAlive == 1) {
		 this.setAlive();
		 this.wasAlive = true;
		} else {
			this.setDead();
			this.wasAlive = false;
		}
		 
	}
	
	public void setAlive() {
		this.isAlive = true;
	}
	public void setDead() {
		this.isAlive = false;
	}
	public boolean getCurrentAliveStatus() {
		return this.isAlive;
	}
	public boolean getPastAliveStatus() {
		return this.wasAlive;
	}
	public void setPastAliveStatus(boolean status) {
		this.wasAlive = status;
	}
	
	/*
	 * Originally I had the Organism calculate the number of its neighbors
	 * who were alive.  Later I decided to move this behavior to the Game
	 * Left this code in, in case I decide to move it back later
	 * 
	public void addNeighbor(Organism o, int row, int col) {
		myNeighbors[row][col] = o;
	}
	public int countNeighbors() {
		int numberOfAliveNeighbors = 0;
		for(Organism[] orgRow : myNeighbors) {
			for(Organism o : orgRow) {
				if(o.getPastAliveStatus()) {
					numberOfAliveNeighbors++;
				}
			}
		}
		return numberOfAliveNeighbors;
	}
	*/
	
	public void addNeighbor(Organism o) {
		myNeighbors2.add(o);
	}
	
	/*
	 * Decided to move this logic to the game, since that seemed more logical
	public int countNeighbors() {
		int numberOfAliveNeighbors = 0;
		for(Organism o : myNeighbors2) {
			if(o.getPastAliveStatus()) {
				numberOfAliveNeighbors++;
			}
		}
		return numberOfAliveNeighbors;
	}
	*/
	
	public void updateMyStatus() {
		// Note: Do we want to move the Game rules all the way down to the Organism,
		// or is that something only the Game should know?
		// Decided that is something only the Game should know
	}


}
