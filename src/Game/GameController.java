package Game;


public class GameController {
	private Desk desk;
	
	public void createNewGame()
	{
		desk = new Desk();
		desk.setInitialState();
	}
}
