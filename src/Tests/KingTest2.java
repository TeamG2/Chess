package Tests;
import Game.*;
import Game.Figure.*;
import Game.Player.Colour;
import junit.framework.TestCase;

public class KingTest2 extends TestCase {
	public void testFailure() {
		int initX = 3, initY = 3, j;
		Desk testDesk = new Desk();
		Position initPos = new Position(initY, initX);
		King kingW1 = new King(Colour.WHITE);
		King kingW2 = new King(Colour.WHITE);
		King kingB = new King(Colour.BLACK);
		testDesk.setCells();
		testDesk.getCell(initY, initX).setFigure(kingW1);
		testDesk.getCell(0, 0).setFigure(kingB);
		Move myMove;
		
		for(j = -1; j< 1; j=j+2){
				myMove = new Move(initPos, new Position(initY+j, initX+j));
				assertTrue(kingW1.isValidMove(testDesk, myMove));
		}
		
		for(j=initY-1; j<initY+1; j=j+2){
				myMove = new Move(initPos, new Position(j, initX));
				assertTrue(kingW1.isValidMove(testDesk, myMove));
		}
		
		for(j=initX-1; j<initX+1; j=j+2){
				myMove = new Move(initPos, new Position(initY, j));
				assertTrue(kingW1.isValidMove(testDesk, myMove));
		}
		

		testDesk.getCell(7, 7).setFigure(kingW2);
		myMove = new Move(initPos, new Position(7, 7));
		assertFalse(kingW1.isValidMove(testDesk, myMove));
		
		myMove = new Move(initPos, new Position(0, initX+1));
		assertFalse(kingW1.isValidMove(testDesk, myMove));
		
		testDesk.getCell(0, initX).setFigure(kingW2);
		myMove = new Move(initPos, new Position(0, initX));
		assertFalse(kingW1.isValidMove(testDesk, myMove));
	
	}

}
