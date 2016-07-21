package Tests;
import Game.*;
import Game.Figure.*;
import Game.Player.Colour;
import junit.framework.TestCase;

public class QueenTest extends TestCase {
	public void testFailure() {
		int initX = 3, initY = 3, j;
		Desk testDesk = new Desk();
		Position initPos = new Position(initY, initX);
		Queen queenW1 = new Queen(Colour.WHITE);
		Queen queenW2 = new Queen(Colour.WHITE);
		Queen queenB = new Queen(Colour.BLACK);
		testDesk.setCells();
		testDesk.getCell(initY, initX).setFigure(queenW1);
		testDesk.getCell(0, 0).setFigure(queenB);
		Move myMove;
		
		for(j = 0-initY; j< 8 - initY; j++){
			if(j!=0){
				myMove = new Move(initPos, new Position(initY+j, initX+j));
				assertTrue(queenW1.isValidMove(testDesk, myMove));
			}
		}
		
		for(j=0; j<8; j++){
			if(j!=initY){
				myMove = new Move(initPos, new Position(j, initX));
				assertTrue(queenW1.isValidMove(testDesk, myMove));
			}
		}
		
		for(j=0; j<8; j++){
			if(j!=initX){
				myMove = new Move(initPos, new Position(initY, j));
				assertTrue(queenW1.isValidMove(testDesk, myMove));
			}
		}
		

		testDesk.getCell(7, 7).setFigure(queenW2);
		myMove = new Move(initPos, new Position(7, 7));
		assertFalse(queenW1.isValidMove(testDesk, myMove));
		
		myMove = new Move(initPos, new Position(0, initX+1));
		assertFalse(queenW1.isValidMove(testDesk, myMove));
		
		testDesk.getCell(0, initX).setFigure(queenW2);
		myMove = new Move(initPos, new Position(0, initX));
		assertFalse(queenW1.isValidMove(testDesk, myMove));
	
	}

}
