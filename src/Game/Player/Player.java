package Game.Player;

import Game.Move;

public abstract class Player {
	private  Colour colour;
	
	public Player(Colour colour)
	{
		this.colour = colour;
	}
	
	public Colour getColour()
	{
		return colour;
	}
	
	public abstract boolean makeMove();
}
