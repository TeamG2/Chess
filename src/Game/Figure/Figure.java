package Game.Figure;

import Game.Player.Colour;

public abstract class Figure {
	
	private Colour colour;
	private char nameFigure;
	
	public Figure(Colour colour)
	{
		this.colour = colour;
	}	
	
	public char getName(){
		return nameFigure;
	}
}
