package UI;

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
	
	public static Colour userColour()
	{
		//todo: implement
		return null;
	}
	
	public static void representBoard()
	{
		//todo: implement
	}
}
