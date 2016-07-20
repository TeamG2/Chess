package Game.Figure;

import java.util.HashSet;

import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Move;
import Game.Position;
import Game.Player.Colour;

public class Rook extends Figure{
	
	private char nameFigure='R';
	public Rook(Colour colour) {
		super(colour);
	}
	public char getName(){
		return nameFigure;	
	}
	
	@Override
	public HashSet<Position> getPossiblePositions(Desk desk, Position current) {
		HashSet<Position> result = new HashSet<Position>();
	
		result.addAll(goUp(desk, current));
		result.addAll(goRight(desk, current));
		result.addAll(goDown(desk, current));
		result.addAll(goLeft(desk, current));
		
		return result;
	} 	
	
	// return false if need to stop loop
	private boolean addNewPosition(Desk desk, HashSet<Position> result, Position newPosition)
	{		
		Cell newCell = desk.getCell(newPosition);
		if (newCell.isFree())
		{
			result.add(newPosition);
			return true;
		}
		else if  (newCell.getFigure().getColour() != this.getColour())
		{
			result.add(newPosition);
			return false;
		}
		else
		{
			return false;
		}
	}
	
	private HashSet<Position> goUp(Desk desk, Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow() + i, position.getColumn());
			if (!newPosition.isExist())
			{
				return result;
			}	
			
			if (!addNewPosition(desk, result, newPosition))
			{
				return result;
			}
		}
		
		return result;
	}
	
	private HashSet<Position> goRight(Desk desk, Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow(), position.getColumn() + i);
			if (!newPosition.isExist() )
			{
				return result;
			}
			
			if (!addNewPosition(desk, result, newPosition))
			{
				return result;
			}
		}
		
		return result;
	}
	
	private HashSet<Position> goDown(Desk desk, Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow() - i, position.getColumn());
			if (!newPosition.isExist())
			{
				return result;
			}	
			
			if (!addNewPosition(desk, result, newPosition))
			{
				return result;
			}
		}
		
		return result;
	}
	
	private HashSet<Position> goLeft(Desk desk, Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow(), position.getColumn() - i);
			if (!newPosition.isExist() )
			{
				return result;
			}
			
			if (!addNewPosition(desk, result, newPosition))
			{
				return result;
			}
		}
		
		return result;
	}
}
