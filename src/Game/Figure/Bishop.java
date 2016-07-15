package Game.Figure;

import Game.Player.Colour;

public class Bishop extends Figure {

	private char nameFigure='B';
	public Bishop(Colour colour) {
		super(colour);
	}
	
	public char getName(){
		return nameFigure;	
	} 	
	

}
