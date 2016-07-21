package Game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import Game.Evaluation.StandartEvaluator;
import Game.Evaluation.TableEvaluator;
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
	
	public Desk cloneDesk() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        //��������� ��������� ����� � ����� � ��������� ���(�����)
        ous.writeObject(getDesk());
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Desk cloneDesk = (Desk) ois.readObject();
        return cloneDesk;
	}
	
	public void startNewGame()
	{
		desk = new Desk();
		desk.setInitialState();
		players = new Player[2];
		
		Colour userColour = ConsoleUI.getInstance().userColour();
		if (userColour == Colour.WHITE)
		{
			players[0] = new User(Colour.WHITE);
			players[1] = new MiniMaxBot(Colour.BLACK, new TableEvaluator());
		}
		else
		{
			players[1] = new User(Colour.BLACK);
			players[0] = new MiniMaxBot(Colour.WHITE, new TableEvaluator());
		}			
		
		currentPlayer = 0;
		gameRunner();
	}
	
	public void gameRunner()
	{
		while (true)
		{
			if (players[currentPlayer] instanceof User)
				ConsoleUI.getInstance().representBoard(desk);
			while (!players[currentPlayer].makeMove())
			{
				ConsoleUI.getInstance().showWrongMoveError();
			}
			currentPlayer = currentPlayer ^ 1; // change player
		}
	}
	
	public Colour changeCol(Colour col) {
		if (col == Colour.WHITE) {
			return Colour.BLACK;
		}
		else return Colour.WHITE;
	} 

}
