package Game.Figure;
import Game.*;
import java.util.HashSet;
import com.sun.prism.paint.Color;
import Game.Player.Colour;

public class Pawn extends Figure {
	private char nameFigure='p';
	public Pawn(Colour colour) {
		super(colour);
	
	}

	public char getName(){
		return nameFigure;	
	}
	
	public boolean isNeedToPromote(Position position)
	{
		if ( getColour() == Colour.WHITE && position.getRow() == 7)
		{
			return true;
		}
		if ( getColour() == Colour.BLACK && position.getRow() == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public HashSet<Position> getPossiblePositions(Desk desk, Position current) {
		// TODO Auto-generated method stub
		HashSet<Position> setOfPosibleMoves= new HashSet <>();
		if ( getColour() == Colour.WHITE){
			int row = current.getRow(), column = current.getColumn();
			
			if (row == 0) System.out.print("Error! Pawn.getPossiblePositions()");
			
			if (row < 7 && desk.getCell(new Position(row + 1, column)).isFree())
			{
				setOfPosibleMoves.add(new Position(row + 1, column));
			}

			if (row == 1 && desk.getCell(new Position(3, column)).isFree()&& desk.getCell(new Position(2, column)).isFree())
			{
				setOfPosibleMoves.add(new Position(3, column));
			}
			
			if (column > 0){
				Cell newCell = desk.getCell(new Position(row + 1, column - 1));
				if  (!newCell.isFree() && newCell.getFigure().getColour() != this.getColour()){
					setOfPosibleMoves.add(new Position(row + 1, column - 1));
				}
			}
			
			if (column < 7){
				Cell newCell = desk.getCell(new Position(row + 1, column + 1));
				if  (!newCell.isFree() && newCell.getFigure().getColour() != this.getColour()){
					setOfPosibleMoves.add(new Position(row + 1, column + 1));
				}
			}
		}	
		
		if ( getColour() == Colour.BLACK){
			int row = current.getRow(), column = current.getColumn();
			
			if (row == 7) System.out.print("Error! Pawn.getPossiblePositions()");
			
			if (row > 0 && desk.getCell(new Position(row - 1, column)).isFree())
			{
				setOfPosibleMoves.add(new Position(row - 1, column));
			}

			if (row == 6 && desk.getCell(new Position(4, column)).isFree()&& desk.getCell(new Position(5, column)).isFree())
			{
				setOfPosibleMoves.add(new Position(4, column));
			}
			
			
			if (column > 0 && row>0){
				Cell newCell = desk.getCell(new Position(row - 1, column - 1));
				if  (!newCell.isFree() && newCell.getFigure().getColour() != this.getColour()){
					setOfPosibleMoves.add(new Position(row - 1, column - 1));
				}
			}
			
			if (column < 7 && row>0){
				Cell newCell = desk.getCell(new Position(row - 1, column + 1));
				if  (!newCell.isFree() && newCell.getFigure().getColour() != this.getColour()){
					setOfPosibleMoves.add(new Position(row - 1, column + 1));
				}
			}
		}
		return setOfPosibleMoves;
	}
}
