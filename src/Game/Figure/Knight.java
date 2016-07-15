package Game.Figure;

import Game.Player.Colour;

public class Knight extends Figure {
	private char nameFigure='N';
	 
	public Knight(Colour colour) {
		super(colour);
	}
	
	public char getName(){
		return nameFigure;	
	} 
	
}
