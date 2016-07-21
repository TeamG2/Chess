package UI;

import java.util.Scanner;
import java.util.regex.Pattern;

import Game.Player.Colour;

import Game.*;
import Game.Desk;
import Game.Cell;
import Game.Figure.*;

public class ConsoleUI {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	
	private static ConsoleUI instance = null;
	
	public static ConsoleUI getInstance()
	{
		if (instance == null)
			instance = new ConsoleUI();
		return instance;
	}
	
	public Colour userColour()
	{

		System.out.println("Please, pick Colour of figures: White (W) or Black (B)");
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		if (s.equals("W")) return Colour.WHITE;
		else return Colour.BLACK;
	}

	public void representBoard(Desk desk)
	{ 
		char [] line={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		System.out.print("\t");
		for(int i=0;i<=7;i++){
			System.out.print("--");
		}
		System.out.println("-");
		for (int i = 7; i >= 0; i--){
			System.out.print((i + 1) + " \t");
				
			for(int j = 0; j <= 7; j++){
				Position pos = new Position(i, j);
				Figure fig = desk.getCell(pos).getFigure();
				System.out.print("|");
				char c= ' ';
				if (fig != null)
				{					
					c = fig.getName();
					if (fig.getColour() == Colour.WHITE)
						c = Character.toUpperCase(c);
				}
				if (c == ' ')
					System.out.print(".");
				else
					System.out.print(c);
				
			}
			
			System.out.println("|");
			System.out.print("\t");
			for(int k=0;k<=7;k++){
				System.out.print("--");
			}
			System.out.println("-");
		}	
		
		System.out.println();
		System.out.print("\t");
		for(int i=0;i<=7;i++){
			System.out.print(" " + line[i]);
		}
		System.out.println();
	}
	
	public void showBotThinkMessage()
	{
		System.out.println("Computer is thinking. Please, wait.");
	}
	
	public void showBotMove(Move move)
	{
		System.out.print("Computer made move: ");
		char fromRow = (char) ('1' + move.getFrom().getRow()) ;
		char fromColumn = (char) ('A' + move.getFrom().getColumn()) ;
		char toRow = (char) ('1' + move.getTo().getRow()) ;
		char toColumn = (char) ('A' + move.getTo().getColumn());
		System.out.print(fromColumn);
		System.out.println(fromRow + ":" + toColumn + toRow);
	}	
	
	public void showWrongMoveError()
	{
		System.out.println("You can't make this move. Please, try again");
	}
	
	public void colorOut(String text, String color)
	{
		System.out.println(color + text + ANSI_RESET);
	}

	
	public Move getMove(){
		System.out.println("Your turn. Please enter the course of type E2:E4.");

		Scanner in = new Scanner(System.in);
		String stringMove=in.nextLine();
		while (!Pattern.matches("^[A-H][1-8]:[A-H][1-8]$", stringMove)){
			System.out.println("Invalid input. Enter a string of the form E2:E1");
			stringMove=in.nextLine();
		}	
			
		int columnFrom = stringMove.charAt(0)-'A';
		int rowFrom = (stringMove.charAt(1)-'1');
		int columnTo = stringMove.charAt(3)-'A';
		int rowTo = (stringMove.charAt(4)-'1');			
		
		Move newMove=new Move(rowFrom, columnFrom, rowTo, columnTo);
		
		return newMove;
	}
}
