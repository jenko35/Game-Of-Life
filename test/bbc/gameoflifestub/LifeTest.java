package bbc.gameoflifestub;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
	
public class LifeTest {

	protected Set<Cell> setOfCells;
	protected Life life;
	
	@Before
	public void setUp(){
    	setOfCells = new HashSet<Cell>();
    	setOfCells.add(new Cell(1,1));
    	setOfCells.add(new Cell(2,2));
        life = new Life(setOfCells);
    }
	
	@Test
	public void testInitialisation()
	{
		assertEquals(2, life.getLiveCells().size());
	}

    @Test
    public void testUnderpopulation()
    {
        assertFalse(life.cellShouldSurvive(0));
        assertFalse(life.cellShouldSurvive(1));
    }

    @Test
    public void testSurvival()
    {
        assertTrue(life.cellShouldSurvive(2));
        assertTrue(life.cellShouldSurvive(3));
    }
    
    @Test
    public void testOvercrowding()
    {
        assertFalse(life.cellShouldSurvive(4));
        assertFalse(life.cellShouldSurvive(5));
    }

    @Test
    public void testIsAlive()
    {
    	assertTrue(life.isAlive(new Cell(2,2)));
    	assertFalse(life.isAlive(new Cell(2,5)));
  	
    }
    
    @Test
    public void testAddAliveCell()
    {
    	assertTrue(life.isAlive(new Cell(2,2)));
    	assertFalse(life.isAlive(new Cell(2,3)));
    	
    	life.addAliveCell(new Cell(2,3));
    	assertTrue(life.isAlive(new Cell(2,3)));
    	
    }

    @Test
    public void testRemoveDeadCell()
    {
    	assertTrue(life.isAlive(new Cell(1,1)));
    	life.removeDeadCell(new Cell(1,1));
    	assertFalse(life.isAlive(new Cell(1,1)));
    	
    }
}
