package Tests;
import org.junit.Test;
import Game.*;
import Game.Figure.*;
import Game.Player.Colour;
import junit.framework.TestCase;

public class TestRookMove extends TestCase {
	public void testFailure() {
		int initX = 3, initY = 3, j;
		Desk testDesk = new Desk();
		Position initPos = new Position(initY, initX);
		Rook rookW1 = new Rook(Colour.WHITE);
		Rook rookW2 = new Rook(Colour.WHITE);
		Rook rookB = new Rook(Colour.BLACK);
		testDesk.setCells();
		testDesk.getCell(initY, initX).setFigure(rookW1);
		testDesk.getCell(0, initX).setFigure(rookB);
//		ConsoleUI aCUI = new ConsoleUI();
//		aCUI.representBoard(testDesk);
		Move myMove;
		
		for(j=0; j<8; j++){
			if(j!=initY){
				myMove = new Move(initPos, new Position(j, initX));
				assertTrue(rookW1.isValidMove(testDesk, myMove));
			}
		}
		
		for(j=0; j<8; j++){
			if(j!=initX){
				myMove = new Move(initPos, new Position(initY, j));
				assertTrue(rookW1.isValidMove(testDesk, myMove));
			}
		}
		
		myMove = new Move(initPos, new Position(0, initX+1));
		assertFalse(rookW1.isValidMove(testDesk, myMove));
		
		testDesk.getCell(0, initX).setFigure(rookW2);
		myMove = new Move(initPos, new Position(0, initX));
		assertFalse(rookW1.isValidMove(testDesk, myMove));

	
		
	}

}
