package Game.Player;

import Game.Position;
import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Move;
import Game.Figure.Figure;
import UI.ConsoleUI;

public class User extends Player {

	public User(Colour colour) {
		super(colour);
	}

	@Override
	public boolean makeMove() {
		Move move = ConsoleUI.getInstance().getMove();
		Desk desk = GameController.getInstance().getDesk();
		
		Position pos1 = move.getFrom();
		Position pos2 = move.getTo();
		
		Cell cell1 = desk.getCell(pos1);
		Cell cell2 = desk.getCell(pos2);
		Figure fig = cell1.getFigure();
		
		if (cell1.isFree()) return false;
		if (fig.getColour() != this.getColour()) return false;
		if (!fig.isValidMove(desk, move)) return false;
		if (!cell2.isFree()) cell2.setFree();
		desk.moveFigure(pos1, pos2);		
		
		return true;		
	}
	

}
