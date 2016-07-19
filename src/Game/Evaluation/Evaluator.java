package Game.Evaluation;

import java.util.Map;

import Game.Desk;
import Game.Figure.*;
import Game.Player.Colour;

public abstract class Evaluator {
	
	protected int pawnValue;
	protected int knightValue;
	protected int bishopValue;
	protected int rookValue;
	protected int queenValue;
	protected int kingValue;
	
	public abstract Map<Colour, Integer> getEvaluation(Desk desk);
	
	public int getValue(Figure figure)
	{
		if (figure instanceof Pawn) return pawnValue;
		if (figure instanceof Knight) return knightValue;
		if (figure instanceof Bishop) return bishopValue;
		if (figure instanceof Rook) return rookValue;
		if (figure instanceof Queen) return queenValue;
		if (figure instanceof King) return kingValue;
		
		return 0;
	}
}
