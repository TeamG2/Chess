package Game.Figure;

import Game.Player.Colour;

public class Pawn extends Figure {
	private char nameFigure='p';
	public Pawn(Colour colour) {
		super(colour);
	
	}

	public char getName(){
		return nameFigure;	
	}
}
