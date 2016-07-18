package Game;

import Game.Player.*;
import UI.ConsoleUI;

public class GameController {
	
	private Desk desk;
	
	private Player[] players;
	
	
	
	private int currentPlayer;
	
	private static GameController instance = null;
	
	private GameController()
	{
		desk = new Desk();
	}
	
	public static GameController getInstance()
	{
		if (instance == null)
			instance = new GameController();
		return instance;
	}
	
	public Desk getDesk()
	{
		return desk;
	}
	
	public void startNewGame()
	{
		desk = new Desk();
		desk.setInitialState();
		players = new Player[2];
		
		Colour userColour = ConsoleUI.getInstance().userColour();
		if (userColour == Colour.WHITE)
		{
			players[0] = new User();
			players[1] = new Bot();
		}
		else
		{
			players[1] = new User();
			players[0] = new Bot();
		}			
		
		currentPlayer = 0;
		gameRunner();
	}
	
	public void gameRunner()
	{
		while (true)
		{
			if (players[currentPlayer] instanceof User)
				ConsoleUI.getInstance().representBoard();
			players[currentPlayer].makeMove();
			currentPlayer = currentPlayer ^ 1; // change player
		}
	}
	
	
}
