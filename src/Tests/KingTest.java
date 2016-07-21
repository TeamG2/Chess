package Tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import Game.Cell;
import Game.Desk;
import Game.Move;
import Game.Position;
import Game.Figure.Bishop;
import Game.Figure.King;
import Game.Player.Colour;

public class KingTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetPossiblePositions() {
		fail("Not yet implemented");
	}

	@Test
	public void testKing() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidMove() {
		//fail("Not yet implemented");
		Desk desk = new Desk();
        desk.setCells();
       
        Position position = new Position(1, 3);
        Cell cell = desk.getCell(position);
        King fig = new King(Colour.WHITE);
        cell.setFigure(fig);
       
        Move move = new Move(position, new Position(2, 3));
        assertTrue(fig.isValidMove(desk, move));
       
        move = new Move(position, new Position(3, 3));
        assertTrue(fig.isValidMove(desk, move));
	}

	@Test
	public void testMakeSystemMove() {
		//fail("Not yet implemented");
		Desk d=new Desk();
		d.setCells();
		King b=new King(Colour.BLACK);
		 Position p=new Position(2,5);
		 boolean bool=true;
		 
		  assertEquals(b.makeSystemMove(p, new Position(2,6)),bool);
	}

}
