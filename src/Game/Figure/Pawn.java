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

	@Override
	public HashSet<Position> getPossiblePositions(Position current) {
		// TODO Auto-generated method stub
		HashSet<Position> setOfPosibleMoves= new HashSet <>();
		if ( getColour() == Colour.WHITE){
			int row = current.getRow(), column = current.getColumn();
			
			if (row == 0) System.out.print("Error! Pawn.getPossiblePositions()");
			
			if (row < 7)
			{
				setOfPosibleMoves.add(new Position(row + 1, column));
			}

			if (row == 1)
			{
				setOfPosibleMoves.add(new Position(3, column));
			}
			
			Desk desk = GameController.getInstance().getDesk();
			
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
			
			if (row > 0)
			{
				setOfPosibleMoves.add(new Position(row - 1, column));
			}

			if (row == 6)
			{
				setOfPosibleMoves.add(new Position(4, column));
			}
			
			Desk desk = GameController.getInstance().getDesk();
			
			if (column > 0){
				Cell newCell = desk.getCell(new Position(row - 1, column - 1));
				if  (!newCell.isFree() && newCell.getFigure().getColour() != this.getColour()){
					setOfPosibleMoves.add(new Position(row + 1, column - 1));
				}
			}
			
			if (column < 7){
				Cell newCell = desk.getCell(new Position(row - 1, column + 1));
				if  (!newCell.isFree() && newCell.getFigure().getColour() != this.getColour()){
					setOfPosibleMoves.add(new Position(row + 1, column + 1));
				}
			}
		}
		return setOfPosibleMoves;
	}
}
