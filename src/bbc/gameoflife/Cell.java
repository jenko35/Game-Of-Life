package bbc.gameoflife;


/**
 * Representation of a cell within a game of life.
 */
public class Cell {
	/** X coordinate if the cell */
	private int x;
	/** Y coordinate if the cell */
	private int y;
	/** Number of live neighbours surround the cell */
	private int liveNeighbours = 0;

	/**
	 * Initialises the cell with its x and y coordinates.
	 * (0,0) indicates the upper left cell.
	 * @param x X coordinate if the cell.
	 * @param y Y coordinate if the cell.
	 */
	public Cell(int x, int y){
		this.x = x;
		this.y = y;		
	}

	/**
	 * This method is used to calculate a hash code for the cell.
	 * @return int This returns the calculated hash code.
	 */
	public int hashCode(){
		return 31 * 31 * x + 31 * y;
	}

	/**
	 * This method is used to check the equality between this cell and another.
	 * @param other The cell to check against this one for equality.
	 * @return boolean True if equal, false if not.
	 */
	public boolean equals(Object other){
		Cell otherCell = (Cell)other;
		return otherCell.x == x && otherCell.y == y; 
	}

	/**
	 * This method increases the number of neighbours by 1.
	 */
	public void addLiveNeighbour(){
		liveNeighbours++;
	}

	/**
	 * @return int Number of live neighbours.
	 */
	public int getLiveNeighbours() {
		return liveNeighbours;
	}

	/**
	 * @return int X coordinate of the cell.
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return int Y coordinate of the cell.
	 */
	public int getY() {
		return y;
	}


}
