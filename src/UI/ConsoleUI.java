package UI;

import java.util.Scanner;
import java.util.regex.Pattern;

import Game.GameController;
import Game.Player.Colour;

public class ConsoleUI {
	
	private static ConsoleUI instance = null;
	
	public static ConsoleUI getInstance()
	{
		if (instance == null)
			instance = new ConsoleUI();
		return instance;
	}
	
	public Colour userColour()
	{
		//todo: implement
		return null;
	}
	
	public void representBoard()
	{
		//todo: implement
	}
	public Game.Move getMove(){
		Scanner in = new Scanner(System.in);
		String stringMove=in.nextLine();
		while (!Pattern.matches("[A-H][0-7]:[A-H][0-7]$", stringMove)){
			System.out.println("Invalid input. Enter a string of the form E2:E1");
		}
		//Game.Move newMove=new Game.Move(1,1,1,1);
		
		in.close();
		return null;
	}
}
