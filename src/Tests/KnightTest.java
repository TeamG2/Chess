package Tests;
import Game.*;
import Game.Figure.*;
import Game.Player.Colour;
import junit.framework.TestCase;

public class KnightTest extends TestCase {
	public void testFailure() {
		int initX = 3, initY = 3, j, i;
		Desk testDesk = new Desk();
		Position initPos = new Position(initY, initX);
		Knight knightW1 = new Knight(Colour.WHITE);
		Knight knightW2 = new Knight(Colour.WHITE);
		Knight knightB = new Knight(Colour.BLACK);
		testDesk.setCells();
		testDesk.getCell(initY, initX).setFigure(knightW1);
		testDesk.getCell(initY-2, initX-1).setFigure(knightB);
		Move myMove;
		
		for(j=-1; j<=1; j=j+2){
			for(i=-2; i<=2; i=i+4){
				myMove = new Move(initPos, new Position(initY+j, initX+i));
				assertTrue(knightW1.isValidMove(testDesk, myMove));
			}
		}
		
		for(j=-1; j<=1; j=j+2){
			for(i=-2; i<=2; i=i+4){
				myMove = new Move(initPos, new Position(initY+i, initX+j));
				assertTrue(knightW1.isValidMove(testDesk, myMove));
			}
		}
		
		

		testDesk.getCell(initY+1, initX+2).setFigure(knightW2);
		myMove = new Move(initPos, new Position(initY+1, initX+2));
		assertFalse(knightW1.isValidMove(testDesk, myMove));
		
		myMove = new Move(initPos, new Position(0, initX+1));
		assertFalse(knightW1.isValidMove(testDesk, myMove));
		
		testDesk.getCell(0, initX).setFigure(knightW2);
		myMove = new Move(initPos, new Position(0, initX));
		assertFalse(knightW1.isValidMove(testDesk, myMove));
	
	}

}
