package bbc.gameoflife;

import java.util.Set;

/**
 * Representation of the live cells within a game of life.
 * This class contains methods to manage the live cells.
 */
public class Life {

	/** A set containing all the current live cells */
	private Set<Cell> liveCells;

	/**
	 * Initialises with the live cells at the beginning of the game.
	 * @param initialLiveCells Set of live cells.
	 */
	public Life(Set<Cell> initialLiveCells)
    {
		this.liveCells = initialLiveCells;
	}
	
	
	/**
	 * @return Set<Cell> Set of current live cells.
	 */
    public Set<Cell> getLiveCells()
    {
        return this.liveCells;
    }

	/**
	 * Decides if a cell should survive or not based on the number of live neighbours.
	 * @param numNeighbours Number of live neighbours.
	 * @return boolean True if cell should survive, false if not.
	 */
    public boolean cellShouldSurvive(int numNeighbours)
    {
    	if(numNeighbours == 2 || numNeighbours == 3 ){
    		return true;
    	}
    	return false;
    }
    
    /**
	 * Adds a cell to the liveCells set.
	 * @param cell Cell to add.
	 */
    public void addAliveCell(Cell cell){
    	liveCells.add(cell);
    }

    /**
	 * Removes a cell from the liveCells set.
	 * @param cell Cell to remove.
	 */
    public void removeDeadCell(Cell cell){
    	liveCells.remove(cell);
    }
    

    /**
	 * Checks if a cell is in the liveCells set or not.
	 * @param cell Cell to check.
	 * @return boolean True if cell is alive, false if not.
	 */
    public boolean isAlive(Cell cell){
    	if(liveCells.contains(cell)){
    		return true;
    	}
    	return false;
    }
    
}
