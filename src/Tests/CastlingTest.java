package Tests;

import Game.Desk;
import Game.GameController;
import Game.Position;
import Game.Figure.King;
import Game.Figure.Rook;
import Game.Player.Colour;
import UI.ConsoleUI;

public class CastlingTest {

	public static void main(String[] args) {
		Desk newDesk = new Desk();
		Position Kpos = new Position(0, 4);
		Position Rpos = new Position(0, 7);
		Position BKpos = new Position(7, 7);
		King king = new King(Colour.WHITE);
		King Bking = new King(Colour.BLACK);
		Rook rook = new Rook(Colour.WHITE);
		newDesk.setCells();
		newDesk.getCell(Kpos).setFigure(king);
		newDesk.getCell(BKpos).setFigure(Bking);
		newDesk.getCell(Rpos).setFigure(rook);
//		ConsoleUI CUI = new ConsoleUI();
//		CUI.representBoard(newDesk);
//		CUI.getMove();
		
		GameController.getInstance(newDesk).startNewGame(newDesk, Colour.WHITE);
	}

}
