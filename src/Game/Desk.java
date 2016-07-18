package Game;

import Game.Figure.Bishop;
import Game.Figure.Figure;
import Game.Figure.King;
import Game.Figure.Knight;
import Game.Figure.Pawn;
import Game.Figure.Queen;
import Game.Figure.Rook;
import Game.Player.Colour;

public class Desk {

	public static final int FIELD_SIZE = 8; 
	
	private Cell[][] field = new Cell[FIELD_SIZE][FIELD_SIZE];
	
	public void setInitialState()
	{		
		this.setCells();
		this.setInitialPawns();		
		this.setInitialRooks();
		this.setInitialKnights();
		this.setInitialBishops();
		this.setInitialQueens();
		this.setInitialKings();
	}
	
	private void setCells()
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				field[i][j] = new Cell();
			}
		}
	}
	
	private void setInitialKings()
	{
		King black = new King(Colour.BLACK);
		King white = new King(Colour.WHITE);
		field[0][4].setFigure(white);
		field[7][3].setFigure(black);	
	}
	
	private void setInitialQueens()
	{
		Queen black = new Queen(Colour.BLACK);
		Queen white = new Queen(Colour.WHITE);
		field[0][3].setFigure(white);
		field[7][4].setFigure(black);	
	}
	
	private void setInitialBishops()
	{
		Bishop black = new Bishop(Colour.BLACK);
		Bishop white = new Bishop(Colour.WHITE);
		field[0][2].setFigure(white);
		field[7][5].setFigure(black);
		
		black = new Bishop(Colour.BLACK);
		white = new Bishop(Colour.WHITE);
		field[0][5].setFigure(white);
		field[7][2].setFigure(black);
	}
	
	private void setInitialPawns()
	{
		for (int i = 0; i < FIELD_SIZE; i++)
		{
			Pawn black = new Pawn(Colour.BLACK);
			Pawn white = new Pawn(Colour.WHITE);
			field[1][i].setFigure(white);
			field[6][i].setFigure(black);
		}
	}
	
	private void setInitialRooks()
	{
		Rook black = new Rook(Colour.BLACK);
		Rook white = new Rook(Colour.WHITE);
		field[0][0].setFigure(white);
		field[7][0].setFigure(black);
		
		black = new Rook(Colour.BLACK);
		white = new Rook(Colour.WHITE);
		field[0][7].setFigure(white);
		field[7][7].setFigure(black);
	}
	
	private void setInitialKnights()
	{
		Knight black = new Knight(Colour.BLACK);
		Knight white = new Knight(Colour.WHITE);
		field[0][1].setFigure(white);
		field[7][1].setFigure(black);
		
		black = new Knight(Colour.BLACK);
		white = new Knight(Colour.WHITE);
		field[0][6].setFigure(white);
		field[7][6].setFigure(black);
	}
	
	public Cell getCell(Position pos) {
		return field[pos.getRow()][pos.getColumn()];
	}
	
//	public Figure [] getFigures(Colour colour){
//		Figure [] allFigs;
//		int i, j;
//		for(i=1; i<=fiel)
//		return	allFigs;
//	}
	
//	public boolean isShah(Colour colour) {
//		for (int i=0; i <= FIELD_SIZE-1; i++) {
//			for (int j=0; j <=  FIELD_SIZE-1; j++) {
//				Figure fig = field[i][j].getFigure();
//					if (fig.getColour() == Colour.WHITE)
//			}
//			
//		}
//		return false;
//	}

}
