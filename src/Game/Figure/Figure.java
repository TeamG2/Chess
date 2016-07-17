package Game.Figure;

import java.util.HashSet;

import Game.Move;
import Game.Position;
import Game.Player.Colour;

public abstract class Figure {
	
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
	
	public abstract boolean isValidMove(Move move);
	
	public abstract HashSet<Position> getPossiblePositions(Position current);
}
