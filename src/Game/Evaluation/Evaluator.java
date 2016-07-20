package Game.Evaluation;

import java.util.Map;

import Game.Desk;
import Game.Position;
import Game.Figure.*;
import Game.Player.Colour;

public abstract class Evaluator {
	
	protected int pawnValue;
	protected int knightValue;
	protected int bishopValue;
	protected int rookValue;
	protected int queenValue;
	protected int kingValue;
	
	abstract protected int getPawnValue(Position position, Colour colour);
	
	abstract protected int getKnightValue(Position position, Colour colour);
	
	abstract protected int getBishopValue(Position position, Colour colour);
	
	abstract protected int getRookValue(Position position, Colour colour);
	
	abstract protected int getQueenValue(Position position, Colour colour);
	
	abstract protected int getKingValue(Position position, Colour colour);
	
	public abstract Map<Colour, Integer> getEvaluation(Desk desk);
	
	public int getValue(Figure figure, Position position)
	{
		if (figure instanceof Pawn) return getPawnValue(position, figure.getColour());
		if (figure instanceof Knight) return getKnightValue(position, figure.getColour());
		if (figure instanceof Bishop) return getBishopValue(position, figure.getColour());
		if (figure instanceof Rook) return getRookValue(position, figure.getColour());
		if (figure instanceof Queen) return getQueenValue(position, figure.getColour());
		if (figure instanceof King) return getKingValue(position, figure.getColour());
		
		return 0;
	}
}
