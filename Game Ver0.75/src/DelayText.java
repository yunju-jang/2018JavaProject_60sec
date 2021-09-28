import java.awt.Color;
import java.awt.Font;
import java.util.TimerTask;

public class DelayText extends TimerTask {
	private int delaySec=3;
	static int n;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Maze.lblShowTime.setVisible(true);
		Maze.lblShowTime.setText(""+ delaySec);
		Maze.lblShowTime.setBackground(Color.green);
		Font fntLabel = new Font("Verdana",Font.BOLD,20);
		
		if(delaySec<1) {
			Maze.lblShowTime.setFont(fntLabel);
			Maze.lblShowTime.setText("GO!");
			this.cancel();
		} // end if
		delaySec-=1;
	} // run()

} // DelayText()
