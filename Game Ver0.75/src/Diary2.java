import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Diary2 extends JPanel {
	
	private DiaryPage diaryPage;
	private JPanel diary2Panel;
	public ImageIcon diary1background;
	
	public static int shelterFood;
	public static int shelterWater;
	private static boolean selectWaterF;
	private static boolean selectFoodF;
	private static boolean selectWaterM;
	private static boolean selectFoodM;
	private static boolean selectWaterD;
	private static boolean selectFoodD;
	private static boolean selectWaterS;
	private static boolean selectFoodS;
	
	public JLabel lblFood, lblWater;
	public static JLabel lblFood0;
	public static JLabel lblFood1;
	public static JLabel lblFood2;
	public static JLabel lblFood3;
	public static JLabel lblFood4;
	public static JLabel lblWater0;
	public static JLabel lblWater1;
	public static JLabel lblWater2;
	public static JLabel lblWater3;
	public static JLabel lblWater4;
	public static JLabel lblFoodText;
	public static JLabel lblWaterText;
	
	public JButton btnSFoodX, btnSFood, btnSWaterX, btnSWater;
	public JButton btnDFoodX, btnDFood, btnDWaterX, btnDWater;
	public JButton btnMFoodX, btnMFood, btnMWaterX, btnMWater;
	public JButton btnFFoodX, btnFFood, btnFWaterX, btnFWater;
	
	public Diary2(DiaryPage d) {
		diaryPage = d;
		setPreferredSize(new Dimension(1902, 1033));
		setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		diary1background = new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png");	//배경이미지
		   
		   diary2Panel=new JPanel() {	//배경 패널 생성
			   public void paintComponent(Graphics g) {		//배경을 그려줌
				   Dimension d =getSize();
				   g.drawImage(diary1background.getImage(), 0, 0, 1920, 1080, null);
				   setOpaque(false);
				   super.paintComponent(g);
			   }//paintComponent()
		   }; //background1
		   diary2Panel.setBounds(0,0,1920,1080);
		   diary2Panel.setLayout(null);
		   add(diary2Panel);
		
		// 식량배분 페이지 = Diary2
					lblFood = new JLabel();
					lblFood.setText("+"+(shelterFood-4));
					lblFood.setVisible(false);
					diary2Panel.add(lblFood);
					
					lblWater = new JLabel();
					lblWater.setText("+"+(shelterWater-4));
					lblWater.setVisible(false);
					diary2Panel.add(lblWater);
					
					lblFood0 = new JLabel();
					lblFood0.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food0.png"));
					lblFood0.setBounds(953, 627, 48, 63);
					lblFood0.setVisible(false);	
					diary2Panel.add(lblFood0);
					
					lblFood1 = new JLabel();
					lblFood1.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food1.png"));
					lblFood1.setBounds(953, 627, 48, 63);
					lblFood1.setVisible(false);	
					diary2Panel.add(lblFood1);
					
					lblFood2 = new JLabel();
					lblFood2.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food2.png"));
					lblFood2.setBounds(953, 627, 48, 63);
					lblFood2.setVisible(false);	
					diary2Panel.add(lblFood2);
					
					lblFood3 = new JLabel();
					lblFood3.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food3.png"));
					lblFood3.setBounds(953, 627, 48, 63);
					lblFood3.setVisible(false);	
					diary2Panel.add(lblFood3);
					
					lblFood4 = new JLabel();
					lblFood4.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food4.png"));
					lblFood4.setBounds(953, 627, 48, 63); // 845, 627, 48, 63
					lblFood4.setVisible(false);	
					diary2Panel.add(lblFood4);
					
					lblWater0 = new JLabel();
					lblWater0.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water0.png"));
					lblWater0.setBounds(957, 713, 46, 80); 
					lblWater0.setVisible(false);	
					diary2Panel.add(lblWater0);
					
					lblWater1 = new JLabel();
					lblWater1.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water1.png"));
					lblWater1.setBounds(957, 713, 46, 80);
					lblWater1.setVisible(false);	
					diary2Panel.add(lblWater1);
					
					lblWater2 = new JLabel();
					lblWater2.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water2.png"));
					lblWater2.setBounds(957, 713, 46, 80);
					lblWater2.setVisible(false);	
					diary2Panel.add(lblWater2);
					
					lblWater3 = new JLabel();
					lblWater3.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water3.png"));
					lblWater3.setBounds(957, 713, 46, 80);
					lblWater3.setVisible(false);	
					diary2Panel.add(lblWater3);
					
					lblWater4 = new JLabel();
					lblWater4.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water4.png"));
					lblWater4.setBounds(957, 713, 46, 80); //851, 716, 44, 78
					lblWater4.setVisible(false);	
					diary2Panel.add(lblWater4);
					
					lblFoodText = new JLabel(""+shelterFood/4);
					lblFoodText.setVisible(false);
					diary2Panel.add(lblFoodText);
					
					lblWaterText = new JLabel(""+shelterWater/4);
					lblWaterText.setVisible(false);
					diary2Panel.add(lblWaterText);
					
					JButton btnSFoodX = new JButton();
					btnSFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
					btnSFoodX.setBounds(1217, 483, 45, 54);
					btnSFoodX.addActionListener(diaryPage.diaryL);
					btnSFoodX.setVisible(false);
					diary2Panel.add(btnSFoodX);
					
					JButton btnSFood = new JButton();
					btnSFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
					btnSFood.setBounds(1217, 483, 45, 54);
					btnSFood.addActionListener(diaryPage.diaryL);
					btnSFood.setVisible(false);
					diary2Panel.add(btnSFood);
					
					JButton btnSWaterX = new JButton();
					btnSWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
					btnSWaterX.setBounds(1177, 480, 33, 55);
					btnSWaterX.addActionListener(diaryPage.diaryL);
					btnSWaterX.setVisible(false);
					diary2Panel.add(btnSWaterX);
					
					JButton btnSWater = new JButton();
					btnSWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
					btnSWater.setBounds(1177, 480, 33, 55);
					btnSWater.addActionListener(diaryPage.diaryL);
					btnSWater.setVisible(false);
					diary2Panel.add(btnSWater);
					
					JButton btnDFoodX = new JButton();
					btnDFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
					btnDFoodX.setBounds(1093, 483, 45, 54);
					btnDFoodX.addActionListener(diaryPage.diaryL);
					btnDFoodX.setVisible(false);
					diary2Panel.add(btnDFoodX);
					
					JButton btnDFood = new JButton();
					btnDFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
					btnDFood.setBounds(1093, 483, 45, 54);
					btnDFood.addActionListener(diaryPage.diaryL);
					btnDFood.setVisible(false);
					diary2Panel.add(btnDFood);
					
					JButton btnDWaterX = new JButton();
					btnDWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
					btnDWaterX.setBounds(1054, 480, 33, 55);
					btnDWaterX.addActionListener(diaryPage.diaryL);
					btnDWaterX.setVisible(false);
					diary2Panel.add(btnDWaterX);
					
					JButton btnDWater = new JButton();
					btnDWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
					btnDWater.setBounds(1054, 480, 33, 55);
					btnDWater.addActionListener(diaryPage.diaryL);
					btnDWater.setVisible(false);
					diary2Panel.add(btnDWater);
					
					JButton btnMFoodX = new JButton();
					btnMFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
					btnMFoodX.setBounds(953, 483, 45, 54);
					btnMFoodX.addActionListener(diaryPage.diaryL);
					btnMFoodX.setVisible(false);
					diary2Panel.add(btnMFoodX);
					
					JButton btnMFood = new JButton();
					btnMFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
					btnMFood.setBounds(953, 483, 45, 54);
					btnMFood.addActionListener(diaryPage.diaryL);
					btnMFood.setVisible(false);
					diary2Panel.add(btnMFood);
					
					JButton btnMWaterX = new JButton();
					btnMWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
					btnMWaterX.setBounds(913, 480, 33, 55);
					btnMWaterX.addActionListener(diaryPage.diaryL);
					btnMWaterX.setVisible(false);
					diary2Panel.add(btnMWaterX);
					
					JButton btnMWater = new JButton();
					btnMWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
					btnMWater.setBounds(913, 480, 33, 55);
					btnMWater.addActionListener(diaryPage.diaryL);
					btnMWater.setVisible(false);
					diary2Panel.add(btnMWater);
					
					JButton btnFFoodX = new JButton();
					btnFFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
					btnFFoodX.setBounds(823, 483, 45, 54);
					btnFFoodX.addActionListener(diaryPage.diaryL);
					btnFFoodX.setVisible(false);
					diary2Panel.add(btnFFoodX);
					
					JButton btnFFood = new JButton();
					btnFFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
					btnFFood.setBounds(823, 483, 45, 54);
					btnFFood.addActionListener(diaryPage.diaryL);
					btnFFood.setVisible(false);
					diary2Panel.add(btnFFood);
					
					JButton btnFWaterX = new JButton();
					btnFWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
					btnFWaterX.setBounds(781, 480, 33, 55);
					btnFWaterX.addActionListener(diaryPage.diaryL);
					btnFWaterX.setVisible(false);
					diary2Panel.add(btnFWaterX);
					
					JButton btnFWater = new JButton();
					btnFWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
					btnFWater.setBounds(781, 480, 33, 55);
					btnFWater.addActionListener(diaryPage.diaryL);
					btnFWater.setVisible(false);
					diary2Panel.add(btnFWater);
		
		
	} // Diary2()
	
	public static void distributionFood() {
		if(selectFoodF == true || selectFoodM == true || selectFoodD == true || selectFoodS == true) {
			shelterFood--;
			if(shelterFood%4 == 0 && shelterFood == 0) {
				lblFoodText.setText(" >> 0");
				lblFood0.setVisible(true);
			} else if(shelterFood%4 == 1 ) {
				lblFoodText.setText(" >> " + shelterFood/4);
				lblFood1.setVisible(true);
			} else if(shelterFood%4 == 2 ) {
				lblFoodText.setText(" >> " + shelterFood/4);
				lblFood2.setVisible(true);
			} else if(shelterFood%4 == 3 ) {
				lblFoodText.setText(" >> " + shelterFood/4);
				lblFood3.setVisible(true);
			} else if(shelterFood%4 == 0 ) {
				lblFoodText.setText(" >> " + shelterFood/4);
				lblFood4.setVisible(true);
			} // if..else if
		} else {
			shelterFood++;
			if(shelterFood%4 == 0 && shelterFood == 0) {
				lblFood0.setVisible(true);
				lblFoodText.setText(" >> 0");
			} else if(shelterFood%4 == 1 ) {
				lblFoodText.setText(" >> " + shelterFood/4);
				lblFood1.setVisible(true);
			} else if(shelterFood%4 == 2 ) {
				lblFoodText.setText(" >> " + shelterFood/4);
				lblFood2.setVisible(true);
			} else if(shelterFood%4 == 3 ) {
				lblFoodText.setText(" >> " + shelterFood/4);
				lblFood3.setVisible(true);
			} else if(shelterFood%4 == 0 ) {
				lblFoodText.setText(" >> " + shelterFood/4);
				lblFood4.setVisible(true);
			} // if..else if
		}
	} // distributionFood()
	
	public static void distributionWater() {
		if(selectWaterF == true || selectWaterM == true || selectWaterD == true || selectWaterS == true) {
			shelterWater--;
			if(shelterWater%4 == 0 && shelterWater == 0) {
				lblWater0.setVisible(true);
				lblWaterText.setText(" >> 0");
			} else if(shelterWater%4 == 1 ) {
				lblWaterText.setText(" >> " + shelterWater/4);
				lblWater1.setVisible(true);
			} else if(shelterWater%4 == 2 ) {
				lblWaterText.setText(" >> " + shelterWater/4);
				lblWater2.setVisible(true);
			} else if(shelterWater%4 == 3 ) {
				lblWaterText.setText(" >> " + shelterWater/4);
				lblWater3.setVisible(true);
			} else if(shelterWater%4 == 0 ) {
				lblWaterText.setText(" >> " + shelterWater/4);
				lblWater4.setVisible(true);
			} // if..else if
		} else {
			shelterWater++;
			if(shelterWater%4 == 0 && shelterWater == 0) {
				lblWater0.setVisible(true);
				lblWaterText.setText(" >> 0");
			} else if(shelterWater%4 == 1 ) {
				lblWaterText.setText(" >> " + shelterWater/4);
				lblWater1.setVisible(true);
			} else if(shelterWater%4 == 2 ) {
				lblWaterText.setText(" >> " + shelterWater/4);
				lblWater2.setVisible(true);
			} else if(shelterWater%4 == 3 ) {
				lblWaterText.setText(" >> " + shelterWater/4);
				lblWater3.setVisible(true);
			} else if(shelterWater%4 == 0 ) {
				lblWaterText.setText(" >> " + shelterWater/4);
				lblWater4.setVisible(true);
			} // if..else if
			}
	} // distributionWater()
	public class DiaryL implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton btn = (JButton)event.getSource();
			// 식량배분 버튼
				if(btn==btnFWaterX && shelterWater>0) // 물이 하나도 없으면 작동 안함
				{
					btnFWaterX.setVisible(false);
					btnFWater.setVisible(true);
					selectWaterF = true; // 아빠 물 마셨다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionWater();
				} else if(btn==btnFWater)
				{
					btnFWater.setVisible(false); // 아빠 물미선택사진으로 바꾸기
					btnFWaterX.setVisible(true);
					selectWaterF = false; // 아빠 물 안마셨다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionWater();
				} // if..else if
				if(btn==btnFFoodX && shelterFood>0) // 음식 없으면 작동 안함 
				{
					btnFFoodX.setVisible(false); // 아빠 음식미택사진으로 바꾸기
					btnFFood.setVisible(true);
					selectFoodF = true; // 아빠 음식 먹었다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionFood();
				} else if(btn==btnFFood)
				{
					btnFFood.setVisible(false); // 아빠 음식미선택사진으로 바꾸기
					btnFFoodX.setVisible(true);
					selectFoodF = false; // 아빠 음식 안먹었다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionFood();
				} // if..else if
				
				if(btn==btnMWaterX && shelterWater>0) // 물이 하나도 없으면 작동 안함
				{
					btnMWaterX.setVisible(false);
					btnMWater.setVisible(true);
					selectWaterM = true; // 엄마 물 마셨다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionWater();
				} else if(btn==btnMWater)
				{
					btnMWater.setVisible(false); // 엄마 물미선택사진으로 바꾸기
					btnMWaterX.setVisible(true);
					selectWaterM = false; // 엄마 물 안마셨다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionWater();
				} // if..else if
				if(btn==btnMFoodX && shelterFood>0) // 음식 없으면 작동 안함 
				{
					btnMFoodX.setVisible(false); // 엄마 음식미택사진으로 바꾸기
					btnMFood.setVisible(true);
					selectFoodM = true; // 엄마 음식 먹었다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionFood();
				} else if(btn==btnMFood)
				{
					btnMFood.setVisible(false); // 엄마 음식미선택사진으로 바꾸기
					btnMFoodX.setVisible(true);
					selectFoodM = false; // 엄마 음식 안먹었다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionFood();
				} // if..else if
				
				if(btn==btnDWaterX && shelterWater>0) // 물이 하나도 없으면 작동 안함
				{
					btnDWaterX.setVisible(false);
					btnDWater.setVisible(true);
					selectWaterD = true; // 엄마 물 마셨다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionWater();
				} else if(btn==btnDWater)
				{
					btnDWater.setVisible(false); // 엄마 물미선택사진으로 바꾸기
					btnDWaterX.setVisible(true);
					selectWaterD = false; // 엄마 물 안마셨다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionWater();
				} // if..else if
				if(btn==btnDFoodX && shelterFood>0) // 음식 없으면 작동 안함 
				{
					btnDFoodX.setVisible(false); // 엄마 음식미택사진으로 바꾸기
					btnDFood.setVisible(true);
					selectFoodD = true; // 엄마 음식 먹었다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionFood();
				} else if(btn==btnDFood)
				{
					btnDFood.setVisible(false); // 엄마 음식미선택사진으로 바꾸기
					btnDFoodX.setVisible(true);
					selectFoodD = false; // 엄마 음식 안먹었다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionFood();
				} // if..else if
				
				if(btn==btnSWaterX && shelterWater>0) // 물이 하나도 없으면 작동 안함
				{
					btnSWaterX.setVisible(false);
					btnSWater.setVisible(true);
					selectWaterS = true; // 엄마 물 마셨다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionWater();
				} else if(btn==btnSWater)
				{
					btnSWater.setVisible(false); // 엄마 물미선택사진으로 바꾸기
					btnSWaterX.setVisible(true);
					selectWaterS = false; // 엄마 물 안마셨다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionWater();
				} // // if..else if
				if(btn==btnSFoodX && shelterFood>0) // 음식 없으면 작동 안함 
				{
					btnSFoodX.setVisible(false); // 엄마 음식미택사진으로 바꾸기
					btnSFood.setVisible(true);
					selectFoodS = true; // 엄마 음식 먹었다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionFood();
				} else if(btn==btnSFood)
				{
					btnSFood.setVisible(false); // 엄마 음식미선택사진으로 바꾸기
					btnSFoodX.setVisible(true);
					selectFoodS = false; // 엄마 음식 안먹었다고 가족상태 클래스에 넘기기 위한 변수
					Diary2.distributionFood();
				} // if..else if
		}
	}
				
}
