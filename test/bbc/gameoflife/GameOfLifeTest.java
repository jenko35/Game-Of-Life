package bbc.gameoflife;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bbc.gameoflife.GameOfLife;

public class GameOfLifeTest {

	protected GameOfLife gameOfLife;
	protected String inputString;
	protected String desiredOutputString;


	@Test
	public void testInitialisation()
	{
		inputString = ".....\n"
				+     ".***.\n"
				+     ".....\n";

		gameOfLife = new GameOfLife(inputString);
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString =  	 ".....\n"
						+   	 ".***.\n"
						+        ".....\n";
		assertEquals(result, desiredOutputString);
	}

	@Test
	public void testCreationOfLife()	// When a dead cell has exactly three neighbours
	{
		inputString = ".....\n"
				+     ".***.\n"
				+     ".....\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = "..*..\n"
					+         "..*..\n"
					+         "..*..\n";
		assertEquals(result, desiredOutputString);
	}
	
	@Test
	public void testNoLive()	//When the initial state consists of all dead cells
	{
		inputString = ".....\n"
				+     ".....\n"
				+     ".....\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = ".....\n"
					+         ".....\n"
					+         ".....\n";
		assertEquals(result, desiredOutputString);
	}
	
	@Test
	public void testUnderpopulation()	// When a live cell has fewer than two neighbours
	{
		inputString = ".....\n"
				+     "..**.\n"
				+     ".....\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = ".....\n"
					+         ".....\n"
					+         ".....\n";
		assertEquals(result, desiredOutputString);
	}
	
	@Test
	public void testOvercrowding()	// When a live cell has more than three neighbours
	{
		inputString = ".*.*.\n"
				+     "..*..\n"
				+     ".*.*.\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = "..*..\n"
					+         ".*.*.\n"
					+         "..*..\n";
		assertEquals(result, desiredOutputString);
	}

	@Test
	public void testSurvival()	// When a live cell has two or three neighbours
	{
		inputString = ".....\n"
				+     "..**.\n"
				+     "..*..\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = ".....\n"
					+         "..**.\n"
					+         "..**.\n";
		assertEquals(result, desiredOutputString);
	}
	

	@Test
	public void testLoneCell()	// Live cell has no neighbours so should die
	{
		inputString = ".....\n"
				+     "..*..\n"
				+     ".....\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = ".....\n"
					+         ".....\n"
					+         ".....\n";
		assertEquals(result, desiredOutputString);
	}

	@Test
	public void testGridGrow()
	{
		inputString = ".....\n"
				+     ".....\n"
				+     "*****\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = ".....\n"
				+      ".***.\n"
				+      ".***.\n"
				+      ".***.\n";
		assertEquals(result, desiredOutputString);
	}

	@Test
	public void testNegativeGridGrow()
	{
		inputString = "*****\n"
				+     ".....\n"
				+     ".....\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = ".***.\n"
					+         ".***.\n"
					+         ".***.\n"
					+         ".....\n";
		assertEquals(result, desiredOutputString);
	}


}
