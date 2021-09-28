		    import java.awt.Dimension;
		    import java.awt.Font;
		    import java.awt.Graphics;

		    import javax.swing.*;

		    public class Diary0 extends JPanel{
		    	private DiaryPage diaryPage;
		    	private JPanel diary0Panel;
		    	public ImageIcon diary0background;
		    	
		    	public int shelterFood, shelterWater, nshelterFood, nshelterWater; //
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
		    	public JLabel lblIsOutsideM, lblIsOutsideF, lblIsOutsideD, lblIsOutsideS;
		    	public JLabel lblTotalGotItem; // 탐험에서 얻은 아이템들을 적은 텍스트라벨
		    	public JLabel lblIsOutside, lblComeBack;
		    	
		    	public Diary0(DiaryPage d) {
		    		
		    		setPreferredSize(new Dimension(1902, 1033));
		    		setBounds(0, 0, 1920, 1080);
		    		setLayout(null);
		    		
		    		diary0background = new ImageIcon("img/StuffSrc/Shelter_basic.png");	//배경이미지
		    		   
		    		   diary0Panel=new JPanel() {	//배경 패널 생성
		    			   public void paintComponent(Graphics g) {		//배경을 그려줌
		    				   Dimension d =getSize();
		    				   g.drawImage(diary0background.getImage(), 0, 0, 1920, 1080, null);
		    				   setOpaque(false);
		    				   super.paintComponent(g);
		    			   }//paintComponent()
		    		   }; //background1
		    		   diary0Panel.setBounds(0,0,1920,1080);
		    		   diary0Panel.setLayout(null);
		    		   add(diary0Panel);
		    		   
		    		   btnOpenDiary = new JButton();
		   		    btnOpenDiary.setIcon(new ImageIcon("img/StuffSrc/Shelter_DiarySelection.png"));
		   		    btnOpenDiary.setLocation(1592, 746);
		   		    btnOpenDiary.setSize(201, 197);
		   		    diary0Panel.add(btnOpenDiary);
		    		   
		    		    lblSCon = new JLabel();
		    			lblSCon.setVisible(false);
		    			lblSCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/S.png"));
		    			lblSCon.setBounds(821, 575, 80, 109);
		    			diary0Panel.add(lblSCon);
		    			
		    			lblDCon = new JLabel();
		    			lblDCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/D.png"));
		    			lblDCon.setBounds(809, 448, 105, 125);
		    			lblDCon.setVisible(false);
		    			diary0Panel.add(lblDCon);
		    			
		    			lblMCon = new JLabel();
		    			lblMCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/M.png"));
		    			lblMCon.setBounds(809, 324, 104, 121);
		    			lblMCon.setVisible(false);
		    		    diary0Panel.add(lblMCon);
		    			
		    			lblFCon = new JLabel();
		    			lblFCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/F.png"));
		    			lblFCon.setBounds(817, 207, 88, 114);
		    			lblFCon.setVisible(false);
		    			diary0Panel.add(lblFCon);
		    			
		    			JButton btnAdvS = new JButton();
		    			btnAdvS.setIcon(new ImageIcon("DiarySr/Adventure/S__SelectionX.png"));
		    			btnAdvS.setBounds(1208, 699, 80, 114);
		    			btnAdvS.setVisible(false);
		    			diary0Panel.add(btnAdvS);
		    			
		    			lblAdvSX = new JLabel();
		    			lblAdvSX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Sx.png"));
		    			lblAdvSX.setBounds(1183, 699, 136, 121);
		    			lblAdvSX.setVisible(false);
		    			diary0Panel.add(lblAdvSX);
		    			
		    			JButton btnAdvSelectS = new JButton();
		    			btnAdvSelectS.setIcon(new ImageIcon("DiarySr/Adventure/S.png"));
		    			btnAdvSelectS.setBounds(1209, 698, 80, 109);
		    			btnAdvSelectS.setVisible(false);
		    			diary0Panel.add(btnAdvSelectS);
		    			
		    			lblAdvDX = new JLabel();
		    			lblAdvDX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Dx.png"));
		    			lblAdvDX.setBounds(1060, 684, 117, 129);
		    			lblAdvDX.setVisible(false);
		    			diary0Panel.add(lblAdvDX);
		    			
		    			JButton btnAdvD = new JButton();
		    			btnAdvD.setIcon(new ImageIcon("DiarySr/Adventure/D__SelectionX.png"));
		    			btnAdvD.setHorizontalAlignment(SwingConstants.LEFT);
		    			btnAdvD.setBounds(1060, 684, 113, 129);
		    			btnAdvD.setVisible(false);
		    			diary0Panel.add(btnAdvD);
		    			
		    			JButton btnAdvSelectD = new JButton();
		    			btnAdvSelectD.setIcon(new ImageIcon("DiarySr/Adventure/D.png"));
		    			btnAdvSelectD.setBounds(1063, 686, 105, 125);
		    			btnAdvSelectD.setVisible(false);
		    			diary0Panel.add(btnAdvSelectD);
		    			
		    			JButton btnAdvM = new JButton();
		    			btnAdvM.setIcon(new ImageIcon("DiarySr/Adventure/M__SelectionX.png"));
		    			btnAdvM.setBounds(941, 689, 105, 124);
		    			btnAdvM.setVisible(false);
		    			diary0Panel.add(btnAdvM);
		    			
		    			lblAdvMX = new JLabel();
		    			lblAdvMX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Mx.png"));
		    			lblAdvMX.setBounds(929, 670, 132, 165);
		    			lblAdvMX.setVisible(false);
		    			diary0Panel.add(lblAdvMX);
		    			
		    			JButton btnAdvSelectM = new JButton();
		    			btnAdvSelectM.setIcon(new ImageIcon("DiarySr/Adventure/M.png"));
		    			btnAdvSelectM.setBounds(943, 690, 104, 121);
		    			btnAdvSelectM.setVisible(false);
		    			diary0Panel.add(btnAdvSelectM);
		    			
		    			JButton btnAdvF = new JButton();
		    			btnAdvF.setIcon(new ImageIcon("DiarySr/Adventure/F__SelectionX.png"));
		    			btnAdvF.setBounds(819, 695, 91, 118);
		    			btnAdvF.setVisible(false);
		    			diary0Panel.add(btnAdvF);
		    			
		    			lblAdvFX = new JLabel();
		    			lblAdvFX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Fx.png"));
		    			lblAdvFX.setBounds(791, 669, 143, 167);
		    			lblAdvFX.setVisible(false);
		    			diary0Panel.add(lblAdvFX);
		    			
		    			JButton btnAdvSelectF = new JButton();
		    			btnAdvSelectF.setIcon(new ImageIcon("DiarySr/Adventure/F.png"));
		    			btnAdvSelectF.setBounds(821, 696, 88, 114);
		    			btnAdvSelectF.setVisible(false);
		    			diary0Panel.add(btnAdvSelectF);
		    			
		    			lblSConText = new JLabel("Son is okay to go on an expedition.");
		    			lblSConText.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		    			lblSConText.setBounds(943, 608, 334, 42);
		    			lblSConText.setVisible(false);
		    			diary0Panel.add(lblSConText);
		    			
		    			lblDConText = new JLabel("Daughter is okay to go on an expedition.");
		    			lblDConText.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		    			lblDConText.setBounds(943, 488, 334, 42);
		    			lblDConText.setVisible(false);
		    			diary0Panel.add(lblDConText);
		    			
		    			lblMConText = new JLabel("Mother is okay to go on an expedition.");
		    			lblMConText.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		    			lblMConText.setBounds(943, 361, 334, 42);
		    			lblMConText.setVisible(false);
		    			diary0Panel.add(lblMConText);
		    			
		    			lblFConText = new JLabel("Father is okay to go on an expedition.");
		    			lblFConText.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 20));
		    			lblFConText.setBounds(943, 246, 334, 42);
		    			lblFConText.setVisible(false);
		    			diary0Panel.add(lblFConText);
		    			
		    			lblBlack = new JLabel();
		    			lblBlack.setIcon(new ImageIcon("img/StuffSrc/Black.png"));
		    			lblBlack.setSize(1902, 1033);
		    			lblBlack.setVisible(false);
		    			diary0Panel.add(lblBlack);
		    			
		    			// Day
		    			lblDay = new JLabel();
		    			lblDay.setLocation(1000, 128);
		    			lblDay.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 38));
		    			lblDay.setSize(129, 72);
		    			lblDay.setText(diaryPage.nDay+"일"); // 정수형 nDay를 텍스트로 변환
		    			lblDay.setVisible(false);
		    			diary0Panel.add(lblDay);
		    			
		    			// 전날 변동사항 표시해주는 페이지 = nDiary1
		    			lblFoodText = new JLabel(""+shelterFood/4);
		    			lblFoodText.setVisible(false);
		    			diary0Panel.add(lblFoodText);
		    			
		    			lblWaterText = new JLabel(""+shelterWater/4);
		    			lblWaterText.setVisible(false);
		    			diary0Panel.add(lblWaterText);
		    			
		    			lblFoodFText = new JLabel();
		    			lblFoodFText.setVisible(false);
		    			diary0Panel.add(lblFoodFText);
		    			
		    			lblFoodMText = new JLabel();
		    			lblFoodMText.setVisible(false);
		    			diary0Panel.add(lblFoodMText);
		    			
		    			lblFoodDText = new JLabel();
		    			lblFoodDText.setVisible(false);
		    			diary0Panel.add(lblFoodDText);
		    			
		    			lblFoodSText = new JLabel();
		    			lblFoodSText.setVisible(false);
		    			diary0Panel.add(lblFoodSText);
		    			
		    			lblWaterFText = new JLabel();
		    			lblWaterFText.setVisible(false);
		    			diary0Panel.add(lblWaterFText);
		    			
		    			lblWaterMText = new JLabel();
		    			lblWaterMText.setVisible(false);
		    			diary0Panel.add(lblWaterMText);
		    			
		    			lblWaterDText = new JLabel();
		    			lblWaterDText.setVisible(false);
		    			diary0Panel.add(lblWaterDText);
		    			
		    			lblWaterSText = new JLabel();
		    			lblWaterSText.setVisible(false);
		    			diary0Panel.add(lblWaterSText);
		    			
		    			lblIsOutside = new JLabel();
		    			lblIsOutside.setVisible(false);
		    			diary0Panel.add(lblIsOutside);
		    			
		    			lblComeBack = new JLabel();
		    			lblComeBack.setVisible(false);
		    			diary0Panel.add(lblComeBack);
		    			
		    			
		    			// 식량배분 페이지 = nDiary2
		    			lblFood = new JLabel();
		    			lblFood.setText("+"+(shelterFood-4));
		    			lblFood.setVisible(false);
		    			diary0Panel.add(lblFood);
		    			
		    			lblWater = new JLabel();
		    			lblWater.setText("+"+(shelterWater-4));
		    			lblWater.setVisible(false);
		    			diary0Panel.add(lblWater);
		    			
		    			lblFood0 = new JLabel();
		    			lblFood0.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food0.png"));
		    			lblFood0.setBounds(953, 627, 48, 63);
		    			lblFood0.setVisible(false);	
		    			diary0Panel.add(lblFood0);
		    			
		    			lblFood1 = new JLabel();
		    			lblFood1.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food1.png"));
		    			lblFood1.setBounds(953, 627, 48, 63);
		    			lblFood1.setVisible(false);	
		    			diary0Panel.add(lblFood1);
		    			
		    			lblFood2 = new JLabel();
		    			lblFood2.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food2.png"));
		    			lblFood2.setBounds(953, 627, 48, 63);
		    			lblFood2.setVisible(false);	
		    			diary0Panel.add(lblFood2);
		    			
		    			lblFood3 = new JLabel();
		    			lblFood3.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food3.png"));
		    			lblFood3.setBounds(953, 627, 48, 63);
		    			lblFood3.setVisible(false);	
		    			diary0Panel.add(lblFood3);
		    			
		    			lblFood4 = new JLabel();
		    			lblFood4.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food4.png"));
		    			lblFood4.setBounds(953, 627, 48, 63); // 845, 627, 48, 63
		    			lblFood4.setVisible(false);	
		    			diary0Panel.add(lblFood4);
		    			
		    			lblWater0 = new JLabel();
		    			lblWater0.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water0.png"));
		    			lblWater0.setBounds(957, 713, 46, 80); 
		    			lblWater0.setVisible(false);	
		    			diary0Panel.add(lblWater0);
		    			
		    			lblWater1 = new JLabel();
		    			lblWater1.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water1.png"));
		    			lblWater1.setBounds(957, 713, 46, 80);
		    			lblWater1.setVisible(false);	
		    			diary0Panel.add(lblWater1);
		    			
		    			lblWater2 = new JLabel();
		    			lblWater2.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water2.png"));
		    			lblWater2.setBounds(957, 713, 46, 80);
		    			lblWater2.setVisible(false);	
		    			diary0Panel.add(lblWater2);
		    			
		    			lblWater3 = new JLabel();
		    			lblWater3.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water3.png"));
		    			lblWater3.setBounds(957, 713, 46, 80);
		    			lblWater3.setVisible(false);	
		    			diary0Panel.add(lblWater3);
		    			
		    			lblWater4 = new JLabel();
		    			lblWater4.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water4.png"));
		    			lblWater4.setBounds(957, 713, 46, 80); //851, 716, 44, 78
		    			lblWater4.setVisible(false);	
		    			diary0Panel.add(lblWater4);
		    			
		    			JButton btnSFoodX = new JButton();
		    			btnSFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		    			btnSFoodX.setBounds(1217, 483, 45, 54);
		    			btnSFoodX.setVisible(false);
		    			diary0Panel.add(btnSFoodX);
		    			
		    			JButton btnSFood = new JButton();
		    			btnSFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		    			btnSFood.setBounds(1217, 483, 45, 54);
		    			btnSFood.setVisible(false);
		    			diary0Panel.add(btnSFood);
		    			
		    			JButton btnSWaterX = new JButton();
		    			btnSWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		    			btnSWaterX.setBounds(1177, 480, 33, 55);
		    			btnSWaterX.setVisible(false);
		    			diary0Panel.add(btnSWaterX);
		    			
		    			JButton btnSWater = new JButton();
		    			btnSWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		    			btnSWater.setBounds(1177, 480, 33, 55);
		    			btnSWater.setVisible(false);
		    			diary0Panel.add(btnSWater);
		    			
		    			JButton btnDFoodX = new JButton();
		    			btnDFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		    			btnDFoodX.setBounds(1093, 483, 45, 54);
		    			btnDFoodX.setVisible(false);
		    			diary0Panel.add(btnDFoodX);
		    			
		    			JButton btnDFood = new JButton();
		    			btnDFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		    			btnDFood.setBounds(1093, 483, 45, 54);
		    			btnDFood.setVisible(false);
		    			diary0Panel.add(btnDFood);
		    			
		    			JButton btnDWaterX = new JButton();
		    			btnDWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		    			btnDWaterX.setBounds(1054, 480, 33, 55);
		    			btnDWaterX.setVisible(false);
		    			diary0Panel.add(btnDWaterX);
		    			
		    			JButton btnDWater = new JButton();
		    			btnDWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		    			btnDWater.setBounds(1054, 480, 33, 55);
		    			btnDWater.setVisible(false);
		    			diary0Panel.add(btnDWater);
		    			
		    			JButton btnMFoodX = new JButton();
		    			btnMFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		    			btnMFoodX.setBounds(953, 483, 45, 54);
		    			btnMFoodX.setVisible(false);
		    			diary0Panel.add(btnMFoodX);
		    			
		    			JButton btnMFood = new JButton();
		    			btnMFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		    			btnMFood.setBounds(953, 483, 45, 54);
		    			btnMFood.setVisible(false);
		    			diary0Panel.add(btnMFood);
		    			
		    			JButton btnMWaterX = new JButton();
		    			btnMWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		    			btnMWaterX.setBounds(913, 480, 33, 55);
		    			btnMWaterX.setVisible(false);
		    			diary0Panel.add(btnMWaterX);
		    			
		    			JButton btnMWater = new JButton();
		    			btnMWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		    			btnMWater.setBounds(913, 480, 33, 55);
		    			btnMWater.setVisible(false);
		    			diary0Panel.add(btnMWater);
		    			
		    			JButton btnFFoodX = new JButton();
		    			btnFFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		    			btnFFoodX.setBounds(823, 483, 45, 54);
		    			btnFFoodX.setVisible(false);
		    			diary0Panel.add(btnFFoodX);
		    			
		    			JButton btnFFood = new JButton();
		    			btnFFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		    			btnFFood.setBounds(823, 483, 45, 54);
		    			btnFFood.setVisible(false);
		    			diary0Panel.add(btnFFood);
		    			
		    			JButton btnFWaterX = new JButton();
		    			btnFWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		    			btnFWaterX.setBounds(781, 480, 33, 55);
		    			btnFWaterX.setVisible(false);
		    			diary0Panel.add(btnFWaterX);
		    			
		    			JButton btnFWater = new JButton();
		    			btnFWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		    			btnFWater.setBounds(781, 480, 33, 55);
		    			btnFWater.setVisible(false);
		    			diary0Panel.add(btnFWater);
		    			
		    		    lblDiarySX = new JLabel();
		    		    lblDiarySX.setIcon(new ImageIcon("img/DiarySrc/Distribution/SX.png"));
		    		    lblDiarySX.setBounds(1170, 357, 136, 125);
		    		    lblDiarySX.setVisible(false);
		    		    diary0Panel.add(lblDiarySX);
		    		      
		    	        lblDiaryS = new JLabel();
		    		    lblDiaryS.setIcon(new ImageIcon("img/DiarySrc/Distribution/S.png"));
		    		    lblDiaryS.setBounds(1195, 357, 80, 109);
		    		    lblDiaryS.setVisible(false);
		    		    diary0Panel.add(lblDiaryS);
		    		      
		    		    lblDiaryDX = new JLabel();
		    		    lblDiaryDX.setIcon(new ImageIcon("img/DiarySrc/Distribution/DX.png"));
		    		    lblDiaryDX.setBounds(1037, 344, 117, 129);
		    		    lblDiaryDX.setVisible(false);
		    		    diary0Panel.add(lblDiaryDX);
		    		      
		    		    lblDiaryD = new JLabel();
		    		    lblDiaryD.setIcon(new ImageIcon("img/DiarySrc/Distribution/D.png"));
		    		    lblDiaryD.setBounds(1040, 346, 105, 125);
		    		    lblDiaryD.setVisible(false);
		    		    diary0Panel.add(lblDiaryD);
		    		      
		    		    lblDiaryMX = new JLabel();
		    		    lblDiaryMX.setIcon(new ImageIcon("img/DiarySrc/Distribution/MX.png"));
		    		    lblDiaryMX.setBounds(891, 330, 132, 165);
		    		    lblDiaryMX.setVisible(false);
		    		    diary0Panel.add(lblDiaryMX);
		    		      
		    		    lblDiaryM = new JLabel();
		    	        lblDiaryM.setIcon(new ImageIcon("img/DiarySrc/Distribution/M.png"));
		    		    lblDiaryM.setBounds(905, 349, 104, 121);
		    		    lblDiaryM.setVisible(false);
		    		    diary0Panel.add(lblDiaryM);
		    		      
		    		    lblDiaryFX = new JLabel();
		    		    lblDiaryFX.setIcon(new ImageIcon("img/DiarySrc/Distribution/FX.png"));
		    		    lblDiaryFX.setBounds(750, 332, 143, 167);
		    		    lblDiaryFX.setVisible(false);
		    		    diary0Panel.add(lblDiaryFX);
		    		      
		    		    lblDiaryF = new JLabel();
		    		    lblDiaryF.setIcon(new ImageIcon("img/DiarySrc/Distribution/F.png"));
		    		    lblDiaryF.setBounds(777, 360, 88, 114);
		    		    lblDiaryF.setVisible(false);
		    		    diary0Panel.add(lblDiaryF);
		    		    //diary0Panel.add(lblTestDiary);
		    			
		    			// 물건 X
		    			JButton btnGunX = new JButton();
		    			btnGunX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/GunX.png"));
		    			btnGunX.setBounds(1101, 666, 126, 119);
		    			btnGunX.setVisible(false);
		    			diary0Panel.add(btnGunX);
		    			
		    			JButton btnChessboardX = new JButton();
		    			btnChessboardX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/ChessboardX.png"));
		    			btnChessboardX.setBounds(1212, 706, 119, 71);
		    			btnChessboardX.setVisible(false);
		    			diary0Panel.add(btnChessboardX);
		    			
		    			JButton btnGasmaskX = new JButton();
		    			btnGasmaskX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/GasmaskX.png"));
		    			btnGasmaskX.setBounds(909, 683, 95, 120);
		    			btnGasmaskX.setVisible(false);
		    			diary0Panel.add(btnGasmaskX);
		    			
		    			JButton btnFlashlightX = new JButton();
		    			btnFlashlightX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/FlashlightX.png"));
		    			btnFlashlightX.setBounds(1028, 691, 112, 94);
		    			btnFlashlightX.setVisible(false);
		    			diary0Panel.add(btnFlashlightX);
		    			
		    			JButton btnAxeX = new JButton();
		    			btnAxeX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/AxeX.png"));
		    			btnAxeX.setBounds(1006, 666, 118, 110);
		    			btnAxeX.setVisible(false);
		    			diary0Panel.add(btnAxeX);
		    			
		    			JButton btnAidkitX = new JButton();
		    			btnAidkitX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/AidkitX.png"));
		    			btnAidkitX.setBounds(1105, 706, 88, 74);
		    			btnAidkitX.setVisible(false);
		    			diary0Panel.add(btnAidkitX);
		    			
		    			JButton btnBookX = new JButton();
		    			btnBookX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/BookX.png"));
		    			btnBookX.setBounds(998, 706, 93, 87);
		    			btnBookX.setVisible(false);
		    			diary0Panel.add(btnBookX);
		    			
		    			JButton btnPesticideX = new JButton();
		    			btnPesticideX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/PesticideX.png"));
		    			btnPesticideX.setBounds(907, 695, 46, 96);
		    			btnPesticideX.setVisible(false);
		    			diary0Panel.add(btnPesticideX);
		    			
		    			JButton btnCardX = new JButton();
		    			btnCardX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/CardX.png"));
		    			btnCardX.setBounds(984, 684, 91, 102);
		    			btnCardX.setVisible(false);
		    			diary0Panel.add(btnCardX);
		    			
		    			JButton btnMapX = new JButton();
		    			btnMapX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/MapX.png"));
		    			btnMapX.setBounds(883, 706, 120, 89);
		    			btnMapX.setVisible(false);
		    			diary0Panel.add(btnMapX);
		    			
		    			JButton btnRadioX = new JButton();
		    			btnRadioX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/RadioX.png"));  //****************** 경로 잘못 설정*********
		    			btnRadioX.setBounds(1092, 701, 116, 84);
		    			btnRadioX.setVisible(false);
		    			diary0Panel.add(btnRadioX);
		    			
		    			// 버튼 _SelectionO
		    			JButton btnSelectionO = new JButton();
		    			btnSelectionO.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/O_Selection.png"));
		    			btnSelectionO.setBounds(1100, 658, 126, 138);
		    			btnSelectionO.setVisible(false);
		    			diary0Panel.add(btnSelectionO);
		    			
		    			JButton btnSelectionX = new JButton();
		    			btnSelectionX.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/X_Selection.png"));
		    			btnSelectionX.setBounds(897, 677, 98, 119);
		    			btnSelectionX.setVisible(false);
		    			diary0Panel.add(btnSelectionX);
		    			
		    			JButton btnSelectionBackB = new JButton();
		    			btnSelectionBackB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/뒤로가기화살표_Selection.png"));
		    			btnSelectionBackB.setBounds(1262, 121, 91, 73);
		    			btnSelectionBackB.setVisible(false);
		    			diary0Panel.add(btnSelectionBackB);
		    			
		    			JButton btnSelectionRightB = new JButton();
		    			btnSelectionRightB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/오른쪽화살표_Selection.png"));
		    			btnSelectionRightB.setBounds(1110, 817, 209, 115);
		    			btnSelectionRightB.setVisible(false);
		    			diary0Panel.add(btnSelectionRightB);
		    			
		    			JButton btnSelectionLeftB = new JButton();
		    			btnSelectionLeftB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/왼쪽화살표_Selection.png"));
		    			btnSelectionLeftB.setBounds(753, 817, 218, 127);
		    			btnSelectionLeftB.setVisible(false);
		    			diary0Panel.add(btnSelectionLeftB);
		    			
		    			JButton btnSelectionBullet = new JButton();
		    			btnSelectionBullet.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Bullet_Selection.png"));
		    			btnSelectionBullet.setBounds(906, 694, 89, 89);
		    			btnSelectionBullet.setVisible(false);
		    			diary0Panel.add(btnSelectionBullet);
		    			
		    			JButton btnSelectionGun = new JButton();
		    			btnSelectionGun.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Gun_Selection.png"));
		    			btnSelectionGun.setBounds(1101, 666, 98, 122);
		    			btnSelectionGun.setVisible(false);
		    			diary0Panel.add(btnSelectionGun);
		    			
		    			JButton btnSelectionChessboard = new JButton();
		    			btnSelectionChessboard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Chessboard_Selection.png"));
		    			btnSelectionChessboard.setBounds(1202, 693, 104, 73);
		    			btnSelectionChessboard.setVisible(false);
		    			diary0Panel.add(btnSelectionChessboard);
		    			
		    			JButton btnSelectionGasmask = new JButton();
		    			btnSelectionGasmask.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Gasmask_Selection.png"));
		    			btnSelectionGasmask.setBounds(909, 683, 46, 100);
		    			btnSelectionGasmask.setVisible(false);
		    			diary0Panel.add(btnSelectionGasmask);
		    			
		    			JButton btnSelectionFlashlight = new JButton(); // 손전등 선택 X사진이 없음
		    			btnSelectionFlashlight.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Flashlight_Selection.png"));
		    			btnSelectionFlashlight.setBounds(1028, 691, 77, 100);
		    			btnSelectionFlashlight.setVisible(false);
		    			diary0Panel.add(btnSelectionFlashlight);
		    			
		    			JButton btnSelectionAxe = new JButton();
		    			btnSelectionAxe.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Axe_Selection.png"));
		    			btnSelectionAxe.setBounds(1006, 666, 71, 135);
		    			btnSelectionAxe.setVisible(false);
		    			diary0Panel.add(btnSelectionAxe);
		    			
		    			JButton btnSelectionAidkit = new JButton();
		    			btnSelectionAidkit.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Aidkit_Selection.png"));
		    			btnSelectionAidkit.setBounds(1105, 706, 87, 54);
		    			btnSelectionAidkit.setVisible(false);
		    			diary0Panel.add(btnSelectionAidkit);
		    			
		    			JButton btnSelectionBook = new JButton();
		    			btnSelectionBook.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Book_Selection.png"));
		    			btnSelectionBook.setBounds(998, 706, 93, 71);
		    			btnSelectionBook.setVisible(false);
		    			diary0Panel.add(btnSelectionBook);
		    			
		    			JButton btnSelectionPesticide = new JButton();
		    			btnSelectionPesticide.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Pesticide_Map_Selection.png"));
		    			btnSelectionPesticide.setBounds(907, 695, 52, 100);
		    			btnSelectionPesticide.setVisible(false);
		    			diary0Panel.add(btnSelectionPesticide);
		    			
		    			JButton btnSelectionCard = new JButton();
		    			btnSelectionCard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Card_Selection.png"));
		    			btnSelectionCard.setBounds(984, 684, 98, 106);
		    			btnSelectionCard.setVisible(false);
		    			diary0Panel.add(btnSelectionCard);
		    			
		    			JButton btnSelectionRadio = new JButton();
		    			btnSelectionRadio.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Radio_Selection.png"));
		    			btnSelectionRadio.setBounds(1092, 701, 103, 77); 
		    			btnSelectionRadio.setVisible(false);
		    			diary0Panel.add(btnSelectionRadio);
		    			
		    			JButton btnSelectionMap = new JButton();
		    			btnSelectionMap.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Map_Selection.png"));
		    			btnSelectionMap.setBounds(883, 706, 88, 66);
		    			btnSelectionMap.setVisible(false);
		    			diary0Panel.add(btnSelectionMap);
		    			
		    			// 버튼 선택X
		    			JButton btnO = new JButton();
		    			btnO.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/O.png"));
		    			btnO.setBounds(1100, 658, 129, 138);
		    			btnO.setVisible(false);
		    			diary0Panel.add(btnO);
		    			
		    			JButton btnX = new JButton();
		    			btnX.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/X.png"));
		    			btnX.setBounds(904, 673, 108, 132);
		    			btnX.setVisible(false);
		    			diary0Panel.add(btnX);
		    			
		    			JButton btnBackB = new JButton();
		    			btnBackB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/뒤로가기화살표_SelectionX.png"));
		    			btnBackB.setBounds(1279, 138, 74, 42);
		    			btnBackB.setVisible(false);
		    			diary0Panel.add(btnBackB);
		    			
		    			JButton btnRightB = new JButton();
		    			btnRightB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/오른쪽화살표_SelectionX.png"));
		    			btnRightB.setBounds(1112, 816, 176, 94);
		    			btnRightB.setVisible(false);
		    			diary0Panel.add(btnRightB);
		    			
		    			JButton btnLeftB = new JButton();
		    			btnLeftB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/왼쪽화살표_SelectionX.png"));
		    			btnLeftB.setBounds(801, 850, 172, 67);
		    			btnLeftB.setVisible(false);
		    			diary0Panel.add(btnLeftB);
		    			
		    			JButton btnBullet = new JButton();
		    			btnBullet.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Bullet_SelectionX.png"));
		    			btnBullet.setBounds(906, 694, 89, 89);
		    			btnBullet.setVisible(false);
		    			diary0Panel.add(btnBullet);
		    			
		    			JButton btnGun = new JButton();
		    			btnGun.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Gun_SelectionX.png"));
		    			btnGun.setBounds(1101, 666, 109, 139);
		    			btnGun.setVisible(false);
		    			diary0Panel.add(btnGun);
		    			
		    			JButton btnChessboard = new JButton();
		    			btnChessboard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/보드_SelectionX.png"));
		    			btnChessboard.setBounds(1202, 693, 106, 88);
		    			btnChessboard.setVisible(false);
		    			diary0Panel.add(btnChessboard);
		    			
		    			JButton btnGasmask = new JButton();
		    			btnGasmask.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Gasmask_SelectionX.png"));
		    			btnGasmask.setBounds(909, 683, 46, 100);
		    			btnGasmask.setVisible(false);
		    			diary0Panel.add(btnGasmask);
		    			
		    			JButton btnFlashlight = new JButton();
		    			btnFlashlight.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Flashlight_SelectionX.png"));
		    			btnFlashlight.setBounds(1028, 691, 77, 100);
		    			btnFlashlight.setVisible(false);
		    			diary0Panel.add(btnFlashlight);
		    			
		    			JButton btnAxe = new JButton();
		    			btnAxe.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Axe_SelectionX.png"));
		    			btnAxe.setBounds(1006, 666, 71, 135);
		    			btnAxe.setVisible(false);
		    			diary0Panel.add(btnAxe);
		    			
		    			JButton btnAidkit = new JButton();
		    			btnAidkit.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Aidkit_SelectionX.png"));
		    			btnAidkit.setBounds(1105, 706, 88, 54);
		    			btnAidkit.setVisible(false);
		    			diary0Panel.add(btnAidkit);
		    			
		    			JButton btnBook = new JButton();
		    			btnBook.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Book_SelectionX.png"));
		    			btnBook.setBounds(998, 706, 93, 71);
		    			btnBook.setVisible(false);
		    			diary0Panel.add(btnBook);
		    			
		    			JButton btnPesticide = new JButton();
		    			btnPesticide.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Pesticide_SelectionX.png"));
		    			btnPesticide.setBounds(907, 695, 46, 100);
		    			btnPesticide.setVisible(false);
		    			diary0Panel.add(btnPesticide);
		    			
		    			JButton btnCard = new JButton();
		    			btnCard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Card_SelectionX.png"));
		    			btnCard.setBounds(984, 684, 111, 113);
		    			btnCard.setVisible(false);
		    			diary0Panel.add(btnCard);
		    			
		    			JButton btnRadio = new JButton();
		    			btnRadio.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Radio_SelectionX.png"));
		    			btnRadio.setBounds(1092, 701, 116, 84);
		    			btnRadio.setVisible(false);
		    			diary0Panel.add(btnRadio);
		    			
		    			JButton btnMap = new JButton();
		    			btnMap.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Map_SelectionX.png"));
		    			btnMap.setBounds(883, 706, 88, 66);
		    			btnMap.setVisible(false);
		    			diary0Panel.add(btnMap);
		    			
		    			// 다이어리 이벤트
		    			lblDiary15 = new JLabel();
		    			lblDiary15.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent15.png"));
		    			lblDiary15.setBounds(0, 0, 1902, 1033);
		    			lblDiary15.setVisible(false);	
		    			diary0Panel.add(lblDiary15);
		    			
		    			lblDiary14 = new JLabel();
		    			lblDiary14.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent14.png"));
		    			lblDiary14.setBounds(0, 0, 1902, 1033);
		    			lblDiary14.setVisible(false);	
		    			diary0Panel.add(lblDiary14);
		    			
		    			lblDiary13 = new JLabel();
		    			lblDiary13.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent13.png"));
		    			lblDiary13.setBounds(0, 0, 1902, 1033);
		    			lblDiary13.setVisible(false);	
		    			diary0Panel.add(lblDiary13);
		    			
		    			lblDiary12 = new JLabel();
		    			lblDiary12.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent12.png"));
		    			lblDiary12.setBounds(0, 0, 1902, 1033);
		    			lblDiary12.setVisible(false);	
		    			diary0Panel.add(lblDiary12);
		    			
		    			lblDiary11 = new JLabel();
		    			lblDiary11.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent11.png"));
		    			lblDiary11.setBounds(0, 0, 1902, 1033);
		    			lblDiary11.setVisible(false);	
		    			diary0Panel.add(lblDiary11);
		    			
		    			lblDiary10 = new JLabel();
		    			lblDiary10.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent10.png"));
		    			lblDiary10.setBounds(0, 0, 1902, 1033);
		    			lblDiary10.setVisible(false);	
		    			diary0Panel.add(lblDiary10);
		    			
		    			lblDiary9 = new JLabel();
		    			lblDiary9.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent9.png"));
		    			lblDiary9.setBounds(0, 0, 1902, 1033);
		    			lblDiary9.setVisible(false);	
		    			diary0Panel.add(lblDiary9);
		    			
		    			lblDiary8 = new JLabel();
		    			lblDiary8.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent8.png"));
		    			lblDiary8.setBounds(0, 0, 1902, 1033);
		    			lblDiary8.setVisible(false);	
		    			diary0Panel.add(lblDiary8);
		    			
		    			lblDiary7 = new JLabel();
		    			lblDiary7.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent7.png"));
		    			lblDiary7.setBounds(0, 0, 1902, 1033);
		    			lblDiary7.setVisible(false);	
		    			diary0Panel.add(lblDiary7);
		    			
		    			lblDiary6 = new JLabel();
		    			lblDiary6.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent6.png"));
		    			lblDiary6.setBounds(0, 0, 1902, 1033);
		    			lblDiary6.setVisible(false);	
		    			diary0Panel.add(lblDiary6);
		    			
		    			lblDiary5 = new JLabel();
		    			lblDiary5.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent5.png"));
		    			lblDiary5.setBounds(0, 0, 1902, 1033);
		    			lblDiary5.setVisible(false);	
		    			diary0Panel.add(lblDiary5);
		    			
		    			lblDiary4 = new JLabel();
		    			lblDiary4.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent4.png"));
		    			lblDiary4.setBounds(0, 0, 1902, 1033);
		    			lblDiary4.setVisible(false);	
		    			diary0Panel.add(lblDiary4);
		    			
		    			lblDiary3 = new JLabel();
		    			lblDiary3.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent3.png"));
		    			lblDiary3.setBounds(0, 0, 1902, 1033);
		    			lblDiary3.setVisible(false);	
		    			diary0Panel.add(lblDiary3);
		    			
		    			lblDiary2 = new JLabel();
		    			lblDiary2.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent2.png"));
		    			lblDiary2.setBounds(0, 0, 1902, 1033);
		    			lblDiary2.setVisible(false);	
		    			diary0Panel.add(lblDiary2);
		    			
		    			lblDiary1 = new JLabel();
		    			lblDiary1.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent1.png"));
		    			lblDiary1.setBounds(0, 0, 1902, 1033);
		    			lblDiary1.setVisible(false);	
		    			diary0Panel.add(lblDiary1);
		    			
		    			lblNormalDiary = new JLabel();
		    			lblNormalDiary.setIcon(new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png"));
		    			lblNormalDiary.setBounds(0, 0, 1902, 1033);
		    			lblNormalDiary.setVisible(false);	
		    			diary0Panel.add(lblNormalDiary);
		    			
		    			// 다이어리 성공 이벤트
		    			lblSDiary1 = new JLabel();
		    			lblSDiary1.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Radio.png"));
		    			lblSDiary1.setBounds(0, 0, 1902, 1033);
		    			lblSDiary1.setVisible(false);
		    			diary0Panel.add(lblSDiary1);
		    			
		    			lblSDiary2 = new JLabel();
		    			lblSDiary2.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Gun.png"));
		    			lblSDiary2.setBounds(0, 0, 1902, 1033);
		    			lblSDiary2.setVisible(false);
		    			diary0Panel.add(lblSDiary2);
		    			
		    			lblSDiary3 = new JLabel();
		    			lblSDiary3.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Map.png"));
		    			lblSDiary3.setBounds(0, 0, 1902, 1033);
		    			lblSDiary3.setVisible(false);
		    			diary0Panel.add(lblSDiary3);
		    			
		    			lblSDiary4 = new JLabel();
		    			lblSDiary4.setIcon(new ImageIcon("img/DiarySrc/Event/Event_문열기.png"));
		    			lblSDiary4.setBounds(0, 0, 1902, 1033);
		    			lblSDiary4.setVisible(false);
		    			diary0Panel.add(lblSDiary4);
		    			
		    			lblSurvive = new JLabel();
		    			lblSurvive.setIcon(new ImageIcon("img/DiarySrc/Ending/생존.png"));
		    			lblSurvive.setBounds(0, 0, 1902, 1033);
		    			lblSurvive.setVisible(false);
		    			diary0Panel.add(lblSurvive);
		    			
		    			lblDie = new JLabel();
		    			lblDie.setIcon(new ImageIcon("img/DiarySrc/Ending/비명횡사.png"));
		    			lblDie.setBounds(0, 0, 1902, 1033);
		    			lblDie.setVisible(false);
		    			diary0Panel.add(lblDie);
		    		    
		    			//lblNormalDiary.setVisible(false);
		    		/*lblDiaryF.setVisible(false);
		    		lblDiaryFX.setVisible(false);
		    		lblDiaryM.setVisible(false);
		    		lblDiaryMX.setVisible(false);
		    		lblDiaryD.setVisible(false);
		    		lblDiaryDX.setVisible(false);
		    		lblDiaryS.setVisible(false);
		    		lblDiarySX.setVisible(false);
		    		lblFood0.setVisible(false);
		    		lblFood1.setVisible(false);
		    		lblFood2.setVisible(false);
		    		lblFood3.setVisible(false);
		    		lblFood4.setVisible(false);
		    		lblWater0.setVisible(false);
		    		lblWater1.setVisible(false);
		    		lblWater2.setVisible(false);
		    		lblWater3.setVisible(false);
		    		lblWater4.setVisible(false);
		    		btnFFoodX.setVisible(false);
		    		btnFFood.setVisible(false);
		    		btnFWaterX.setVisible(false);
		    		btnFWater.setVisible(false);
		    		btnMFoodX.setVisible(false);
		    		btnMFood.setVisible(false);
		    		btnMWaterX.setVisible(false);
		    		btnMWater.setVisible(false);
		    		btnDFoodX.setVisible(false);
		    		btnDFood.setVisible(false);
		    		btnDWaterX.setVisible(false);
		    		btnDWater.setVisible(false);
		    		btnSFoodX.setVisible(false);
		    		btnSFood.setVisible(false);
		    		btnSWaterX.setVisible(false);
		    		btnSWater.setVisible(false);
		    		lblDay.setVisible(false);
		    		btnBackB.setVisible(false);
		    		btnLeftB.setVisible(false);
		    		btnRightB.setVisible(false);
		    		btnSelectionRightB.setVisible(false);
		    		btnSelectionLeftB.setVisible(false);
		    		btnSelectionBackB.setVisible(false);
		    		lblFood.setVisible(false);
		    		lblWater.setVisible(false);
		    		lblDiary1.setVisible(false);
		    		lblDiary2.setVisible(false);
		    		lblDiary3.setVisible(false);
		    		lblDiary4.setVisible(false);
		    		lblDiary5.setVisible(false);
		    		lblDiary6.setVisible(false);
		    		lblDiary7.setVisible(false);
		    		lblDiary8.setVisible(false);
		    		lblDiary9.setVisible(false);
		    		lblDiary10.setVisible(false);
		    		lblDiary11.setVisible(false);
		    		lblDiary12.setVisible(false);
		    		lblDiary13.setVisible(false);
		    		lblDiary14.setVisible(false);
		    		lblDiary15.setVisible(false);
		    		btnGunX.setVisible(false);
		    		btnChessboardX.setVisible(false);
		    		btnGasmaskX.setVisible(false);
		    		btnFlashlightX.setVisible(false);
		    		btnAxeX.setVisible(false);
		    		btnAidkitX.setVisible(false);
		    		btnBookX.setVisible(false);
		    		btnPesticideX.setVisible(false);
		    		btnCardX.setVisible(false);
		    		btnMapX.setVisible(false);
		    		btnRadioX.setVisible(false);
		    		btnSelectionO.setVisible(false);
		    		btnSelectionX.setVisible(false);
		    		btnSelectionBackB.setVisible(false);
		    		btnSelectionRightB.setVisible(false);
		    		btnSelectionLeftB.setVisible(false);
		    		btnSelectionBullet.setVisible(false);
		    		btnSelectionGun.setVisible(false);
		    		btnSelectionChessboard.setVisible(false);
		    		btnSelectionGasmask.setVisible(false);
		    		btnSelectionFlashlight.setVisible(false);
		    		btnSelectionAxe.setVisible(false);
		    		btnSelectionAidkit.setVisible(false);
		    		btnSelectionBook.setVisible(false);
		    		btnSelectionPesticide.setVisible(false);
		    		btnSelectionCard.setVisible(false);
		    		btnSelectionRadio.setVisible(false);
		    		btnSelectionMap.setVisible(false);
		    		btnO.setVisible(false);
		    		btnX.setVisible(false);
		    		btnBackB.setVisible(false);
		    		btnRightB.setVisible(false);
		    		btnLeftB.setVisible(false);
		    		btnBullet.setVisible(false);
		    		btnGun.setVisible(false);
		    		btnChessboard.setVisible(false);
		    		btnGasmask.setVisible(false);
		    		btnFlashlight.setVisible(false);
		    		btnAxe.setVisible(false);
		    		btnAidkit.setVisible(false);
		    		btnBook .setVisible(false);
		    		btnPesticide.setVisible(false);
		    		btnCard.setVisible(false);
		    		btnRadio.setVisible(false);
		    		btnMap.setVisible(false);
		    		lblFoodFText.setVisible(false);
		    		lblWaterFText.setVisible(false);
		    		lblFoodMText.setVisible(false);
		    		lblWaterMText.setVisible(false);
		    		lblFoodSText.setVisible(false);
		    		lblWaterSText.setVisible(false);
		    		lblFoodDText.setVisible(false);
		    		lblWaterDText.setVisible(false);
		    		lblIsOutside.setVisible(false);
		    		lblComeBack.setVisible(false);
		    		lblTotalGotItem.setVisible(false);*/
		    		
		    		btnOpenDiary.setVisible(true);
		    		
		    		
		    	} // Diary0()
		    	
		    }
