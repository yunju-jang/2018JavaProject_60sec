import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.TimerTask;

import javax.swing.JPanel;

public class CountDown extends TimerTask{

	Maze maze;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Maze.procTime-=1;
		Maze.lblShowTime.setText(""+Maze.procTime);
		Maze.lblShowTime.setBackground(Color.yellow);
		
		if(Maze.procTime<60) {
		Maze.lblShowTime.setVisible(true);
		}
		if(Maze.procTime==59) {
			Font fntLabel = new Font("Verdana",Font.BOLD,30);
			Maze.lblShowTime.setFont(fntLabel);
		}
		if(Maze.procTime<1) {
			this.cancel();
		}
		
	} // run()
	
}
