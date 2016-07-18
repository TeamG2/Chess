package Game;

import Game.Figure.Figure;

public class Cell {
	
	private Figure figure;
	
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
}
