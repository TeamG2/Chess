package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Game.Cell;
import Game.Desk;
import Game.GameController;
import Game.Position;
import Game.Figure.Figure;
import Game.Figure.King;
import Game.Figure.Pawn;
import Game.Figure.Queen;
import Game.Player.Colour;

public class ShahTest {

	@Test
	public void test() {
		Desk desk = new Desk();
		desk.setCells();
		
		Position position = new Position(2, 3);
		Cell cell = desk.getCell(position);
		Figure fig = new King(Colour.WHITE);
		cell.setFigure(fig);
		
		position = new Position(1, 2);
		cell = desk.getCell(position);
		fig = new King(Colour.BLACK);
		cell.setFigure(fig);
		
		assertTrue(GameController.getInstance().isShahFor(desk, Colour.WHITE));
	}

}
