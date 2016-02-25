package bbc.gameoflifestub;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class NeigboursTest {
	
	protected Neighbours neighbours;
	protected Set<Cell> setOfLiveCells;
	
	@Before
	public void setUp(){
		setOfLiveCells = new HashSet<Cell>();
		setOfLiveCells.add(new Cell(1,1));
		setOfLiveCells.add(new Cell(2,2));
    	neighbours = new Neighbours(setOfLiveCells);
	}

	@Test
	public void testInitialisation()
	{
		assertEquals(14, neighbours.getLiveNeighbourMap().size());
		int liveNeighbourCount = neighbours.getLiveNeighbourMap().get(new Cell(0,0));
		assertEquals(1, liveNeighbourCount);
		liveNeighbourCount = neighbours.getLiveNeighbourMap().get(new Cell(2,1));
		assertEquals(2, liveNeighbourCount);
	}

	@Test
	public void testAddLiveCell()
	{
		assertEquals(14, neighbours.getLiveNeighbourMap().size());
		assertNull(neighbours.getLiveNeighbourMap().get(new Cell(4,3)));
		neighbours.addLiveCell(new Cell(3,3));
		assertEquals(19, neighbours.getLiveNeighbourMap().size());
		int liveNeighbourCount = neighbours.getLiveNeighbourMap().get(new Cell(4,3));
		assertEquals(1, liveNeighbourCount);
	}

	@Test
	public void testRemoveDeadCell()
	{
		assertEquals(14, neighbours.getLiveNeighbourMap().size());
		int liveNeighbourCount = neighbours.getLiveNeighbourMap().get(new Cell(0,0));
		assertEquals(1, liveNeighbourCount);
		neighbours.removeDeadCell(new Cell(1,1));
		assertNull(neighbours.getLiveNeighbourMap().get(new Cell(0,0)));
		assertEquals(8, neighbours.getLiveNeighbourMap().size());
	}
		
}
