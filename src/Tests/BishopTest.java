package Tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Game.*;
import Game.Figure.Bishop;
import Game.Player.*;
public class BishopTest {
	HashSet<Position> hash;
	
	@Test
	public void testIsValidMove() {
		Desk desk = new Desk();
        desk.setCells();
       
        Position position = new Position(1, 3);
        Cell cell = desk.getCell(position);
        Bishop fig = new Bishop(Colour.WHITE);
        cell.setFigure(fig);
       
        Move move = new Move(position, new Position(2, 3));
        assertTrue(fig.isValidMove(desk, move));
       
        move = new Move(position, new Position(3, 3));
        assertTrue(fig.isValidMove(desk, move));
	//	fail("Not yet implemented");
		
	}

	@Test
	public void testMakeSystemMove() {
		Desk d=new Desk();
		d.setCells();
		Bishop b=new Bishop(Colour.BLACK);
		 Position p=new Position(2,5);
		 boolean bool=true;
		 
		 // assertEquals(b.makeSystemMove(p, new Position(2,6)),bool);
		 
		//fail("Not yet implemented");
	}

	@Test
	public void testGetFromBuffer() {
		fail("Not yet implemented");
	}
	@Test
	public void testGetPossibleposition(){
		Bishop b=new Bishop(Colour.BLACK);
		hash=new HashSet<>();
		Position current=new Position(3,2);
		Desk desk=new Desk();
		desk.setInitialState();
			for(int i=0;i<8;i++){
				Position p=new Position(3,i);
				Cell cell = desk.getCell(p);
				hash.add(p);
			}
			for(int i=0;i<8;i++){
				Position p=new Position(i,2);
				hash.add(p);
			}
			
			assertEquals(b.getPossiblePositions(desk, current),hash);
	}

}
