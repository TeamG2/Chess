package Game.Evaluation;

import java.util.EnumMap;
import java.util.Map;

import Game.Cell;
import Game.Desk;
import Game.Position;
import Game.Figure.Figure;
import Game.Player.Colour;

public class TableEvaluator extends Evaluator {
	
	@Override
	protected int getPawnValue(Position position, Colour colour) {
		int [][] table = {{0,  0,  0,  0,  0,  0,  0,  0},
				{50, 50, 50, 50, 50, 50, 50, 50},
				{10, 10, 20, 30, 30, 20, 10, 10},
				 {5,  5, 10, 25, 25, 10,  5,  5},
				 {0,  0,  0, 20, 20,  0,  0,  0},
				 {5, -5,-10,  0,  0,-10, -5,  5},
				 {5, 10, 10,-20,-20, 10, 10,  5},
				 {0,  0,  0,  0,  0,  0,  0,  0}};
		if (colour == Colour.WHITE)
			return table[position.getRow()][position.getColumn()];
		else
			return table[7 - position.getRow()][position.getColumn()];
	}
	
	@Override
	protected int getKnightValue(Position position, Colour colour) {
		int [][] table = {{-50,-40,-30,-30,-30,-30,-40,-50},
				{-40,-20,  0,  0,  0,  0,-20,-40},
				{-30,  0, 10, 15, 15, 10,  0,-30},
				{-30,  5, 15, 20, 20, 15,  5,-30},
				{-30,  0, 15, 20, 20, 15,  0,-30},
				{-30,  5, 10, 15, 15, 10,  5,-30},
				{-40,-20,  0,  5,  5,  0,-20,-40},
				{-50,-40,-30,-30,-30,-30,-40,-50}};
		if (colour == Colour.WHITE)
			return table[position.getRow()][position.getColumn()];
		else
			return table[7 - position.getRow()][position.getColumn()];
	}
	
	@Override
	protected int getBishopValue(Position position, Colour colour) {
		int [][] table = {{-20,-10,-10,-10,-10,-10,-10,-20},
				{-10,  0,  0,  0,  0,  0,  0,-10},
				{-10,  0,  5, 10, 10,  5,  0,-10},
				{-10,  5,  5, 10, 10,  5,  5,-10},
				{-10,  0, 10, 10, 10, 10,  0,-10},
				{-10, 10, 10, 10, 10, 10, 10,-10},
				{-10,  5,  0,  0,  0,  0,  5,-10},
				{-20,-10,-10,-10,-10,-10,-10,-20}};
		if (colour == Colour.WHITE)
			return table[position.getRow()][position.getColumn()];
		else
			return table[7 - position.getRow()][position.getColumn()];
	}
	
	@Override
	protected int getRookValue(Position position, Colour colour) {
		int [][] table = {{0,  0,  0,  0,  0,  0,  0,  0},
				  {5, 10, 10, 10, 10, 10, 10,  5},
				  {-5,  0,  0,  0,  0,  0,  0, -5},
				  {-5,  0,  0,  0,  0,  0,  0, -5},
				  {-5,  0,  0,  0,  0,  0,  0, -5},
				  {-5,  0,  0,  0,  0,  0,  0, -5},
				  {-5,  0,  0,  0,  0,  0,  0, -5},
				   {0,  0,  0,  5,  5,  0,  0,  0}};
		if (colour == Colour.WHITE)
			return table[position.getRow()][position.getColumn()];
		else
			return table[7 - position.getRow()][position.getColumn()];
	}
	
	@Override
	protected int getQueenValue(Position position, Colour colour) {
		int [][] table = {{-20,-10,-10, -5, -5,-10,-10,-20},
				{-10,  0,  0,  0,  0,  0,  0,-10},
				{-10,  0,  5,  5,  5,  5,  0,-10},
				 {-5,  0,  5,  5,  5,  5,  0, -5},
				  {0,  0,  5,  5,  5,  5,  0, -5},
				{-10,  5,  5,  5,  5,  5,  0,-10},
				{-10,  0,  5,  0,  0,  0,  0,-10},
				{-20,-10,-10, -5, -5,-10,-10,-20}};
		if (colour == Colour.WHITE)
			return table[position.getRow()][position.getColumn()];
		else
			return table[7 - position.getRow()][position.getColumn()];
	}
	
	@Override
	protected int getKingValue(Position position, Colour colour) {
		int [][] table = {{-30,-40,-40,-50,-50,-40,-40,-30},
				{-30,-40,-40,-50,-50,-40,-40,-30},
				{-30,-40,-40,-50,-50,-40,-40,-30},
				{-30,-40,-40,-50,-50,-40,-40,-30},
				{-20,-30,-30,-40,-40,-30,-30,-20},
				{-10,-20,-20,-20,-20,-20,-20,-10},
				 {20, 20,  0,  0,  0,  0, 20, 20},
				 {20, 30, 10,  0,  0, 10, 30, 20}};
		if (colour == Colour.WHITE)
			return table[position.getRow()][position.getColumn()];
		else
			return table[7 - position.getRow()][position.getColumn()];
	}

	@Override
	public Map<Colour, Integer> getEvaluation(Desk desk) {
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
					currentValue += getValue(figure, new Position(i, j));
					result.put(figure.getColour(), currentValue);
				}
			}
		}
		
		return result;
	}

}
