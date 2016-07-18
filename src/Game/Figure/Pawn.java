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
		Desk desk = GameController.getInstance().getDesk();
		if ( getColour() == Colour.WHITE){
			int x=current.getX(),y=current.getY();
			
			if (y==1)System.out.print("Error! Pawn.getPossiblePositions()");
			
			if (y<7) if (desk.getCell(new Position(x,y+1)).isFree()) setOfPosibleMoves.add(new Position(x,y+1));

			if (y==2)if (desk.getCell(new Position(x,4)).isFree()) setOfPosibleMoves.add(new Position(x,4));
			
			if (x>0){
			Cell newCell = desk.getCell(new Position(x-1,y+1));
				if  (newCell.getFigure().getColour() != getColour()){
					setOfPosibleMoves.add(new Position(x-1,y+1));
				}
			}
			
			if (x<7){
			Cell newCell = desk.getCell(new Position(x+1,y+1));
				if  (newCell.getFigure().getColour() != this.getColour()){
					setOfPosibleMoves.add(new Position(x+1,y+1));
				}
			}

		}	
		
		if ( getColour() == Colour.BLACK){
			int x=current.getX(),y=current.getY();
			
			if (y==7)System.out.print("Error! Pawn.getPossiblePositions()");
			
			if (y>0) if (desk.getCell(new Position(x,y-1)).isFree()) setOfPosibleMoves.add(new Position(x,y-1));

			if (y==6)if (desk.getCell(new Position(x,5)).isFree()) setOfPosibleMoves.add(new Position(x,5));
			
			if (x>0){
			Cell newCell = desk.getCell(new Position(x-1,y-1));
				if  (newCell.getFigure().getColour() != getColour()){
					setOfPosibleMoves.add(new Position(x-1,y-1));
				}
			}
			
			if (x<7){
			Cell newCell = desk.getCell(new Position(x+1,y-1));
				if  (newCell.getFigure().getColour() != this.getColour()){
					setOfPosibleMoves.add(new Position(x+1,y+1));
				}
			}
		}
		return setOfPosibleMoves;
	}
}
