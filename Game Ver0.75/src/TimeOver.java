import java.awt.Color;
import java.awt.Font;
import java.util.TimerTask;

public class TimeOver extends TimerTask {

	/*public static Game g ;
	TimeOver() throws InterruptedException{
		g = new Game();
	}*/
	public static boolean gameOver;
	public static boolean success;
	Maze maze;
	//static int n;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		gameOver = true;
		System.out.println("Time Over!!");
		Font fntLabel = new Font("Verdana",Font.BOLD,20);
		
		if(Maze.currentX==18 && Maze.currentY==18) {
			Maze.changePanel=true;
			success=true; // 시간안에 방공호 안에 들어가있음.
			System.out.println("성공!!");
			//n = 1;
			
			//g.setVisible(true);
		} // end if
		
		else {
			success=false; // 시간안에 방공호 안에 못들어감.
			System.out.println("실패!!");
			//n = 0;
		} // end else if
		
		if(success==true) {
			Maze.lblShowTime.setBackground(Color.blue);
			Maze.lblShowTime.setFont(fntLabel);
			Maze.lblShowTime.setText("Clear");	
			
		}
		if(success==false) {
			Maze.lblShowTime.setBackground(Color.RED);
			Maze.lblShowTime.setFont(fntLabel);
			Maze.lblShowTime.setText("Fail");			
		}
		
	} // run()
 
} // TimeOver class