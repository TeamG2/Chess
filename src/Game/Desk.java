package Game;

import Game.Figure.Bishop;
import Game.Figure.King;
import Game.Figure.Knight;
import Game.Figure.Pawn;
import Game.Figure.Queen;
import Game.Figure.Rook;
import Game.Player.Colour;

public class Desk {

	private final int FIELD_SIZE = 8; 
	
	private Cell[][] field = new Cell[FIELD_SIZE][FIELD_SIZE];
	
	public void setInitialState()
	{		
		this.setInitialPawns();		
		this.setInitialRooks();
		this.setInitialKnights();
		this.setInitialBishops();
		this.setInitialQueens();
		this.setInitialKings();
	}
	
	private void setInitialKings()
	{
		King black = new King(Colour.BLACK);
		King white = new King(Colour.WHITE);
		field[0][4] = new Cell(black);
		field[7][3] = new Cell(white);		
	}
	
	private void setInitialQueens()
	{
		Queen black = new Queen(Colour.BLACK);
		Queen white = new Queen(Colour.WHITE);
		field[0][3] = new Cell(black);
		field[7][4] = new Cell(white);		
	}
	
	private void setInitialBishops()
	{
		Bishop black = new Bishop(Colour.BLACK);
		Bishop white = new Bishop(Colour.WHITE);
		field[0][2] = new Cell(black);
		field[7][5] = new Cell(white);
		
		black = new Bishop(Colour.BLACK);
		white = new Bishop(Colour.WHITE);
		field[0][2] = new Cell(black);
		field[7][5] = new Cell(white);
	}
	
	private void setInitialPawns()
	{
		for (int i = 0; i < FIELD_SIZE; i++)
		{
			Pawn black = new Pawn(Colour.BLACK);
			Pawn white = new Pawn(Colour.WHITE);
			field[1][i] = new Cell(black);
			field[6][i] = new Cell(white);
		}
	}
	
	private void setInitialRooks()
	{
		Rook black = new Rook(Colour.BLACK);
		Rook white = new Rook(Colour.WHITE);
		field[0][0] = new Cell(black);
		field[7][0] = new Cell(white);
		
		black = new Rook(Colour.BLACK);
		white = new Rook(Colour.WHITE);
		field[0][7] = new Cell(black);
		field[7][7] = new Cell(white);
	}
	
	private void setInitialKnights()
	{
		Knight black = new Knight(Colour.BLACK);
		Knight white = new Knight(Colour.WHITE);
		field[0][1] = new Cell(black);
		field[7][1] = new Cell(white);
		
		black = new Knight(Colour.BLACK);
		white = new Knight(Colour.WHITE);
		field[0][6] = new Cell(black);
		field[7][6] = new Cell(white);
	}
	
	public Cell getCell(Position pos) {
		return field[pos.getX()][pos.getY()];
	}
	
}
