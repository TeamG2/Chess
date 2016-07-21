package Game.Player;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import Game.Desk;
import Game.GameController;
import Game.Position;
import Game.Evaluation.Evaluator;
import Game.Figure.Figure;
import Game.Figure.King;

public class MiniMaxBot extends Player {
	
	private Evaluator evaluator;
	

	public MiniMaxBot(Colour colour, Evaluator evaluator) {
		super(colour);
		this.evaluator = evaluator;
	}

	@Override
	public boolean makeMove() {

		Desk desk = GameController.getInstance().getDesk();
		ScoredMove optimal = maxi(desk, 3, this.getColour());
		
		desk.moveFigure(optimal.from, optimal.to);
		
		return true;
	}
	
	private ScoredMove maxi( Desk desk, int depth, Colour colour) {
	    if ( depth == 0 )
	    {
	    	Map<Colour, Integer> evaluation = evaluator.getEvaluation(desk);
	    	return new ScoredMove(new Position(-1, -1), new Position(-1, -1), evaluation.get(colour));
	    }
	    ScoredMove max = new ScoredMove(new Position(-1, -1), new Position(-1, -1), Integer.MIN_VALUE);
	    for (int i = 0; i < Desk.FIELD_SIZE; i++) {
	    	for (int j = 0; j < Desk.FIELD_SIZE; j++) {
	    		Position position = new Position(i, j);	    		
	    		if (!desk.getCell(position).isFree() && 
	    				desk.getCell(position).getFigure().getColour() == colour)
	    		{
	    			Figure figure = desk.getCell(position).getFigure();
	    			if (figure instanceof King) continue;
	    			HashSet<Position> possiblePositions = figure.getPossiblePositions(desk, position);	    			
	    			
	    			for (Position newPosition : possiblePositions) {
	    				Desk newDesk = null;
						try {
							newDesk = desk.cloneDesk();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}    				
	    				newDesk.moveFigure(position, newPosition);
	    				
	    				ScoredMove score = mini(newDesk, depth - 1, colour.getOpposite());
	    				if( score.score > max.score )
	    				{
	    					max.from = position;
	    					max.to = newPosition;
	    					max.score = score.score;
	    				}
	    			}
	    		}
	    	}
	    }
	    return max;
	}
	 
	private ScoredMove mini( Desk desk, int depth, Colour colour) {
	    
	    if ( depth == 0 )
	    {
	    	Map<Colour, Integer> evaluation = evaluator.getEvaluation(desk);
	    	return new ScoredMove(new Position(-1, -1), new Position(-1, -1), -evaluation.get(colour));
	    }
	    ScoredMove min = new ScoredMove(new Position(-1, -1), new Position(-1, -1), Integer.MAX_VALUE);
	    for (int i = 0; i < Desk.FIELD_SIZE; i++) {
	    	for (int j = 0; j < Desk.FIELD_SIZE; j++) {
	    		Position position = new Position(i, j);	    		
	    		if (!desk.getCell(position).isFree() && 
	    				desk.getCell(position).getFigure().getColour() == colour)
	    		{
	    			Figure figure = desk.getCell(position).getFigure();
	    			if (figure instanceof King) continue;
	    			HashSet<Position> possiblePositions = figure.getPossiblePositions(desk, position);	    			
	    			
	    			for (Position newPosition : possiblePositions) {
	    				Desk newDesk = null;
						try {
							newDesk = desk.cloneDesk();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			// todo: copy desk	    				
	    				newDesk.moveFigure(position, newPosition);
	    				
	    				ScoredMove score = maxi(newDesk, depth - 1, colour.getOpposite());
	    				if( score.score < min.score )
	    				{
	    		            min.from = position;
	    		            min.to = newPosition;
	    		            min.score = score.score;
	    				}
	    			}
	    		}
	    	}
	    }
	    return min;
	}

}