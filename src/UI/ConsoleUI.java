package UI;

import java.util.Scanner;
import java.util.regex.Pattern;

import Game.Player.Colour;
import Game.*;

public class ConsoleUI {
	
	private static ConsoleUI instance = null;
	
	public static ConsoleUI getInstance()
	{
		if (instance == null)
			instance = new ConsoleUI();
		return instance;
	}
	
	public static Colour userColour()
	{
		//todo: implement
		return null;
	}
	
	public static void representBoard()
	{
		//todo: implement
	}
	public static Game.Move getMove(){
		System.out.println("Your turn. Please enter the course of type E2:E4.");
		Scanner in = new Scanner(System.in);
		String stringMove=in.nextLine();
		while (!Pattern.matches("^[A-H][0-7]:[A-H][0-7]$", stringMove)){
			System.out.println("Invalid input. Enter a string of the form E2:E1");
			stringMove=in.nextLine();
		}
		int x1,y1,x2,y2;
		
		
		x1=stringMove.charAt(1)-'A';
		y1=stringMove.charAt(2)-'0';
		x2=stringMove.charAt(3)-'A';
		y2=stringMove.charAt(4)-'0';		
	
		
		Move newMove=new Move(x1,y1,x2,y2);
		
		in.close();
		return newMove;
	}
}
