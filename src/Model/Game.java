package Model;

public class Game {
	private Desk desk;
	
	public void createNewGame()
	{
		desk = new Desk();
		desk.setInitialState();
	}
}
