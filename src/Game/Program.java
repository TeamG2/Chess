package Game;

import java.io.IOException;

import UI.GraphicUI;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		 GraphicUI app;
//		try {
//			app = new GraphicUI();
//			app.setVisible(true); 
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} //Создаем экземпляр нашего приложения
//		 
		
		GameController.getInstance().startNewGame();
	}

}
