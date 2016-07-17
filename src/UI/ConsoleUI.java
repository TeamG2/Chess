package UI;

import java.util.Scanner;
import java.util.regex.Pattern;

import Game.Player.Colour;

import Game.*;
import Game.Desk;
import Game.Cell;
import Game.Figure.*;

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

		System.out.println("Please, pick Colour of figures: White (W) or Black (B)");
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		
		
		if (s == "W") return Colour.WHITE;
		else return Colour.BLACK;
	}

	public void representBoard()
	{ 
		Desk desk = GameController.getInstance().getDesk();
		char [] line={'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
		for (int i=0;i<=7;i++){
			System.out.print(line[i]+" \t");
				
			for(int j=0;j<=7;j++){
				Position pos = new Position(i, j);
				Figure fig =desk.getCell(pos).getFigure();
				char c= ' ';
				if (fig != null)
					c = fig.getName();
				if (c==' ')
					System.out.print(".");
				else
					System.out.print(c);
				
			}
			System.out.println();
		}	
		
		System.out.print("\t");
		for(int i=1;i<=8;i++){
			System.out.print(i);
		}
		System.out.println();
	}

	
	public Move getMove(){
		System.out.println("Your turn. Please enter the course of type E2:E4.");

		Scanner in = new Scanner(System.in);
		String stringMove=in.nextLine();
		while (!Pattern.matches("^[A-H][0-7]:[A-H][0-7]$", stringMove)){
			System.out.println("Invalid input. Enter a string of the form E2:E1");
			stringMove=in.nextLine();
		}
		int x1,y1,x2,y2;
		
		
		x1=stringMove.charAt(0)-'A';
		y1=stringMove.charAt(1)-'1';
		x2=stringMove.charAt(3)-'A';
		y2=stringMove.charAt(4)-'1';		
	
		
		Move newMove=new Move(x1,y1,x2,y2);
		
		return newMove;
	}
}
