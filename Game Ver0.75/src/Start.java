
import java.awt.Dimension;

import javax.swing.JFrame;

public class Start {

	public static void main(String[] args) throws InterruptedException { // Timer 때문에 사용
		   
		   Game game;
		   JFrame frame = new JFrame("Game");
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setPreferredSize(new Dimension(1920,1080));
			frame.setResizable(false);

			
	        Maze view = new Maze();
	       // view.setVisible(true);
			frame.getContentPane().add(view);
			
			frame.pack();
			frame.setVisible(true);
			
			while(true) {
				System.out.println("");
				if(TimeOver.success==true) {  // 미로게임 성공하면 
					System.out.println("작동중");
		            view.setVisible(false); 
		            //remove(view);
		            game = new Game();
		            game.setLayout(null);
		            frame.add(game);
		            game.setVisible(true);
		            DiaryPage d= new DiaryPage();
		    		//frame.add(d);
		    		//d.setVisible(true);
				} // end if
			} // end while
	                

	    }

}