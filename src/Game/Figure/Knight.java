package Game.Figure;

import java.util.HashSet;

import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Move;
import Game.Position;
import Game.Player.Colour;

public class Knight extends Figure {
	private char nameFigure='N';
	 
	public Knight(Colour colour) {
		super(colour);
	}
	
	public char getName(){
		return nameFigure;	
	}

	@Override
	public HashSet<Position> getPossiblePositions(Desk desk, Position current) {		
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = -1; i <= 1; i += 2)
		{
			for (int j = -1; j <= 1; j += 2)
			{
				Position newPosition1 = new Position(current.getRow() + i*2, current.getColumn() + j*1);
				if (isValidPosition(desk, newPosition1))
				{
					result.add(newPosition1);
				}				
				
				Position newPosition2 = new Position(current.getRow() + i*1, current.getColumn() + j*2);
				if (isValidPosition(desk, newPosition2))
				{
					result.add(newPosition2);
				}
			}
		}		
		
		return result;
	} 
	
	private boolean isValidPosition(Desk desk, Position newPosition)
	{		
		if (newPosition.getRow() < 0 || newPosition.getColumn() < 0 ||
				newPosition.getRow() >= Desk.FIELD_SIZE  || newPosition.getColumn() >= Desk.FIELD_SIZE )
		{
			return false;
		}	
		
				
		Cell newCell = desk.getCell(newPosition);		
		if (newCell.isFree() || newCell.getFigure().getColour() != this.getColour())
		{
			return true;
		}		
		else
		{
			return false;
		}
	}
	
}
