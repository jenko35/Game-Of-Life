package bbc.gameoflife;

import java.util.HashSet;
import java.util.Set;

/**
 * Controls the main game functions.
 */
public class GameOfLife {

	/** Holds current Life class containing all the live cells */
	private Life life;
	/** Holds current Neighbours class containing all the important cells */
	private Neighbours neighbours;
	/** Current lowest X coordinate of cells */
	private int minX =0;
	/** Current lowest Y coordinate of cells */
	private int minY =0;
	/** Current highest X coordinate of cells */
	private int maxX =0;
	/** Current highest Y coordinate of cells */
	private int maxY =0;
	/** Number of iterations the game has currently played */
	private int goCount = 0;

	/**
	 * Initialises the game by picking out the initial live cells in the game.
	 * @param input String containing the initial state of the game.
	 */
	public GameOfLife(String input){

		String lines[] = input.split("\n");
		//String lines[] = input.split("\\r?\\n");

		Set<Cell> initialLiveCells = new HashSet<Cell>();

		for(int i=0; i < lines.length; i++){
			for(int j=0; j < lines[i].length(); j++){
				if(lines[i].charAt(j) == '*'){
					initialLiveCells.add(new Cell(j, i));
				}
			}
		}
		life = new Life(initialLiveCells);
		neighbours = new Neighbours(initialLiveCells);
		maxX = lines[0].length() - 1;
		maxY = lines.length - 1;
	}

	/**
	 * Moves the state of the game on by one round.
	 * Iterates through the important cells applying the game rules. All the cells that transition from being alive to dead
	 * are added to a set, and all the cells that transition from being dead to alive are added to another set.
	 * The Neighbour and Life classes are then updated to reflect the sets created.
	 */
	public void nextGo(){
		Set<Cell> neighbourCells = neighbours.getLiveNeighbourMap().keySet();
		Set<Cell> aliveToDead = new HashSet<Cell>();
		Set<Cell> deadToAlive = new HashSet<Cell>();
		for (Cell cell : neighbourCells) {
			if(life.isAlive(cell)){
				if(life.cellShouldSurvive(neighbours.getLiveNeighbourMap().get(cell))){
				}
				else{
					aliveToDead.add(cell);
				}
			}
			else{
				if(neighbours.getLiveNeighbourMap().get(cell) == 3){
					deadToAlive.add(cell);
				}
			}
		}

		for (Cell cell : aliveToDead) {
			neighbours.removeDeadCell(cell);
			life.removeDeadCell(cell);
		}

		for (Cell cell : deadToAlive) {
			neighbours.addLiveCell(cell);
			life.addAliveCell(cell);
			checkBounds(cell);
		}
		goCount++;
	}

	/**
	 * Converts the set of live cells into a human readable string.
	 * The current game status is unordered in a set of live cells. A 2d array is created large enough to 
	 * contain the highest and lowest coordinates for every live cell. Because the live cells can have negative
	 * coordinates we have to offset all their locations in the array so non are below [0][0] within the array.
	 * The final game string is then built by going through the array adding "*" for live cells and "." for dead
	 * cells. At the end of each row a new line character is added to the result.
	 * @return String The game board in a human readable format.
	 */
	public String printBoard(){
		int width = maxX - minX + 1;
		int height = maxY - minY + 1;
		int offsetX = minX * -1;
		int offsetY = minY * -1;
		boolean table[][] = new boolean[width][height];
		String result = "";


		for (Cell cell : life.getLiveCells()) {
			table[cell.getX() + offsetX][cell.getY() + offsetY] = true;
		}


		for(int j=0; j < table[0].length; j++){
			for(int i=0; i < table.length; i++){
				if(table[i][j]){
					result = result + " *";
					//result = result + "*";
				}
				else{
					result = result + " .";
					//result = result + ".";
				}
			}
			result = result + "\n";
		}
		System.out.println("Round: " + goCount);
		System.out.println(result);
		return result;
	}

	/**
	 * Checks to see if a cell will fit in the current board dimensions.
	 * If not then the board dimensions are increased to accommodate the cell.
	 * @param cell Cell to check.
	 */
	public void checkBounds(Cell cell){
		if(cell.getX() < minX){
			minX = cell.getX();
		}
		else if(cell.getX() > maxX){
			maxX = cell.getX();
		}

		if(cell.getY() < minY){
			minY = cell.getY();
		}
		else if(cell.getY() > maxY){
			maxY = cell.getY();
		}
	}

}
