package Game.Player;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

import Game.Desk;
import Game.GameController;
import Game.Move;
import Game.Position;
import Game.Evaluation.Evaluator;
import Game.Figure.Figure;
import Game.Figure.King;
import UI.ConsoleUI;

public class AlphaBetaBot extends Player {
	
	private Evaluator evaluator;
	

	public AlphaBetaBot(Colour colour, Evaluator evaluator) {
		super(colour);
		this.evaluator = evaluator;
	}

	@Override
	public boolean makeMove() {
			
		ConsoleUI.getInstance().showBotThinkMessage();
		Desk desk = GameController.getInstance().getDesk();
		ScoredMove alpha = new ScoredMove(new Position(-1, -1), new Position(-1, -1), Integer.MIN_VALUE);
		ScoredMove beta = new ScoredMove(new Position(-1, -1), new Position(-1, -1), Integer.MAX_VALUE);
		ScoredMove optimal = maxi(alpha, beta, desk, 4, this.getColour());
		
		desk.moveFigure(optimal.from, optimal.to);
		ConsoleUI.getInstance().showBotMove(new Move(optimal.from, optimal.to));
		return true;
	}
	
	private ScoredMove maxi(ScoredMove alphaF, ScoredMove betaF, Desk desk, int depth, Colour colour) {
	    if ( depth == 0 )
	    {    	
	    	Map<Colour, Integer> evaluation = evaluator.getEvaluation(desk);
	    	int value = evaluation.get(colour);
	    	return new ScoredMove(new Position(-1, -1), new Position(-1, -1), value);
	    }
	    ScoredMove alpha = new ScoredMove(new Position(alphaF.from.getRow(), alphaF.from.getColumn()),
	    		 new Position(alphaF.to.getRow(), alphaF.to.getColumn()), alphaF.score);
	    ScoredMove beta = new ScoredMove(new Position(betaF.from.getRow(), betaF.from.getColumn()),
	    		 new Position(betaF.to.getRow(), betaF.to.getColumn()), betaF.score);
	    for (int i = 0; i < Desk.FIELD_SIZE; i++) {
	    	for (int j = 0; j < Desk.FIELD_SIZE; j++) {
	    		Position position = new Position(i, j);	    		
	    		if (!desk.getCell(position).isFree() && 
	    				desk.getCell(position).getFigure().getColour() == colour)
	    		{
	    			Figure figure = desk.getCell(position).getFigure();
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
	    				
	    				ScoredMove score = mini(alpha, beta, newDesk, depth - 1, colour.getOpposite());
	    				
	    				if( score.score > alpha.score )
	    				{
	    					alpha.from = new Position(position.getRow(), position.getColumn());
	    					alpha.to = new Position(newPosition.getRow(), newPosition.getColumn());
	    					alpha.score = score.score;
	    				}
	    				if (alpha.score >= beta.score)
	    				{
	    					return beta;
	    				}
	    			}
	    		}
	    	}
	    }
	    return alpha;
	}
	 
	private ScoredMove mini(ScoredMove alphaF, ScoredMove betaF, Desk desk, int depth, Colour colour) {
	    
	    if ( depth == 0 )
	    {
	    	Map<Colour, Integer> evaluation = evaluator.getEvaluation(desk);
	    	int value = evaluation.get(colour);
	    	return new ScoredMove(new Position(-1, -1), new Position(-1, -1), -value);
	    }
	    ScoredMove alpha = new ScoredMove(new Position(alphaF.from.getRow(), alphaF.from.getColumn()),
	    		 new Position(alphaF.to.getRow(), alphaF.to.getColumn()), alphaF.score);
	    ScoredMove beta = new ScoredMove(new Position(betaF.from.getRow(), betaF.from.getColumn()),
	    		 new Position(betaF.to.getRow(), betaF.to.getColumn()), betaF.score);
	    for (int i = 0; i < Desk.FIELD_SIZE; i++) {
	    	for (int j = 0; j < Desk.FIELD_SIZE; j++) {
	    		Position position = new Position(i, j);	    		
	    		if (!desk.getCell(position).isFree() && 
	    				desk.getCell(position).getFigure().getColour() == colour)
	    		{
	    			Figure figure = desk.getCell(position).getFigure();
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
	    				
	    				ScoredMove score = maxi(alpha, beta, newDesk, depth - 1, colour);
	    				if( score.score < beta.score )
	    				{
	    					beta.from = new Position(position.getRow(), position.getColumn());
	    					beta.to =  new Position(newPosition.getRow(), newPosition.getColumn());
	    					beta.score = score.score;
	    				}
	    				if (beta.score <= alpha.score)
	    				{
	    					return alpha;
	    				}
	    			}
	    		}
	    	}
	    }
	    return beta;
	}

}

class ScoredMove {
	public Position from;
	public Position to;	
	public int score;
	
	public ScoredMove(Position from, Position to, int score)
	{
		this.from = from;
		this.to = to;
		this.score = score;
	}
}
