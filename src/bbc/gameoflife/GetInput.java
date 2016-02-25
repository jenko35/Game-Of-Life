package bbc.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetInput {

	static String defautInput = ".*...\n"
						+   	"..**.\n"
						+       ".**..\n";

	static GameOfLife gameOfLife;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {

		startLife(getInputString());
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(input.equals("")){
			input = defautInput;
		}
		return input;
	}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return -1;
	}

}
