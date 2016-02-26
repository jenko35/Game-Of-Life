package bbc.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Designed to take user input to easily interact with the game of life implementation.
 */
public class GetInput {

	/** The default input used if no input is specified by the user */
	static String defautInput = ".*...\n"
						+   	"..**.\n"
						+       ".**..\n";

	/** Stores a current game of life */
	static GameOfLife gameOfLife;
	/** Used to read user input from the console */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Starting point for of the program.
	 */
	public static void main(String[] args) {

		startLife(getInputString());
	}

	/**
	 * Manages the user input from the console.
	 * @param input Initial string required to start the game of life.
	 */
	public static void startLife(String input){
		gameOfLife = new GameOfLife(input);

		gameOfLife.printBoard();
		while(true){
			int goNum = waitForInput();
			if(goNum > 0){
				for(int i=0; i< goNum; i++){
					gameOfLife.nextGo();
				}
				gameOfLife.printBoard();
			}
			else if(goNum == 0){
				break;
			}
		}
	}

	/**
	 * Reads the initial status of the game from the console.
	 * If no game has been input then it returns the demo game.
	 * @return String Initial string required to start the game of life.
	 */
	public static String getInputString(){
		String input = "";

		System.out.println("Enter Input String");
		try {
			String line;
			while(!(line = br.readLine()).equals("")){
				line = line.replaceAll(" ","");

				input = input + line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(input.equals("")){
			input = defautInput;
		}
		return input;
	}

	/**
	 * Reads input from the console to determine how many rounds should be played next time.
	 * If no input is given the the number is set to 1.
	 * @return int Number of rounds to play.
	 */
	public static int waitForInput(){
		String line = "";
		try {
			line = br.readLine();
			if(line.equals("")){
				return 1;
			}
			else if(line.equals("exit")){
				return 0;
			}
			else{
				try{
					int i = Integer.parseInt(line);
					return i;
				}catch(NumberFormatException nfe){
					System.err.println("Invalid Format!");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return -1;
	}

}
