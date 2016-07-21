package Game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

import Game.Evaluation.StandartEvaluator;
import Game.Evaluation.TableEvaluator;
import Game.Figure.Figure;
import Game.Figure.King;
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
	
	public boolean isShahFor(Desk desk, Colour colour) {
		for (int i=0; i <= desk.FIELD_SIZE-1; i++) {
			for (int j=0; j <=  desk.FIELD_SIZE-1; j++) {
				Figure fig = desk.getCell(i, j).getFigure();
					if ((fig!=null) && (fig.getColour() == colour.getOpposite())) {
						HashSet<Position> set = fig.getPossiblePositions(desk, new Position(i, j));
						if (isKingInSet(desk, colour, set)) {							
							return true;
						}
					}
			}	
		}
		return false;
	}
	
	public boolean isCheckMateFor(Desk desk, Colour colour) { 			//Мат - нет ни одного способа защитить короля от шаха
		for (int i=0; i <= desk.FIELD_SIZE-1; i++) {
			for (int j=0; j <=  desk.FIELD_SIZE-1; j++) {
				Figure fig = desk.getCell(i, j).getFigure();
				if (fig.getColour() == colour) { 			// Берем фигуру свого цвета
					HashSet<Position> set = fig.getPossiblePositions(desk, new Position(i, j));
					Position pos1 = new Position(i, j);
					for (Position pos2 : set) {
						fig.makeSystemMove(pos1, pos2); 	// Делаем виртуальный ход (возможно срубаем), чтобы проверить, можно ли защитить короля
						if (!GameController.getInstance().isShahFor(desk, colour)) { 			// Шах пропал - значит есть способ защитить короля. Мата нет.
							fig.makeSystemMove(pos2, pos1); // Возвращаем фигуру, которой "виртуально" ходили, на место
							if (Figure.getFromBuffer() != null) {
								desk.getCell(pos2.getRow(), pos2.getColumn()).setFigure(Figure.getFromBuffer()); // Возвращаем на доску возможно срубленную фигуру
							}
							return false;
						}
					}
				}
			}
		}
		return true;	
	}
	
	private boolean isKingInSet(Desk d, Colour col, HashSet<Position> set) {
		for (Position pos : set) {
			if (d.getCell(pos).getFigure() instanceof King) return true; 
		}
		return false;
	}
	
	public void gameRunner()
	{
		while (true)
		{
			if (isShahFor(desk, players[currentPlayer].getColour()))
			{
				ConsoleUI.getInstance().showShahMessage(players[currentPlayer].getColour());
			}
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
