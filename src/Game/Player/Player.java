package Game.Player;

import Game.Move;

public abstract class Player {
	private  Colour colour;
	
	public Colour getColour()
	{
		return colour;
	}
	
	public abstract boolean makeMove();
}
