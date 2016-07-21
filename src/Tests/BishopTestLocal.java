package Tests;
import org.junit.Test;
import Game.*;
import Game.Figure.*;
import Game.Player.Colour;
import junit.framework.TestCase;

public class BishopTestLocal extends TestCase {
	public void testFailure() {
		int initX = 3, initY = 3, j;
		Desk testDesk = new Desk();
		Position initPos = new Position(initY, initX);
		Bishop bishopW1 = new Bishop(Colour.WHITE);
		Bishop bishopW2 = new Bishop(Colour.WHITE);
		Bishop bishopB = new Bishop(Colour.BLACK);
		testDesk.setCells();
		testDesk.getCell(initY, initX).setFigure(bishopW1);
		testDesk.getCell(0, 0).setFigure(bishopB);
		Move myMove;
		
		for(j = 0-initY; j< 8 - initY; j++){
			if(j!=0){
				myMove = new Move(initPos, new Position(initY+j, initX+j));
				assertTrue(bishopW1.isValidMove(testDesk, myMove));
			}
		}
		

		testDesk.getCell(7, 7).setFigure(bishopW2);
		myMove = new Move(initPos, new Position(7, 7));
		assertFalse(bishopW1.isValidMove(testDesk, myMove));
	
	}

}
