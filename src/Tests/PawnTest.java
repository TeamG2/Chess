package Tests;

import static org.junit.Assert.*;


import org.junit.Test;

import Game.Cell;
import Game.Desk;
import Game.Move;
import Game.Position;
import Game.Figure.Figure;
import Game.Figure.Pawn;
import Game.Figure.Queen;
import Game.Player.Colour;

public class PawnTest {

	@Test
	public void promote() {		
		Desk desk = new Desk();
		desk.setCells();
		
		Cell cell = desk.getCell(new Position(6, 0));
		cell.setFigure(new Pawn(Colour.WHITE));
		desk.moveFigure(new Position(6, 0), new Position(7, 0));
		
		assertTrue(desk.getCell(new Position(7, 0)).getFigure() instanceof Queen);
		assertTrue(desk.getCell(new Position(6, 0)).isFree());
	}
	
	@Test
	public void isValidMove() {		
		Desk desk = new Desk();
		desk.setCells();
		
		Position position = new Position(1, 3);
		Cell cell = desk.getCell(position);
		Figure fig = new Pawn(Colour.WHITE);
		cell.setFigure(fig);
		
		Move move = new Move(position, new Position(2, 3));
		assertTrue(fig.isValidMove(desk, move));
		
		move = new Move(position, new Position(3, 3));
		assertTrue(fig.isValidMove(desk, move));		
		
		move = new Move(position, new Position(1, 3));
		assertFalse(fig.isValidMove(desk, move));	
		
		move = new Move(position, new Position(2, 4));
		assertFalse(fig.isValidMove(desk, move));	
		
		cell = desk.getCell(new Position(2, 4));
		fig = new Pawn(Colour.BLACK);
		cell.setFigure(fig);
		
		move = new Move(new Position(2, 4), position);
		assertTrue(fig.isValidMove(desk, move));			
	}

}
