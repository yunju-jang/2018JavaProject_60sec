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


	/*	private boolean gameOver = false;  // false=게임오버 아님 true=게임오버 되었음
	public void setGameOver() {
		TimeOver over = new TimeOver();
		gameOver=over.gameOver;
	} // setGameOver()*/
	
	public static boolean changePanel;
	
    public static int currentX=1; // maze[Y][X]의 인데스 안에 사용할 변수 --> 현재 어느 위치에 있는지 확인
    public static int currentY=1; // maze[Y][X]의 인덱스 안에 사용할 변수 --> 현재 어느 위치에 있는지 확인
    
    public static int procTime=64; // 게임 시작하면 흘러갈 시간
    public static JLabel lblShowTime; // 시간 넣을 라벨
    static Timer timer;
    static TimerTask beforeStart;
    static TimerTask timeOver;
    static TimerTask countDown;
    static TimerTask delayText;
    
    private JLabel lblAidkit, lblAxe, lblRadio, lblGasmask, lblPesticide, lblChessboard,
    			   lblFlashlight, lblMap, lblBook, lblGun, lblBullet,lblCard,
    			   lblFood1, lblFood2, lblFood3, lblFood4, lblFood5, 
    			   lblWater1, lblWater2, lblWater3, lblWater4, lblWater5,
    			   lblMom, lblDad, lblSon, lblDaughter;   // 그림 넣기 위한 라벨 준비
    
    private ImageIcon imgAidkit, imgAxe, imgRadio, imgGasmask, imgPesticide, imgChessboard,
    				  imgFlashlight, imgMap, imgBook, imgGun, imgBullet, imgCard,
    				  imgFood, imgWater, imgMom, imgDad, imgSon, imgDaughter; //  라벨에 넣을 그림 준비
    
    private int /*countAidkit, countAxe, countRadio, countGasmask, countPesticide, countChessboard,
    			countFlashlight, countMap, countBook, countGun, countBullet, countCard,
    			countFood, countWater,
    			countMom,countSon,countDaughter; // 아이템 개수값 설정*/
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
    // 아이템 먹으면 늘어나는 숫자--> 한 번 방문하면 더이상 작동 안하도록
    
    private int[] randomNum;  // 겹치지 않는 랜덤값을 각 인덱스 배열에 넣는다
    
    private int ranX,ranY; // 랜덤 x,y 좌표값
    
    private int AidkitX,AidkitY, AxeX,AxeY, RadioX,RadioY, GasmaskX,GasmaskY, PesticideX,PesticideY,
    			ChessboardX,ChessboardY, FlashlightX,FlashlightY, MapX,MapY, BookX,BookY,
    			GunX,GunY, BulletX,BulletY, CardX,CardY, Food1X,Food1Y, Food2X,Food2Y,
    			Food3X,Food3Y, Food4X,Food4Y, Food5X,Food5Y, Water1X,Water1Y, Water2X,Water2Y,
    			Water3X,Water3Y, Water4X,Water4Y, Water5X,Water5Y, 
    			MomX,MomY, SonX,SonY, DaughterX,DaughterY;   			
    // 각 아이템의 랜덤 x,y 좌표값을 저장하기 위한 변수  
    
    
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
    // Diary 게임에서 진행하기 위해 필요한 변수들 넘기기 위해 필요한 메소드
	
	private int[][] maze
        = 	{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2}, // 1 = wall 
			{1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,2,2},  // 0 = path
			{1,0,1,1,0,1,0,1,0,1,1,1,1,1,1,0,0,0,1,1},  // 2 = 시간라벨 넣을 장소
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

	      for(int j = 0;j < i;j++){ // 랜덤값 재생성 여부를 파악하기 위한 for문.
	        if(randomNum[i] == randomNum[j]){ // 중복값이 있으면..
	          i--;  // 외부 for문의 'i'값에서 -1을 해서 'randomNum[i]'에 들어갈 해당 자리의 랜덤값 재생성.
	        } // end if
	        
	      } // end for
	 } // end for
	
	return randomNum;
	
} // setRandomNumber()
	
	
	public void setItemPoint() {
		
		for(int i=0; i<25; i++) {
			
			switch(i) {
			case 0: ranX=1; ranY=3; break;    // i=0 일 때 ranX, ranY의 값을 설정한 다음 다른 스위치문에서 case문에 걸리는 아이템의 좌표값을 전달
			case 1: ranX=1; ranY=6; break;    // ranX는 배열 인덱스의 x값과 같다 --> maze[x][y]
			case 2: ranX=3; ranY=18; break;   // ranY도 마찬가지
			case 3: ranX=4; ranY=14; break;   // setBounds의 순서는 (x,y,w,h) 순서인데
			case 4: ranX=5; ranY=8; break;    // setBounds(ranX, ranY, w, h)가 아니라
			case 5: ranX=5; ranY=12; break;   // setBounds(ranY, ranX, w, h)로 설정해야 한다.
			case 6: ranX=7; ranY=1; break;    // maze[x][y] 으로 미로를 설정한다고 할 때
			case 7: ranX=7; ranY=10; break;   // 배열에서 x가 증가한다는 것은 아래쪽 방향으로 증가하는 것이 아닌 오른쪽으로 증가한다는 것인데
			case 8: ranX=7; ranY=16; break;   // frame에서 x가 증가한다는 것은 아래쪽 방향으로 증가한다는 뜻이다.
			case 9: ranX=9; ranY=11; break;   // ranX, ranY는 maze[ranX][ranY] 처럼 배열 안에 들어가는 변수이므로 
			case 10: ranX=10; ranY=13; break; // frame의 x,y 처럼 setBounds를 설정할 때는 ranX,ranY와는 X축,Y축이 반전되므로
			case 11: ranX=10; ranY=18; break; // setBounds(ranY, ranX, w, h)로 해야 위치가 맞는다. 
			case 12: ranX=11; ranY=4; break;
			case 13: ranX=12; ranY=6; break;  // 헷갈려서 적어놓자면 currentX, currentY는
			case 14: ranX=12; ranY=8; break;  // setBounds(currentX, currentY, w, h)로 설정했으므로
			case 15: ranX=13; ranY=2; break;  // 미로 위치값은 maze[currentY][currentX]로 설정해야 위치가 맞는다.
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
			case 1: AidkitX=ranX; AidkitY=ranY; break;// --> gotItem() 메소드에서 필요함 && setBounds 할 때에도 필요함
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
	
	Maze() throws InterruptedException  { // Timer 때문에 사용
        setPreferredSize(new Dimension(1920, 1080));
        setLayout(null);    
        setFocusable(true); // 패널객체가 사용자의 키보드입력 받음
        
        currentY=1; // 처음 아빠 위치 저장
        currentX=1; // 처음 아빠 위치 저장
        
//======================================== ImageIcon 생성 =========================================        
      imgAidkit = new ImageIcon("img/Image/구급상자.png");       
      imgAxe = new ImageIcon("img/Image/도끼.png"); 
      imgRadio = new ImageIcon("img/Image/라디오.png"); 
      imgGasmask = new ImageIcon("img/Image/방독면.png");  
      imgPesticide = new ImageIcon("img/Image/살충제.png"); 
      imgChessboard = new ImageIcon("img/Image/체스판.png");  
      imgFlashlight = new ImageIcon("img/Image/손전등.png"); 
      imgMap = new ImageIcon("img/Image/지도.png"); 
      imgBook = new ImageIcon("img/Image/책.png");  
      imgGun = new ImageIcon("img/Image/총.png"); 
      imgBullet = new ImageIcon("img/Image/총알.png"); 
      imgCard = new ImageIcon("img/Image/카드.png"); 
      imgFood = new ImageIcon("img/Image/식량.png"); 
      imgWater = new ImageIcon("img/Image/물병.png"); 
      imgMom = new ImageIcon("img/Image/엄마.png"); 
      imgDad = new ImageIcon("img/Image/아빠.png"); 
      imgSon = new ImageIcon("img/Image/아들.png"); 
      imgDaughter = new ImageIcon("img/Image/딸.png"); 
//====================================== END ImageIcon 생성 ==================================	
		
		setRandomNumber();
		setItemPoint();	
		// 아이템 랜덤배치
		
		
//================================ JLabel 생성 & 추가 & 위치선정 =====================================		
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
		

		
		// setItemPoint() 에서 받아온 랜덤위치값으로 위치지정
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
		// 키보드 누름에 따라 좌표값이 달라짐 --> 아빠 움직임	
		
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
		lblShowTime.setOpaque(true); // 불투명도를 참으로 설정하여 배경색을 보이게 한다
		lblShowTime.setVisible(false);
		add(lblShowTime);

		
	

	
//===================== END JLabel 생성 & 추가 & 위치선정 ==================================
		
		/*
		 * Timer 객체는 일정한 시간이 되면 TimerTask객체가 작동된다.
		 * Timer 객체에서 사용될 TimerTask 정의 --> ex) BeforeStart class, TimeOver class
		 * TimerTask는 추상클래스이므로 run 메소드를 정의해야한다. 
		 */
		

		
		timer = new Timer(true);  // Timer 객체 생성, true 매개변수의 의미는 객체의 실행이 끝나면 종료하겠다는 뜻
		beforeStart = new BeforeStart(); 
		timeOver = new TimeOver(); 
		countDown = new CountDown();
		delayText = new DelayText();
		// schedule 메소드가 사용할 TimerTask 객체 생성
	
		/*
		 * 1초 = 1000
		 * 이지만 1초가 넘어가는 시간이 너무 오래걸려서 
		 * 임의로 0.58초가 지나면 1초가 지나간걸로 한다
		 * 즉 1초 = 580 
		 */
		
		
		timer.schedule(beforeStart,580*4);// 4초 후 beforeStart 실행 (게임 시작 전 3초간의 여유를 주기 위함)
		timer.schedule(countDown, 0, 580); // procTime이 0초가 될 때까지 반복
		timer.schedule(delayText, 0, 580); // 3,2,1 Text 눈에 보이게 
		timer.schedule(timeOver, 580*64);  //  64초 후 실행 (게임은 60초동안 진행 다만 전에 3초후에 게임 실행하므로 총 63초 기다림)
		/*if(TimeOver.gameOver==false) {
        	if(BeforeStart.Start==true) {*/
		
	} // ExamPanel()
	

	
			
	public void gotItem() {
		if(currentX==Water1Y && currentY==Water1X && visitedWater01==0){  // lblWater1 위치
			lblWater1.setVisible(false);
			countWater+=4;
			visitedWater01=1;
		} // end if --> lblWater1 got!!
		
		else if(currentX==Water2Y && currentY==Water2X && visitedWater02==0 ) { // lblWater2 위치
			lblWater2.setVisible(false);
			countWater+=4;
			visitedWater02=1;
		} // end else if --> lblWater2 got!!
		
		else if(currentX==Water3Y && currentY==Water3X && visitedWater03==0 ) { // lblWater3 위치
			lblWater3.setVisible(false);
			countWater+=4;
			visitedWater03=1;
		} // end else if --> lblWater3 got!!
		
		else if(currentX==Water4Y && currentY==Water4X && visitedWater04==0 ) { // lblWater4 위치
			lblWater4.setVisible(false);
			countWater+=4;
			visitedWater04=1;
		} // end else if --> lblWater4 got!!
		
		else if(currentX==Water5Y && currentY==Water5X && visitedWater05==0 ) { // lblWater5 위치
			lblWater5.setVisible(false);
			countWater+=4;
			visitedWater05=1;
		} // end else if --> lblWater5 got!!
		
		else if(currentX==Food1Y && currentY==Food1X && visitedFood01==0 ) { // lblFood1 위치
			lblFood1.setVisible(false);
			countFood+=4;
			visitedFood01=1;
		} // end else if --> lblFood1 got!!
		
		else if(currentX==Food2Y && currentY==Food2X && visitedFood02==0 ) { // lblFood2 위치
			lblFood2.setVisible(false);
			countFood+=4;
			visitedFood02=1;
		} // end else if --> lblFood2 got!!
		
		else if(currentX==Food3Y && currentY==Food3X && visitedFood03==0 ) { // lblFood3 위치
			lblFood3.setVisible(false);
			countFood+=4;
			visitedFood03=1;
		} // end else if --> lblFood3 got!!
		
		else if(currentX==Food4Y && currentY==Food4X && visitedFood04==0 ) { // lblFood4 위치
			lblFood4.setVisible(false);
			countFood+=4;
			visitedFood04=1;
		} // end else if --> lblFood4 got!!
		
		else if(currentX==Food5Y && currentY==Food5X && visitedFood05==0 ) { // lblFood5 위치
			lblFood5.setVisible(false);
			countFood+=4;
			visitedFood05=1;
		} // end else if --> lblFood5 got!!
		
		else if(currentX==AidkitY && currentY==AidkitX ) { // lblAidkit 위치
			lblAidkit.setVisible(false);
			countAidkit=1;
		} // end else if --> lblAidkit got!!
		
		else if(currentX==AxeY && currentY==AxeX ) { // lblAxe 위치
			lblAxe.setVisible(false);
			countAxe=1;
		} // end else if --> lblAxe got!!
		
		else if(currentX==RadioY && currentY==RadioX ) { // lblRadio 위치
			lblRadio.setVisible(false);
			countRadio=1;
		} // end else if --> lblRadio got!!
		
		else if(currentX==GasmaskY && currentY==GasmaskX ) { // lblGasmask 위치
			lblGasmask.setVisible(false);
			countGasmask=1;
		} // end else if --> lblGasmask got!!
		
		else if(currentX==PesticideY && currentY==PesticideX ) { // lblPesticide 위치
			lblPesticide.setVisible(false);
			countPesticide=1;
		} // end else if --> lblPesticide got!!
		
		else if(currentX==ChessboardY && currentY==ChessboardX ) { // lblChessboard 위치
			lblChessboard.setVisible(false);
			countChessboard=1;
		} // end else if --> lblChessboard got!!
		
		else if(currentX==FlashlightY && currentY==FlashlightX ) { // lblFlashlight 위치
			lblFlashlight.setVisible(false);
			countFlashlight=1;
		} // end else if --> lblFlashlight got!!
		
		else if(currentX==MapY && currentY==MapX ) { // lblMap 위치
			lblMap.setVisible(false);
			countMap=1;
		} // end else if --> lblMap got!!
		
		else if(currentX==BookY && currentY==BookX ) { // lblBook 위치
			lblBook.setVisible(false);
			countBook=1;
		} // end else if --> lblBook got!!
		
		else if(currentX==GunY && currentY==GunX ) { // lblGun 위치
			lblGun.setVisible(false);
			countGun=1;
		} // end else if --> lblGun got!!
		
		else if(currentX==BulletY && currentY==BulletX ) { // lblBullet 위치
			lblBullet.setVisible(false);
			countBullet=1;
		} // end else if --> lblBullet got!!
		
		else if(currentX==CardY && currentY==CardX ) { // lblCard 위치
			lblCard.setVisible(false);
			countCard=1;
		} // end else if --> lblCard got!!
		
		else if(currentX==MomY && currentY==MomX) { // lblMom 위치
			lblMom.setVisible(false);
			countMom=1;
		} // end else if --> lblMom got!!
		
		else if(currentX==DaughterY && currentY==DaughterX) { // lblDaughter 위치
			lblDaughter.setVisible(false);
			countDaughter=1;
		} // end else if --> lblDaughter got!!
		
		else if(currentX==SonY && currentY==SonX ) { // lblSon 위치
			lblSon.setVisible(false);
			countSon=1;
		} // end else if --> lblSon got!!
		
		
	} // gotItem()
	
	

    public void paintComponent(Graphics g) {
    	
        super.paintComponent(g);
        
        //g.translate(8,30);
        
        // draw the maze
        for (int row = 0; row < maze.length; row++) {  // maze.length = maze의 길이 = 20
            for (int col = 0; col < maze[0].length; col++) {  // maze[0].length = maze의 행의 길이 = 20
                Color color;
                Color color2 = new Color(0x00000000, true);  // 투명으로 설정
                //Color color3 = new Color(0x55000000,true);
                switch (maze[row][col]) {
                    case 1 : color = Color.BLACK; break;  // wall.color=black
                    case 9 : color = Color.RED; break;   // Exit.color=red
                    case 2 : color = color2; // 시간라벨 넣을 곳 --> 투명하게 설정
                    default : color = color2;      // path.color=투명
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
        			// 오른쪽 방향으로 움직인다고 가정할 때 오른쪽 칸이 길일 경우
            			currentX +=1; // 배열 y축 감소 --> 오른쪽 방향 한 칸 이동
            			gotItem();
            			lblDad.setBounds(currentX*30, currentY*30, 30, 30);
        			} // end if
        		} // end if 3초 후에 움직일 수 있음
        	} // end if 타임오버되지 않는동안 구문실행
        } // VK_RIGHT
        
        else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
        	if(TimeOver.gameOver==false) {
	        	if(BeforeStart.Start==true) {
	        		if(maze[currentY][currentX-1]==0) {  
	        			// 왼쪽 방향으로 움직인다고 가정할 때 왼쪽 칸이 길일 경우
	        			currentX -=1; // 배열 y축 감소 --> 왼쪽 방향 한 칸 이동
	        			gotItem();
	        			lblDad.setBounds(currentX*30, currentY*30, 30, 30);
	        		} // end if
	        	} // end if 3초 후에 움직일 수 있음
        	} // end if 타임오버되지 않는동안 구문실행
        } // VK_LEFT
        
        else if(ke.getKeyCode()==KeyEvent.VK_UP) {
        	if(TimeOver.gameOver==false) {
	        	if(BeforeStart.Start==true) {
	        		if(maze[currentY-1][currentX]==0 ) {  
	        			// 윗쪽 방향으로 움직인다고 가정할 때 윗쪽 칸이 길일 경우
	        			currentY -=1; // 배열 x축 감소 --> 위쪽 방향 한 칸 이동
	        			gotItem();
	        			lblDad.setBounds(currentX*30, currentY*30, 30, 30);
	        		} // end if
	        	} // end if 3초 후에 움직일 수 있음
        	} // end if 타임오버되지 않는동안 구문실행
        } // VK_UP
        
        else if(ke.getKeyCode()==KeyEvent.VK_DOWN) {
        	if(TimeOver.gameOver==false) {
	    		if(BeforeStart.Start==true) {
	    			if(maze[currentY+1][currentX]==0 || maze[currentY+1][currentX]==9) {         	
	    				// 아래 방향으로 움직인다고 가정할 때 아래쪽 칸이 길일 경우
	    				currentY +=1; // 배열 x축 증가 --> 아래방향 한 칸 이동
	    				gotItem();
	    				lblDad.setBounds(currentX*30, currentY*30, 30, 30);
	  
	        		} // end if 아래 눌렀을 때 벽이 아닌 길일 경우 움직임...그 이외는 아무것도 동작 안함
	    		} // end if 3초 후에 움직일 수 있음
        	} // end if 타임오버되지 않는동안 구문실행
        } // VK_DOWN
      //  repaint(); 
        
    } // processKeyEvent()



  
  
  
    
   /*public static void main(String[] args) throws InterruptedException { // Timer 때문에 사용
		   
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
                

    }*/
	
}
