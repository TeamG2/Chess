package Game.Figure;

import java.util.HashSet;

import Game.Desk;
import Game.Move;
import Game.Position;
import Game.Player.Colour;

public class Bishop extends Figure {

	private char nameFigure='B';
	public Bishop(Colour colour) {
		super(colour);
	}
	
	public char getName(){
		return nameFigure;	
	}

	@Override
	public boolean isValidMove(Move move) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	@Override
	public HashSet<Position> getPossiblePositions(Position current) {
		
		
		
		return null;
	} 	
	
	private HashSet<Position> goUpLeft(Position position)
	{
		for (int i = 0; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getX() - i, position.getY() - i);
			if (newPosition.getX() < 0 || newPosition.getY() < 0)
			{
				
			}
		}
	}

}
