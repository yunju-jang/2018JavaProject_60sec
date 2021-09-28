import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Diary4 extends JPanel {
	private DiaryPage diaryPage;
	private JPanel diary4Panel;
	public ImageIcon diary4background;
	
	private ConPanel father, mother, daughter, son;
	
	public JLabel lblFoodText, lblWaterText, lblFoodFText, lblFoodMText, lblFoodDText, lblFoodSText;
	public JLabel lblWaterFText, lblWaterMText, lblWaterDText, lblWaterSText;
	public JLabel lblFood0,lblFood1, lblFood2, lblFood3, lblFood4;
	public JLabel lblWater0, lblWater1, lblWater2, lblWater3, lblWater4;
	public JLabel lblDiary15, lblDiary14, lblDiary13, lblDiary12;
	public JLabel lblDiary11, lblDiary10, lblDiary9, lblDiary8, lblDiary7;
	public JLabel lblDiary6, lblDiary5, lblDiary4, lblDiary3;
	public JLabel lblDiary2, lblDiary1, lblNormalDiary, lblTestDiary;
	public JLabel lblDiaryF, lblDiaryFX, lblDiaryM, lblDiaryMX, lblDiaryD;
	public JLabel lblDiaryDX, lblDiaryS, lblDiarySX, lblDay, lblFood, lblWater, lblBlack;
	public JLabel lblSDiary1, lblSDiary2, lblSDiary3, lblSDiary4, lblSurvive, lblDie;
	
	public JButton btnSFoodX, btnSFood, btnSWaterX, btnSWater;
	public JButton btnDFoodX, btnDFood, btnDWaterX, btnDWater;
	public JButton btnMFoodX, btnMFood, btnMWaterX, btnMWater;
	public JButton btnFFoodX, btnFFood, btnFWaterX, btnFWater;
	
	public JButton btnGunX, btnChessboardX, btnGasmaskX, btnFlashlightX;
	public JButton btnAxeX, btnAidkitX, btnBookX, btnPesticideX;
	public JButton btnCardX, btnMapX, btnRadioX;
	
	public JButton btnSelectionO, btnSelectionX, btnSelectionBackB;
	public JButton btnSelectionRightB, btnSelectionLeftB;
	public JButton btnSelectionBullet, btnSelectionGun;
	public JButton btnSelectionChessboard, btnSelectionGasmask;
	public JButton btnSelectionFlashlight, btnSelectionAxe;
	public JButton btnSelectionAidkit, btnSelectionBook;
	public JButton btnSelectionPesticide, btnSelectionCard;
	public JButton btnSelectionRadio, btnSelectionMap, btnOpenDiary;
	
	public JButton btnO, btnX, btnBackB, btnRightB, btnLeftB;
	public JButton btnBullet, btnGun, btnChessboard, btnGasmask;
	public JButton btnFlashlight, btnAxe, btnAidkit, btnBook;
	public JButton btnPesticide, btnCard, btnRadio, btnMap;
	
	public JLabel lblOpenDiary, lblShelterFood2, lblShelterFood3, lblShelterFood1;
	public JLabel lblShelterWater4, lblShelterWater3, lblShelterWater2, lblShelterWater1; 
	public JLabel lblCard, lblBullet, lblGunBreak, lblGun, lblChessboard;
	public JLabel lblBook, lblFlashlightBreak, lblFlashlight, lblPesticide, lblGasmaskBreak;
	public JLabel lblGasmask, lblRadioBreak, lblRadio, lblMapBreak, lblMap, lblAxe;
	public JLabel lblAidkitUse, lblAidkit, lblShelter;
	public JLabel lblFConText, lblMConText, lblDConText, lblSConText, lblSCon, lblDCon, lblMCon, lblFCon, lblAdvFX,lblAdvDX,lblAdvMX,lblAdvSX; // 탐험 불가능한 상태 이미지
	
	public JButton btnAdvF, btnAdvSelectF, btnAdvM,  btnAdvSelectM, btnAdvD, btnAdvSelectD, btnAdvS,  btnAdvSelectS;
	private int isOutside; // 누군가가 탐험 나갔다면 1, 아무도 탐험중이 아니면 0
	private int isOutsideM, isOutsideF, isOutsideS, isOutsideD; // 각 가족이 탐험중인지 아닌지
	private int randomAdv; // 얼마나 오랫동안 탐험할지 저장하는 변수 --> 즉 탐험기간
	
	private JLabel lblIsOutsideM, lblIsOutsideF, lblIsOutsideD, lblIsOutsideS;
	
	private int eda, leaveHomeDay; // adventure() 참고
	private int ranWater, ranFood, ranCard, ranBullet, ranGun, ranChessboard, ranBook,
				ranFlashlight, ranPesticide, ranMap, ranGasmask, ranRadio, ranAxe, ranAidkit;
	// 랜덤으로 아이템 가져올것인지 아닌지 받는 변수
	
	private int tempWaterM, tempFoodM, tempMindM, tempConditionM, tempHealthM;
	private int tempWaterF, tempFoodF, tempMindF, tempConditionF, tempHealthF;
	private int tempWaterS, tempFoodS, tempMindS, tempConditionS, tempHealthS;
	private int tempWaterD, tempFoodD, tempMindD, tempConditionD, tempHealthD;
	// 탐험 가기 전 가족의 상태를 저장해 놓는 변수
	
	private boolean backHomeM, backHomeF, backHomeS, backHomeD;
	// 누가 탐험에서 돌아왔는지 확인하기 위한 변수
	
	private JLabel lblTotalGotItem; // 탐험에서 얻은 아이템들을 적은 텍스트라벨
	private String gotRadio, gotBullet, gotGun, gotChessboard, gotBook, gotFlashlight,
				gotPesticide, gotMap, gotGasmask, gotAxe, gotAidkit,gotCard, gotWater, gotFood;
	// 탐험에서 아이템을 얻었는지 안얻었는지 텍스트를 담은 변수들..lblTotalGotItem에 모두 집어넣을 거임
	
	private JLabel lblIsOutside, lblComeBack; // diaryPage 1쪽에서 누나 나갔는지, 혹은 누가 돌아왔는지 나타내는 텍스트 라벨
	

	public int currentSelected; // 탐험 현재 고른 사람
	// 엄마=1, 아빠=2, 아들=3, 딸=4
	public DiaryL diaryL; // ActionListener
	
	
	
	public Diary4(DiaryPage d) {
		diaryPage = d;
		setPreferredSize(new Dimension(1902, 1033));
		setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		diary4background = new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png");	//배경이미지
		   
		   diary4Panel=new JPanel() {	//배경 패널 생성
			   public void paintComponent(Graphics g) {		//배경을 그려줌
				   Dimension d =getSize();
				   g.drawImage(diary4background.getImage(), 0, 0, 1920, 1080, null);
				   setOpaque(false);
				   super.paintComponent(g);
			   }//paintComponent()
		   }; //background4
		   diary4Panel.setBounds(0,0,1920,1080);
		   diary4Panel.setLayout(null);
		   add(diary4Panel);
		   
		   diaryL = new DiaryL();
		
	    btnOpenDiary = new JButton();
	    btnOpenDiary.setVisible(false);
	    btnOpenDiary.setIcon(new ImageIcon("img/StuffSrc/Shelter_DiarySelection.png"));
	    btnOpenDiary.setLocation(1592, 746);
	    btnOpenDiary.setSize(201, 197);
	    btnOpenDiary.addActionListener(diaryL);
	    diary4Panel.add(btnOpenDiary);
	    
	    lblSCon = new JLabel();
		lblSCon.setVisible(false);
		lblSCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/S.png"));
		lblSCon.setBounds(821, 575, 80, 109);
		diary4Panel.add(lblSCon);
		
		lblDCon = new JLabel();
		lblDCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/D.png"));
		lblDCon.setBounds(809, 448, 105, 125);
		lblDCon.setVisible(false);
		diary4Panel.add(lblDCon);
		
		lblMCon = new JLabel();
		lblMCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/M.png"));
		lblMCon.setBounds(809, 324, 104, 121);
		lblMCon.setVisible(false);
	    diary4Panel.add(lblMCon);
		
		lblFCon = new JLabel();
		lblFCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/F.png"));
		lblFCon.setBounds(817, 207, 88, 114);
		lblFCon.setVisible(false);
		diary4Panel.add(lblFCon);
		
		JButton btnAdvS = new JButton();
		btnAdvS.setIcon(new ImageIcon("DiarySr/Adventure/S__SelectionX.png"));
		btnAdvS.setBounds(1208, 699, 80, 114);
		btnAdvS.setVisible(false);
		diary4Panel.add(btnAdvS);
		btnAdvS.addActionListener(diaryL);
		
		lblAdvSX = new JLabel();
		lblAdvSX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Sx.png"));
		lblAdvSX.setBounds(1183, 699, 136, 121);
		lblAdvSX.setVisible(false);
		diary4Panel.add(lblAdvSX);
		
		JButton btnAdvSelectS = new JButton();
		btnAdvSelectS.setIcon(new ImageIcon("DiarySr/Adventure/S.png"));
		btnAdvSelectS.setBounds(1209, 698, 80, 109);
		btnAdvSelectS.addActionListener(diaryL);
		btnAdvSelectS.setVisible(false);
		diary4Panel.add(btnAdvSelectS);
		
		lblAdvDX = new JLabel();
		lblAdvDX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Dx.png"));
		lblAdvDX.setBounds(1060, 684, 117, 129);
		lblAdvDX.setVisible(false);
		diary4Panel.add(lblAdvDX);
		
		JButton btnAdvD = new JButton();
		btnAdvD.setIcon(new ImageIcon("DiarySr/Adventure/D__SelectionX.png"));
		btnAdvD.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdvD.setBounds(1060, 684, 113, 129);
		btnAdvD.addActionListener(diaryL);
		btnAdvD.setVisible(false);
		diary4Panel.add(btnAdvD);
		
		JButton btnAdvSelectD = new JButton();
		btnAdvSelectD.setIcon(new ImageIcon("DiarySr/Adventure/D.png"));
		btnAdvSelectD.setBounds(1063, 686, 105, 125);
		btnAdvSelectD.addActionListener(diaryL);
		btnAdvSelectD.setVisible(false);
		diary4Panel.add(btnAdvSelectD);
		
		JButton btnAdvM = new JButton();
		btnAdvM.setIcon(new ImageIcon("DiarySr/Adventure/M__SelectionX.png"));
		btnAdvM.setBounds(941, 689, 105, 124);
		btnAdvM.addActionListener(diaryL);
		btnAdvM.setVisible(false);
		diary4Panel.add(btnAdvM);
		
		lblAdvMX = new JLabel();
		lblAdvMX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Mx.png"));
		lblAdvMX.setBounds(929, 670, 132, 165);
		lblAdvMX.setVisible(false);
		diary4Panel.add(lblAdvMX);
		
		JButton btnAdvSelectM = new JButton();
		btnAdvSelectM.setIcon(new ImageIcon("DiarySr/Adventure/M.png"));
		btnAdvSelectM.setBounds(943, 690, 104, 121);
		btnAdvSelectM.addActionListener(diaryL);
		btnAdvSelectM.setVisible(false);
		diary4Panel.add(btnAdvSelectM);
		
		JButton btnAdvF = new JButton();
		btnAdvF.setIcon(new ImageIcon("DiarySr/Adventure/F__SelectionX.png"));
		btnAdvF.setBounds(819, 695, 91, 118);
		btnAdvF.addActionListener(diaryL);
		btnAdvF.setVisible(false);
		diary4Panel.add(btnAdvF);
		
		lblAdvFX = new JLabel();
		lblAdvFX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Fx.png"));
		lblAdvFX.setBounds(791, 669, 143, 167);
		lblAdvFX.setVisible(false);
		diary4Panel.add(lblAdvFX);
		
		JButton btnAdvSelectF = new JButton();
		btnAdvSelectF.setIcon(new ImageIcon("DiarySr/Adventure/F.png"));
		btnAdvSelectF.setBounds(821, 696, 88, 114);
		btnAdvSelectF.addActionListener(diaryL);
		btnAdvSelectF.setVisible(false);
		diary4Panel.add(btnAdvSelectF);
		
		lblSConText = new JLabel("Son is okay to go on an expedition.");
		lblSConText.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		lblSConText.setBounds(943, 608, 334, 42);
		lblSConText.setVisible(false);
		diary4Panel.add(lblSConText);
		
		lblDConText = new JLabel("Daughter is okay to go on an expedition.");
		lblDConText.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		lblDConText.setBounds(943, 488, 334, 42);
		lblDConText.setVisible(false);
		diary4Panel.add(lblDConText);
		
		lblMConText = new JLabel("Mother is okay to go on an expedition.");
		lblMConText.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		lblMConText.setBounds(943, 361, 334, 42);
		lblMConText.setVisible(false);
		diary4Panel.add(lblMConText);
		
		lblFConText = new JLabel("Father is okay to go on an expedition.");
		lblFConText.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		lblFConText.setBounds(943, 246, 334, 42);
		lblFConText.setVisible(false);
		diary4Panel.add(lblFConText);
		
		// Day
		lblDay = new JLabel();
		lblDay.setLocation(1000, 128);
		lblDay.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 38));
		lblDay.setSize(129, 72);
		lblDay.setText(diaryPage.nDay+"일"); // 정수형 nDay를 텍스트로 변환
		lblDay.setVisible(false);
		diary4Panel.add(lblDay);
		
		// 전날 변동사항 표시해주는 페이지 = nDiary1
		lblFoodText = new JLabel(""+Game.shelterFood/4);
		lblFoodText.setVisible(false);
		diary4Panel.add(lblFoodText);
		
		lblWaterText = new JLabel(""+Game.shelterWater/4);
		lblWaterText.setVisible(false);
		diary4Panel.add(lblWaterText);
		
		lblFoodFText = new JLabel();
		lblFoodFText.setVisible(false);
		diary4Panel.add(lblFoodFText);
		
		lblFoodMText = new JLabel();
		lblFoodMText.setVisible(false);
		diary4Panel.add(lblFoodMText);
		
		lblFoodDText = new JLabel();
		lblFoodDText.setVisible(false);
		diary4Panel.add(lblFoodDText);
		
		lblFoodSText = new JLabel();
		lblFoodSText.setVisible(false);
		diary4Panel.add(lblFoodSText);
		
		lblWaterFText = new JLabel();
		lblWaterFText.setVisible(false);
		diary4Panel.add(lblWaterFText);
		
		lblWaterMText = new JLabel();
		lblWaterMText.setVisible(false);
		diary4Panel.add(lblWaterMText);
		
		lblWaterDText = new JLabel();
		lblWaterDText.setVisible(false);
		diary4Panel.add(lblWaterDText);
		
		lblWaterSText = new JLabel();
		lblWaterSText.setVisible(false);
		diary4Panel.add(lblWaterSText);
		
		lblIsOutside = new JLabel();
		lblIsOutside.setVisible(false);
		diary4Panel.add(lblIsOutside);
		
		lblComeBack = new JLabel();
		lblComeBack.setVisible(false);
		diary4Panel.add(lblComeBack);
		
		lblTotalGotItem = new JLabel();
		lblTotalGotItem.setVisible(false);
		add(lblTotalGotItem);
		
		
		// 식량배분 페이지 = nDiary2
		lblFood = new JLabel();
		lblFood.setText("+"+(Game.shelterFood-4));
		lblFood.setVisible(false);
		diary4Panel.add(lblFood);
		
		lblWater = new JLabel();
		lblWater.setText("+"+(Game.shelterWater-4));
		lblWater.setVisible(false);
		diary4Panel.add(lblWater);
		
		lblFood0 = new JLabel();
		lblFood0.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food0.png"));
		lblFood0.setBounds(953, 627, 48, 63);
		lblFood0.setVisible(false);	
		diary4Panel.add(lblFood0);
		
		lblFood1 = new JLabel();
		lblFood1.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food1.png"));
		lblFood1.setBounds(953, 627, 48, 63);
		lblFood1.setVisible(false);	
		diary4Panel.add(lblFood1);
		
		lblFood2 = new JLabel();
		lblFood2.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food2.png"));
		lblFood2.setBounds(953, 627, 48, 63);
		lblFood2.setVisible(false);	
		diary4Panel.add(lblFood2);
		
		lblFood3 = new JLabel();
		lblFood3.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food3.png"));
		lblFood3.setBounds(953, 627, 48, 63);
		lblFood3.setVisible(false);	
		diary4Panel.add(lblFood3);
		
		lblFood4 = new JLabel();
		lblFood4.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food4.png"));
		lblFood4.setBounds(953, 627, 48, 63); // 845, 627, 48, 63
		lblFood4.setVisible(false);	
		diary4Panel.add(lblFood4);
		
		lblWater0 = new JLabel();
		lblWater0.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water0.png"));
		lblWater0.setBounds(957, 713, 46, 80); 
		lblWater0.setVisible(false);	
		diary4Panel.add(lblWater0);
		
		lblWater1 = new JLabel();
		lblWater1.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water1.png"));
		lblWater1.setBounds(957, 713, 46, 80);
		lblWater1.setVisible(false);	
		diary4Panel.add(lblWater1);
		
		lblWater2 = new JLabel();
		lblWater2.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water2.png"));
		lblWater2.setBounds(957, 713, 46, 80);
		lblWater2.setVisible(false);	
		diary4Panel.add(lblWater2);
		
		lblWater3 = new JLabel();
		lblWater3.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water3.png"));
		lblWater3.setBounds(957, 713, 46, 80);
		lblWater3.setVisible(false);	
		diary4Panel.add(lblWater3);
		
		lblWater4 = new JLabel();
		lblWater4.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water4.png"));
		lblWater4.setBounds(957, 713, 46, 80); //851, 716, 44, 78
		lblWater4.setVisible(false);	
		diary4Panel.add(lblWater4);
		
		JButton btnSFoodX = new JButton();
		btnSFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		btnSFoodX.setBounds(1217, 483, 45, 54);
		btnSFoodX.addActionListener(diaryL);
		btnSFoodX.setVisible(false);
		diary4Panel.add(btnSFoodX);
		
		JButton btnSFood = new JButton();
		btnSFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		btnSFood.setBounds(1217, 483, 45, 54);
		btnSFood.addActionListener(diaryL);
		btnSFood.setVisible(false);
		diary4Panel.add(btnSFood);
		
		JButton btnSWaterX = new JButton();
		btnSWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		btnSWaterX.setBounds(1177, 480, 33, 55);
		btnSWaterX.addActionListener(diaryL);
		btnSWaterX.setVisible(false);
		diary4Panel.add(btnSWaterX);
		
		JButton btnSWater = new JButton();
		btnSWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		btnSWater.setBounds(1177, 480, 33, 55);
		btnSWater.addActionListener(diaryL);
		btnSWater.setVisible(false);
		diary4Panel.add(btnSWater);
		
		JButton btnDFoodX = new JButton();
		btnDFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		btnDFoodX.setBounds(1093, 483, 45, 54);
		btnDFoodX.addActionListener(diaryL);
		btnDFoodX.setVisible(false);
		diary4Panel.add(btnDFoodX);
		
		JButton btnDFood = new JButton();
		btnDFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		btnDFood.setBounds(1093, 483, 45, 54);
		btnDFood.addActionListener(diaryL);
		btnDFood.setVisible(false);
		diary4Panel.add(btnDFood);
		
		JButton btnDWaterX = new JButton();
		btnDWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		btnDWaterX.setBounds(1054, 480, 33, 55);
		btnDWaterX.addActionListener(diaryL);
		btnDWaterX.setVisible(false);
		diary4Panel.add(btnDWaterX);
		
		JButton btnDWater = new JButton();
		btnDWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		btnDWater.setBounds(1054, 480, 33, 55);
		btnDWater.addActionListener(diaryL);
		btnDWater.setVisible(false);
		diary4Panel.add(btnDWater);
		
		JButton btnMFoodX = new JButton();
		btnMFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		btnMFoodX.setBounds(953, 483, 45, 54);
		btnMFoodX.addActionListener(diaryL);
		btnMFoodX.setVisible(false);
		diary4Panel.add(btnMFoodX);
		
		JButton btnMFood = new JButton();
		btnMFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		btnMFood.setBounds(953, 483, 45, 54);
		btnMFood.addActionListener(diaryL);
		btnMFood.setVisible(false);
		diary4Panel.add(btnMFood);
		
		JButton btnMWaterX = new JButton();
		btnMWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		btnMWaterX.setBounds(913, 480, 33, 55);
		btnMWaterX.addActionListener(diaryL);
		btnMWaterX.setVisible(false);
		diary4Panel.add(btnMWaterX);
		
		JButton btnMWater = new JButton();
		btnMWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		btnMWater.setBounds(913, 480, 33, 55);
		btnMWater.addActionListener(diaryL);
		btnMWater.setVisible(false);
		diary4Panel.add(btnMWater);
		
		JButton btnFFoodX = new JButton();
		btnFFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		btnFFoodX.setBounds(823, 483, 45, 54);
		btnFFoodX.addActionListener(diaryL);
		btnFFoodX.setVisible(false);
		diary4Panel.add(btnFFoodX);
		
		JButton btnFFood = new JButton();
		btnFFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		btnFFood.setBounds(823, 483, 45, 54);
		btnFFood.addActionListener(diaryL);
		btnFFood.setVisible(false);
		diary4Panel.add(btnFFood);
		
		JButton btnFWaterX = new JButton();
		btnFWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		btnFWaterX.setBounds(781, 480, 33, 55);
		btnFWaterX.addActionListener(diaryL);
		btnFWaterX.setVisible(false);
		diary4Panel.add(btnFWaterX);
		
		JButton btnFWater = new JButton();
		btnFWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		btnFWater.setBounds(781, 480, 33, 55);
		btnFWater.addActionListener(diaryL);
		btnFWater.setVisible(false);
		diary4Panel.add(btnFWater);
		
	    lblDiarySX = new JLabel();
	    lblDiarySX.setIcon(new ImageIcon("img/DiarySrc/Distribution/SX.png"));
	    lblDiarySX.setBounds(1170, 357, 136, 125);
	    lblDiarySX.setVisible(false);
	    diary4Panel.add(lblDiarySX);
	      
        lblDiaryS = new JLabel();
	    lblDiaryS.setIcon(new ImageIcon("img/DiarySrc/Distribution/S.png"));
	    lblDiaryS.setBounds(1195, 357, 80, 109);
	    lblDiaryS.setVisible(false);
	    diary4Panel.add(lblDiaryS);
	      
	    lblDiaryDX = new JLabel();
	    lblDiaryDX.setIcon(new ImageIcon("img/DiarySrc/Distribution/DX.png"));
	    lblDiaryDX.setBounds(1037, 344, 117, 129);
	    lblDiaryDX.setVisible(false);
	    diary4Panel.add(lblDiaryDX);
	      
	    lblDiaryD = new JLabel();
	    lblDiaryD.setIcon(new ImageIcon("img/DiarySrc/Distribution/D.png"));
	    lblDiaryD.setBounds(1040, 346, 105, 125);
	    lblDiaryD.setVisible(false);
	    diary4Panel.add(lblDiaryD);
	      
	    lblDiaryMX = new JLabel();
	    lblDiaryMX.setIcon(new ImageIcon("img/DiarySrc/Distribution/MX.png"));
	    lblDiaryMX.setBounds(891, 330, 132, 165);
	    lblDiaryMX.setVisible(false);
	    diary4Panel.add(lblDiaryMX);
	      
	    lblDiaryM = new JLabel();
        lblDiaryM.setIcon(new ImageIcon("img/DiarySrc/Distribution/M.png"));
	    lblDiaryM.setBounds(905, 349, 104, 121);
	    lblDiaryM.setVisible(false);
	    diary4Panel.add(lblDiaryM);
	      
	    lblDiaryFX = new JLabel();
	    lblDiaryFX.setIcon(new ImageIcon("img/DiarySrc/Distribution/FX.png"));
	    lblDiaryFX.setBounds(750, 332, 143, 167);
	    lblDiaryFX.setVisible(false);
	    diary4Panel.add(lblDiaryFX);
	      
	    lblDiaryF = new JLabel();
	    lblDiaryF.setIcon(new ImageIcon("img/DiarySrc/Distribution/F.png"));
	    lblDiaryF.setBounds(777, 360, 88, 114);
	    lblDiaryF.setVisible(false);
	    diary4Panel.add(lblDiaryF);
	    //diary4Panel.add(lblTestDiary);
		
		// 물건 X
		JButton btnGunX = new JButton();
		btnGunX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/GunX.png"));
		btnGunX.setBounds(1101, 666, 126, 119);
		btnGunX.addActionListener(diaryL);
		btnGunX.setVisible(false);
		diary4Panel.add(btnGunX);
		
		JButton btnChessboardX = new JButton();
		btnChessboardX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/ChessboardX.png"));
		btnChessboardX.setBounds(1212, 706, 119, 71);
		btnChessboardX.addActionListener(diaryL);
		btnChessboardX.setVisible(false);
		diary4Panel.add(btnChessboardX);
		
		JButton btnGasmaskX = new JButton();
		btnGasmaskX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/GasmaskX.png"));
		btnGasmaskX.setBounds(909, 683, 95, 120);
		btnGasmaskX.addActionListener(diaryL);
		btnGasmaskX.setVisible(false);
		diary4Panel.add(btnGasmaskX);
		
		JButton btnFlashlightX = new JButton();
		btnFlashlightX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/FlashlightX.png"));
		btnFlashlightX.setBounds(1028, 691, 112, 94);
		btnFlashlightX.addActionListener(diaryL);
		btnFlashlightX.setVisible(false);
		diary4Panel.add(btnFlashlightX);
		
		JButton btnAxeX = new JButton();
		btnAxeX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/AxeX.png"));
		btnAxeX.setBounds(1006, 666, 118, 110);
		btnAxeX.addActionListener(diaryL);
		btnAxeX.setVisible(false);
		diary4Panel.add(btnAxeX);
		
		JButton btnAidkitX = new JButton();
		btnAidkitX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/AidkitX.png"));
		btnAidkitX.setBounds(1105, 706, 88, 74);
		btnAidkitX.addActionListener(diaryL);
		btnAidkitX.setVisible(false);
		diary4Panel.add(btnAidkitX);
		
		JButton btnBookX = new JButton();
		btnBookX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/BookX.png"));
		btnBookX.setBounds(998, 706, 93, 87);
		btnBookX.addActionListener(diaryL);
		btnBookX.setVisible(false);
		diary4Panel.add(btnBookX);
		
		JButton btnPesticideX = new JButton();
		btnPesticideX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/PesticideX.png"));
		btnPesticideX.setBounds(907, 695, 46, 96);
		btnPesticideX.addActionListener(diaryL);
		btnPesticideX.setVisible(false);
		diary4Panel.add(btnPesticideX);
		
		JButton btnCardX = new JButton();
		btnCardX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/CardX.png"));
		btnCardX.setBounds(984, 684, 91, 102);
		btnCardX.addActionListener(diaryL);
		btnCardX.setVisible(false);
		diary4Panel.add(btnCardX);
		
		JButton btnMapX = new JButton();
		btnMapX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/MapX.png"));
		btnMapX.setBounds(883, 706, 120, 89);
		btnMapX.addActionListener(diaryL);
		btnMapX.setVisible(false);
		diary4Panel.add(btnMapX);
		
		JButton btnRadioX = new JButton();
		btnRadioX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/Radio_Selection.png"));
		btnRadioX.setBounds(1092, 701, 116, 84);
		btnRadioX.addActionListener(diaryL);
		btnRadioX.setVisible(false);
		diary4Panel.add(btnRadioX);
		
		// 버튼 _SelectionO
		JButton btnSelectionO = new JButton();
		btnSelectionO.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/O_Selection.png"));
		btnSelectionO.setBounds(1100, 658, 126, 138);
		btnSelectionO.addActionListener(diaryL);
		btnSelectionO.setVisible(false);
		diary4Panel.add(btnSelectionO);
		
		JButton btnSelectionX = new JButton();
		btnSelectionX.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/X_Selection.png"));
		btnSelectionX.setBounds(897, 677, 98, 119);
		btnSelectionX.addActionListener(diaryL);
		btnSelectionX.setVisible(false);
		diary4Panel.add(btnSelectionX);

		
		JButton btnSelectionBullet = new JButton();
		btnSelectionBullet.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Bullet_Selection.png"));
		btnSelectionBullet.setBounds(906, 694, 89, 89);
		btnSelectionBullet.addActionListener(diaryL);
		btnSelectionBullet.setVisible(false);
		diary4Panel.add(btnSelectionBullet);
		
		JButton btnSelectionGun = new JButton();
		btnSelectionGun.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Gun_Selection.png"));
		btnSelectionGun.setBounds(1101, 666, 98, 122);
		btnSelectionGun.addActionListener(diaryL);
		btnSelectionGun.setVisible(false);
		diary4Panel.add(btnSelectionGun);
		
		JButton btnSelectionChessboard = new JButton();
		btnSelectionChessboard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Chessboard_Selection.png"));
		btnSelectionChessboard.setBounds(1202, 693, 104, 73);
		btnSelectionChessboard.addActionListener(diaryL);
		btnSelectionChessboard.setVisible(false);
		diary4Panel.add(btnSelectionChessboard);
		
		JButton btnSelectionGasmask = new JButton();
		btnSelectionGasmask.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Gasmask_Selection.png"));
		btnSelectionGasmask.setBounds(909, 683, 46, 100);
		btnSelectionGasmask.addActionListener(diaryL);
		btnSelectionGasmask.setVisible(false);
		diary4Panel.add(btnSelectionGasmask);
		
		JButton btnSelectionFlashlight = new JButton(); // 손전등 선택 X사진이 없음
		btnSelectionFlashlight.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Flashlight_Selection.png"));
		btnSelectionFlashlight.setBounds(1028, 691, 77, 100);
		btnSelectionFlashlight.addActionListener(diaryL);
		btnSelectionFlashlight.setVisible(false);
		diary4Panel.add(btnSelectionFlashlight);
		
		JButton btnSelectionAxe = new JButton();
		btnSelectionAxe.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Axe_Selection.png"));
		btnSelectionAxe.setBounds(1006, 666, 71, 135);
		btnSelectionAxe.addActionListener(diaryL);
		btnSelectionAxe.setVisible(false);
		diary4Panel.add(btnSelectionAxe);
		
		JButton btnSelectionAidkit = new JButton();
		btnSelectionAidkit.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Aidkit_Selection.png"));
		btnSelectionAidkit.setBounds(1105, 706, 87, 54);
		btnSelectionAidkit.addActionListener(diaryL);
		btnSelectionAidkit.setVisible(false);
		diary4Panel.add(btnSelectionAidkit);
		
		JButton btnSelectionBook = new JButton();
		btnSelectionBook.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Book_Selection.png"));
		btnSelectionBook.setBounds(998, 706, 93, 71);
		btnSelectionBook.addActionListener(diaryL);
		btnSelectionBook.setVisible(false);
		diary4Panel.add(btnSelectionBook);
		
		JButton btnSelectionPesticide = new JButton();
		btnSelectionPesticide.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Pesticide_Map_Selection.png"));
		btnSelectionPesticide.setBounds(907, 695, 52, 100);
		btnSelectionPesticide.addActionListener(diaryL);
		btnSelectionPesticide.setVisible(false);
		diary4Panel.add(btnSelectionPesticide);
		
		JButton btnSelectionCard = new JButton();
		btnSelectionCard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Card_Selection.png"));
		btnSelectionCard.setBounds(984, 684, 98, 106);
		btnSelectionCard.addActionListener(diaryL);
		btnSelectionCard.setVisible(false);
		diary4Panel.add(btnSelectionCard);
		
		JButton btnSelectionRadio = new JButton();
		btnSelectionRadio.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Radio_Selection.png"));
		btnSelectionRadio.setBounds(1092, 701, 103, 77); 
		btnSelectionRadio.addActionListener(diaryL);
		btnSelectionRadio.setVisible(false);
		diary4Panel.add(btnSelectionRadio);
		
		JButton btnSelectionMap = new JButton();
		btnSelectionMap.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Map_Selection.png"));
		btnSelectionMap.setBounds(883, 706, 88, 66);
		btnSelectionMap.addActionListener(diaryL);
		btnSelectionMap.setVisible(false);
		diary4Panel.add(btnSelectionMap);
		
		// 버튼 선택X
		JButton btnO = new JButton();
		btnO.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/O.png"));
		btnO.setBounds(1100, 658, 129, 138);
		btnO.addActionListener(diaryL);
		btnO.setVisible(false);
		diary4Panel.add(btnO);
		
		JButton btnX = new JButton();
		btnX.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/X.png"));
		btnX.setBounds(904, 673, 108, 132);
		btnX.addActionListener(diaryL);
		btnX.setVisible(false);
		diary4Panel.add(btnX);
		
		JButton btnBullet = new JButton();
		btnBullet.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Bullet_SelectionX.png"));
		btnBullet.setBounds(906, 694, 89, 89);
		btnBullet.addActionListener(diaryL);
		btnBullet.setVisible(false);
		diary4Panel.add(btnBullet);
		
		JButton btnGun = new JButton();
		btnGun.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Gun_SelectionX.png"));
		btnGun.setBounds(1101, 666, 109, 139);
		btnGun.addActionListener(diaryL);
		btnGun.setVisible(false);
		diary4Panel.add(btnGun);
		
		JButton btnChessboard = new JButton();
		btnChessboard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/보드_SelectionX.png"));
		btnChessboard.setBounds(1202, 693, 106, 88);
		btnChessboard.addActionListener(diaryL);
		btnChessboard.setVisible(false);
		diary4Panel.add(btnChessboard);
		
		JButton btnGasmask = new JButton();
		btnGasmask.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Gasmask_SelectionX.png"));
		btnGasmask.setBounds(909, 683, 46, 100);
		btnGasmask.addActionListener(diaryL);
		btnGasmask.setVisible(false);
		diary4Panel.add(btnGasmask);
		
		JButton btnFlashlight = new JButton();
		btnFlashlight.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Flashlight_SelectionX.png"));
		btnFlashlight.setBounds(1028, 691, 77, 100);
		btnFlashlight.addActionListener(diaryL);
		btnFlashlight.setVisible(false);
		diary4Panel.add(btnFlashlight);
		
		JButton btnAxe = new JButton();
		btnAxe.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Axe_SelectionX.png"));
		btnAxe.setBounds(1006, 666, 71, 135);
		btnAxe.addActionListener(diaryL);
		btnAxe.setVisible(false);
		diary4Panel.add(btnAxe);
		
		JButton btnAidkit = new JButton();
		btnAidkit.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Aidkit_SelectionX.png"));
		btnAidkit.setBounds(1105, 706, 88, 54);
		btnAidkit.addActionListener(diaryL);
		btnAidkit.setVisible(false);
		diary4Panel.add(btnAidkit);
		
		JButton btnBook = new JButton();
		btnBook.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Book_SelectionX.png"));
		btnBook.setBounds(998, 706, 93, 71);
		btnBook.addActionListener(diaryL);
		btnBook.setVisible(false);
		diary4Panel.add(btnBook);
		
		JButton btnPesticide = new JButton();
		btnPesticide.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Pesticide_SelectionX.png"));
		btnPesticide.setBounds(907, 695, 46, 100);
		btnPesticide.addActionListener(diaryL);
		btnPesticide.setVisible(false);
		diary4Panel.add(btnPesticide);
		
		JButton btnCard = new JButton();
		btnCard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Card_SelectionX.png"));
		btnCard.setBounds(984, 684, 111, 113);
		btnCard.addActionListener(diaryL);
		btnCard.setVisible(false);
		diary4Panel.add(btnCard);
		
		JButton btnRadio = new JButton();
		btnRadio.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Radio_SelectionX.png"));
		btnRadio.setBounds(1092, 701, 116, 84);
		btnRadio.addActionListener(diaryL);
		btnRadio.setVisible(false);
		diary4Panel.add(btnRadio);
		
		JButton btnMap = new JButton();
		btnMap.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Map_SelectionX.png"));
		btnMap.setBounds(883, 706, 88, 66);
		btnMap.addActionListener(diaryL);
		btnMap.setVisible(false);
		diary4Panel.add(btnMap);
		
		// 다이어리 이벤트
		lblDiary15 = new JLabel();
		lblDiary15.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent15.png"));
		lblDiary15.setBounds(0, 0, 1902, 1033);
		lblDiary15.setVisible(false);	
		diary4Panel.add(lblDiary15);
		
		lblDiary14 = new JLabel();
		lblDiary14.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent14.png"));
		lblDiary14.setBounds(0, 0, 1902, 1033);
		lblDiary14.setVisible(false);	
		diary4Panel.add(lblDiary14);
		
		lblDiary13 = new JLabel();
		lblDiary13.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent13.png"));
		lblDiary13.setBounds(0, 0, 1902, 1033);
		lblDiary13.setVisible(false);	
		diary4Panel.add(lblDiary13);
		
		lblDiary12 = new JLabel();
		lblDiary12.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent12.png"));
		lblDiary12.setBounds(0, 0, 1902, 1033);
		lblDiary12.setVisible(false);	
		diary4Panel.add(lblDiary12);
		
		lblDiary11 = new JLabel();
		lblDiary11.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent11.png"));
		lblDiary11.setBounds(0, 0, 1902, 1033);
		lblDiary11.setVisible(false);	
		diary4Panel.add(lblDiary11);
		
		lblDiary10 = new JLabel();
		lblDiary10.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent10.png"));
		lblDiary10.setBounds(0, 0, 1902, 1033);
		lblDiary10.setVisible(false);	
		diary4Panel.add(lblDiary10);
		
		lblDiary9 = new JLabel();
		lblDiary9.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent9.png"));
		lblDiary9.setBounds(0, 0, 1902, 1033);
		lblDiary9.setVisible(false);	
		diary4Panel.add(lblDiary9);
		
		lblDiary8 = new JLabel();
		lblDiary8.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent8.png"));
		lblDiary8.setBounds(0, 0, 1902, 1033);
		lblDiary8.setVisible(false);	
		diary4Panel.add(lblDiary8);
		
		lblDiary7 = new JLabel();
		lblDiary7.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent7.png"));
		lblDiary7.setBounds(0, 0, 1902, 1033);
		lblDiary7.setVisible(false);	
		diary4Panel.add(lblDiary7);
		
		lblDiary6 = new JLabel();
		lblDiary6.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent6.png"));
		lblDiary6.setBounds(0, 0, 1902, 1033);
		lblDiary6.setVisible(false);	
		diary4Panel.add(lblDiary6);
		
		lblDiary5 = new JLabel();
		lblDiary5.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent5.png"));
		lblDiary5.setBounds(0, 0, 1902, 1033);
		lblDiary5.setVisible(false);	
		diary4Panel.add(lblDiary5);
		
		lblDiary4 = new JLabel();
		lblDiary4.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent4.png"));
		lblDiary4.setBounds(0, 0, 1902, 1033);
		lblDiary4.setVisible(false);	
		diary4Panel.add(lblDiary4);
		
		lblDiary3 = new JLabel();
		lblDiary3.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent3.png"));
		lblDiary3.setBounds(0, 0, 1902, 1033);
		lblDiary3.setVisible(false);	
		diary4Panel.add(lblDiary3);
		
		lblDiary2 = new JLabel();
		lblDiary2.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent2.png"));
		lblDiary2.setBounds(0, 0, 1902, 1033);
		lblDiary2.setVisible(false);	
		diary4Panel.add(lblDiary2);
		
		lblDiary1 = new JLabel();
		lblDiary1.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent1.png"));
		lblDiary1.setBounds(0, 0, 1902, 1033);
		lblDiary1.setVisible(false);	
		diary4Panel.add(lblDiary1);
		
		lblNormalDiary = new JLabel();
		lblNormalDiary.setIcon(new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png"));
		lblNormalDiary.setBounds(0, 0, 1902, 1033);
		lblNormalDiary.setVisible(false);	
		diary4Panel.add(lblNormalDiary);
		
		// 다이어리 성공 이벤트
		lblSDiary1 = new JLabel();
		lblSDiary1.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Radio.png"));
		lblSDiary1.setBounds(0, 0, 1902, 1033);
		lblSDiary1.setVisible(false);
		diary4Panel.add(lblSDiary1);
		
		lblSDiary2 = new JLabel();
		lblSDiary2.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Gun.png"));
		lblSDiary2.setBounds(0, 0, 1902, 1033);
		lblSDiary2.setVisible(false);
		diary4Panel.add(lblSDiary2);
		
		lblSDiary3 = new JLabel();
		lblSDiary3.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Map.png"));
		lblSDiary3.setBounds(0, 0, 1902, 1033);
		lblSDiary3.setVisible(false);
		diary4Panel.add(lblSDiary3);
		
		lblSDiary4 = new JLabel();
		lblSDiary4.setIcon(new ImageIcon("img/DiarySrc/Event/Event_문열기.png"));
		lblSDiary4.setBounds(0, 0, 1902, 1033);
		lblSDiary4.setVisible(false);
		diary4Panel.add(lblSDiary4);
		
		lblSurvive = new JLabel();
		lblSurvive.setIcon(new ImageIcon("img/DiarySrc/Ending/생존.png"));
		lblSurvive.setBounds(0, 0, 1902, 1033);
		lblSurvive.setVisible(false);
		diary4Panel.add(lblSurvive);
		
		lblDie = new JLabel();
		lblDie.setIcon(new ImageIcon("img/DiarySrc/Ending/비명횡사.png"));
		lblDie.setBounds(0, 0, 1902, 1033);
		lblDie.setVisible(false);
		diary4Panel.add(lblDie);
	   
		
		if(isOutsideM==1 || isOutsideF==1 || isOutsideD==1 || isOutsideS==1) { // 누군가가 탐험중이면 탐험선택 못하도록
			lblAdvFX.setVisible(true);
			lblAdvDX.setVisible(true);
			lblAdvMX.setVisible(true);
			lblAdvSX.setVisible(true);
			// 탐험 불가능한 상태 이미지 띄우기
			btnAdvF.setVisible(false); btnAdvSelectF.setVisible(false);
			btnAdvM.setVisible(false); btnAdvSelectM.setVisible(false); 
			btnAdvD.setVisible(false); btnAdvSelectD.setVisible(false);
			btnAdvS.setVisible(false); btnAdvSelectS.setVisible(false);
			// 탐험 선택/미선택 버튼 안보이게

		}else { // 아무도 탐험 중이 아니라면
			/*fatherCondition(father);   // fatherCondition(ConPanel father)
			momCondition(mother);
			sonCondition(son);
			daughterCondition(daughter);*/

			
		} // 탐험중이 아니면 선택할 수 있도록
		
		
		
	} // Diary4(Game g)
	
	// 나갔는지 확인하는 변수 만들기 --> 아빠버튼선택--> isOutside+=1;
	 public void momCondition(ConPanel mom) {
		 mom=this.mother;
		   if(mom.getCondition()==3 || mom.getCondition()==2) { // 사망 혹은 녹초상태 --> 탐험 불가능 상태
			   lblAdvMX.setVisible(true); // 엄마 탐험 못가는 상태 이미지 보이게
			   btnAdvM.setVisible(false); // 나머지는 안보이게
			   btnAdvSelectM.setVisible(false);
			   if(mom.getCondition()==3) {
				   lblMConText.setText("..."); // 사망했을 경우 나타내는 텍스트
			   }
			   else lblMConText.setText("Mother is not in a condition she can go on an expedition."); // 녹초일 경우 나타내는 텍스트
		   } // end if 사망 혹은 녹초상태 --> 탐험 불가능 상태
		   
		   else {
			   btnAdvM.setVisible(true); // 탐험 선택 안 한 상태 이미지 보이게
			   btnAdvSelectM.setVisible(false);
			   lblAdvMX.setVisible(false);
			   
			   if(mom.getHealth()==1 || mom.getHealth()==3 || mom.getMind()==1) // 탐험은 가능하나 위험한 상태
				   lblMConText.setText("She is not sure if she can return safely."); 
			   else // 탐험 가능한 상태
				   lblMConText.setText("Mother is okay to go on an expedition.");   
			   
		   } // end else --> 탐험 가능한 상태
		   
	   } // MomCondition()
	/*
	   public void fatherCondition(ConPanel dad) {
		   dad=this.father;
		   if(dad.getCondition()==3 || dad.getCondition()==2) { // 사망 혹은 녹초상태 --> 탐험 불가능 상태
			   lblAdvFX.setVisible(true); // 아빠 탐험 못가는 상태 이미지 보이게
			   btnAdvF.setVisible(false); // 나머지는 안보이게
			   btnAdvSelectF.setVisible(false);
			   if(dad.getCondition()==3) {
				   lblFConText.setText("..."); // 사망했을 경우 나타내는 텍스트
			   }
			   else lblFConText.setText("Father is not in a condition he can go on an expedition."); // 녹초일 경우 나타내는 텍스트
		   } // end if 사망 혹은 녹초상태 --> 탐험 불가능 상태
		   
		   else {
			   btnAdvF.setVisible(true); // 탐험 선택 안 한 상태 이미지 보이게
			   btnAdvSelectF.setVisible(false);
			   lblAdvFX.setVisible(false);
			   
			   if(dad.getHealth()==1 || dad.getHealth()==3 || dad.getMind()==1) // 탐험은 가능하나 위험한 상태
				   lblFConText.setText("He is not sure if he can return safely."); 
			   else // 탐험 가능한 상태
				   lblFConText.setText("Father is okay to go on an expedition.");   
			   
		   } // end else --> 탐험 가능한 상태
		   
	   } // FatherCondition()
	   
	   
	   public void daughterCondition(ConPanel daughter) {
		   daughter=this.daughter;
		   if(daughter.getCondition()==3 || daughter.getCondition()==2) { // 사망 혹은 녹초상태 --> 탐험 불가능 상태
			   lblAdvDX.setVisible(true); // 딸 탐험 못가는 상태 이미지 보이게
			   btnAdvD.setVisible(false); // 나머지는 안보이게
			   btnAdvSelectD.setVisible(false);
			   if(daughter.getCondition()==3) {
				   lblDConText.setText("..."); // 사망했을 경우 나타내는 텍스트
			   }
			   else lblDConText.setText("Daughter is not in a condition she can go on an expedition."); // 녹초일 경우 나타내는 텍스트
		   } // end if 사망 혹은 녹초상태 --> 탐험 불가능 상태
		   
		   else {
			   btnAdvD.setVisible(true); // 탐험 선택 안 한 상태 이미지 보이게
			   btnAdvSelectD.setVisible(false);
			   lblAdvDX.setVisible(false);
			   
			   if(daughter.getHealth()==1 || daughter.getHealth()==3 || daughter.getMind()==1) // 탐험은 가능하나 위험한 상태
				   lblDConText.setText("She is not sure if she can return safely."); 
			   else // 탐험 가능한 상태
				   lblDConText.setText("Daughter is okay to go on an expedition.");   
			   
		   } // end else --> 탐험 가능한 상태
		   
	   } // DaughterCondition()
	   
	   
	   public void sonCondition(ConPanel son) {
		   son=this.son;
		   if(son.getCondition()==3 || son.getCondition()==2) { // 사망 혹은 녹초상태 --> 탐험 불가능 상태
			   lblAdvSX.setVisible(true); // 아들 탐험 못가는 상태 이미지 보이게
			   btnAdvS.setVisible(false); // 나머지는 안보이게
			   btnAdvSelectS.setVisible(false);
			   if(son.getCondition()==3) {
				   lblSConText.setText("..."); // 사망했을 경우 나타내는 텍스트
			   }
			   else lblSConText.setText("Son is not in a condition he can go on an expedition."); // 녹초일 경우 나타내는 텍스트
		   } // end if 사망 혹은 녹초상태 --> 탐험 불가능 상태
		   
		   else {
			   btnAdvS.setVisible(true); // 탐험 선택 안 한 상태 이미지 보이게
			   btnAdvSelectS.setVisible(false);
			   lblAdvSX.setVisible(false);
			   
			   if(son.getHealth()==1 || son.getHealth()==3 || son.getMind()==1) // 탐험은 가능하나 위험한 상태
				   lblSConText.setText("He is not sure if he can return safely."); 
			   else // 탐험 가능한 상태
				   lblSConText.setText("Son is okay to go on an expedition.");   
			   
		   } // end else --> 탐험 가능한 상태
		   
	   } // SonCondition()
*/	
	   public class DiaryL implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				JButton btn = (JButton)event.getSource();

				// 탐험
				if(btn==btnAdvM) { 
					btnAdvM.setVisible(false);
					btnAdvSelectM.setVisible(true);				
					btnAdvF.setVisible(true);
					btnAdvSelectF.setVisible(false);										
					btnAdvD.setVisible(true);
					btnAdvSelectD.setVisible(false);										
					btnAdvS.setVisible(true);
					btnAdvSelectS.setVisible(false);
					currentSelected=1; // 현재 선택상태인 사람 엄마
					isOutsideM=1; // 엄마 나가는걸로 설정
					randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 얼마나 탐험할 지 랜덤으로 정함
					eda = DiaryPage.nDay+randomAdv; // estimated day of arrival (EDA) 도착 예정 시간의 약자
					leaveHomeDay=DiaryPage.nDay+1; // 떠나는 날
				} // end if 엄마 탐험 미선택상태를 눌러서 선택상태로 만듦.  
				else if(btn==btnAdvSelectM) {
					btnAdvM.setVisible(true);
					btnAdvSelectM.setVisible(false);
					btnAdvF.setVisible(true); 
					btnAdvSelectF.setVisible(false);										
					btnAdvD.setVisible(true); 
					btnAdvSelectD.setVisible(false);		 							
					btnAdvS.setVisible(true); 
					btnAdvSelectS.setVisible(false);  
					currentSelected=0;
					isOutsideM=0; // 엄마 안나가는걸로 설정
				} // end else if 엄마 탐험 선택상태를 눌러서 미선택상태로 만듦.
				
				else if(btn==btnAdvF) {
					btnAdvM.setVisible(true);
					btnAdvSelectM.setVisible(false);				
					btnAdvF.setVisible(false);
					btnAdvSelectF.setVisible(true);										
					btnAdvD.setVisible(true);
					btnAdvSelectD.setVisible(false);										
					btnAdvS.setVisible(true);
					btnAdvSelectS.setVisible(false);
					currentSelected=2; // 현재 선택상태인 사람 아빠
					isOutsideF=1; // 아빠 나가는걸로 설정
					randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 얼마나 탐험할 지 랜덤으로 정함
					eda = DiaryPage.nDay+randomAdv; // estimated day of arrival (EDA) 도착 예정 시간의 약자
					leaveHomeDay=DiaryPage.nDay+1; // 떠나는 날
				} // end if 아빠 탐험 미선택상태를 눌러서 선택상태로 만듦.  
				
				else if(btn==btnAdvSelectF) {
					btnAdvM.setVisible(true);
					btnAdvSelectM.setVisible(false);
					btnAdvF.setVisible(true); 
					btnAdvSelectF.setVisible(false);										
					btnAdvD.setVisible(true); 
					btnAdvSelectD.setVisible(false);		 							
					btnAdvS.setVisible(true); 
					btnAdvSelectS.setVisible(false);  
					currentSelected=0;
					isOutsideF=0; // 아빠 안나가는걸로 설정
				} // end else if 아빠 탐험 선택상태를 눌러서 미선택상태로 만듦.
				
				else if(btn==btnAdvS) {
					btnAdvM.setVisible(true);
					btnAdvSelectM.setVisible(false);				
					btnAdvF.setVisible(true);
					btnAdvSelectF.setVisible(false);										
					btnAdvD.setVisible(true);
					btnAdvSelectD.setVisible(false);										
					btnAdvS.setVisible(false);
					btnAdvSelectS.setVisible(true);
					currentSelected=3; // 현재 선택상태인 사람 아들
					isOutsideS=1; // 아들 나가는걸로 설정
					randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 얼마나 탐험할 지 랜덤으로 정함
					eda = DiaryPage.nDay+randomAdv; // estimated day of arrival (EDA) 도착 예정 시간의 약자
					leaveHomeDay=DiaryPage.nDay+1; // 떠나는 날
				} // end if 아들 탐험 미선택상태를 눌러서 선택상태로 만듦.  
				
				else if(btn==btnAdvSelectS) {
					btnAdvM.setVisible(true);
					btnAdvSelectM.setVisible(false);
					btnAdvF.setVisible(true); 
					btnAdvSelectF.setVisible(false);										
					btnAdvD.setVisible(true); 
					btnAdvSelectD.setVisible(false);		 							
					btnAdvS.setVisible(true); 
					btnAdvSelectS.setVisible(false);  
					currentSelected=0;
					isOutsideS=0; // 아들 안나가는걸로 설정
				} // end else if 아들 탐험 선택상태를 눌러서 미선택상태로 만듦.
				
				else if(btn==btnAdvD) {
					btnAdvM.setVisible(true);
					btnAdvSelectM.setVisible(false);				
					btnAdvF.setVisible(true);
					btnAdvSelectF.setVisible(false);										
					btnAdvD.setVisible(false);
					btnAdvSelectD.setVisible(true);										
					btnAdvS.setVisible(true);
					btnAdvSelectS.setVisible(false);
					isOutsideD=1; // 딸 나가는걸로 설정
					currentSelected=4; // 현재 선택상태인 사람 딸
					randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 얼마나 탐험할 지 랜덤으로 정함
					eda = DiaryPage.nDay+randomAdv; // estimated day of arrival (EDA) 도착 예정 시간의 약자
					leaveHomeDay=DiaryPage.nDay+1; // 떠나는 날
				} // end if 딸 탐험 미선택상태를 눌러서 선택상태로 만듦.  
				
				else if(btn==btnAdvSelectD) {
					btnAdvM.setVisible(true);
					btnAdvSelectM.setVisible(false);
					btnAdvF.setVisible(true); 
					btnAdvSelectF.setVisible(false);										
					btnAdvD.setVisible(true); 
					btnAdvSelectD.setVisible(false);		 							
					btnAdvS.setVisible(true); 
					btnAdvSelectS.setVisible(false);  
					isOutsideD=0; // 딸 안나가는걸로 설정
					currentSelected=0;
				} // end else if D 탐험 선택상태를 눌러서 미선택상태로 만듦.
			}
	   }
	
	
	
	
	
} // Diary4 class
