package Game.Figure;

import java.util.HashSet;

import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Move;
import Game.Position;
import Game.Player.Colour;

public abstract class Figure {
	private Colour colour;
	private char nameFigure;
	private static Figure Buffer;

	
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
	
	public boolean isValidMove(Move move)
	{		
		return getPossiblePositions(move.getFrom()).contains(move.getTo());
	}
	
	public abstract HashSet<Position> getPossiblePositions(Position current);
	
	public boolean isFigureInSet(char nameFigure, Colour col, HashSet<Position> hash) {
		return false;
	}
	
	public boolean makeSystemMove(Position pos1, Position pos2) {
		Desk desk = GameController.getInstance().getDesk();
		Cell cell1 = desk.getCell(pos1);
		Cell cell2 = desk.getCell(pos2);
		Move move = new Move(pos1.getRow(), pos1.getColumn(), pos2.getRow(), pos2.getColumn());
		
		if (cell1.isFree()) return false;
		
		if (!this.isValidMove(move)) return false;
		
		if (!cell2.isFree()) {
			Buffer = cell2.getFigure();
			cell2.setFree();
		}
		cell1.setFree();
		cell2.setFigure(this);
		return true;
	}
	
	public static Figure getFromBuffer() {
		return Buffer;
	}
	
 }
