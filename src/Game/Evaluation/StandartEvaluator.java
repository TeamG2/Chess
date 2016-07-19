package Game.Evaluation;

import java.util.EnumMap;
import java.util.Map;

import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Figure.Figure;
import Game.Player.Colour;

public class StandartEvaluator extends Evaluator {
	protected int pawnValue = 1;
	protected int knightValue = 3;
	protected int bishopValue = 3;
	protected int rookValue = 5;
	protected int queenValue = 9;
	protected int kingValue = 1000000;
	
	public Map<Colour, Integer> getEvaluation(Desk desk)
	{
		Map<Colour, Integer> result = new EnumMap<Colour, Integer>(Colour.class);
		result.put(Colour.WHITE, 0);
		result.put(Colour.BLACK, 0);
		
		for (int i = 0; i < Desk.FIELD_SIZE; i++)
		{
			for (int j = 0; j < Desk.FIELD_SIZE; j++)
			{
				Cell cell = desk.getCell(i, j);
				if (!cell.isFree())
				{
					Figure figure = cell.getFigure();
					int currentValue = result.get(figure.getColour());
					currentValue += getValue(figure);
					result.put(figure.getColour(), currentValue);
				}
			}
		}
		
		return result;
	}
}
