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
	public HashSet<Position> getPossiblePositions(Position current) {
		
		HashSet<Position> result = new HashSet<Position>();
		result.addAll(goUpLeft(current));
		result.addAll(goUpRight(current));
		result.addAll(goDownLeft(current));
		result.addAll(goDownRight(current));
		
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
	
	private HashSet<Position> goUpLeft(Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 0; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getX() - i, position.getY() - i);
			if (newPosition.getX() < 0 || newPosition.getY() < 0 ||
					newPosition.getX() >= Desk.FIELD_SIZE  || newPosition.getY() >= Desk.FIELD_SIZE )
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
	
	private HashSet<Position> goUpRight(Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 0; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getX() + i, position.getY() - i);
			if (newPosition.getX() < 0 || newPosition.getY() < 0 ||
					newPosition.getX() >= Desk.FIELD_SIZE  || newPosition.getY() >= Desk.FIELD_SIZE )
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
	
	private HashSet<Position> goDownLeft(Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 0; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getX() - i, position.getY() + i);
			if (newPosition.getX() < 0 || newPosition.getY() < 0 ||
					newPosition.getX() >= Desk.FIELD_SIZE  || newPosition.getY() >= Desk.FIELD_SIZE )
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
	
	private HashSet<Position> goDownRight(Position position)
	{
		HashSet<Position> result = new HashSet<Position>();
		
		for (int i = 0; i < Desk.FIELD_SIZE; i++)
		{
			Position newPosition = new Position(position.getX() + i, position.getY() + i);
			if (newPosition.getX() < 0 || newPosition.getY() < 0 ||
					newPosition.getX() >= Desk.FIELD_SIZE  || newPosition.getY() >= Desk.FIELD_SIZE )
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
