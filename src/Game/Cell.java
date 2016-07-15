package Game;

import Game.Figure.Figure;

public class Cell {
	
	private Figure figure;
	private int xCoord, yCoord;
	//boolean isOccupied;
	
	public Cell(Figure figure)
	{
		this.figure = figure;
		
		
	}
	
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public int getYCoord() {
		return this.yCoord;
	}
	
	public int getXCoord() {
		return this.xCoord;
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
	
	public void placeFigure(Figure figure){
		this.figure = figure;
	}
	
	public Figure getFigure() {
		return this.figure;
	}
	
}
