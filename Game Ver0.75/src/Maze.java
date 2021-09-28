import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Maze extends JPanel {


	/*	private boolean gameOver = false;  // false=���ӿ��� �ƴ� true=���ӿ��� �Ǿ���
	public void setGameOver() {
		TimeOver over = new TimeOver();
		gameOver=over.gameOver;
	} // setGameOver()*/
	
	public static boolean changePanel;
	
    public static int currentX=1; // maze[Y][X]�� �ε��� �ȿ� ����� ���� --> ���� ��� ��ġ�� �ִ��� Ȯ��
    public static int currentY=1; // maze[Y][X]�� �ε��� �ȿ� ����� ���� --> ���� ��� ��ġ�� �ִ��� Ȯ��
    
    public static int procTime=64; // ���� �����ϸ� �귯�� �ð�
    public static JLabel lblShowTime; // �ð� ���� ��
    static Timer timer;
    static TimerTask beforeStart;
    static TimerTask timeOver;
    static TimerTask countDown;
    static TimerTask delayText;
    
    private JLabel lblAidkit, lblAxe, lblRadio, lblGasmask, lblPesticide, lblChessboard,
    			   lblFlashlight, lblMap, lblBook, lblGun, lblBullet,lblCard,
    			   lblFood1, lblFood2, lblFood3, lblFood4, lblFood5, 
    			   lblWater1, lblWater2, lblWater3, lblWater4, lblWater5,
    			   lblMom, lblDad, lblSon, lblDaughter;   // �׸� �ֱ� ���� �� �غ�
    
    private ImageIcon imgAidkit, imgAxe, imgRadio, imgGasmask, imgPesticide, imgChessboard,
    				  imgFlashlight, imgMap, imgBook, imgGun, imgBullet, imgCard,
    				  imgFood, imgWater, imgMom, imgDad, imgSon, imgDaughter; //  �󺧿� ���� �׸� �غ�
    
    private int /*countAidkit, countAxe, countRadio, countGasmask, countPesticide, countChessboard,
    			countFlashlight, countMap, countBook, countGun, countBullet, countCard,
    			countFood, countWater,
    			countMom,countSon,countDaughter; // ������ ������ ����*/
    countAidkit= 0;
    private int countAxe= 0;
    private int  countRadio= 0;
    private int  countGasmask= 0;
    private int  countPesticide= 0;
    private int  countChessboard = 0;
    private int countFlashlight= 0;
    private int	countMap= 0;
    private int countBook= 0;
    private int countGun= 0;
    private int countBullet= 0;
    private int	countCard = 0;
    private int	countFood= 0;
    private int	countWater= 0;
    private int	countMom= 0;
    private int	countSon= 0;
    private int countDaughter = 0;
		   
    
    private int visitedWater01,visitedWater02, visitedWater03, visitedWater04, visitedWater05,
    			visitedFood01, visitedFood02, visitedFood03, visitedFood04, visitedFood05;
    // ������ ������ �þ�� ����--> �� �� �湮�ϸ� ���̻� �۵� ���ϵ���
    
    private int[] randomNum;  // ��ġ�� �ʴ� �������� �� �ε��� �迭�� �ִ´�
    
    private int ranX,ranY; // ���� x,y ��ǥ��
    
    private int AidkitX,AidkitY, AxeX,AxeY, RadioX,RadioY, GasmaskX,GasmaskY, PesticideX,PesticideY,
    			ChessboardX,ChessboardY, FlashlightX,FlashlightY, MapX,MapY, BookX,BookY,
    			GunX,GunY, BulletX,BulletY, CardX,CardY, Food1X,Food1Y, Food2X,Food2Y,
    			Food3X,Food3Y, Food4X,Food4Y, Food5X,Food5Y, Water1X,Water1Y, Water2X,Water2Y,
    			Water3X,Water3Y, Water4X,Water4Y, Water5X,Water5Y, 
    			MomX,MomY, SonX,SonY, DaughterX,DaughterY;   			
    // �� �������� ���� x,y ��ǥ���� �����ϱ� ���� ����  
    
    
    public int getWater() { return countWater; }
    public int getFood() { return countFood; }
    public int getAidkit() { return countAidkit; }
    public int getAxe() { return countAxe; }
    public int getRadio() { return countRadio; }
    public int getGasmask() { return countGasmask; }
    public int getPesticide() { return countPesticide; }
    public int getChessboard() { return countChessboard; }
    public int getFlashlight() { return countFlashlight; }
    public int getMap() { return countMap; }
    public int getBook() { return countBook; }
    public int getGun() { return countGun; }
    public int getBullet() { return countBullet; }
    public int getCard() { return countCard; }
    public int getMom() { return countMom; }
    public int getSon() { return countSon; }
    public int getDaughter() { return countDaughter; }
    // Diary ���ӿ��� �����ϱ� ���� �ʿ��� ������ �ѱ�� ���� �ʿ��� �޼ҵ�
	
	private int[][] maze
        = 	{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2}, // 1 = wall 
			{1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,2,2},  // 0 = path
			{1,0,1,1,0,1,0,1,0,1,1,1,1,1,1,0,0,0,1,1},  // 2 = �ð��� ���� ���
			{1,0,0,0,0,1,0,1,0,1,0,0,0,0,1,1,1,0,0,1},
			{1,0,1,1,1,1,0,1,0,1,0,1,1,0,0,0,0,1,1,1},
			{1,0,0,0,0,0,0,1,0,0,0,1,0,0,1,1,0,0,0,1},
			{1,1,1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
			{1,0,1,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,1,0,1,1,1,1,1,0,1,0,0,0,1},
			{1,0,0,0,1,0,0,1,0,1,1,0,1,1,0,1,1,1,1,1},
			{1,0,1,1,1,1,0,1,0,0,0,0,1,0,0,0,0,0,0,1},
			{1,0,0,0,0,1,0,1,0,1,1,1,1,0,1,0,1,1,1,1},
			{1,1,1,1,0,1,0,1,0,0,0,0,0,0,1,0,1,1,0,1},
			{1,0,0,1,0,1,0,1,0,1,1,1,1,1,1,0,0,0,0,1},
			{1,0,1,1,0,1,0,1,0,1,0,0,0,0,1,1,1,0,1,1},
			{1,0,0,0,0,1,0,1,0,0,0,1,1,0,1,0,0,0,1,1}, 
			{1,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,1,0,0,1},
			{1,1,0,1,0,0,0,1,0,1,0,1,1,0,1,0,1,1,0,1},
			{1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,1,9,1}, // define the target
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}}; // node as "9" at position(18,18)
	
	
	public int[] setRandomNumber(){
		randomNum = new int[25];
		Random generator = new Random();
		for(int i = 0; i < 25; i++) {
	      randomNum[i] = generator.nextInt(25)+1; // From 1 ~ 25

	      for(int j = 0;j < i;j++){ // ������ ����� ���θ� �ľ��ϱ� ���� for��.
	        if(randomNum[i] == randomNum[j]){ // �ߺ����� ������..
	          i--;  // �ܺ� for���� 'i'������ -1�� �ؼ� 'randomNum[i]'�� �� �ش� �ڸ��� ������ �����.
	        } // end if
	        
	      } // end for
	 } // end for
	
	return randomNum;
	
} // setRandomNumber()
	
	
	public void setItemPoint() {
		
		for(int i=0; i<25; i++) {
			
			switch(i) {
			case 0: ranX=1; ranY=3; break;    // i=0 �� �� ranX, ranY�� ���� ������ ���� �ٸ� ����ġ������ case���� �ɸ��� �������� ��ǥ���� ����
			case 1: ranX=1; ranY=6; break;    // ranX�� �迭 �ε����� x���� ���� --> maze[x][y]
			case 2: ranX=3; ranY=18; break;   // ranY�� ��������
			case 3: ranX=4; ranY=14; break;   // setBounds�� ������ (x,y,w,h) �����ε�
			case 4: ranX=5; ranY=8; break;    // setBounds(ranX, ranY, w, h)�� �ƴ϶�
			case 5: ranX=5; ranY=12; break;   // setBounds(ranY, ranX, w, h)�� �����ؾ� �Ѵ�.
			case 6: ranX=7; ranY=1; break;    // maze[x][y] ���� �̷θ� �����Ѵٰ� �� ��
			case 7: ranX=7; ranY=10; break;   // �迭���� x�� �����Ѵٴ� ���� �Ʒ��� �������� �����ϴ� ���� �ƴ� ���������� �����Ѵٴ� ���ε�
			case 8: ranX=7; ranY=16; break;   // frame���� x�� �����Ѵٴ� ���� �Ʒ��� �������� �����Ѵٴ� ���̴�.
			case 9: ranX=9; ranY=11; break;   // ranX, ranY�� maze[ranX][ranY] ó�� �迭 �ȿ� ���� �����̹Ƿ� 
			case 10: ranX=10; ranY=13; break; // frame�� x,y ó�� setBounds�� ������ ���� ranX,ranY�ʹ� X��,Y���� �����ǹǷ�
			case 11: ranX=10; ranY=18; break; // setBounds(ranY, ranX, w, h)�� �ؾ� ��ġ�� �´´�. 
			case 12: ranX=11; ranY=4; break;
			case 13: ranX=12; ranY=6; break;  // �򰥷��� ������ڸ� currentX, currentY��
			case 14: ranX=12; ranY=8; break;  // setBounds(currentX, currentY, w, h)�� ���������Ƿ�
			case 15: ranX=13; ranY=2; break;  // �̷� ��ġ���� maze[currentY][currentX]�� �����ؾ� ��ġ�� �´´�.
			case 16: ranX=14; ranY=10; break;
			case 17: ranX=18; ranY=1; break;
			case 18: ranX=18; ranY=6; break;
			case 19: ranX=18; ranY=12; break;
			case 20: ranX=18; ranY=16; break;
			case 21: ranX=9; ranY=3; break;
			case 22: ranX=7; ranY=5; break;
			case 23: ranX=18; ranY=8; break;
			case 24: ranX=12; ranY=18; break;
			} // end switch
			
			
			switch(randomNum[i]) {
			case 1: AidkitX=ranX; AidkitY=ranY; break;// --> gotItem() �޼ҵ忡�� �ʿ��� && setBounds �� ������ �ʿ���
			case 2: AxeX=ranX; AxeY=ranY; break;
			case 3: RadioX=ranX; RadioY=ranY; break;
			case 4: GasmaskX=ranX; GasmaskY=ranY; break;
			case 5: PesticideX=ranX; PesticideY=ranY; break;
			case 6: ChessboardX=ranX; ChessboardY=ranY; break;
			case 7: FlashlightX=ranX; FlashlightY=ranY; break;
			case 8: MapX=ranX; MapY=ranY; break;
			case 9: BookX=ranX; BookY=ranY; break;
			case 10: GunX=ranX; GunY=ranY; break;
			case 11: BulletX=ranX; BulletY=ranY; break;
			case 12: CardX=ranX; CardY=ranY; break;
			case 13: Food1X=ranX; Food1Y=ranY; break;
			case 14: Food2X=ranX; Food2Y=ranY; break;
			case 15: Food3X=ranX; Food3Y=ranY; break;
			case 16: Food4X=ranX; Food4Y=ranY; break;
			case 17: Food5X=ranX; Food5Y=ranY; break;
			case 18: Water1X=ranX; Water1Y=ranY; break;
			case 19: Water2X=ranX; Water2Y=ranY; break;
			case 20: Water3X=ranX; Water3Y=ranY; break;
			case 21: Water4X=ranX; Water4Y=ranY; break;
			case 22: Water5X=ranX; Water5Y=ranY; break;
			case 23: MomX=ranX; MomY=ranY; break;
			case 24: SonX=ranX; SonY=ranY; break;
			case 25: DaughterX=ranX; DaughterY=ranY; break;	
			} // end switch

		} // end for
		
	} // setItemPoint()
	
	Maze() throws InterruptedException  { // Timer ������ ���
        setPreferredSize(new Dimension(1920, 1080));
        setLayout(null);    
        setFocusable(true); // �гΰ�ü�� ������� Ű�����Է� ����
        
        currentY=1; // ó�� �ƺ� ��ġ ����
        currentX=1; // ó�� �ƺ� ��ġ ����
        
//======================================== ImageIcon ���� =========================================        
      imgAidkit = new ImageIcon("img/Image/���޻���.png");       
      imgAxe = new ImageIcon("img/Image/����.png"); 
      imgRadio = new ImageIcon("img/Image/����.png"); 
      imgGasmask = new ImageIcon("img/Image/�浶��.png");  
      imgPesticide = new ImageIcon("img/Image/������.png"); 
      imgChessboard = new ImageIcon("img/Image/ü����.png");  
      imgFlashlight = new ImageIcon("img/Image/������.png"); 
      imgMap = new ImageIcon("img/Image/����.png"); 
      imgBook = new ImageIcon("img/Image/å.png");  
      imgGun = new ImageIcon("img/Image/��.png"); 
      imgBullet = new ImageIcon("img/Image/�Ѿ�.png"); 
      imgCard = new ImageIcon("img/Image/ī��.png"); 
      imgFood = new ImageIcon("img/Image/�ķ�.png"); 
      imgWater = new ImageIcon("img/Image/����.png"); 
      imgMom = new ImageIcon("img/Image/����.png"); 
      imgDad = new ImageIcon("img/Image/�ƺ�.png"); 
      imgSon = new ImageIcon("img/Image/�Ƶ�.png"); 
      imgDaughter = new ImageIcon("img/Image/��.png"); 
//====================================== END ImageIcon ���� ==================================	
		
		setRandomNumber();
		setItemPoint();	
		// ������ ������ġ
		
		
//================================ JLabel ���� & �߰� & ��ġ���� =====================================		
		lblAidkit = new JLabel(imgAidkit);         
		lblAxe = new JLabel(imgAxe);
		lblRadio= new JLabel(imgRadio);            
		lblGasmask= new JLabel(imgGasmask);
		lblPesticide= new JLabel(imgPesticide);    
		lblChessboard= new JLabel(imgChessboard);
		lblFlashlight= new JLabel(imgFlashlight);      
		lblMap= new JLabel(imgMap);
		lblBook= new JLabel(imgBook);              
		lblGun= new JLabel(imgGun);
		lblBullet= new JLabel(imgBullet);          
		lblCard= new JLabel(imgCard);
		lblMom = new JLabel(imgMom);			   
		lblDad = new JLabel(imgDad);
		lblSon = new JLabel(imgSon);			   
		lblDaughter = new JLabel(imgDaughter);
		
		lblFood1= new JLabel(imgFood);             lblWater1= new JLabel(imgWater);
		lblFood2= new JLabel(imgFood);             lblWater2= new JLabel(imgWater);
		lblFood3= new JLabel(imgFood);             lblWater3= new JLabel(imgWater);
		lblFood4= new JLabel(imgFood);             lblWater4= new JLabel(imgWater);
		lblFood5= new JLabel(imgFood);             lblWater5= new JLabel(imgWater);
		

		
		// setItemPoint() ���� �޾ƿ� ������ġ������ ��ġ����
		lblAidkit.setBounds(AidkitY*30, AidkitX*30, 30, 30);           			add(lblAidkit);
		lblAxe.setBounds(AxeY*30, AxeX*30, 30, 30);              				add(lblAxe);
		lblRadio.setBounds(RadioY*30, RadioX*30, 30, 30);            			add(lblRadio);
		lblGasmask.setBounds(GasmaskY*30, GasmaskX*30, 30, 30);          		add(lblGasmask);
		lblPesticide.setBounds(PesticideY*30, PesticideX*30, 30, 30);           add(lblPesticide);
		lblChessboard.setBounds(ChessboardY*30, ChessboardX*30, 30, 30);        add(lblChessboard);
		lblFlashlight.setBounds(FlashlightY*30, FlashlightX*30, 30, 30);        add(lblFlashlight);
		lblMap.setBounds(MapY*30, MapX*30, 30, 30);             				add(lblMap);
		lblBook.setBounds(BookY*30, BookX*30, 30, 30);             				add(lblBook);
		lblGun.setBounds(GunY*30, GunX*30, 30, 30);             	 			add(lblGun);
		lblBullet.setBounds(BulletY*30, BulletX*30, 30, 30);         			add(lblBullet);
		lblCard.setBounds(CardY*30, CardX*30, 30, 30);          	 			add(lblCard);
		lblMom.setBounds(MomY*30, MomX*30, 30, 30);            		 			add(lblMom);
		lblDaughter.setBounds(DaughterY*30, DaughterX*30, 30, 30);        		add(lblDaughter);
		lblSon.setBounds(SonY*30, SonX*30, 30, 30);          					add(lblSon);
		
		lblDad.setBounds(currentX*30, currentY*30, 25, 25);    add(lblDad);
		// Ű���� ������ ���� ��ǥ���� �޶��� --> �ƺ� ������	
		
		lblFood1.setBounds(Food1Y*30, Food1X*30, 30, 30);          add(lblFood1);
		lblFood2.setBounds(Food2Y*30, Food2X*30, 30, 30);          add(lblFood2);
		lblFood3.setBounds(Food3Y*30, Food3X*30, 30, 30);          add(lblFood3);
		lblFood4.setBounds(Food4Y*30, Food4X*30, 30, 30);          add(lblFood4);
		lblFood5.setBounds(Food5Y*30, Food5X*30, 30, 30);          add(lblFood5);
		
		lblWater1.setBounds(Water1Y*30, Water1X*30, 30, 30);         add(lblWater1);
		lblWater2.setBounds(Water2Y*30, Water2X*30, 30, 30);         add(lblWater2);
		lblWater3.setBounds(Water3Y*30, Water3X*30, 30, 30);         add(lblWater3);
		lblWater4.setBounds(Water4Y*30, Water4X*30, 30, 30);         add(lblWater4);
		lblWater5.setBounds(Water5Y*30, Water5X*30, 30, 30);         add(lblWater5);
		
		lblShowTime = new JLabel(""+procTime);
//		lblShowTime.setBackground(Color.yellow);
		lblShowTime.setVerticalAlignment(SwingConstants.CENTER);
		lblShowTime.setHorizontalAlignment(SwingConstants.CENTER);
		Font fntLabel = new Font("Verdana",Font.BOLD,30);
		lblShowTime.setFont(fntLabel);
		lblShowTime.setBounds(18*30, 0*30, 60, 60);
		lblShowTime.setOpaque(true); // �������� ������ �����Ͽ� ������ ���̰� �Ѵ�
		lblShowTime.setVisible(false);
		add(lblShowTime);

		
	

	
//===================== END JLabel ���� & �߰� & ��ġ���� ==================================
		
		/*
		 * Timer ��ü�� ������ �ð��� �Ǹ� TimerTask��ü�� �۵��ȴ�.
		 * Timer ��ü���� ���� TimerTask ���� --> ex) BeforeStart class, TimeOver class
		 * TimerTask�� �߻�Ŭ�����̹Ƿ� run �޼ҵ带 �����ؾ��Ѵ�. 
		 */
		

		
		timer = new Timer(true);  // Timer ��ü ����, true �Ű������� �ǹ̴� ��ü�� ������ ������ �����ϰڴٴ� ��
		beforeStart = new BeforeStart(); 
		timeOver = new TimeOver(); 
		countDown = new CountDown();
		delayText = new DelayText();
		// schedule �޼ҵ尡 ����� TimerTask ��ü ����
	
		/*
		 * 1�� = 1000
		 * ������ 1�ʰ� �Ѿ�� �ð��� �ʹ� �����ɷ��� 
		 * ���Ƿ� 0.58�ʰ� ������ 1�ʰ� �������ɷ� �Ѵ�
		 * �� 1�� = 580 
		 */
		
		
		timer.schedule(beforeStart,580*4);// 4�� �� beforeStart ���� (���� ���� �� 3�ʰ��� ������ �ֱ� ����)
		timer.schedule(countDown, 0, 580); // procTime�� 0�ʰ� �� ������ �ݺ�
		timer.schedule(delayText, 0, 580); // 3,2,1 Text ���� ���̰� 
		timer.schedule(timeOver, 580*64);  //  64�� �� ���� (������ 60�ʵ��� ���� �ٸ� ���� 3���Ŀ� ���� �����ϹǷ� �� 63�� ��ٸ�)
		/*if(TimeOver.gameOver==false) {
        	if(BeforeStart.Start==true) {*/
		
	} // ExamPanel()
	

	
			
	public void gotItem() {
		if(currentX==Water1Y && currentY==Water1X && visitedWater01==0){  // lblWater1 ��ġ
			lblWater1.setVisible(false);
			countWater+=4;
			visitedWater01=1;
		} // end if --> lblWater1 got!!
		
		else if(currentX==Water2Y && currentY==Water2X && visitedWater02==0 ) { // lblWater2 ��ġ
			lblWater2.setVisible(false);
			countWater+=4;
			visitedWater02=1;
		} // end else if --> lblWater2 got!!
		
		else if(currentX==Water3Y && currentY==Water3X && visitedWater03==0 ) { // lblWater3 ��ġ
			lblWater3.setVisible(false);
			countWater+=4;
			visitedWater03=1;
		} // end else if --> lblWater3 got!!
		
		else if(currentX==Water4Y && currentY==Water4X && visitedWater04==0 ) { // lblWater4 ��ġ
			lblWater4.setVisible(false);
			countWater+=4;
			visitedWater04=1;
		} // end else if --> lblWater4 got!!
		
		else if(currentX==Water5Y && currentY==Water5X && visitedWater05==0 ) { // lblWater5 ��ġ
			lblWater5.setVisible(false);
			countWater+=4;
			visitedWater05=1;
		} // end else if --> lblWater5 got!!
		
		else if(currentX==Food1Y && currentY==Food1X && visitedFood01==0 ) { // lblFood1 ��ġ
			lblFood1.setVisible(false);
			countFood+=4;
			visitedFood01=1;
		} // end else if --> lblFood1 got!!
		
		else if(currentX==Food2Y && currentY==Food2X && visitedFood02==0 ) { // lblFood2 ��ġ
			lblFood2.setVisible(false);
			countFood+=4;
			visitedFood02=1;
		} // end else if --> lblFood2 got!!
		
		else if(currentX==Food3Y && currentY==Food3X && visitedFood03==0 ) { // lblFood3 ��ġ
			lblFood3.setVisible(false);
			countFood+=4;
			visitedFood03=1;
		} // end else if --> lblFood3 got!!
		
		else if(currentX==Food4Y && currentY==Food4X && visitedFood04==0 ) { // lblFood4 ��ġ
			lblFood4.setVisible(false);
			countFood+=4;
			visitedFood04=1;
		} // end else if --> lblFood4 got!!
		
		else if(currentX==Food5Y && currentY==Food5X && visitedFood05==0 ) { // lblFood5 ��ġ
			lblFood5.setVisible(false);
			countFood+=4;
			visitedFood05=1;
		} // end else if --> lblFood5 got!!
		
		else if(currentX==AidkitY && currentY==AidkitX ) { // lblAidkit ��ġ
			lblAidkit.setVisible(false);
			countAidkit=1;
		} // end else if --> lblAidkit got!!
		
		else if(currentX==AxeY && currentY==AxeX ) { // lblAxe ��ġ
			lblAxe.setVisible(false);
			countAxe=1;
		} // end else if --> lblAxe got!!
		
		else if(currentX==RadioY && currentY==RadioX ) { // lblRadio ��ġ
			lblRadio.setVisible(false);
			countRadio=1;
		} // end else if --> lblRadio got!!
		
		else if(currentX==GasmaskY && currentY==GasmaskX ) { // lblGasmask ��ġ
			lblGasmask.setVisible(false);
			countGasmask=1;
		} // end else if --> lblGasmask got!!
		
		else if(currentX==PesticideY && currentY==PesticideX ) { // lblPesticide ��ġ
			lblPesticide.setVisible(false);
			countPesticide=1;
		} // end else if --> lblPesticide got!!
		
		else if(currentX==ChessboardY && currentY==ChessboardX ) { // lblChessboard ��ġ
			lblChessboard.setVisible(false);
			countChessboard=1;
		} // end else if --> lblChessboard got!!
		
		else if(currentX==FlashlightY && currentY==FlashlightX ) { // lblFlashlight ��ġ
			lblFlashlight.setVisible(false);
			countFlashlight=1;
		} // end else if --> lblFlashlight got!!
		
		else if(currentX==MapY && currentY==MapX ) { // lblMap ��ġ
			lblMap.setVisible(false);
			countMap=1;
		} // end else if --> lblMap got!!
		
		else if(currentX==BookY && currentY==BookX ) { // lblBook ��ġ
			lblBook.setVisible(false);
			countBook=1;
		} // end else if --> lblBook got!!
		
		else if(currentX==GunY && currentY==GunX ) { // lblGun ��ġ
			lblGun.setVisible(false);
			countGun=1;
		} // end else if --> lblGun got!!
		
		else if(currentX==BulletY && currentY==BulletX ) { // lblBullet ��ġ
			lblBullet.setVisible(false);
			countBullet=1;
		} // end else if --> lblBullet got!!
		
		else if(currentX==CardY && currentY==CardX ) { // lblCard ��ġ
			lblCard.setVisible(false);
			countCard=1;
		} // end else if --> lblCard got!!
		
		else if(currentX==MomY && currentY==MomX) { // lblMom ��ġ
			lblMom.setVisible(false);
			countMom=1;
		} // end else if --> lblMom got!!
		
		else if(currentX==DaughterY && currentY==DaughterX) { // lblDaughter ��ġ
			lblDaughter.setVisible(false);
			countDaughter=1;
		} // end else if --> lblDaughter got!!
		
		else if(currentX==SonY && currentY==SonX ) { // lblSon ��ġ
			lblSon.setVisible(false);
			countSon=1;
		} // end else if --> lblSon got!!
		
		
	} // gotItem()
	
	

    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        
        //g.translate(8,30);
        
        // draw the maze
        for (int row = 0; row < maze.length; row++) {  // maze.length = maze�� ���� = 20
            for (int col = 0; col < maze[0].length; col++) {  // maze[0].length = maze�� ���� ���� = 20
                Color color;
                Color color2 = new Color(0x00000000, true);  // �������� ����
                //Color color3 = new Color(0x55000000,true);
                switch (maze[row][col]) {
                    case 1 : color = Color.BLACK; break;  // wall.color=black
                    case 9 : color = Color.RED; break;   // Exit.color=red
                    case 2 : color = color2; // �ð��� ���� �� --> �����ϰ� ����
                    default : color = color2;      // path.color=����
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                
            } // end for
            
        } // end for
        
        
        // draw circle      
//        g.setColor(Color.RED);
       // g.fillOval(currentX * 30, currentY * 30, 30, 30);
        //repaint();
        
    } // paint()
    
    
    protected void processKeyEvent(KeyEvent ke) {
        if (ke.getID() != KeyEvent.KEY_RELEASED) {
            return;
        } // Pressed
        
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
        	if(TimeOver.gameOver==false) {
        		if(BeforeStart.Start==true) {
        			if(maze[currentY][currentX+1]==0 ) {  
        			// ������ �������� �����δٰ� ������ �� ������ ĭ�� ���� ���
            			currentX +=1; // �迭 y�� ���� --> ������ ���� �� ĭ �̵�
            			gotItem();
            			lblDad.setBounds(currentX*30, currentY*30, 30, 30);
        			} // end if
        		} // end if 3�� �Ŀ� ������ �� ����
        	} // end if Ÿ�ӿ������� �ʴµ��� ��������
        } // VK_RIGHT
        
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        	if(TimeOver.gameOver==false) {
	        	if(BeforeStart.Start==true) {
	        		if(maze[currentY][currentX-1]==0) {  
	        			// ���� �������� �����δٰ� ������ �� ���� ĭ�� ���� ���
	        			currentX -=1; // �迭 y�� ���� --> ���� ���� �� ĭ �̵�
	        			gotItem();
	        			lblDad.setBounds(currentX*30, currentY*30, 30, 30);
	        		} // end if
	        	} // end if 3�� �Ŀ� ������ �� ����
        	} // end if Ÿ�ӿ������� �ʴµ��� ��������
        } // VK_LEFT
        
        else if(ke.getKeyCode()==KeyEvent.VK_UP) {
        	if(TimeOver.gameOver==false) {
	        	if(BeforeStart.Start==true) {
	        		if(maze[currentY-1][currentX]==0 ) {  
	        			// ���� �������� �����δٰ� ������ �� ���� ĭ�� ���� ���
	        			currentY -=1; // �迭 x�� ���� --> ���� ���� �� ĭ �̵�
	        			gotItem();
	        			lblDad.setBounds(currentX*30, currentY*30, 30, 30);
	        		} // end if
	        	} // end if 3�� �Ŀ� ������ �� ����
        	} // end if Ÿ�ӿ������� �ʴµ��� ��������
        } // VK_UP
        
        else if(ke.getKeyCode()==KeyEvent.VK_DOWN) {
        	if(TimeOver.gameOver==false) {
	    		if(BeforeStart.Start==true) {
	    			if(maze[currentY+1][currentX]==0 || maze[currentY+1][currentX]==9) {         	
	    				// �Ʒ� �������� �����δٰ� ������ �� �Ʒ��� ĭ�� ���� ���
	    				currentY +=1; // �迭 x�� ���� --> �Ʒ����� �� ĭ �̵�
	    				gotItem();
	    				lblDad.setBounds(currentX*30, currentY*30, 30, 30);
	  
	        		} // end if �Ʒ� ������ �� ���� �ƴ� ���� ��� ������...�� �ܴ̿� �ƹ��͵� ���� ����
	    		} // end if 3�� �Ŀ� ������ �� ����
        	} // end if Ÿ�ӿ������� �ʴµ��� ��������
        } // VK_DOWN
      //  repaint(); 
        
    } // processKeyEvent()



  
  
  
    
   /*public static void main(String[] args) throws InterruptedException { // Timer ������ ���
		   
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
			if(TimeOver.success==true) {  // �̷ΰ��� �����ϸ� 
				System.out.println("�۵���");
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
                

    }*/
	
}
