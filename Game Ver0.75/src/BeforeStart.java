import java.util.TimerTask;

public class BeforeStart extends TimerTask {

	public static boolean Start=false; 

	@Override
	public void run() {
		
		System.out.println("START!!");
		Start=true;
	}
}
