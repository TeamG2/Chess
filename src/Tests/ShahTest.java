package Tests;

import static org.junit.Assert.*;

import java.util.HashSet;

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
		
		Position position = new Position(0, 3);
		Cell cell = desk.getCell(position);
		Figure fig = new King(Colour.WHITE);
		cell.setFigure(fig);
		
		position = new Position(0, 2);
		cell = desk.getCell(position);
		fig = new Queen(Colour.WHITE);
		cell.setFigure(fig);
		
		position = new Position(0, 4);
		cell = desk.getCell(position);
		fig = new Queen(Colour.WHITE);
		cell.setFigure(fig);
		
		position = new Position(1, 3);
		cell = desk.getCell(position);
		fig = new Queen(Colour.WHITE);
		cell.setFigure(fig);
		
		position = new Position(1, 4);
		cell = desk.getCell(position);
		fig = new Queen(Colour.WHITE);
		cell.setFigure(fig);
		
		position = new Position(1, 2);
		cell = desk.getCell(position);
		fig = new Queen(Colour.BLACK);
		cell.setFigure(fig);
		
		HashSet<Position> setik = desk.getCell(0, 3).getFigure().getPossiblePositions(desk, new Position(0,3));
		
		assertTrue(GameController.getInstance().isShahFor(desk, Colour.WHITE));
	}

}
