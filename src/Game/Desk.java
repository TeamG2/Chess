package Game;

import java.util.HashSet;

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
	
	public void moveFigure(Cell from, Cell to)
	{
		to.setFigure(from.getFigure());
		from.setFree();		
	}
	
	private void setInitialKings()
	{
		King black = new King(Colour.BLACK);
		King white = new King(Colour.WHITE);
		field[0][3].setFigure(white);
		field[7][3].setFigure(black);	
	}
	
	private void setInitialQueens()
	{
		Queen black = new Queen(Colour.BLACK);
		Queen white = new Queen(Colour.WHITE);
		field[0][4].setFigure(white);
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
	
	public boolean isShahFor(Colour colour) {
		Colour oppositeCol = GameController.getInstance().changeCol(colour);
		for (int i=0; i <= FIELD_SIZE-1; i++) {
			for (int j=0; j <=  FIELD_SIZE-1; j++) {
				Figure fig = field[i][j].getFigure();
					if (fig.getColour() == oppositeCol) { 
						HashSet<Position> set = fig.getPossiblePositions(new Position(i, j));
						if (fig.isFigureInSet('K', colour, set)) return true;
					}
			}	
		}
		return false;
	}
	
	public boolean isCheckMateFor(Colour colour) { 			//Мат - нет ни одного способа защитить короля от шаха
		for (int i=0; i <= FIELD_SIZE-1; i++) {
			for (int j=0; j <=  FIELD_SIZE-1; j++) {
				Figure fig = field[i][j].getFigure();
				if (fig.getColour() == colour) { 			// Берем фигуру свого цвета
					HashSet<Position> set = fig.getPossiblePositions(new Position(i, j));
					Position pos1 = new Position(i, j);
					for (Position pos2 : set) {
						fig.makeSystemMove(pos1, pos2); 	// Делаем виртуальный ход (возможно срубаем), чтобы проверить, можно ли защитить короля
						if (!isShahFor(colour)) { 			// Шах пропал - значит есть способ защитить короля. Мата нет.
							fig.makeSystemMove(pos2, pos1); // Возвращаем фигуру, которой "виртуально" ходили, на место
							if (Figure.getFromBuffer() != null) {
								field[pos2.getRow()][pos2.getColumn()].setFigure(Figure.getFromBuffer()); // Возвращаем на доску возможно срубленную фигуру
							}
							return false;
						}
					}
				}
			}
		}
		return true;	
	}
		
	
	

}
