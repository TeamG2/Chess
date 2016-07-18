package Game;

import Game.Figure.Figure;

public class Cell {
	
	private Figure figure;
	private int xCoord, yCoord;
//	private int xCoord, yCoord;
	
	public Cell(Figure figure)
	{
		this.figure = figure;
		
		
	}
	

	
	public Cell(){
		this.figure = null;
	}
	
	public boolean isFree(){
		if(this.figure == null){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public void setFigure(Figure figure){
		this.figure = figure;
	}
	public void setFree(){
		this.figure = null;
	}
	public Figure getFigure() {
		return this.figure;
	}
	
//	public void setXCoord(int xCoord) {
//		this.xCoord = xCoord;
//	}
//	
//	public void setYCoord(int yCoord) {
//		this.yCoord = yCoord;
//	}
//	
//	public int getYCoord() {
//		return this.yCoord;
//	}
//	
//	public int getXCoord() {
//		return this.xCoord;
//	}
	
}
