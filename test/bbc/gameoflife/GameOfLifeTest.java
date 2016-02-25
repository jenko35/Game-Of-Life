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
	public void testBasicFunction()
	{
		inputString = ".....\n"
				+     ".***.\n"
				+     ".....\n";

		gameOfLife = new GameOfLife(inputString);
		gameOfLife.nextGo();
		String result = gameOfLife.printBoard().replaceAll(" ", "");	// Allow for spaced formatting
		desiredOutputString = "..*..\n"
					   +      "..*..\n"
					   +      "..*..\n";
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
					   +      ".***.\n"
					   +      ".***.\n"
		   			   +      ".....\n";
		assertEquals(result, desiredOutputString);
	}


}
