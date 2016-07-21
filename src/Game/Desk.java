package Game;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

import Game.Figure.Bishop;
import Game.Figure.Figure;
import Game.Figure.King;
import Game.Figure.Knight;
import Game.Figure.Pawn;
import Game.Figure.Queen;
import Game.Figure.Rook;
import Game.Player.Colour;

public class Desk implements Serializable  {

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
	
	public void setCells()
	{
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 8; j++)
			{
				field[i][j] = new Cell();
			}
		}
	}
	
	public void moveFigure(Position from, Position to)
	{
		Cell fromCell = this.getCell(from);
		Cell toCell = this.getCell(to);
		
		toCell.setFigure(fromCell.getFigure());
		fromCell.setFree();	
		
		if (toCell.getFigure() instanceof Pawn)
		{
			Pawn pawn = (Pawn)toCell.getFigure();
			if (pawn.isNeedToPromote(to))
			{
				toCell.setFigure(new Queen(pawn.getColour()));
			}
		}
	}
	
	private void setInitialKings()
	{
		King black = new King(Colour.BLACK);
		King white = new King(Colour.WHITE);
		field[0][4].setFigure(white);
		field[7][4].setFigure(black);	
	}
	
	private void setInitialQueens()
	{
		Queen black = new Queen(Colour.BLACK);
		Queen white = new Queen(Colour.WHITE);
		field[0][3].setFigure(white);
		field[7][3].setFigure(black);	
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
	
	public Cell getCell(int row, int column) {
		Position pos = new Position(row, column);
		return field[pos.getRow()][pos.getColumn()];
	}
	
//	public Figure [] getFigures(Colour colour){
//		Figure [] allFigs;
//		int i, j;
//		for(i=1; i<=fiel)
//		return	allFigs;
//	}
	
	
	


	
	public Desk cloneDesk() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ous = new ObjectOutputStream(baos);
        //сохраняем состояние доски в поток и закрываем его(поток)
        ous.writeObject(this);
        ous.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Desk cloneDesk = (Desk) ois.readObject();
        return cloneDesk;
	}	
	
	

}
