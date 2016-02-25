package bbc.gameoflife;

import java.util.HashMap;
import java.util.Set;

/**
 * Representation of all the current important cells in a game of life.
 * Only cells that currently have live neighbours are important to the game.
 */
public class Neighbours {

	/** A HashMap that contains all the current important cells along with the number of live neighbours they have */
	static HashMap<Cell, Integer> liveNeighbourMap;

	/**
	 * Initialises the liveNeighbourMap using the current live cells to work out important neighbours.
	 * @param liveCells Set of live cells.
	 */
	public Neighbours(Set<Cell> liveCells){
		liveNeighbourMap = new HashMap<Cell, Integer>();

		for (Cell cell : liveCells) {
			addLiveCell(cell);
		}
	}

	/**
	 * Adds neighbours surrounding a live cell to the liveNeighbourMap.
	 * Cycles through the neighbouring 8 cells, each one is checked against the liveNeighbourMap, if
	 * it exists then its current value is incremented indicating that it has another live neighbour.
	 * If it doesn't exist then it is added to the liveNeighbourMap with a value of 1.
	 * @param cell Live cell to have its neighbours updated.
	 */
	public void addLiveCell(Cell cell){
		for(int i=-1; i < 2; i++){
			for(int j=-1; j < 2; j++){
				if(!(i==0 && j==0)){														//Ignore self
					Cell tempCell = new Cell((cell.getX() + j), (cell.getY() + i));
					Integer numOccurrence = liveNeighbourMap.get(tempCell);

					if(numOccurrence == null){
						//first count
						liveNeighbourMap.put(tempCell, 1);

					} else{
						liveNeighbourMap.put(tempCell, numOccurrence + 1);

					}
				}
			}
		}
	}

	/**
	 * Removes neighbours surrounding a cell that has died from the liveNeighbourMap.
	 * Cycles through the neighbouring 8 cells, each one is checked against the liveNeighbourMap, if
	 * it exists then its current value is decremented indicating that it has lost a live neighbour.
	 * Once a cell has no neighbours, it is removed from the liveNeighbourMap.
	 * @param cell Newly dead cell to have its neighbours updated.
	 */
	public void removeDeadCell(Cell cell){
		for(int i=-1; i < 2; i++){
			for(int j=-1; j < 2; j++){
				if(!(i==0 && j==0)){														//Ignore self
					Cell tempCell = new Cell((cell.getX() + j), (cell.getY() + i));
					Integer numOccurrence = liveNeighbourMap.get(tempCell);
					if(numOccurrence == null){
						System.out.println("Occurrence error");
					} 
					else if(numOccurrence == 1){
						liveNeighbourMap.remove(tempCell);
					}
					else{
						liveNeighbourMap.put(tempCell, numOccurrence - 1);
					}
				}
			}
		}
	}


	/**
	 * @return HashMap<Cell, Integer> The current liveNeighbourMap.
	 */
	public HashMap<Cell, Integer> getLiveNeighbourMap() {
		return liveNeighbourMap;
	}

}


