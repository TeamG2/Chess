package UI;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import Game.Desk;
import Game.Position;
import Game.Figure.Figure;

public class GraphicUI extends JFrame implements AbstactUI {
	  JPanel panel = null;
	  Container container = null;
	
	  public GraphicUI() throws IOException{
	    super("Chess");
	    setBounds(100, 100, 600, 800);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    container = getContentPane();
	    panel = new JPanel(new GridLayout(8, 8));
	    for (int i = 0 ; i < 8; i++)
	    {
	    	for (int j = 0; j < 8; j++)	    		
	    	{
	    		BufferedImage imgBG = ImageIO.read(new File("black_cell.png"));
	            
	            BufferedImage otherImage = ImageIO.read(new File("king.png"));
	            		BufferedImage imgFG = new BufferedImage(imgBG.getWidth() - 20, imgBG.getHeight() - 20, BufferedImage.TYPE_INT_RGB);

	            		Graphics g1 = imgFG.createGraphics();
	            		g1.drawImage(otherImage, 0, 0, imgBG.getWidth() - 20, imgBG.getHeight() - 20, null);
	            		g1.dispose();
	            // For simplicity we will presume the images are of identical size
	            final BufferedImage combinedImage = new BufferedImage( 
	                    imgBG.getWidth(), 
	                    imgBG.getHeight(), 
	                    BufferedImage.TYPE_INT_ARGB );
	            Graphics2D g = combinedImage.createGraphics();
	            g.drawImage(imgBG,0,0,null);
	            g.drawImage(imgFG,0,0,null);
	            g.dispose();
	    		panel.add(new JLabel(new ImageIcon(combinedImage)));
	   // 		int plus = i % 2;
	    //		if (((j % 2) + plus) % 2 == 0)
		//    		panel.add(new JLabel(new ImageIcon("black_cell.png")));
		//    	else
		//    		panel.add(new JLabel(new ImageIcon("white_cell.png")));
	    	}		    	
	    }
	    
	    
	    
	    add(panel);
	  }

	@Override
	public void representBoard(Desk desk) {
		// TODO Auto-generated method stub
		for (int i = 7; i >= 0; i--){
			System.out.print((i + 1) + " \t");
				
			for(int j = 0; j <= 7; j++){
				Position pos = new Position(i, j);
				Figure fig = desk.getCell(pos).getFigure();
				char c= ' ';
				if (fig != null)
					c = fig.getName();
				if (c == ' ')
					System.out.print(".");
				else
					System.out.print(c);
				
			}
			System.out.println();
		}	
	}
}