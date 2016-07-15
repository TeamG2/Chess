package Game.Figure;

import Game.Player.Colour;

public class King extends Figure{
	private char nameFigure='K';
	public King(Colour colour) {
		super(colour);
	}
	
	public char getName(){
		return nameFigure;	
	}

}
