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
			int x=current.getX(),y=current.getY();
			
			if (y==1)System.out.print("Error! Pawn.getPossiblePositions()");
			
			if (y<7)setOfPosibleMoves.add(new Position(x,y+1));

			if (y==2)setOfPosibleMoves.add(new Position(x,4));
			
			Desk desk = GameController.getInstance().getDesk();
			
			if (x>0){
			Cell newCell = desk.getCell(new Position(x-1,y+1));
				if  (newCell.getFigure().getColour() != this.getColour()){
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
		return setOfPosibleMoves;
	}
}
