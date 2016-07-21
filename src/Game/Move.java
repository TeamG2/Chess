package Game;

public class Move {
	
	private Position from;
	private Position to;
	
	public Move(int rowFrom, int columnFrom, int rowTo, int columnTo){
		from = new Position(rowFrom, columnFrom);
		to = new Position(rowTo, columnTo);
	}
	
	public Move(Position from, Position to) {
		this.from = from;
		this.to= to;
	}

	public Position getFrom()
	{
		return from;
	}
	
	public Position getTo()
	{
		return to;
	}

}
