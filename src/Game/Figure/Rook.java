package Game.Figure;

import Game.Player.Colour;

public class Rook extends Figure{
	
	private char nameFigure='R';
	public Rook(Colour colour) {
		super(colour);
	}
	public char getName(){
		return nameFigure;	
	}
}
