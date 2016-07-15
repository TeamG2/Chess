package Game;

public class Move {
	
	private Position from;
	private Position to;
	
	public Move(int x1,int y1, int x2,int y2){
		from = new Position(x1,y1);
		to = new Position(x2,y2);
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
