package Game.Player;

import Game.Position;
import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Move;
import Game.Figure.Figure;
import UI.ConsoleUI;

public class User extends Player {

	@Override
	public boolean makeMove() {
		Move move = ConsoleUI.getInstance().getMove();
		Desk desk = GameController.getInstance().getDesk();
		
		Position pos1 = move.getFrom();
		Position pos2 = move.getTo();
		
		Cell Cell1 = desk.getCell(pos1);
		Cell Cell2 = desk.getCell(pos2);
		Figure fig = Cell1.getFigure();
		
		if (Cell1.isFree()) return false;
		if (!fig.checkMove(pos1, pos2)) return false;
		if (!Cell2.isFree()) Cell2.setFree();
			
		Cell1.setFree();
		Cell2.placeFigure(fig);
		return true;
		
	}

}
