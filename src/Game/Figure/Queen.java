package Game.Figure;

import Game.Player.Colour;

public class Queen extends Figure {
	private char nameFigure='Q';
	public Queen(Colour colour) {
		super(colour);
	}
	
	public char getName(){
		return nameFigure;	
	}
}
