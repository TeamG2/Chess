package Game.Figure;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Move;
import Game.Position;
import Game.Player.Colour;

public class King extends Figure{
	private char nameFigure='K';
	public King(Colour colour) {
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
		// TODO Auto-generated method stub
		HashSet<Position> setOfPosibleMoves= new HashSet <>();
		Desk desk = GameController.getInstance().getDesk();
		int y = current.getRow(), x = current.getColumn();
		
		List<Position> set=new ArrayList<>();
		set.add(new Position(y+1,x-1));
		set.add(new Position(y+1,x));
		set.add(new Position(y+1,x+1));
		set.add(new Position(y,x-1));
		set.add(new Position(y,x+1));
		set.add(new Position(y-1,x-1));
		set.add(new Position(y-1,x));
		set.add(new Position(y-1,x+1));
		
		for (int i=0; i<set.size();i++){ 
			Position newPos=set.get(i);
			Cell newCell = desk.getCell(newPos);
			/* ƒоступные ходы дл€  орол€, это ходы вокруг него.
			 * 1) могут быть угловые позиции. Ќужно проверить существует ли эта клетка на поле.
			 * 2) нужно чтобы не было фигуры своего цвета
			 * 3) €чейка пуста€ или там находитс€ враг 	
			 
			 **/
			if (newPos.isExsist()
					&&(!(newCell.getFigure().getColour() == getColour()))
					&&(newCell.isFree() || newCell.getFigure().getColour() != getColour())
				)
				setOfPosibleMoves.add(newPos);	
		}
		return setOfPosibleMoves;
	}

}
