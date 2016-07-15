package Game;


public class GameController {
	private Desk desk;
	
	private static GameController instance = null;
	
	private GameController()
	{
		desk = new Desk();
	}
	
	public static GameController getInstance()
	{
		if (instance == null)
			instance = new GameController();
		return instance;
	}
	
	public void startNewGame()
	{
		desk = new Desk();
		desk.setInitialState();
	}
}
