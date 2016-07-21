package Game.Figure;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;

import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Move;
import Game.Position;
import Game.Player.Colour;

public abstract class Figure implements Serializable {
	private Colour colour;
	private char nameFigure;

	
	public Figure(Colour colour)
	{
		this.colour = colour;
	}	
	
	public Colour getColour()
	{
		return colour;
	}
	
	public char getName(){
		return nameFigure;
	}
	
	public boolean isValidMove(Desk desk, Move move)
	{	
		//если для для цвета фигуры находящейся в позиции из шах
		//и если эта фигура не король
		//вернуть ноль
		
		if ( (GameController.getInstance().isShahFor(desk, desk.getCell(move.getFrom()).getFigure().getColour())))
				
		{	
			Desk thisGame = null;
			try {
				thisGame = desk.cloneDesk();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thisGame.moveFigure(move.getFrom(),move.getTo());
			if (GameController.getInstance().isShahFor(thisGame, thisGame.getCell(move.getTo()).getFigure().getColour())){
				return false;
			}
			
			
		}
		
		return getPossiblePositions(desk, move.getFrom()).contains(move.getTo());
	}
	
	public abstract HashSet<Position> getPossiblePositions(Desk desk, Position current);
	

	
 }
