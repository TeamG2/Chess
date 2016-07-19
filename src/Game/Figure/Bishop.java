package Game.Figure;

import java.util.HashSet;

import Game.Cell;
import Game.Desk;
import Game.GameController;
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
	public HashSet<Position> getPossiblePositions(Desk desk, Position current) {
		
		HashSet<Position> result = new HashSet<Position>();
		result.addAll(goUpLeft(desk, current));
		result.addAll(goUpRight(desk, current));
		result.addAll(goDownLeft(desk, current));
		result.addAll(goDownRight(desk, current));
		
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
	
	private HashSet<Position> goUpLeft(Desk desk, Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow() + i, position.getColumn() - i);
			if (newPosition.getRow() < 0 || newPosition.getColumn() < 0 ||
					newPosition.getRow() >= Desk.FIELD_SIZE  || newPosition.getColumn() >= Desk.FIELD_SIZE )
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
	
	private HashSet<Position> goUpRight(Desk desk, Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow() + i, position.getColumn() + i);
			if (newPosition.getRow() < 0 || newPosition.getColumn() < 0 ||
					newPosition.getRow() >= Desk.FIELD_SIZE  || newPosition.getColumn() >= Desk.FIELD_SIZE )
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
	
	private HashSet<Position> goDownRight(Desk desk, Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow() - i, position.getColumn() + i);
			if (newPosition.getRow() < 0 || newPosition.getColumn() < 0 ||
					newPosition.getRow() >= Desk.FIELD_SIZE  || newPosition.getColumn() >= Desk.FIELD_SIZE )
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
	
	private HashSet<Position> goDownLeft(Desk desk, Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow() - i, position.getColumn() - i);
			if (newPosition.getRow() < 0 || newPosition.getColumn() < 0 ||
					newPosition.getRow() >= Desk.FIELD_SIZE  || newPosition.getColumn() >= Desk.FIELD_SIZE )
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
