package Game.Figure;

import java.util.HashSet;

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
		return null;
	}

}
