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
	public HashSet<Position> getPossiblePositions(Position current) {
		HashSet<Position> result = new HashSet<Position>();
	
		result.addAll(goUp(current));
		result.addAll(goRight(current));
		result.addAll(goDown(current));
		result.addAll(goLeft(current));
		
		return result;
	} 	
	
	// return false if need to stop loop
	private boolean addNewPosition(HashSet<Position> result, Position newPosition)
	{
		Desk desk = GameController.getInstance().getDesk();
		
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
	
	private HashSet<Position> goUp(Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow() + i, position.getColumn());
			if (newPosition.isExist())
			{
				return result;
			}	
			
			if (!addNewPosition(result, newPosition))
			{
				return result;
			}
		}
		
		return result;
	}
	
	private HashSet<Position> goRight(Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow(), position.getColumn() + i);
			if (newPosition.isExist() )
			{
				return result;
			}
			
			if (!addNewPosition(result, newPosition))
			{
				return result;
			}
		}
		
		return result;
	}
	
	private HashSet<Position> goDown(Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow() - i, position.getColumn());
			if (newPosition.isExist())
			{
				return result;
			}	
			
			if (!addNewPosition(result, newPosition))
			{
				return result;
			}
		}
		
		return result;
	}
	
	private HashSet<Position> goLeft(Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 1; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getRow(), position.getColumn() - i);
			if (newPosition.isExist() )
			{
				return result;
			}
			
			if (!addNewPosition(result, newPosition))
			{
				return result;
			}
		}
		
		return result;
	}
}
