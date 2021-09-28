import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Game extends JPanel {

	//public static JPanel contentPane;

/*	
	public static void main(String[] args) throws InterruptedException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame("60");
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        
			        Game game = new Game();
			        frame.getContentPane().add(game);
			        
			        frame.pack();
			        frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public static ConPanel father, mother, daughter, son;
	public Maze maze;
	public static int nEvent, nSurEvent, aEvent;
	public int nSCount = 0;
	public static int nRandomResult = (int)(Math.random()*3); // 0~3
	public static int eventSelectData;
	
	public JLabel lblFoodText, lblWaterText;
	public static JLabel lblFoodFText;
	public JLabel lblFoodMText;
	public JLabel lblFoodDText;
	public JLabel lblFoodSText;
	public static JLabel lblWaterFText;
	public JLabel lblWaterMText;
	public JLabel lblWaterDText;
	public JLabel lblWaterSText;
	public JLabel lblFood0,lblFood1, lblFood2, lblFood3, lblFood4;
	public JLabel lblWater0, lblWater1, lblWater2, lblWater3, lblWater4;
	public JLabel lblDiary15, lblDiary14, lblDiary13, lblDiary12;
	public JLabel lblDiary11, lblDiary10, lblDiary9, lblDiary8, lblDiary7;
	public JLabel lblDiary6, lblDiary5, lblDiary4, lblDiary3;
	public JLabel lblDiary2, lblDiary1, lblNormalDiary, lblTestDiary;
	public JLabel lblDiaryF, lblDiaryFX, lblDiaryM, lblDiaryMX, lblDiaryD;
	public JLabel lblDiaryDX, lblDiaryS, lblDiarySX, lblDay, lblFood, lblWater;
	public JLabel lblSDiary1, lblSDiary2, lblSDiary3, lblSDiary4, lblSurvive, lblDie;
	
	public JButton btnSFoodX, btnSFood, btnSWaterX, btnSWater;
	public JButton btnDFoodX, btnDFood, btnDWaterX, btnDWater;
	public JButton btnMFoodX, btnMFood, btnMWaterX, btnMWater;
	public JButton btnFFoodX, btnFFood, btnFWaterX, btnFWater;
	
	public JButton btnGunX, btnChessboardX, btnGasmaskX, btnFlashlightX;
	public JButton btnAxeX, btnAidkitX, btnBookX, btnPesticideX;
	public JButton btnCardX, btnMapX, btnRadioX;
	
	public JButton btnSelectionO, btnSelectionX;
	public JButton btnSelectionBullet, btnSelectionGun;
	public JButton btnSelectionChessboard, btnSelectionGasmask;
	public JButton btnSelectionFlashlight, btnSelectionAxe;
	public JButton btnSelectionAidkit, btnSelectionBook;
	public JButton btnSelectionPesticide, btnSelectionCard;
	public JButton btnSelectionRadio, btnSelectionMap, btnOpenDiary;
	
	public JButton btnO, btnX;
	public JButton btnBullet, btnGun, btnChessboard, btnGasmask;
	public JButton btnFlashlight, btnAxe, btnAidkit, btnBook;
	public JButton btnPesticide, btnCard, btnRadio, btnMap;
	
	public static int shelterAidkit, shelterAxe, shelterBook, shelterBullet;
	public static int shelterCard, shelterChessboard, shelterFlashlight;
	public static int shelterGasmask, shelterGun, shelterMap, shelterRadio, shelterPesticide;
	public static int shelterFood, shelterWater, nshelterFood, nshelterWater; // nDay�� ��¥�� ������
	//public static int nDay = 1;
	public static int shelterM, shelterF, shelterD, shelterS;
	
	public JLabel lblFClear, lblMClear, lblDClear, lblSClear;
	public JLabel lblSNormal, lblSCrazyExhausted, lblSSick, lblSCrazy, lblSExhaustedSick, lblSExhausted;
	public JLabel lblDTired, lblDNormal, lblDSickExhaustedInjury, lblDSickExhaustedCrazy;
	public JLabel lblDSickExhausted, lblDSick, lblDExhaustedInjury, lblDExhausted;
	public JLabel lblMTired, lblMSickCrazyExhausted, lblMSick, lblMDead, lblMCrazy;
	public JLabel lblMExhaustedSickInjury, lblMExhaustedSick, lblMExhaustedCrazy, lblMExhausted, lblMNormal;
	public JLabel lblFDead, lblFExhaustedSickInjury, lblFExhaustedSick, lblFCrazyTired, lblFInjuryExhausted;
	public JLabel lblFSickCrazy, lblFSickTired, lblFExhausted, lblFCrazy, lblFInjury, lblFTired, lblFSick, lblFNormal;

	public static JLabel lblShelterFood2, lblShelterFood3, lblShelterFood1;
	public static JLabel lblShelterWater4, lblShelterWater3, lblShelterWater2, lblShelterWater1; 
	public static JLabel lblCard, lblBullet, lblGunBreak, lblGun, lblChessboard;
	public static JLabel lblBook, lblFlashlightBreak, lblFlashlight, lblPesticide, lblGasmaskBreak;
	public static JLabel lblGasmask, lblRadioBreak, lblRadio, lblMapBreak, lblMap, lblAxe;
	public static JLabel lblAidkitUse, lblAidkit, lblShelter;
	
	public static boolean selectWaterF;
	public static boolean selectFoodF;
	public static boolean selectWaterM;
	public static boolean selectFoodM;
	public static boolean selectWaterD;
	public static boolean selectFoodD;
	public static boolean selectWaterS;
	public static boolean selectFoodS;
	
	JLabel lblFConText, lblMConText, lblDConText, lblSConText;
	JLabel lblSCon, lblDCon, lblMCon, lblFCon;
	JLabel lblAdvFX,lblAdvDX,lblAdvMX,lblAdvSX; // Ž�� �Ұ����� ���� �̹���
	
	JButton btnAdvF, btnAdvSelectF, btnAdvM,  btnAdvSelectM; 
	JButton btnAdvD, btnAdvSelectD, btnAdvS,  btnAdvSelectS;
	
	
	public ConMouseL mouseL; // MouseListener
	public static int currentSelected; // Ž�� ���� �� ���
	// ����=1, �ƺ�=2, �Ƶ�=3, ��=4
	
	public static int isOutside; // �������� Ž�� �����ٸ� 1, �ƹ��� Ž������ �ƴϸ� 0
	public static int isOutsideM, isOutsideF, isOutsideS, isOutsideD; // �� ������ Ž�������� �ƴ���
	public int randomAdv; // �󸶳� �������� Ž������ �����ϴ� ���� --> �� Ž��Ⱓ
	
	public JLabel lblIsOutsideM, lblIsOutsideF, lblIsOutsideD, lblIsOutsideS;
	
	public static int eda, leaveHomeDay; // adventure() ����
	public static int ranWater, ranFood, ranCard, ranBullet, ranGun, ranChessboard, ranBook,
				ranFlashlight, ranPesticide, ranMap, ranGasmask, ranRadio, ranAxe, ranAidkit;
	// �������� ������ �����ð����� �ƴ��� �޴� ����
	
	public int tempWaterM, tempFoodM, tempMindM, tempConditionM, tempHealthM;
	public int tempWaterF, tempFoodF, tempMindF, tempConditionF, tempHealthF;
	public int tempWaterS, tempFoodS, tempMindS, tempConditionS, tempHealthS;
	public int tempWaterD, tempFoodD, tempMindD, tempConditionD, tempHealthD;
	// Ž�� ���� �� ������ ���¸� ������ ���� ����
	
	public static boolean backHomeM, backHomeF, backHomeS, backHomeD;
	// ���� Ž�迡�� ���ƿԴ��� Ȯ���ϱ� ���� ����
	
	public JLabel lblTotalGotItem; // Ž�迡�� ���� �����۵��� ���� �ؽ�Ʈ��
	public static String gotRadio, gotBullet, gotGun, gotChessboard, gotBook, gotFlashlight,
				gotPesticide, gotMap, gotGasmask, gotAxe, gotAidkit,gotCard, gotWater, gotFood;
	// Ž�迡�� �������� ������� �Ⱦ������ �ؽ�Ʈ�� ���� ������..lblTotalGotItem�� ��� ������� ����
	
	//public JLabel lblIsOutside, lblComeBack; // diaryPage 1�ʿ��� ���� ��������, Ȥ�� ���� ���ƿԴ��� ��Ÿ���� �ؽ�Ʈ ��
	public DiaryPage diaryPage;
	
	public Game() throws InterruptedException{
		setPreferredSize(new Dimension(1920, 1080));
		setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		ConPanel father = new ConPanel(this);
		ConPanel mother = new ConPanel(this);
		ConPanel daughter = new ConPanel(this);
		ConPanel son = new ConPanel(this);
		
		
		Maze maze = new Maze(); // Maze���� �����ۿ� ������ ������ �޴� Ŭ���� �����ϱ�
		
		//diaryL = new DiaryL();
		mouseL = new ConMouseL();
		
		setShelterItem(maze);
		//diaryPage(nDiaryPage);
		
		
		diaryPage = new DiaryPage();
		add(diaryPage);
		
		
		/*lblSCon = new JLabel();
		lblSCon.setVisible(false);
		lblSCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/S.png"));
		lblSCon.setBounds(821, 575, 80, 109);
		add(lblSCon);
		lblSCon.addMouseListener(mouseL);
		
		lblDCon = new JLabel();
		lblDCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/D.png"));
		lblDCon.setBounds(809, 448, 105, 125);
		lblDCon.setVisible(false);
		add(lblDCon);
		
		lblMCon = new JLabel();
		lblMCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/M.png"));
		lblMCon.setBounds(809, 324, 104, 121);
		lblMCon.setVisible(false);
	    add(lblMCon);
		
		lblFCon = new JLabel();
		lblFCon.setIcon(new ImageIcon("img/DiarySrc/Adventure/F.png"));
		lblFCon.setBounds(817, 207, 88, 114);
		lblFCon.setVisible(false);
		add(lblFCon);
		
		JButton btnAdvS = new JButton();
		btnAdvS.setIcon(new ImageIcon("DiarySr/Adventure/S__SelectionX.png"));
		btnAdvS.setBounds(1208, 699, 80, 114);
		btnAdvS.setVisible(false);
		add(btnAdvS);
		btnAdvS.addActionListener(diaryL);
		
		lblAdvSX = new JLabel();
		lblAdvSX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Sx.png"));
		lblAdvSX.setBounds(1183, 699, 136, 121);
		lblAdvSX.setVisible(false);
		add(lblAdvSX);
		
		JButton btnAdvSelectS = new JButton();
		btnAdvSelectS.setIcon(new ImageIcon("DiarySr/Adventure/S.png"));
		btnAdvSelectS.setBounds(1209, 698, 80, 109);
		btnAdvSelectS.addActionListener(diaryL);
		btnAdvSelectS.setVisible(false);
		add(btnAdvSelectS);
		
		lblAdvDX = new JLabel();
		lblAdvDX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Dx.png"));
		lblAdvDX.setBounds(1060, 684, 117, 129);
		lblAdvDX.setVisible(false);
		add(lblAdvDX);
		
		JButton btnAdvD = new JButton();
		btnAdvD.setIcon(new ImageIcon("DiarySr/Adventure/D__SelectionX.png"));
		btnAdvD.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdvD.setBounds(1060, 684, 113, 129);
		btnAdvD.addActionListener(diaryL);
		btnAdvD.setVisible(false);
		add(btnAdvD);
		
		JButton btnAdvSelectD = new JButton();
		btnAdvSelectD.setIcon(new ImageIcon("DiarySr/Adventure/D.png"));
		btnAdvSelectD.setBounds(1063, 686, 105, 125);
		btnAdvSelectD.addActionListener(diaryL);
		btnAdvSelectD.setVisible(false);
		add(btnAdvSelectD);
		
		JButton btnAdvM = new JButton();
		btnAdvM.setIcon(new ImageIcon("DiarySr/Adventure/M__SelectionX.png"));
		btnAdvM.setBounds(941, 689, 105, 124);
		btnAdvM.addActionListener(diaryL);
		btnAdvM.setVisible(false);
		add(btnAdvM);
		
		lblAdvMX = new JLabel();
		lblAdvMX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Mx.png"));
		lblAdvMX.setBounds(929, 670, 132, 165);
		lblAdvMX.setVisible(false);
		add(lblAdvMX);
		
		JButton btnAdvSelectM = new JButton();
		btnAdvSelectM.setIcon(new ImageIcon("DiarySr/Adventure/M.png"));
		btnAdvSelectM.setBounds(943, 690, 104, 121);
		btnAdvSelectM.addActionListener(diaryL);
		btnAdvSelectM.setVisible(false);
		add(btnAdvSelectM);
		
		JButton btnAdvF = new JButton();
		btnAdvF.setIcon(new ImageIcon("DiarySr/Adventure/F__SelectionX.png"));
		btnAdvF.setBounds(819, 695, 91, 118);
		btnAdvF.addActionListener(diaryL);
		btnAdvF.setVisible(false);
		add(btnAdvF);
		
		lblAdvFX = new JLabel();
		lblAdvFX.setIcon(new ImageIcon("img/DiarySrc/Adventure/Fx.png"));
		lblAdvFX.setBounds(791, 669, 143, 167);
		lblAdvFX.setVisible(false);
		add(lblAdvFX);
		
		JButton btnAdvSelectF = new JButton();
		btnAdvSelectF.setIcon(new ImageIcon("DiarySr/Adventure/F.png"));
		btnAdvSelectF.setBounds(821, 696, 88, 114);
		btnAdvSelectF.addActionListener(diaryL);
		btnAdvSelectF.setVisible(false);
		add(btnAdvSelectF);
		
		lblSConText = new JLabel("Son is okay to go on an expedition.");
		lblSConText.setFont(new Font("������� ExtraBold", Font.BOLD, 20));
		lblSConText.setBounds(943, 608, 334, 42);
		lblSConText.setVisible(false);
		add(lblSConText);
		
		lblDConText = new JLabel("Daughter is okay to go on an expedition.");
		lblDConText.setFont(new Font("������� ExtraBold", Font.BOLD, 20));
		lblDConText.setBounds(943, 488, 334, 42);
		lblDConText.setVisible(false);
		add(lblDConText);
		
		lblMConText = new JLabel("Mother is okay to go on an expedition.");
		lblMConText.setFont(new Font("������� ExtraBold", Font.BOLD, 20));
		lblMConText.setBounds(943, 361, 334, 42);
		lblMConText.setVisible(false);
		add(lblMConText);
		
		lblFConText = new JLabel("Father is okay to go on an expedition.");
		lblFConText.setFont(new Font("������� ExtraBold", Font.BOLD, 20));
		lblFConText.setBounds(943, 246, 334, 42);
		lblFConText.setVisible(false);
		add(lblFConText);
		
		lblBlack = new JLabel();
		lblBlack.setIcon(new ImageIcon("img/StuffSrc/Black.png"));
		lblBlack.setSize(1902, 1033);
		lblBlack.setVisible(false);
		lblBlack.addMouseListener(mouseL);
		lblBlack.setVisible(false);
		add(lblBlack);
		
		// Day
		lblDay = new JLabel();
		lblDay.setLocation(1000, 128);
		lblDay.setFont(new Font("������� ExtraBold", Font.BOLD, 38));
		lblDay.setSize(129, 72);
		lblDay.setText(nDay+"��"); // ������ nDay�� �ؽ�Ʈ�� ��ȯ
		lblDay.setVisible(false);
		add(lblDay);
		
		// ���� �������� ǥ�����ִ� ������ = nDiary1
		lblFoodText = new JLabel(""+shelterFood/4);
		lblFoodText.setVisible(false);
		add(lblFoodText);
		
		lblWaterText = new JLabel(""+shelterWater/4);
		lblWaterText.setVisible(false);
		add(lblWaterText);
		
		lblFoodFText = new JLabel();
		lblFoodFText.setVisible(false);
		add(lblFoodFText);
		
		lblFoodMText = new JLabel();
		lblFoodMText.setVisible(false);
		add(lblFoodMText);
		
		lblFoodDText = new JLabel();
		lblFoodDText.setVisible(false);
		add(lblFoodDText);
		
		lblFoodSText = new JLabel();
		lblFoodSText.setVisible(false);
		add(lblFoodSText);
		
		lblWaterFText = new JLabel();
		lblWaterFText.setVisible(false);
		add(lblWaterFText);
		
		lblWaterMText = new JLabel();
		lblWaterMText.setVisible(false);
		add(lblWaterMText);
		
		lblWaterDText = new JLabel();
		lblWaterDText.setVisible(false);
		add(lblWaterDText);
		
		lblWaterSText = new JLabel();
		lblWaterSText.setVisible(false);
		add(lblWaterSText);
		
		lblIsOutside = new JLabel();
		lblIsOutside.setVisible(false);
		add(lblIsOutside);
		
		lblComeBack = new JLabel();
		lblComeBack.setVisible(false);
		add(lblComeBack);
		
		
		// �ķ���� ������ = nDiary2
		lblFood = new JLabel();
		lblFood.setText("+"+(shelterFood-4));
		lblFood.setVisible(false);
		add(lblFood);
		
		lblWater = new JLabel();
		lblWater.setText("+"+(shelterWater-4));
		lblWater.setVisible(false);
		add(lblWater);
		
		lblFood0 = new JLabel();
		lblFood0.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food0.png"));
		lblFood0.setBounds(953, 627, 48, 63);
		lblFood0.setVisible(false);	
		add(lblFood0);
		
		lblFood1 = new JLabel();
		lblFood1.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food1.png"));
		lblFood1.setBounds(953, 627, 48, 63);
		lblFood1.setVisible(false);	
		add(lblFood1);
		
		lblFood2 = new JLabel();
		lblFood2.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food2.png"));
		lblFood2.setBounds(953, 627, 48, 63);
		lblFood2.setVisible(false);	
		add(lblFood2);
		
		lblFood3 = new JLabel();
		lblFood3.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food3.png"));
		lblFood3.setBounds(953, 627, 48, 63);
		lblFood3.setVisible(false);	
		add(lblFood3);
		
		lblFood4 = new JLabel();
		lblFood4.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food4.png"));
		lblFood4.setBounds(953, 627, 48, 63); // 845, 627, 48, 63
		lblFood4.setVisible(false);	
		add(lblFood4);
		
		lblWater0 = new JLabel();
		lblWater0.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water0.png"));
		lblWater0.setBounds(957, 713, 46, 80); 
		lblWater0.setVisible(false);	
		add(lblWater0);
		
		lblWater1 = new JLabel();
		lblWater1.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water1.png"));
		lblWater1.setBounds(957, 713, 46, 80);
		lblWater1.setVisible(false);	
		add(lblWater1);
		
		lblWater2 = new JLabel();
		lblWater2.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water2.png"));
		lblWater2.setBounds(957, 713, 46, 80);
		lblWater2.setVisible(false);	
		add(lblWater2);
		
		lblWater3 = new JLabel();
		lblWater3.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water3.png"));
		lblWater3.setBounds(957, 713, 46, 80);
		lblWater3.setVisible(false);	
		add(lblWater3);
		
		lblWater4 = new JLabel();
		lblWater4.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water4.png"));
		lblWater4.setBounds(957, 713, 46, 80); //851, 716, 44, 78
		lblWater4.setVisible(false);	
		add(lblWater4);
		
		JButton btnSFoodX = new JButton();
		btnSFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		btnSFoodX.setBounds(1217, 483, 45, 54);
		btnSFoodX.addActionListener(diaryL);
		btnSFoodX.setVisible(false);
		add(btnSFoodX);
		
		JButton btnSFood = new JButton();
		btnSFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		btnSFood.setBounds(1217, 483, 45, 54);
		btnSFood.addActionListener(diaryL);
		btnSFood.setVisible(false);
		add(btnSFood);
		
		JButton btnSWaterX = new JButton();
		btnSWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		btnSWaterX.setBounds(1177, 480, 33, 55);
		btnSWaterX.addActionListener(diaryL);
		btnSWaterX.setVisible(false);
		add(btnSWaterX);
		
		JButton btnSWater = new JButton();
		btnSWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		btnSWater.setBounds(1177, 480, 33, 55);
		btnSWater.addActionListener(diaryL);
		btnSWater.setVisible(false);
		add(btnSWater);
		
		JButton btnDFoodX = new JButton();
		btnDFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		btnDFoodX.setBounds(1093, 483, 45, 54);
		btnDFoodX.addActionListener(diaryL);
		btnDFoodX.setVisible(false);
		add(btnDFoodX);
		
		JButton btnDFood = new JButton();
		btnDFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		btnDFood.setBounds(1093, 483, 45, 54);
		btnDFood.addActionListener(diaryL);
		btnDFood.setVisible(false);
		add(btnDFood);
		
		JButton btnDWaterX = new JButton();
		btnDWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		btnDWaterX.setBounds(1054, 480, 33, 55);
		btnDWaterX.addActionListener(diaryL);
		btnDWaterX.setVisible(false);
		add(btnDWaterX);
		
		JButton btnDWater = new JButton();
		btnDWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		btnDWater.setBounds(1054, 480, 33, 55);
		btnDWater.addActionListener(diaryL);
		btnDWater.setVisible(false);
		add(btnDWater);
		
		JButton btnMFoodX = new JButton();
		btnMFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		btnMFoodX.setBounds(953, 483, 45, 54);
		btnMFoodX.addActionListener(diaryL);
		btnMFoodX.setVisible(false);
		add(btnMFoodX);
		
		JButton btnMFood = new JButton();
		btnMFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		btnMFood.setBounds(953, 483, 45, 54);
		btnMFood.addActionListener(diaryL);
		btnMFood.setVisible(false);
		add(btnMFood);
		
		JButton btnMWaterX = new JButton();
		btnMWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		btnMWaterX.setBounds(913, 480, 33, 55);
		btnMWaterX.addActionListener(diaryL);
		btnMWaterX.setVisible(false);
		add(btnMWaterX);
		
		JButton btnMWater = new JButton();
		btnMWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		btnMWater.setBounds(913, 480, 33, 55);
		btnMWater.addActionListener(diaryL);
		btnMWater.setVisible(false);
		add(btnMWater);
		
		JButton btnFFoodX = new JButton();
		btnFFoodX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_SelectionX.png"));
		btnFFoodX.setBounds(823, 483, 45, 54);
		btnFFoodX.addActionListener(diaryL);
		btnFFoodX.setVisible(false);
		add(btnFFoodX);
		
		JButton btnFFood = new JButton();
		btnFFood.setIcon(new ImageIcon("img/DiarySrc/Distribution/Food_Selection.png"));
		btnFFood.setBounds(823, 483, 45, 54);
		btnFFood.addActionListener(diaryL);
		btnFFood.setVisible(false);
		add(btnFFood);
		
		JButton btnFWaterX = new JButton();
		btnFWaterX.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_SelectionX.png"));
		btnFWaterX.setBounds(781, 480, 33, 55);
		btnFWaterX.addActionListener(diaryL);
		btnFWaterX.setVisible(false);
		add(btnFWaterX);
		
		JButton btnFWater = new JButton();
		btnFWater.setIcon(new ImageIcon("img/DiarySrc/Distribution/Water_Selection.png"));
		btnFWater.setBounds(781, 480, 33, 55);
		btnFWater.addActionListener(diaryL);
		btnFWater.setVisible(false);
		add(btnFWater);
		
	    lblDiarySX = new JLabel();
	    lblDiarySX.setIcon(new ImageIcon("img/DiarySrc/Distribution/SX.png"));
	    lblDiarySX.setBounds(1170, 357, 136, 125);
	    lblDiarySX.setVisible(false);
	    add(lblDiarySX);
	      
        lblDiaryS = new JLabel();
	    lblDiaryS.setIcon(new ImageIcon("img/DiarySrc/Distribution/S.png"));
	    lblDiaryS.setBounds(1195, 357, 80, 109);
	    lblDiaryS.setVisible(false);
	    add(lblDiaryS);
	      
	    lblDiaryDX = new JLabel();
	    lblDiaryDX.setIcon(new ImageIcon("img/DiarySrc/Distribution/DX.png"));
	    lblDiaryDX.setBounds(1037, 344, 117, 129);
	    lblDiaryDX.setVisible(false);
	    add(lblDiaryDX);
	      
	    lblDiaryD = new JLabel();
	    lblDiaryD.setIcon(new ImageIcon("img/DiarySrc/Distribution/D.png"));
	    lblDiaryD.setBounds(1040, 346, 105, 125);
	    lblDiaryD.setVisible(false);
	    add(lblDiaryD);
	      
	    lblDiaryMX = new JLabel();
	    lblDiaryMX.setIcon(new ImageIcon("img/DiarySrc/Distribution/MX.png"));
	    lblDiaryMX.setBounds(891, 330, 132, 165);
	    lblDiaryMX.setVisible(false);
	    add(lblDiaryMX);
	      
	    lblDiaryM = new JLabel();
        lblDiaryM.setIcon(new ImageIcon("img/DiarySrc/Distribution/M.png"));
	    lblDiaryM.setBounds(905, 349, 104, 121);
	    lblDiaryM.setVisible(false);
	    add(lblDiaryM);
	      
	    lblDiaryFX = new JLabel();
	    lblDiaryFX.setIcon(new ImageIcon("img/DiarySrc/Distribution/FX.png"));
	    lblDiaryFX.setBounds(750, 332, 143, 167);
	    lblDiaryFX.setVisible(false);
	    add(lblDiaryFX);
	      
	    lblDiaryF = new JLabel();
	    lblDiaryF.setIcon(new ImageIcon("img/DiarySrc/Distribution/F.png"));
	    lblDiaryF.setBounds(777, 360, 88, 114);
	    lblDiaryF.setVisible(false);
	    add(lblDiaryF);
	    //add(lblTestDiary);
		
		// ���� X
		JButton btnGunX = new JButton();
		btnGunX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/GunX.png"));
		btnGunX.setBounds(1101, 666, 126, 119);
		btnGunX.addActionListener(diaryL);
		btnGunX.setVisible(false);
		add(btnGunX);
		
		JButton btnChessboardX = new JButton();
		btnChessboardX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/ChessboardX.png"));
		btnChessboardX.setBounds(1212, 706, 119, 71);
		btnChessboardX.addActionListener(diaryL);
		btnChessboardX.setVisible(false);
		add(btnChessboardX);
		
		JButton btnGasmaskX = new JButton();
		btnGasmaskX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/GasmaskX.png"));
		btnGasmaskX.setBounds(909, 683, 95, 120);
		btnGasmaskX.addActionListener(diaryL);
		btnGasmaskX.setVisible(false);
		add(btnGasmaskX);
		
		JButton btnFlashlightX = new JButton();
		btnFlashlightX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/FlashlightX.png"));
		btnFlashlightX.setBounds(1028, 691, 112, 94);
		btnFlashlightX.addActionListener(diaryL);
		btnFlashlightX.setVisible(false);
		add(btnFlashlightX);
		
		JButton btnAxeX = new JButton();
		btnAxeX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/AxeX.png"));
		btnAxeX.setBounds(1006, 666, 118, 110);
		btnAxeX.addActionListener(diaryL);
		btnAxeX.setVisible(false);
		add(btnAxeX);
		
		JButton btnAidkitX = new JButton();
		btnAidkitX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/AidkitX.png"));
		btnAidkitX.setBounds(1105, 706, 88, 74);
		btnAidkitX.addActionListener(diaryL);
		btnAidkitX.setVisible(false);
		add(btnAidkitX);
		
		JButton btnBookX = new JButton();
		btnBookX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/BookX.png"));
		btnBookX.setBounds(998, 706, 93, 87);
		btnBookX.addActionListener(diaryL);
		btnBookX.setVisible(false);
		add(btnBookX);
		
		JButton btnPesticideX = new JButton();
		btnPesticideX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/PesticideX.png"));
		btnPesticideX.setBounds(907, 695, 46, 96);
		btnPesticideX.addActionListener(diaryL);
		btnPesticideX.setVisible(false);
		add(btnPesticideX);
		
		JButton btnCardX = new JButton();
		btnCardX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/CardX.png"));
		btnCardX.setBounds(984, 684, 91, 102);
		btnCardX.addActionListener(diaryL);
		btnCardX.setVisible(false);
		add(btnCardX);
		
		JButton btnMapX = new JButton();
		btnMapX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/MapX.png"));
		btnMapX.setBounds(883, 706, 120, 89);
		btnMapX.addActionListener(diaryL);
		btnMapX.setVisible(false);
		add(btnMapX);
		
		JButton btnRadioX = new JButton();
		btnRadioX.setIcon(new ImageIcon("img/DiarySrc/NotStuff/Map_Selection.png"));  //****************** ��� �߸� ����*********
		btnRadioX.setBounds(1092, 701, 116, 84);
		btnRadioX.addActionListener(diaryL);
		btnRadioX.setVisible(false);
		add(btnRadioX);
		
		// ��ư _SelectionO
		JButton btnSelectionO = new JButton();
		btnSelectionO.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/O_Selection.png"));
		btnSelectionO.setBounds(1100, 658, 126, 138);
		btnSelectionO.addActionListener(diaryL);
		btnSelectionO.setVisible(false);
		add(btnSelectionO);
		
		JButton btnSelectionX = new JButton();
		btnSelectionX.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/X_Selection.png"));
		btnSelectionX.setBounds(897, 677, 98, 119);
		btnSelectionX.addActionListener(diaryL);
		btnSelectionX.setVisible(false);
		add(btnSelectionX);
		
		JButton btnSelectionBackB = new JButton();
		btnSelectionBackB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/�ڷΰ���ȭ��ǥ_Selection.png"));
		btnSelectionBackB.setBounds(1262, 121, 91, 73);
		btnSelectionBackB.addActionListener(diaryL);
		btnSelectionBackB.addMouseListener(mouseL);
		btnSelectionBackB.setVisible(false);
		add(btnSelectionBackB);
		
		JButton btnSelectionRightB = new JButton();
		btnSelectionRightB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/������ȭ��ǥ_Selection.png"));
		btnSelectionRightB.setBounds(1110, 817, 209, 115);
		btnSelectionRightB.addActionListener(diaryL);
		btnSelectionRightB.addMouseListener(mouseL);
		btnSelectionRightB.setVisible(false);
		add(btnSelectionRightB);
		
		JButton btnSelectionLeftB = new JButton();
		btnSelectionLeftB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/����ȭ��ǥ_Selection.png"));
		btnSelectionLeftB.setBounds(753, 817, 218, 127);
		btnSelectionLeftB.addActionListener(diaryL);
		btnSelectionLeftB.addMouseListener(mouseL);
		btnSelectionLeftB.setVisible(false);
		add(btnSelectionLeftB);
		
		JButton btnSelectionBullet = new JButton();
		btnSelectionBullet.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Bullet_Selection.png"));
		btnSelectionBullet.setBounds(906, 694, 89, 89);
		btnSelectionBullet.addActionListener(diaryL);
		btnSelectionBullet.setVisible(false);
		add(btnSelectionBullet);
		
		JButton btnSelectionGun = new JButton();
		btnSelectionGun.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Gun_Selection.png"));
		btnSelectionGun.setBounds(1101, 666, 98, 122);
		btnSelectionGun.addActionListener(diaryL);
		btnSelectionGun.setVisible(false);
		add(btnSelectionGun);
		
		JButton btnSelectionChessboard = new JButton();
		btnSelectionChessboard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Chessboard_Selection.png"));
		btnSelectionChessboard.setBounds(1202, 693, 104, 73);
		btnSelectionChessboard.addActionListener(diaryL);
		btnSelectionChessboard.setVisible(false);
		add(btnSelectionChessboard);
		
		JButton btnSelectionGasmask = new JButton();
		btnSelectionGasmask.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Gasmask_Selection.png"));
		btnSelectionGasmask.setBounds(909, 683, 46, 100);
		btnSelectionGasmask.addActionListener(diaryL);
		btnSelectionGasmask.setVisible(false);
		add(btnSelectionGasmask);
		
		JButton btnSelectionFlashlight = new JButton(); // ������ ���� X������ ����
		btnSelectionFlashlight.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Flashlight_Selection.png"));
		btnSelectionFlashlight.setBounds(1028, 691, 77, 100);
		btnSelectionFlashlight.addActionListener(diaryL);
		btnSelectionFlashlight.setVisible(false);
		add(btnSelectionFlashlight);
		
		JButton btnSelectionAxe = new JButton();
		btnSelectionAxe.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Axe_Selection.png"));
		btnSelectionAxe.setBounds(1006, 666, 71, 135);
		btnSelectionAxe.addActionListener(diaryL);
		btnSelectionAxe.setVisible(false);
		add(btnSelectionAxe);
		
		JButton btnSelectionAidkit = new JButton();
		btnSelectionAidkit.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Aidkit_Selection.png"));
		btnSelectionAidkit.setBounds(1105, 706, 87, 54);
		btnSelectionAidkit.addActionListener(diaryL);
		btnSelectionAidkit.setVisible(false);
		add(btnSelectionAidkit);
		
		JButton btnSelectionBook = new JButton();
		btnSelectionBook.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Book_Selection.png"));
		btnSelectionBook.setBounds(998, 706, 93, 71);
		btnSelectionBook.addActionListener(diaryL);
		btnSelectionBook.setVisible(false);
		add(btnSelectionBook);
		
		JButton btnSelectionPesticide = new JButton();
		btnSelectionPesticide.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Pesticide_Map_Selection.png"));
		btnSelectionPesticide.setBounds(907, 695, 52, 100);
		btnSelectionPesticide.addActionListener(diaryL);
		btnSelectionPesticide.setVisible(false);
		add(btnSelectionPesticide);
		
		JButton btnSelectionCard = new JButton();
		btnSelectionCard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Card_Selection.png"));
		btnSelectionCard.setBounds(984, 684, 98, 106);
		btnSelectionCard.addActionListener(diaryL);
		btnSelectionCard.setVisible(false);
		add(btnSelectionCard);
		
		JButton btnSelectionRadio = new JButton();
		btnSelectionRadio.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Radio_Selection.png"));
		btnSelectionRadio.setBounds(1092, 701, 103, 77); 
		btnSelectionRadio.addActionListener(diaryL);
		btnSelectionRadio.setVisible(false);
		add(btnSelectionRadio);
		
		JButton btnSelectionMap = new JButton();
		btnSelectionMap.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/Map_Selection.png"));
		btnSelectionMap.setBounds(883, 706, 88, 66);
		btnSelectionMap.addActionListener(diaryL);
		btnSelectionMap.setVisible(false);
		add(btnSelectionMap);
		
		// ��ư ����X
		JButton btnO = new JButton();
		btnO.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/O.png"));
		btnO.setBounds(1100, 658, 129, 138);
		btnO.addActionListener(diaryL);
		btnO.setVisible(false);
		add(btnO);
		
		JButton btnX = new JButton();
		btnX.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/X.png"));
		btnX.setBounds(904, 673, 108, 132);
		btnX.addActionListener(diaryL);
		btnX.setVisible(false);
		add(btnX);
		
		JButton btnBackB = new JButton();
		btnBackB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/�ڷΰ���ȭ��ǥ_SelectionX.png"));
		btnBackB.setBounds(1279, 138, 74, 42);
		btnBackB.addActionListener(diaryL);
		btnBackB.addMouseListener(mouseL);
		btnBackB.setVisible(false);
		add(btnBackB);
		
		JButton btnRightB = new JButton();
		btnRightB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/������ȭ��ǥ_SelectionX.png"));
		btnRightB.setBounds(1112, 816, 176, 94);
		btnRightB.addActionListener(diaryL);
		btnRightB.addMouseListener(mouseL);
		btnRightB.setVisible(false);
		add(btnRightB);
		
		JButton btnLeftB = new JButton();
		btnLeftB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/����ȭ��ǥ_SelectionX.png"));
		btnLeftB.setBounds(801, 850, 172, 67);
		btnLeftB.addActionListener(diaryL);
		btnLeftB.addMouseListener(mouseL);
		btnLeftB.setVisible(false);
		add(btnLeftB);
		
		JButton btnBullet = new JButton();
		btnBullet.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Bullet_SelectionX.png"));
		btnBullet.setBounds(906, 694, 89, 89);
		btnBullet.addActionListener(diaryL);
		btnBullet.setVisible(false);
		add(btnBullet);
		
		JButton btnGun = new JButton();
		btnGun.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Gun_SelectionX.png"));
		btnGun.setBounds(1101, 666, 109, 139);
		btnGun.addActionListener(diaryL);
		btnGun.setVisible(false);
		add(btnGun);
		
		JButton btnChessboard = new JButton();
		btnChessboard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/����_SelectionX.png"));
		btnChessboard.setBounds(1202, 693, 106, 88);
		btnChessboard.addActionListener(diaryL);
		btnChessboard.setVisible(false);
		add(btnChessboard);
		
		JButton btnGasmask = new JButton();
		btnGasmask.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Gasmask_SelectionX.png"));
		btnGasmask.setBounds(909, 683, 46, 100);
		btnGasmask.addActionListener(diaryL);
		btnGasmask.setVisible(false);
		add(btnGasmask);
		
		JButton btnFlashlight = new JButton();
		btnFlashlight.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Flashlight_SelectionX.png"));
		btnFlashlight.setBounds(1028, 691, 77, 100);
		btnFlashlight.addActionListener(diaryL);
		btnFlashlight.setVisible(false);
		add(btnFlashlight);
		
		JButton btnAxe = new JButton();
		btnAxe.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Axe_SelectionX.png"));
		btnAxe.setBounds(1006, 666, 71, 135);
		btnAxe.addActionListener(diaryL);
		btnAxe.setVisible(false);
		add(btnAxe);
		
		JButton btnAidkit = new JButton();
		btnAidkit.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Aidkit_SelectionX.png"));
		btnAidkit.setBounds(1105, 706, 88, 54);
		btnAidkit.addActionListener(diaryL);
		btnAidkit.setVisible(false);
		add(btnAidkit);
		
		JButton btnBook = new JButton();
		btnBook.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Book_SelectionX.png"));
		btnBook.setBounds(998, 706, 93, 71);
		btnBook.addActionListener(diaryL);
		btnBook.setVisible(false);
		add(btnBook);
		
		JButton btnPesticide = new JButton();
		btnPesticide.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Pesticide_SelectionX.png"));
		btnPesticide.setBounds(907, 695, 46, 100);
		btnPesticide.addActionListener(diaryL);
		btnPesticide.setVisible(false);
		add(btnPesticide);
		
		JButton btnCard = new JButton();
		btnCard.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Card_SelectionX.png"));
		btnCard.setBounds(984, 684, 111, 113);
		btnCard.addActionListener(diaryL);
		btnCard.setVisible(false);
		add(btnCard);
		
		JButton btnRadio = new JButton();
		btnRadio.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Radio_SelectionX.png"));
		btnRadio.setBounds(1092, 701, 116, 84);
		btnRadio.addActionListener(diaryL);
		btnRadio.setVisible(false);
		add(btnRadio);
		
		JButton btnMap = new JButton();
		btnMap.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/Map_SelectionX.png"));
		btnMap.setBounds(883, 706, 88, 66);
		btnMap.addActionListener(diaryL);
		btnMap.setVisible(false);
		add(btnMap);
		
		// ���̾ �̺�Ʈ
		lblDiary15 = new JLabel();
		lblDiary15.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent15.png"));
		lblDiary15.setBounds(0, 0, 1902, 1033);
		lblDiary15.setVisible(false);	
		add(lblDiary15);
		
		lblDiary14 = new JLabel();
		lblDiary14.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent14.png"));
		lblDiary14.setBounds(0, 0, 1902, 1033);
		lblDiary14.setVisible(false);	
		add(lblDiary14);
		
		lblDiary13 = new JLabel();
		lblDiary13.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent13.png"));
		lblDiary13.setBounds(0, 0, 1902, 1033);
		lblDiary13.setVisible(false);	
		add(lblDiary13);
		
		lblDiary12 = new JLabel();
		lblDiary12.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent12.png"));
		lblDiary12.setBounds(0, 0, 1902, 1033);
		lblDiary12.setVisible(false);	
		add(lblDiary12);
		
		lblDiary11 = new JLabel();
		lblDiary11.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent11.png"));
		lblDiary11.setBounds(0, 0, 1902, 1033);
		lblDiary11.setVisible(false);	
		add(lblDiary11);
		
		lblDiary10 = new JLabel();
		lblDiary10.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent10.png"));
		lblDiary10.setBounds(0, 0, 1902, 1033);
		lblDiary10.setVisible(false);	
		add(lblDiary10);
		
		lblDiary9 = new JLabel();
		lblDiary9.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent9.png"));
		lblDiary9.setBounds(0, 0, 1902, 1033);
		lblDiary9.setVisible(false);	
		add(lblDiary9);
		
		lblDiary8 = new JLabel();
		lblDiary8.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent8.png"));
		lblDiary8.setBounds(0, 0, 1902, 1033);
		lblDiary8.setVisible(false);	
		add(lblDiary8);
		
		lblDiary7 = new JLabel();
		lblDiary7.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent7.png"));
		lblDiary7.setBounds(0, 0, 1902, 1033);
		lblDiary7.setVisible(false);	
		add(lblDiary7);
		
		lblDiary6 = new JLabel();
		lblDiary6.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent6.png"));
		lblDiary6.setBounds(0, 0, 1902, 1033);
		lblDiary6.setVisible(false);	
		add(lblDiary6);
		
		lblDiary5 = new JLabel();
		lblDiary5.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent5.png"));
		lblDiary5.setBounds(0, 0, 1902, 1033);
		lblDiary5.setVisible(false);	
		add(lblDiary5);
		
		lblDiary4 = new JLabel();
		lblDiary4.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent4.png"));
		lblDiary4.setBounds(0, 0, 1902, 1033);
		lblDiary4.setVisible(false);	
		add(lblDiary4);
		
		lblDiary3 = new JLabel();
		lblDiary3.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent3.png"));
		lblDiary3.setBounds(0, 0, 1902, 1033);
		lblDiary3.setVisible(false);	
		add(lblDiary3);
		
		lblDiary2 = new JLabel();
		lblDiary2.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent2.png"));
		lblDiary2.setBounds(0, 0, 1902, 1033);
		lblDiary2.setVisible(false);	
		add(lblDiary2);
		
		lblDiary1 = new JLabel();
		lblDiary1.setIcon(new ImageIcon("img/DiarySrc/nomalEvent/nomalEvent1.png"));
		lblDiary1.setBounds(0, 0, 1902, 1033);
		lblDiary1.setVisible(false);	
		add(lblDiary1);
		
		lblNormalDiary = new JLabel();
		lblNormalDiary.setIcon(new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png"));
		lblNormalDiary.setBounds(0, 0, 1902, 1033);
		lblNormalDiary.setVisible(false);	
		add(lblNormalDiary);
		
		// ���̾ ���� �̺�Ʈ
		lblSDiary1 = new JLabel();
		lblSDiary1.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Radio.png"));
		lblSDiary1.setBounds(0, 0, 1902, 1033);
		lblSDiary1.setVisible(false);
		add(lblSDiary1);
		
		lblSDiary2 = new JLabel();
		lblSDiary2.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Gun.png"));
		lblSDiary2.setBounds(0, 0, 1902, 1033);
		lblSDiary2.setVisible(false);
		add(lblSDiary2);
		
		lblSDiary3 = new JLabel();
		lblSDiary3.setIcon(new ImageIcon("img/DiarySrc/Event/Event_Map.png"));
		lblSDiary3.setBounds(0, 0, 1902, 1033);
		lblSDiary3.setVisible(false);
		add(lblSDiary3);
		
		lblSDiary4 = new JLabel();
		lblSDiary4.setIcon(new ImageIcon("img/DiarySrc/Event/Event_������.png"));
		lblSDiary4.setBounds(0, 0, 1902, 1033);
		lblSDiary4.setVisible(false);
		add(lblSDiary4);
		
		lblSurvive = new JLabel();
		lblSurvive.setIcon(new ImageIcon("img/DiarySrc/Ending/����.png"));
		lblSurvive.setBounds(0, 0, 1902, 1033);
		lblSurvive.setVisible(false);
		add(lblSurvive);
		
		lblDie = new JLabel();
		lblDie.setIcon(new ImageIcon("img/DiarySrc/Ending/���Ⱦ��.png"));
		lblDie.setBounds(0, 0, 1902, 1033);
		lblDie.setVisible(false);
		add(lblDie);*/
		
		lblSClear = new JLabel();
		lblSClear.setBounds(352, 452, 203, 558);
		lblSClear.addMouseListener(mouseL);
		lblSClear.setVisible(false);
		add(lblSClear);
		
		lblDClear = new JLabel();
		lblDClear.setBounds(569, 385, 263, 435);
		lblDClear.addMouseListener(mouseL);
		lblDClear.setVisible(false);
		add(lblDClear);
		
		lblMClear = new JLabel();
		lblMClear.setBounds(1220, 311, 460, 649);
		lblMClear.addMouseListener(mouseL);
		lblMClear.setVisible(false);
		add(lblMClear);
		
		lblFClear = new JLabel();
		lblFClear.setBounds(851, 335, 354, 656);
		lblFClear.addMouseListener(mouseL);
		lblFClear.setVisible(false);
		add(lblFClear);
		
		lblSNormal = new JLabel();
		lblSNormal.setIcon(new ImageIcon("img/FamconSrc/S/SNormal.png"));
		lblSNormal.setBounds(0, 0, 1902, 1033);
		lblSNormal.setVisible(false);	
		add(lblSNormal);
		
		lblSCrazyExhausted = new JLabel();
		lblSCrazyExhausted.setIcon(new ImageIcon("img/FamconSrc/S/SCrazyExhausted.png"));
		lblSCrazyExhausted.setBounds(0, 0, 1902, 1033);
		lblSCrazyExhausted.setVisible(false);	
		add(lblSCrazyExhausted);
		
		lblSSick = new JLabel();
		lblSSick.setIcon(new ImageIcon("img/FamconSrc/S/SSick.png"));
		lblSSick.setBounds(0, 0, 1902, 1033);
		lblSSick.setVisible(false);	
		add(lblSSick);
		
		lblSCrazy = new JLabel();
		lblSCrazy.setIcon(new ImageIcon("img/FamconSrc/S/SCrazy.png"));
		lblSCrazy.setBounds(0, 0, 1902, 1033);
		lblSCrazy.setVisible(false);	
		add(lblSCrazy);
		
		lblSExhaustedSick = new JLabel();
		lblSExhaustedSick.setIcon(new ImageIcon("img/FamconSrc/S/SExhaustedSick.png"));
		lblSExhaustedSick.setBounds(0, 0, 1902, 1033);
		lblSExhaustedSick.setVisible(false);	
		add(lblSExhaustedSick);
		
		lblSExhausted = new JLabel();
		lblSExhausted.setIcon(new ImageIcon("img/FamconSrc/S/SExhausted.png"));
		lblSExhausted.setBounds(0, 0, 1902, 1033);
		lblSExhausted.setVisible(false);	
		add(lblSExhausted);
		
		lblDTired = new JLabel();
		lblDTired.setIcon(new ImageIcon("img/FamconSrc/D/DTired.png"));
		lblDTired.setBounds(0, 0, 1902, 1033);
		lblDTired.setVisible(false);	
		add(lblDTired);
		
		lblDNormal = new JLabel();
		lblDNormal.setIcon(new ImageIcon("img/FamconSrc/D/DNormal.png"));
		lblDNormal.setBounds(0, 0, 1902, 1033);
		lblDNormal.setVisible(false);	
		add(lblDNormal);
		
		lblDSickExhaustedInjury = new JLabel();
		lblDSickExhaustedInjury.setIcon(new ImageIcon("img/FamconSrc/D/DSickExhaustedInjury.png"));
		lblDSickExhaustedInjury.setBounds(0, 0, 1902, 1033);
		lblDSickExhaustedInjury.setVisible(false);	
		add(lblDSickExhaustedInjury);
		
		lblDSickExhaustedCrazy = new JLabel();
		lblDSickExhaustedCrazy.setIcon(new ImageIcon("img/FamconSrc/D/DSickExhaustedCrazy.png"));
		lblDSickExhaustedCrazy.setBounds(0, 0, 1902, 1033);
		lblDSickExhaustedCrazy.setVisible(false);	
		add(lblDSickExhaustedCrazy);
		
		lblDSickExhausted = new JLabel();
		lblDSickExhausted.setIcon(new ImageIcon("img/FamconSrc/D/DSickExhausted.png"));
		lblDSickExhausted.setBounds(0, 0, 1902, 1033);
		lblDSickExhausted.setVisible(false);	
		add(lblDSickExhausted);
		
		lblDSick = new JLabel();
		lblDSick.setIcon(new ImageIcon("img/FamconSrc/D/DSick.png"));
		lblDSick.setBounds(0, 0, 1902, 1033);
		lblDSick.setVisible(false);	
		add(lblDSick);
		
		lblDExhaustedInjury = new JLabel();
		lblDExhaustedInjury.setIcon(new ImageIcon("img/FamconSrc/D/DExhaustedInjury.png"));
		lblDExhaustedInjury.setBounds(0, 0, 1902, 1033);
		lblDExhaustedInjury.setVisible(false);	
		add(lblDExhaustedInjury);
		
		lblDExhausted = new JLabel();
		lblDExhausted.setIcon(new ImageIcon("img/FamconSrc/D/DExhausted.png"));
		lblDExhausted.setBounds(0, 0, 1902, 1033);
		lblDExhausted.setVisible(false);	
		add(lblDExhausted);
		
		lblMTired = new JLabel();
		lblMTired.setIcon(new ImageIcon("img/FamconSrc/M/MTired.png"));
		lblMTired.setBounds(0, 0, 1902, 1033);
		lblMTired.setVisible(false);	
		add(lblMTired);
		
		lblMSickCrazyExhausted = new JLabel();
		lblMSickCrazyExhausted.setIcon(new ImageIcon("img/FamconSrc/M/MSickCrazyExhausted.png"));
		lblMSickCrazyExhausted.setBounds(0, 0, 1902, 1033);
		lblMSickCrazyExhausted.setVisible(false);	
		add(lblMSickCrazyExhausted);
		
		lblMSick = new JLabel();
		lblMSick.setIcon(new ImageIcon("img/FamconSrc/M/MSick.png"));
		lblMSick.setBounds(0, 0, 1902, 1033);
		lblMSick.setVisible(false);	
		add(lblMSick);
		
		lblMDead = new JLabel();
		lblMDead.setIcon(new ImageIcon("img/FamconSrc/M/MDead.png"));
		lblMDead.setBounds(0, 0, 1902, 1033);
		lblMDead.setVisible(false);	
		add(lblMDead);
		
		lblMCrazy = new JLabel();
		lblMCrazy.setIcon(new ImageIcon("img/FamconSrc/M/MCrazy.png"));
		lblMCrazy.setBounds(0, 0, 1902, 1033);
		lblMCrazy.setVisible(false);	
		add(lblMCrazy);
		
		lblMExhaustedSickInjury = new JLabel();
		lblMExhaustedSickInjury.setIcon(new ImageIcon("img/FamconSrc/M/MExhaustedSickInjury.png"));
		lblMExhaustedSickInjury.setBounds(0, 0, 1902, 1033);
		lblMExhaustedSickInjury.setVisible(false);	
		add(lblMExhaustedSickInjury);
		
		lblMExhaustedSick = new JLabel();
		lblMExhaustedSick.setIcon(new ImageIcon("img/FamconSrc/M/MExhaustedSick.png"));
		lblMExhaustedSick.setBounds(0, 0, 1902, 1033);
		lblMExhaustedSick.setVisible(false);	
		add(lblMExhaustedSick);
		
		lblMExhaustedCrazy = new JLabel();
		lblMExhaustedCrazy.setIcon(new ImageIcon("img/FamconSrc/M/MExhaustedCrazy.png"));
		lblMExhaustedCrazy.setBounds(0, 0, 1902, 1033);
		lblMExhaustedCrazy.setVisible(false);	
		add(lblMExhaustedCrazy);
		
		lblMExhausted = new JLabel();
		lblMExhausted.setIcon(new ImageIcon("img/FamconSrc/M/MExhausted.png"));
		lblMExhausted.setBounds(0, 0, 1902, 1033);
		lblMExhausted.setVisible(false);	
		add(lblMExhausted);
		
		lblMNormal = new JLabel();
		lblMNormal.setIcon(new ImageIcon("img/FamconSrc/M/MNormal.png"));
		lblMNormal.setBounds(0, 0, 1902, 1033);
		lblMNormal.setVisible(false);	
		add(lblMNormal);
		
		lblFDead = new JLabel();
		lblFDead.setIcon(new ImageIcon("img/FamconSrc/F/FDead.png"));
		lblFDead.setBounds(0, 0, 1902, 1033);
		lblFDead.setVisible(false);	
		add(lblFDead);
		
		lblFExhaustedSickInjury = new JLabel();
		lblFExhaustedSickInjury.setIcon(new ImageIcon("img/FamconSrc/F/F_����_����_�λ�.png"));
		lblFExhaustedSickInjury.setBounds(0, 0, 1902, 1033);
		lblFExhaustedSickInjury.setVisible(false);	
		add(lblFExhaustedSickInjury);
		
		lblFExhaustedSick = new JLabel();
		lblFExhaustedSick.setIcon(new ImageIcon("img/FamconSrc/F/FExhaustedSick.png"));
		lblFExhaustedSick.setBounds(0, 0, 1902, 1033);
		lblFExhaustedSick.setVisible(false);	
		add(lblFExhaustedSick);
		
		lblFCrazyTired = new JLabel();
		lblFCrazyTired.setIcon(new ImageIcon("img/FamconSrc/F/FCrazyTired.png"));
		lblFCrazyTired.setBounds(0, 0, 1902, 1033);
		lblFCrazyTired.setVisible(false);	
		add(lblFCrazyTired);
		
		lblFInjuryExhausted = new JLabel();
		lblFInjuryExhausted.setIcon(new ImageIcon("img/FamconSrc/F/FInjuryExhausted.png"));
		lblFInjuryExhausted.setBounds(0, 0, 1902, 1033);
		lblFInjuryExhausted.setVisible(false);	
		add(lblFInjuryExhausted);
		
		lblFSickCrazy = new JLabel();
		lblFSickCrazy.setIcon(new ImageIcon("img/FamconSrc/F/FSickCrazy.png"));
		lblFSickCrazy.setBounds(0, 0, 1902, 1033);
		lblFSickCrazy.setVisible(false);	
		add(lblFSickCrazy);
		
		lblFSickTired = new JLabel();
		lblFSickTired.setIcon(new ImageIcon("img/FamconSrc/F/FSickTired.png"));
		lblFSickTired.setBounds(0, 0, 1902, 1033);
		lblFSickTired.setVisible(false);	
		add(lblFSickTired);
		
		lblFExhausted = new JLabel();
		lblFExhausted.setIcon(new ImageIcon("img/FamconSrc/F/FExhausted.png"));
		lblFExhausted.setBounds(0, 0, 1902, 1033);
		lblFExhausted.setVisible(false);	
		add(lblFExhausted);
		
		lblFCrazy = new JLabel();
		lblFCrazy.setIcon(new ImageIcon("img/FamconSrc/F/FCrazy.png"));
		lblFCrazy.setBounds(0, 0, 1902, 1033);
		lblFCrazy.setVisible(false);	
		add(lblFCrazy);
		
		lblFInjury = new JLabel();
		lblFInjury.setIcon(new ImageIcon("img/FamconSrc/F/FInjury.png"));
		lblFInjury.setBounds(0, 0, 1902, 1033);
		lblFInjury.setVisible(false);	
		add(lblFInjury);
		
		lblFTired = new JLabel();
		lblFTired.setIcon(new ImageIcon("img/FamconSrc/F/FTired.png"));
		lblFTired.setBounds(0, 0, 1902, 1033);
		lblFTired.setVisible(false);	
		add(lblFTired);
		
		lblFSick = new JLabel();
		lblFSick.setIcon(new ImageIcon("img/FamconSrc/F/FSick.png"));
		lblFSick.setBounds(0, 0, 1902, 1033);
		lblFSick.setVisible(false);	
		add(lblFSick);
		
		lblFNormal = new JLabel();
		lblFNormal.setIcon(new ImageIcon("img/FamconSrc/F/FNormal.png"));
		lblFNormal.setBounds(0, 0, 1902, 1033);
		lblFNormal.setVisible(false);	
		add(lblFNormal);
		
		/*lblOpenDiary = new JLabel();
		lblOpenDiary.setLocation(1592, 746);
		lblOpenDiary.setSize(201, 197);
		lblOpenDiary.setIcon(new ImageIcon("img/StuffSrc/Shelter_DiarySelection.png"));
		add(lblOpenDiary);*/
		
		lblShelterFood2 = new JLabel();
		lblShelterFood2.setIcon(new ImageIcon("img/StuffSrc/Food2.png"));
		lblShelterFood2.setBounds(0, 0, 1902, 1033);
		lblShelterFood2.setVisible(false);	
		add(lblShelterFood2);
		
		lblShelterFood3 = new JLabel();
		lblShelterFood3.setIcon(new ImageIcon("img/StuffSrc/Food3.png"));
		lblShelterFood3.setBounds(0, 0, 1902, 1033);
		lblShelterFood3.setVisible(false);
		add(lblShelterFood3);
		
		lblShelterFood1 = new JLabel();
		lblShelterFood1.setIcon(new ImageIcon("img/StuffSrc/Food.png"));
		lblShelterFood1.setBounds(0, 0, 1902, 1033);
		lblShelterFood1.setVisible(false);
		add(lblShelterFood1);
		
		lblShelterWater4 = new JLabel();
		lblShelterWater4.setIcon(new ImageIcon("img/StuffSrc/Water4.png"));
		lblShelterWater4.setBounds(0, 0, 1902, 1033);
		lblShelterWater4.setVisible(false);
		add(lblShelterWater4);
		
		lblShelterWater3 = new JLabel();
		lblShelterWater3.setIcon(new ImageIcon("img/StuffSrc/Water3.png"));
		lblShelterWater3.setBounds(0, 0, 1902, 1033);
		lblShelterWater3.setVisible(false);
		add(lblShelterWater3);
		
		lblShelterWater2 = new JLabel();
		lblShelterWater2.setIcon(new ImageIcon("img/StuffSrc/Water2.png"));
		lblShelterWater2.setBounds(0, 0, 1902, 1033);
		lblShelterWater2.setVisible(false);
		add(lblShelterWater2);
		
		lblShelterWater1 = new JLabel();
		lblShelterWater1.setIcon(new ImageIcon("img/StuffSrc/Water.png"));
		lblShelterWater1.setBounds(0, 0, 1902, 1033);
		lblShelterWater1.setVisible(false);
		add(lblShelterWater1);
		
		lblCard = new JLabel();
		lblCard.setIcon(new ImageIcon("img/StuffSrc/Card.png"));
		lblCard.setBounds(0, 0, 1902, 1033);
		lblCard.setVisible(false);
		add(lblCard);
		
		lblBullet = new JLabel();
		lblBullet.setIcon(new ImageIcon("img/StuffSrc/Bullet.png"));
		lblBullet.setBounds(0, 0, 1902, 1033);
		lblBullet.setVisible(false);
		add(lblBullet);
		
		lblGunBreak = new JLabel();
		lblGunBreak.setIcon(new ImageIcon("img/StuffSrc/Gun_Break.png"));
		lblGunBreak.setBounds(0, 0, 1902, 1033);
		lblGunBreak.setVisible(false);
		add(lblGunBreak);
		
		lblGun = new JLabel();
		lblGun.setIcon(new ImageIcon("img/StuffSrc/Gun.png"));
		lblGun.setBounds(0, 0, 1902, 1033);
		lblGun.setVisible(false);
		add(lblGun);
		
		lblChessboard = new JLabel();
		lblChessboard.setIcon(new ImageIcon("img/StuffSrc/Chessboard.png"));
		lblChessboard.setBounds(0, 0, 1902, 1033);
		lblChessboard.setVisible(false);
		add(lblChessboard);
		
		lblBook = new JLabel();
		lblBook.setIcon(new ImageIcon("img/StuffSrc/Book.png"));
		lblBook.setBounds(0, 0, 1902, 1033);
		lblBook.setVisible(false);
		add(lblBook);
		
		lblFlashlightBreak = new JLabel();
		lblFlashlightBreak.setIcon(new ImageIcon("img/StuffSrc/Flashlight_Use.png"));
		lblFlashlightBreak.setBounds(0, 0, 1902, 1033);
		lblFlashlightBreak.setVisible(false);
		add(lblFlashlightBreak);
		
		lblFlashlight = new JLabel();
		lblFlashlight.setIcon(new ImageIcon("img/StuffSrc/Flashlight.png"));
		lblFlashlight.setBounds(0, 0, 1902, 1033);
		lblFlashlight.setVisible(false);
		add(lblFlashlight);
		
		lblPesticide = new JLabel();
		lblPesticide.setIcon(new ImageIcon("img/StuffSrc/Pesticide.png"));
		lblPesticide.setBounds(0, 0, 1902, 1033);
		lblPesticide.setVisible(false);
		add(lblPesticide);
		
		lblGasmaskBreak = new JLabel();
		lblGasmaskBreak.setIcon(new ImageIcon("img/StuffSrc/Gasmask_Break.png"));
		lblGasmaskBreak.setBounds(0, 0, 1902, 1033);
		lblGasmaskBreak.setVisible(false);
		add(lblGasmaskBreak);
		
		lblGasmask = new JLabel();
		lblGasmask.setIcon(new ImageIcon("img/StuffSrc/Gasmask.png"));
		lblGasmask.setBounds(0, 0, 1902, 1033);
		lblGasmask.setVisible(false);
		add(lblGasmask);
		
		lblRadioBreak = new JLabel();
		lblRadioBreak.setIcon(new ImageIcon("img/StuffSrc/Radio_Break.png"));
		lblRadioBreak.setBounds(0, 0, 1902, 1033);
		lblRadioBreak.setVisible(false);
		add(lblRadioBreak);
		
		lblRadio = new JLabel();
		lblRadio.setIcon(new ImageIcon("img/StuffSrc/Radio.png"));
		lblRadio.setBounds(0, 0, 1902, 1033);
		lblRadio.setVisible(false);
		add(lblRadio);
		
		lblMapBreak = new JLabel();
		lblMapBreak.setIcon(new ImageIcon("img/StuffSrc/Map_Break.png"));
		lblMapBreak.setBounds(0, 0, 1902, 1033);
		lblMapBreak.setVisible(false);
		add(lblMapBreak);
		
		lblMap = new JLabel();
		lblMap.setIcon(new ImageIcon("img/StuffSrc/Map.png"));
		lblMap.setBounds(0, 0, 1902, 1033);
		lblMap.setVisible(false);
		add(lblMap);
		
		lblAxe = new JLabel();
		lblAxe.setIcon(new ImageIcon("img/StuffSrc/Axe.png"));
		lblAxe.setBounds(0, 0, 1902, 1033);
		lblAxe.setVisible(false);
		add(lblAxe);
		
		lblAidkitUse = new JLabel();
		lblAidkitUse.setIcon(new ImageIcon("img/StuffSrc/Aidkit_Use.png"));
		lblAidkitUse.setBounds(0, 0, 1902, 1033);
		lblAidkitUse.setVisible(false);
		add(lblAidkitUse);
		
		lblAidkit = new JLabel();
		lblAidkit.setIcon(new ImageIcon("img/StuffSrc/Aidkit.png"));
		lblAidkit.setBounds(0, 0, 1902, 1033);
		lblAidkit.setVisible(false);
		add(lblAidkit);
		
		lblShelter = new JLabel();
		lblShelter.setIcon(new ImageIcon("img/StuffSrc/Shelter_basic.png"));
		lblShelter.setBounds(0, 0, 1902, 1033);
		add(lblShelter);
		
	} // Game()
		
		public void setShelterItem(Maze maze) {
			shelterAidkit = maze.getAidkit();
			shelterAxe = maze.getAxe();
			shelterBook = maze.getBook();
			shelterBullet = maze.getBullet();
			shelterCard = maze.getCard();
			shelterChessboard = maze.getChessboard();
			shelterFlashlight = maze.getFlashlight();
			shelterGasmask = maze.getGasmask();
			shelterGun = maze.getGun();
			shelterMap = maze.getMap();
			shelterPesticide = maze.getPesticide();
			shelterRadio = maze.getRadio();
			shelterFood = maze.getFood();
			shelterWater = maze.getWater();
			shelterM = maze.getMom();
			shelterD = maze.getDaughter();
			shelterS = maze.getSon();
			DiaryPage.nDay = 1;			
		} // ��ŸƮ �������κ��� ������ �޾ƿ���
	
	/*public void setShelterItem() {
		shelterAidkit = 1;
		shelterAxe = 0;
		shelterBook = 1;
		shelterBullet =1;
		shelterCard = 1;
		shelterChessboard =0;
		shelterFlashlight = 0;
		shelterGasmask =1;
		shelterGun = 1;
		shelterMap = 1;
		shelterPesticide = 1;
		shelterRadio =1;
		shelterFood = 10;
		shelterWater = 5;
		shelterM = 0;
		shelterD = 1;
		shelterS = 1;
		DiaryPage.nDay = 1;			
	} // ��ŸƮ �������κ��� ������ �޾ƿ���
*/		
		//btnDiary~~��� �ڵ��� ���µ� �����غ��ϱ� ���⼭ ���ȣ�� ���ǵ� �����ؾ� �ҵ�..? Aidkit�� ���� �������!
				public void btnDiaryAidkit() {
					if(shelterAidkit == 1) {
						btnAidkit.setVisible(true);
						lblAidkit.setVisible(true);
					} else {
						btnAidkitX.setVisible(true);
						
					} // if..else
				}
				public void btnDiaryAxe() {
					if(shelterAxe == 1) {
						btnAxe.setVisible(true);
						lblAxe.setVisible(true);
					} else {
						btnAxeX.setVisible(true);
					} // if..else
				}
				public void btnDiaryRadio() {
					if(shelterRadio == 1) {
						btnRadio.setVisible(true);
						lblRadio.setVisible(true);
					} else {
						btnRadioX.setVisible(true);
					} // if..else
				}
				public void btnDiaryGasmask() {
					if(shelterGasmask == 1) {
						btnGasmask.setVisible(true);
						lblGasmask.setVisible(true);
					} else {
						btnGasmaskX.setVisible(true);
					} // if..else
				}
				public void btnDiaryPesticide() {
					if(shelterPesticide == 1) {
						btnPesticide.setVisible(true);
						lblPesticide.setVisible(true);
					} else {
						btnPesticideX.setVisible(true);
					} // if..else
				}
				public void btnDiaryFlashlight() {
					if(shelterFlashlight == 1) {
						btnFlashlight.setVisible(true);
						lblFlashlight.setVisible(true);
					} else {
						btnFlashlightX.setVisible(true);
					} // if..else
				}
				public void btnDiaryMap() {
					if(shelterMap == 1) {
						btnMap.setVisible(true);
						lblMap.setVisible(true);
					} else {
						btnMapX.setVisible(true);
					} // if..else
				}
				public void btnDiaryBook() {
					if(shelterBook == 1) {
						btnBook.setVisible(true);
						lblBook.setVisible(true);
					} else {
						btnBookX.setVisible(true);
					} // if..else
				}
				public void btnDiaryChessboard() {
					if(shelterChessboard == 1) {
						btnChessboard.setVisible(true);
						lblChessboard.setVisible(true);
					} else {
						btnChessboardX.setVisible(true);
					} // if..else
				}
				public void btnDiaryGun() {
					if(shelterGun == 1) {
						btnGun.setVisible(true);
						lblGun.setVisible(true);
					} else {
						btnGunX.setVisible(true);
					} // if..else
				}
				public void btnDiaryBullet() {
					if(shelterBullet == 1) {
						btnBullet.setVisible(true);
						lblBullet.setVisible(true);
					} // if
				}
				public void btnDiaryCard() {
					if(shelterCard == 1) {
						btnCard.setVisible(true);
						lblCard.setVisible(true);
					} else {
						btnCardX.setVisible(true);
					} // if..else
				}
				
				public void normalEvent() {
					nEvent = (int)(Math.random()*15) + 1; //  event 1~15
					switch (nEvent) {
					case 1:
						lblDiary1.setVisible(true);
						btnDiaryMap();
						btnDiaryCard();
						btnDiaryRadio();
						break;
					case 2:
						lblDiary2.setVisible(true);
						btnDiaryPesticide();
						btnDiaryBook();
						btnDiaryAidkit();
						break;
					case 3:
						lblDiary3.setVisible(true);
						btnDiaryCard();
						btnDiaryChessboard();
						break;
					case 4:
						lblDiary4.setVisible(true);
						btnDiaryRadio();
						break;
					case 5:
						lblDiary5.setVisible(true);
						btnDiaryAxe();
						btnDiaryAidkit();
						break;
					case 6:
						lblDiary6.setVisible(true);
						btnDiaryPesticide();
						btnDiaryAxe();
						btnDiaryGun();
						break;
					case 7:
						lblDiary7.setVisible(true);
						btnX.setVisible(true);
						btnO.setVisible(true);
						break;
					case 8:
						lblDiary8.setVisible(true);
						btnDiaryAidkit();
						break;
					case 9:
						lblDiary9.setVisible(true);
						btnDiaryGun();
						btnDiaryFlashlight();
						break;
					case 10:
						lblDiary10.setVisible(true);
						btnDiaryBook();
						break;
					case 11:
						lblDiary11.setVisible(true);
						btnDiaryGun();
						btnDiaryGasmask();
						btnDiaryCard();
						btnDiaryChessboard();
						break;
					case 12:
						lblDiary12.setVisible(true);
						btnDiaryAxe();
						btnDiaryGun();
						break;
					case 13:
						lblDiary13.setVisible(true);
						btnDiaryCard();
						break;
					case 14:
						lblDiary14.setVisible(true);
						btnDiaryChessboard();
						btnDiaryPesticide();
						btnDiaryBook();
						break;
					case 15:
						lblDiary15.setVisible(true);
						btnDiaryChessboard();
						btnDiaryBook();
						btnDiaryAidkit();
						break;
					} 
				} // �󺧹迭�����ؼ� �������� �ϳ� �����ޱ� - �Ϸ簡 ���� ������.. 
				//= ȭ��ǥ ������ ���������� +1 �ؼ� �ķ���� �������� �Ǹ� ��Ÿ������ �̰� ������ ������//
				
				// �����̺�Ʈ ���Դ��� ���°� �ڵ�
				
				public void surviveEvent() {
					nSurEvent = (int)(Math.random()*4) + 1; // 1~4
					switch(nSurEvent) {
					case 1:
						lblSDiary1.setVisible(true);
						btnDiaryRadio();
						break;
					case 2:
						lblSDiary2.setVisible(true);
						break;
					case 3:
						lblSDiary3.setVisible(true);
						btnDiaryMap();
						break;
					case 4:
						lblSDiary4.setVisible(true);
						btnDiaryGun();
						break;
					}
				} // surviveEvent
				
				public void allEvent() {
					aEvent = (int)(Math.random()*10) + 1; // 1~10 
					switch(aEvent) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
						normalEvent();
						break;
					case 9:
					case 10:
						surviveEvent();
						break;
					} // switch_aEvent => 8:2
				} // allEvent()
				
				public void sucessEvent() {
					if (nSCount >= 2) {
						lblSurvive.setVisible(true);
						System.out.println("Survive");
					} else {}
				} // sucessEvent()   
			
				
				
				private class ConMouseL implements MouseListener {
					public void mouseEntered(MouseEvent e) {
						JLabel lbl = (JLabel)e.getSource();
						
						if(lbl == lblSClear) {//�Ƶ鿡 ���콺�� �÷��� ��
							son.food();
							son.water();
							son.health();
							son.mind();
							son.condition();
							son.lbl_food.setVisible(true);
							son.lbl_water.setVisible(true);
							son.lbl_health.setVisible(true);
							son.lbl_mind.setVisible(true);
							son.lbl_condition.setVisible(true);
						} else if(lbl == lblDClear) { //���� ���콺�� �÷��� ��
							daughter.food();
							daughter.water();
							daughter.health();
							daughter.mind();
							daughter.condition();
							daughter.lbl_food.setVisible(true);
							daughter.lbl_water.setVisible(true);
							daughter.lbl_health.setVisible(true);
							daughter.lbl_mind.setVisible(true);
							daughter.lbl_condition.setVisible(true);
						} else if(lbl == lblFClear) {//�ƺ��� ���콺�� �÷��� ��
							father.food();
							father.water();
							father.health();
							father.mind();
							father.condition();
							father.lbl_food.setVisible(true);
							father.lbl_water.setVisible(true);
							father.lbl_health.setVisible(true);
							father.lbl_mind.setVisible(true);
							father.lbl_condition.setVisible(true);
						} else if(lbl == lblMClear) {//������ ���콺�� �÷��� ��
							mother.food();
							mother.water();
							mother.health();
							mother.mind();
							mother.condition();
							mother.lbl_food.setVisible(true);
							mother.lbl_water.setVisible(true);
							mother.lbl_health.setVisible(true);
							mother.lbl_mind.setVisible(true);
							mother.lbl_condition.setVisible(true);
						} // if..else if
					} // mouse Entered
					public void mouseExited(MouseEvent e) {
						JLabel lbl = (JLabel)e.getSource();
						
						if(lbl == lblSClear) {
							son.food();
							son.water();
							son.health();
							son.mind();
							son.condition();
							son.lbl_food.setVisible(false);
							son.lbl_water.setVisible(false);
							son.lbl_health.setVisible(false);
							son.lbl_mind.setVisible(false);
							son.lbl_condition.setVisible(false);						
						}
								
						if(lbl == lblDClear) {
							daughter.food();
							daughter.water();
							daughter.health();
							daughter.mind();
							daughter.condition();
							daughter.lbl_food.setVisible(false);
							daughter.lbl_water.setVisible(false);
							daughter.lbl_health.setVisible(false);
							daughter.lbl_mind.setVisible(false);
							daughter.lbl_condition.setVisible(false);
						}
									
						if(lbl == lblFClear) {
							father.food();
							father.water();
							father.health();
							father.mind();
							father.condition();
							father.lbl_food.setVisible(false);
							father.lbl_water.setVisible(false);
							father.lbl_health.setVisible(false);
							father.lbl_mind.setVisible(false);
							father.lbl_condition.setVisible(false);	
						}
										
										
						if(lbl == lblMClear) {
							mother.food();
							mother.water();
							mother.health();
							mother.mind();
							mother.condition();
							mother.lbl_food.setVisible(false);
							mother.lbl_water.setVisible(false);
							mother.lbl_health.setVisible(false);
							mother.lbl_mind.setVisible(false);
							mother.lbl_condition.setVisible(false);
						}
			
					} // mouseExited()
					public void mouseClicked(MouseEvent e) {} // mousePressed()
					public void mouseReleased(MouseEvent e) {} // mouseReleased
					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				
				} // MenuListener class

				
				public static void setEventResult() {
				      switch (nEvent) {
				      case 1:  // 1�� �̺�Ʈ�� �߻��Ѵٸ�
				         switch (eventSelectData) { // 
				         case 1:
				            lblCard.setVisible(false);
				            if(shelterRadio == 0) { lblRadio.setVisible(false); } // shelterRadio�� ���ٸ�
				            else if(shelterRadio == 1) {
				               lblRadio.setVisible(false);
				               lblRadioBreak.setVisible(true);
				            } // shelterRadio�� �ִٸ�
				            shelterMap = 0;
				            break;
				         case 2:
				            if(shelterMap == 0) { lblMap.setVisible(false); } // shelterMap�� ���ٸ�
				            else if(shelterMap == 1) {
				               lblMap.setVisible(false);
				               lblMapBreak.setVisible(true);
				            } // shelterMap�� �ִٸ�
				            if(shelterRadio == 0) { lblRadio.setVisible(false); } // shelterRadio�� ���ٸ�
				            else if(shelterRadio == 1) {
				               lblRadio.setVisible(false);
				               lblRadioBreak.setVisible(true);
				            } // shelterRadio�� �ִٸ�
				            shelterCard = 0;
				            break;
				         case 3:
				            if(shelterMap == 0) { lblMap.setVisible(false); } // shelterMap�� ���ٸ�
				            else if(shelterMap == 1) {
				               lblMap.setVisible(false);
				               lblMapBreak.setVisible(true);
				            } // shelterMap�� �ִٸ�
				            lblCard.setVisible(false);
				            shelterRadio = 1;
				            break;
				         case 4: // �ƹ��͵� ���þ��ϸ� ��� ȫ���� �������� = �� ��� ������ų� ���峲
				        	 if(shelterMap == 0) { lblMap.setVisible(false); } // shelterMap�� ���ٸ�
					            else if(shelterMap == 1) {
					               lblMap.setVisible(false);
					               lblMapBreak.setVisible(true);
					            } // shelterMap�� �ִٸ�
				        	 if(shelterRadio == 0) { lblRadio.setVisible(false); } // shelterRadio�� ���ٸ�
					            else if(shelterRadio == 1) {
					               lblRadio.setVisible(false);
					               lblRadioBreak.setVisible(true);
					            } // shelterRadio�� �ִٸ�
				        	 lblCard.setVisible(false);
				        	 break;
				         } // switch_eventSelectData
				      case 2:
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  if(shelterBook == 0) { lblBook.setVisible(false); } // shelterBook�� ���ٸ�
				    		  else if(shelterBook == 1) { lblBook.setVisible(true); } // shelterBook�� ������
				    		  if(shelterAidkit == 0) { lblAidkit.setVisible(false); } // shelterAidkit�� ���ٸ�
				    		  else if(shelterAidkit == 1) { lblAidkit.setVisible(true); } // shelterAidkit�� ������
				    		  if(nRandomResult==0) {shelterFood+=4; nshelterFood = 1;} // �������� ���� �� ������ Ȯ���� �ķ� 1���� ����
				    		  break;
				    	  case 2:
				    		  if(shelterPesticide == 0) { lblPesticide.setVisible(false); } // shelterPesticide�� ���ٸ�
				    		  else if(shelterPesticide == 1) { lblPesticide.setVisible(true); } // shelterPesticide�� ������
				    		  if(shelterAidkit == 0) { lblAidkit.setVisible(false); } // shelterAidkit�� ���ٸ�
				    		  else if(shelterAidkit == 1) { lblAidkit.setVisible(true); } // shelterAidkit�� ������
				    		  if(nRandomResult == 0 || nRandomResult == 1) {daughter.setHealth(2);} // å�� ���� �� ������ Ȯ���� ���� ���� �ɸ�
				    		  break;
				    	  case 3:
				    		  if(shelterPesticide == 0) { lblPesticide.setVisible(false); } // shelterPesticide�� ���ٸ�
				    		  else if(shelterPesticide == 1) { lblPesticide.setVisible(true); } // shelterPesticide�� ������
				    		  if(shelterBook == 0) { lblBook.setVisible(false); } // shelterBook�� ���ٸ�
				    		  else if(shelterBook == 1) { lblBook.setVisible(true); } // shelterBook�� ������
				    		  break;
				    	  case 4: // ���� ������ Ȯ���� ���� ���� �ɸ�
				    		  if(nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2) {daughter.setHealth(2);}
				    		  break;
				    	  }
				      case 3:
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  if(shelterChessboard == 0) { lblChessboard.setVisible(false); } // shelterChessboard�� ���ٸ�
				    		  else if(shelterChessboard == 1) { lblChessboard.setVisible(true); } // shelterChessboard�� ������
				    		  break;
				    	  case 2:
				    		  if(shelterCard == 0) { lblCard.setVisible(false); } // shelterCard�� ���ٸ�
				    		  else if(shelterCard == 1) { lblCard.setVisible(true); } // shelterCard�� ������
				    		  break;
				    	  case 3: //��ħ :mind=11
				    		  father.setMind(11);
				    		  mother.setMind(11);
				    		  daughter.setMind(11);
				    		  son.setMind(11);
				    		  break;
				    	  }
				      case 4: //Aidkit �̺�Ʈ
				    	  switch(eventSelectData) {
				    	  case 1://���� ����� �� ������ �������� ����
				    		  if(nRandomResult == 0 || nRandomResult == 1) {
				    			  lblRadio.setVisible(false);
				                  lblRadioBreak.setVisible(true);
				                  shelterRadio = 0; }
				    		  father.setMind(-2);
				    		  mother.setMind(-2);
				    		  daughter.setMind(-2);
				    		  son.setMind(-2);
				    		  break;
				    	  case 2://���� �ȵ���� ��
				    		  father.setMind(5);
				    		  mother.setMind(5);
				    		  daughter.setMind(5);
				    		  son.setMind(5);
				    		  
				    		  if(father.condition<2) {father.setCondition(1);}
				    		  if(mother.condition<2) {mother.setCondition(1);}
				    		  if(daughter.condition<2) {daughter.setCondition(1);}
				    		  if(son.condition<2) {son.setCondition(1);}
				    		  break;
				    	  }
				      case 5://�޸����κλ�
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  if(shelterAidkit == 0) { lblAidkit.setVisible(false); } // shelterAidkit�� ���ٸ�
				    		  else if(shelterAidkit == 1) { 
				    			  lblAidkit.setVisible(false); 
				    			  lblAidkitUse.setVisible(true);
				    			  daughter.setHealth(0);
				    		  } // shelterAidkit�� ������
				    		  break;
				    	  case 2:
				    		  if(shelterAxe == 0) { lblAxe.setVisible(false); }
				    		  else if(shelterAxe == 1) { 
				    			  lblAxe.setVisible(false); //Flashlight ����� �Ⱥ��̰� ����
				    			  shelterAxe=0; //���ȣ�� ���� ������
				    			  if((nRandomResult == 0 || nRandomResult == 1) && daughter.health<2)
				    				  daughter.setHealth(1);
				    		  
				    		  }
				    		  break;
				    	  case 3://�̹����ٲ��ְ�
				    		  if(mother.health<2)  {mother.setHealth(1);}
				    		  if(father.health<2)  {father.setHealth(1);}
				    		  if(daughter.health<2)  {daughter.setHealth(1);}
				    		  if(son.health<2)  {son.setHealth(1);}
				    		  break;
				    	  }
				      case 6: //���ȣ��Ż��
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  if(shelterAxe == 0) { lblAxe.setVisible(false); }
				    		  else if(shelterAxe == 1) { 
				    			  lblAxe.setVisible(false); //����������� �Ⱥ��̰Լ���
				    			  shelterAxe=0;
				    			  if(nRandomResult == 0) {shelterFood+=4; nshelterFood = 1;}
				    		  }
				    		  if(shelterGun == 0) { lblGun.setVisible(false); }
				    		  else if(shelterGun == 1) { 
				    			  if(nRandomResult == 0) {
				    				  lblGun.setVisible(false);
				    			  	  lblGunBreak.setVisible(true);
				    			  }else if (nRandomResult == 1 && shelterAxe==0) {
				    				  shelterAxe+=1;
				    				  
				    			  }else if((nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2) && shelterBullet==0) {
				    				  lblGunBreak.setVisible(true);
				    			  }
				    		}
				    		  break;
				    	  case 2:
				    		  if(shelterPesticide == 0) { lblPesticide.setVisible(false); } // shelterPesticide�� ���ٸ�
				    		  else if(shelterPesticide == 1) { 
				    			  lblPesticide.setVisible(false); 
				    			  if(nRandomResult==0 || nRandomResult == 1) {shelterFood-=4; nshelterFood = 1;} // �������� ���� �� ������ Ȯ���� �ķ� 1���� ����
				    			  if(father.health<2) {father.setHealth(1);}
				    		  
				    		  } // shelterPesticide�� ������
				    		  if(shelterGun == 0) { lblGun.setVisible(false); }
				    		  else if(shelterGun == 1) { 
				    			  if(nRandomResult == 0) {
				    				  lblGun.setVisible(false);
				    			  	  lblGunBreak.setVisible(true);
				    			  }else if (nRandomResult == 1 && shelterAxe==0) {
				    				  shelterAxe+=1;
				    				  
				    			  }else if((nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2) && shelterBullet==0) {
				    				  lblGunBreak.setVisible(true);
				    			  }
				    		  
				    		  }
				    		  break;
				    	  case 3:
				    		  if(shelterPesticide == 0) { lblPesticide.setVisible(false); } // shelterPesticide�� ���ٸ�
				    		  else if(shelterPesticide == 1) { 
				    			  lblPesticide.setVisible(false); 
				    			  if(nRandomResult==0 || nRandomResult == 1) {shelterFood-=4; nshelterFood = 1;} // �������� ���� �� ������ Ȯ���� �ķ� 1���� ����
				    			  if(father.health<2) {father.setHealth(1);}
				    		  } // shelterPesticide�� ������
				    		  if(shelterAxe == 0) { lblAxe.setVisible(false); }
				    		  else if(shelterAxe == 1) { 
				    			  lblAxe.setVisible(false); //����������� �Ⱥ��̰Լ���
				    			  shelterAxe=0;
				    			  if(nRandomResult == 0) {shelterFood+=4; nshelterFood = 1;}
				    			  
				    		  }
				    		  break;
				    	  case 4:
				    		  if((nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2)) {shelterFood-=4; nshelterFood = 1;}//���� Ȯ���� �ķ� 1���� ����
				    		  break;
				    	  }
				      case 7: //����������
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  break;
				    	  case 2:
				    		  break;
				    	  case 3:
				    		  if(father.condition<3) {father.setCondition(2);}
				    		  if(mother.condition<3) {mother.setCondition(2);}
				    		  if(daughter.condition<3) {daughter.setCondition(2);}
				    		  if(son.condition<3) {son.setCondition(2);}
				    		  break;
				    	  } // OX����
				      case 8: //�Ҹ���
				    	  switch(eventSelectData) {
				    	  case 1: 
				    		  lblAidkit.setVisible(false);
				    		  lblAidkitUse.setVisible(true);
				    		  break;
				    	  case 2:
				    		  if(father.condition<3) {father.setCondition(2);}
				    		  if(mother.condition<3) {mother.setCondition(2);}
				    		  if(daughter.condition<3) {daughter.setCondition(2);}
				    		  if(son.condition<3) {son.setCondition(2);}
				    		  break;
				    	  }
				      case 9: //��й�
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  if(shelterFlashlight == 0) { lblFlashlight.setVisible(false); }
				    		  else if(shelterFlashlight == 1) { 
				    			  lblFlashlight.setVisible(false); 
				    			  if(nRandomResult==0) {shelterFood+=4; nshelterFood = 1;} // ������ Ȯ���� �ķ� 1���� ����
				    		  }
				    		  break;
				    	  case 2:
				    		  if(shelterGun == 0) { lblGun.setVisible(false); }
				    		  else if(shelterGun == 1) { 
				    			  if(nRandomResult == 0) {
				    				  lblGun.setVisible(false);
				    			  	  lblGunBreak.setVisible(true);
				    			  }else if (nRandomResult == 1 && shelterAxe==0) {
				    				  shelterAxe+=1;
				    				  
				    			  }else if((nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2) && shelterBullet==0) {
				    				  lblGunBreak.setVisible(true);
				    			  }
				    		  
				    		  }
				    		  break;
				    	  case 3:
				    		  break;
				    	  }
				      case 10: //��������
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  lblBook.setVisible(false);
				    		  break;
				    	  case 2:
				    		  lblBook.setVisible(true);
				    		  son.setMind(3);
				    		  mother.setMind(3);
				    		  father.setMind(3);
				    		  daughter.setMind(3);
				    		  break;
				    	  }
				      case 11: //���ι��Ǳ�ȯ
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  if(shelterGasmask == 0) { lblGasmask.setVisible(false); }
				    		  else if(shelterGasmask == 1) {lblGasmask.setVisible(true); }
				    		  if(shelterCard == 0) { lblCard.setVisible(false); } // shelterCard�� ���ٸ�
				    		  else if(shelterCard == 1) { lblCard.setVisible(true); } // shelterCard�� ������
				    		  if(shelterChessboard == 0) { lblChessboard.setVisible(false); } // shelterChessboard�� ���ٸ�
				    		  else if(shelterChessboard == 1) { lblChessboard.setVisible(true); } // shelterChessboard�� ������
				    		  break;
				    	  case 2: 
				    		  if(shelterGun == 0) { lblGun.setVisible(false); }
				    		  else if(shelterGun == 1) { 
				    			  if(nRandomResult == 0) {
				    				  lblGun.setVisible(false);
				    			  	  lblGunBreak.setVisible(true);
				    			  }else if (nRandomResult == 1 && shelterAxe==0) {
				    				  shelterAxe+=1;
				    				  
				    			  }else if((nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2) && shelterBullet==0) {
				    				  lblGunBreak.setVisible(true);
				    			  }
				    		  
				    		  }
				    		  if(shelterCard == 0) { lblCard.setVisible(false); } // shelterCard�� ���ٸ�
				    		  else if(shelterCard == 1) { lblCard.setVisible(true); } // shelterCard�� ������
				    		  if(shelterChessboard == 0) { lblChessboard.setVisible(false); } // shelterChessboard�� ���ٸ�
				    		  else if(shelterChessboard == 1) { lblChessboard.setVisible(true); } // shelterChessboard�� ������
				    		  break;
				    	  case 3: 
				    		  if(shelterGasmask == 0) { lblGasmask.setVisible(false); }
				    		  else if(shelterGasmask == 1) {lblGasmask.setVisible(true); }
				    		  if(shelterChessboard == 0) { lblChessboard.setVisible(false); } // shelterChessboard�� ���ٸ�
				    		  else if(shelterChessboard == 1) { lblChessboard.setVisible(true); } // shelterChessboard�� ������
				    		  if(shelterGun == 0) { lblGun.setVisible(false); }
				    		  else if(shelterGun == 1) { 
				    			  if(nRandomResult == 0) {
				    				  lblGun.setVisible(false);
				    			  	  lblGunBreak.setVisible(true);
				    			  }else if (nRandomResult == 1 && shelterAxe==0) {
				    				  shelterAxe+=1;
				    				  
				    			  }else if((nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2) && shelterBullet==0) {
				    				  lblGunBreak.setVisible(true);
				    			  }
				    		  }
				    		  break;
				    	  case 4:
				    		  if(shelterGasmask == 0) { 
				    			  if(father.condition<3) {father.setCondition(2);}
					    		  if(mother.condition<3) {mother.setCondition(2);}
					    		  if(daughter.condition<3) {daughter.setCondition(2);}
					    		  if(son.condition<3) {son.setCondition(2);}
				    		  }
				    		  else if(shelterGasmask == 1) {
				    			  lblGasmask.setVisible(false); 
				    			  lblGasmaskBreak.setVisible(true);
				    			  shelterGasmask=0;
				    			  }
				    		  if(shelterCard == 0) { 
				    			  son.setMind(1);
					    		  mother.setMind(1);
					    		  father.setMind(1);
					    		  daughter.setMind(1);
				    		  } // shelterCard�� ���ٸ�
				    		  else if(shelterCard == 1) { 
				    			  lblCard.setVisible(false);
					    		  son.setMind(-1);
					    		  mother.setMind(-1);
					    		  father.setMind(-1);
					    		  daughter.setMind(-1);
				    			  
				    		  } // shelterCard�� ������
				    		  if(shelterGun == 0) { lblGun.setVisible(false); }
				    		  else if(shelterGun == 1) { 
				    			  if(nRandomResult == 0) {
				    				  lblGun.setVisible(false);
				    			  	  lblGunBreak.setVisible(true);
				    			  }else if (nRandomResult == 1 && shelterAxe==0) {
				    				  shelterAxe+=1;
				    				  
				    			  }else if((nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2) && shelterBullet==0) {
				    				  lblGunBreak.setVisible(true);
				    			  }
				    		  }
				    		  break;
				    	  case 5:
				    		  break;
				    	  }
				      case 12: //���̺�Ʈ
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  if(shelterGun == 0) { lblGun.setVisible(false); }
				    		  else if(shelterGun == 1) { 
				    			  if(nRandomResult == 0) {
				    				  lblGun.setVisible(false);
				    			  	  lblGunBreak.setVisible(true);
				    			  }else if (nRandomResult == 1 && shelterAxe==0) {
				    				  shelterAxe+=1;
				    				  
				    			  }else if((nRandomResult == 0 || nRandomResult == 1 || nRandomResult == 2) && shelterBullet==0) {
				    				  lblGunBreak.setVisible(true);
				    			  }
				    			  
				    		  }
				    		  break;
				    	  case 2:
				    		  if(shelterAxe == 0) { lblAxe.setVisible(false); }
				    		  else if(shelterAxe == 1) { 
				    			  lblAxe.setVisible(false); //����������� �Ⱥ��̰Լ���
				    			  shelterAxe=0;
				    			  if(nRandomResult == 0) {shelterFood+=4; nshelterFood = 1;}
				    			  
				    		  }
				    		  break;
				    	  case 3:
				    		  if(father.condition<3) {father.setCondition(2);}
				    		  if(mother.condition<3) {mother.setCondition(2);}
				    		  if(daughter.condition<3) {daughter.setCondition(2);}
				    		  if(son.condition<3) {son.setCondition(2);}
				    		  break;
				    	  }
				      case 13: //ī�嵵��
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  
				    		  lblCard.setVisible(false);
				    		  son.setMind(-1);
				    		  mother.setMind(-1);
				    		  father.setMind(-1);
				    		  daughter.setMind(-1);
				    		  break;
				    	  case 2:
				    		  son.setMind(1);
				    		  mother.setMind(1);
				    		  father.setMind(1);
				    		  daughter.setMind(1);
				    		  break;
				    	  }
				      case 14: //Ƽ�̱���
				    	  switch(eventSelectData) {
				    	  case 1://ü����
				    		  if(shelterPesticide == 0) { lblPesticide.setVisible(false); } // shelterPesticide�� ���ٸ�
				    		  else if(shelterPesticide == 1) { lblPesticide.setVisible(true); } // shelterPesticide�� ������
				    		  if(shelterBook == 0) { lblBook.setVisible(false); }
				    		  else if(shelterBook == 1) { lblBook.setVisible(true); }
				    		  son.setMind(-2);
				    		  break;
				    	  case 2: //������
				    		  if(shelterChessboard == 0) { lblChessboard.setVisible(false); } // shelterChessboard�� ���ٸ�
				    		  else if(shelterChessboard == 1) { lblChessboard.setVisible(true); } // shelterChessboard�� ������
				    		  if(shelterBook == 0) { lblBook.setVisible(false); }
				    		  else if(shelterBook == 1) { lblBook.setVisible(true); }
				    		  lblPesticide.setVisible(false);
				    		  if((nRandomResult == 0 || nRandomResult == 1) && son.health<3) {son.setHealth(2);}
				    		  break;
				    	  case 3:
				    		  if(shelterChessboard == 0) { lblChessboard.setVisible(false); } // shelterChessboard�� ���ٸ�
				    		  else if(shelterChessboard == 1) { lblChessboard.setVisible(true); } // shelterChessboard�� ������
				    		  if(shelterPesticide == 0) { lblPesticide.setVisible(false); } // shelterPesticide�� ���ٸ�
				    		  else if(shelterPesticide == 1) { lblPesticide.setVisible(true); } // shelterPesticide�� ������
				    		  son.setMind(-2);
				    		  mother.setMind(-1);
				    		  father.setMind(-1);
				    		  daughter.setMind(-1);
				    		  break;
				    	  case 4:
				    		  son.setMind(4);
				    		  mother.setMind(1);
				    		  father.setMind(1);
				    		  daughter.setMind(1); 
				    		  break;
				    	  }
				      case 15: //Ƽ�̻���
				    	  switch(eventSelectData) {
				    	  case 1:
				    		  if(shelterBook == 0) { lblBook.setVisible(false); } // shelterPesticide�� ���ٸ�
				    		  else if(shelterBook == 1) { lblBook.setVisible(true); } // shelterPesticide�� ������
				    		  if(shelterAidkit == 0) { lblAidkit.setVisible(false); }
				    		  else if(shelterAidkit == 1) { lblAidkit.setVisible(true); }
				    		  
				    		  break;
				    	  case 2:
				    		  if(shelterChessboard == 0) { lblChessboard.setVisible(false); } // shelterChessboard�� ���ٸ�
				    		  else if(shelterChessboard == 1) { lblChessboard.setVisible(true); } // shelterChessboard�� ������
				    		  if(shelterAidkit == 0) { lblAidkit.setVisible(false); }
				    		  else if(shelterAidkit == 1) { lblAidkit.setVisible(true); }
				    		  break;
				    	  case 3:
				    		  if(shelterChessboard == 0) { lblChessboard.setVisible(false); } // shelterChessboard�� ���ٸ�
				    		  else if(shelterChessboard == 1) { lblChessboard.setVisible(true); } // shelterChessboard�� ������
				    		  if(shelterBook == 0) { lblBook.setVisible(false); }
				    		  else if(shelterBook == 1) { lblBook.setVisible(true); }
				    		  break;
				    	  case 4:
				    		  son.setMind(4);
				    		  mother.setMind(1);
				    		  father.setMind(1);
				    		  daughter.setMind(1);
				    		  break;
				    	  }
				      } // switch_nEvent
				} // setEventResult()
				    		  
				    		  
					// ��ư �ٽ� ���������� �ڵ��� �ʿ�..!! ������ �ƿ����°� �ڵ� ���ϸ� ���� �ȵǴϱ� ���� �ڵ� ���ص� �ɵ�!
					/*public class DiaryL implements ActionListener {
						public void actionPerformed(ActionEvent event) {
							JButton btn = (JButton)event.getSource();
							// if�� switch�� �ٲٱ�...
							if (nEvent == 1) {
								if(btn == btnMap) { // btn == btnMap 
									btnMap.setVisible(false);
					                btnSelectionMap.setVisible(true);
					                eventSelectData = 1;
								} else if(btn == btnCard) { // btn == btnCard
									btnCard.setVisible(false);
					                btnSelectionCard.setVisible(true);
					                eventSelectData = 2;
								} else if(btn == btnRadio) { // btn == btnRadio
									btnRadio.setVisible(false);
					                btnSelectionRadio.setVisible(true); 
					                eventSelectData = 3;
								}  else if(btn == btnSelectionMap) {
					                  btnMap.setVisible(true);
					                  btnSelectionMap.setVisible(false);
					                  eventSelectData = 4;
					               } else if(btn == btnSelectionCard) {
					                  btnCard.setVisible(true);
					                  btnSelectionCard.setVisible(false);
					                  eventSelectData = 4;
					               } else if(btn == btnSelectionRadio) {
					                  btnRadio.setVisible(true);
					                  btnSelectionRadio.setVisible(false); 
					                  eventSelectData = 4;
					               } else eventSelectData = 4; // nEvent == 1	
								
								} else if (nEvent == 2) {
									if(btn == btnPesticide) { // btn == btnPesticide
										btnPesticide.setVisible(false);
										btnSelectionPesticide.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnBook) { // btn == btnBook
										btnBook.setVisible(false);
										btnSelectionBook.setVisible(true);
										eventSelectData = 2;
									} else if(btn == btnAidkit) { // btn == btnAidkit
										btnAidkit.setVisible(false);
										btnSelectionAidkit.setVisible(true);
										eventSelectData = 3;
									} else if(btn == btnSelectionPesticide){
										btnPesticide.setVisible(true);
										btnSelectionPesticide.setVisible(false);
										eventSelectData = 4;
									} else if(btn == btnSelectionBook) {
										btnBook.setVisible(true);
										btnSelectionBook.setVisible(false);
										eventSelectData = 4;
									} else if(btn == btnSelectionAidkit) {
										btnAidkit.setVisible(true);
										btnSelectionAidkit.setVisible(false);
										eventSelectData = 4;
									} else eventSelectData = 4; // nEvent == 2 
									
								} else if (nEvent == 3) {
									if(btn == btnCard) { // btn == btnCard
										btnCard.setVisible(false);
										btnSelectionCard.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnChessboard) {
										btnChessboard.setVisible(false);
										btnSelectionChessboard.setVisible(true);
										eventSelectData = 2;
									} else if(btn == btnSelectionCard) {
										btnCard.setVisible(true);
										btnSelectionCard.setVisible(false);
										eventSelectData = 3;
									} else if(btn == btnSelectionChessboard) {
										btnChessboard.setVisible(true);
										btnSelectionChessboard.setVisible(false);
										eventSelectData = 3;
									} else eventSelectData = 3; // nEvent == 3
								
								} else if (nEvent == 4) {
									if (btn == btnRadio) {
										btnRadio.setVisible(false);
										btnSelectionRadio.setVisible(true); 
										eventSelectData = 1;
									} else if(btn == btnSelectionRadio) {
										btnRadio.setVisible(true);
										btnSelectionRadio.setVisible(false);
										eventSelectData = 2;
									} else eventSelectData = 2; // nEvent == 4
								
								
								} else if (nEvent == 5) {
									if(btn == btnAxe) {
										btnAxe.setVisible(false);
										btnSelectionAxe.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnAidkit) {
										btnAidkit.setVisible(false);
										btnSelectionAidkit.setVisible(true);
									eventSelectData = 2;
									} else if(btn == btnSelectionAxe) {
										btnAxe.setVisible(true);
										btnSelectionAxe.setVisible(false);
										eventSelectData = 3;
									} else if(btn == btnSelectionAidkit) {
										btnAidkit.setVisible(true);
										btnSelectionAidkit.setVisible(false);
										eventSelectData = 3;
									} else eventSelectData = 3; // nEvent == 5
								
								} else if (nEvent == 6) {
									if(btn == btnPesticide) {
										btnPesticide.setVisible(false);
										btnSelectionPesticide.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnAxe) {
										btnAxe.setVisible(false);
										btnSelectionAxe.setVisible(true);
										eventSelectData = 2;
									} else if(btn == btnGun) {
										btnGun.setVisible(false);
										btnSelectionGun.setVisible(true);
										eventSelectData = 3;
									} else if(btn == btnSelectionPesticide) {
										btnPesticide.setVisible(true);
										btnSelectionPesticide.setVisible(false);
										eventSelectData = 4;
									} else if(btn == btnSelectionAxe) {
										btnAxe.setVisible(true);
										btnSelectionAxe.setVisible(false);
										eventSelectData = 4;
									} else if(btn == btnSelectionGun) {
										btnGun.setVisible(true);
										btnSelectionGun.setVisible(false);
										eventSelectData = 4;
									} else eventSelectData = 4; // nEvent == 6
								
								} else if (nEvent == 7) {
									if(btn == btnX) {
										btnX.setVisible(false);
										btnSelectionX.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnO) {
										btnO.setVisible(false);
										btnSelectionO.setVisible(true);
										eventSelectData = 2;
									}  else if(btn == btnSelectionX) {
										btnX.setVisible(true);
										btnSelectionX.setVisible(false);
										eventSelectData = 3;
									} else if(btn == btnSelectionO) {
										btnO.setVisible(true);
										btnSelectionO.setVisible(false);
										eventSelectData = 3;
									} else eventSelectData = 3; // nEvent == 7
								
								} else if (nEvent == 8) {
									if(btn == btnAidkit) {
										btnAidkit.setVisible(false);
										btnSelectionAidkit.setVisible(true);
										eventSelectData = 1;
									}  else if (btn == btnSelectionAidkit) {
										btnAidkit.setVisible(true);
										btnSelectionAidkit.setVisible(false);
										eventSelectData = 2;
									} else eventSelectData = 2; // nEvent== 8
								
								} else if (nEvent == 9) {
									if(btn == btnGun) {
										btnGun.setVisible(false);
										btnSelectionGun.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnFlashlight) {
										btnFlashlight.setVisible(false);
										btnSelectionFlashlight.setVisible(true);
										eventSelectData = 2;
									}  else if(btn == btnSelectionGun) {
										btnGun.setVisible(true);
										btnSelectionGun.setVisible(false);
											eventSelectData = 3;
									} else if(btn == btnSelectionFlashlight) {
										btnFlashlight.setVisible(true);
										btnSelectionFlashlight.setVisible(false);
										eventSelectData = 3;
									} else eventSelectData = 3; // nEvent == 9
				
								} else if (nEvent == 10) {
									if(btn == btnBook) {
										 btnBook.setVisible(false);
										 btnSelectionBook.setVisible(true);
										 eventSelectData = 1;
									}  else if (btn == btnSelectionBook) {
										 btnBook.setVisible(true);
										 btnSelectionBook.setVisible(false);
										 eventSelectData = 2;
									} else eventSelectData = 2; // nEvent == 10
				
								} else if (nEvent == 11) {
									if(btn == btnGun) {
										btnGun.setVisible(false);
										btnSelectionGun.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnGasmask) {
										btnGasmask.setVisible(false);
										btnSelectionGasmask.setVisible(true);
										eventSelectData = 2;
									} else if(btn == btnCard) {
										btnCard.setVisible(false);
										btnSelectionCard.setVisible(true);
										eventSelectData = 3;
									} else if(btn == btnChessboard) {
										btnChessboard.setVisible(false);
										btnSelectionChessboard.setVisible(true);
										eventSelectData = 4;
									}  else if(btn == btnSelectionGun) {
										btnGun.setVisible(true);
										btnSelectionGun.setVisible(false);
										eventSelectData = 5;
									} else if(btn == btnSelectionGasmask) {
										btnGasmask.setVisible(true);
										btnSelectionGasmask.setVisible(false);
										eventSelectData = 5;
									} else if(btn == btnSelectionCard) {
										btnCard.setVisible(true);
										btnSelectionCard.setVisible(false);
										eventSelectData = 5;
									} else if(btn == btnSelectionChessboard) {
										btnChessboard.setVisible(true);
										btnSelectionChessboard.setVisible(false);
										eventSelectData = 5;
									} else eventSelectData = 5; // nEvent == 11
									
								} else if (nEvent == 12) {
									if(btn == btnAxe) {
										btnAxe.setVisible(false);
										btnSelectionAxe.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnGun) {
										btnGun.setVisible(false);
										btnSelectionGun.setVisible(true);
										eventSelectData = 2;
									} else if(btn == btnSelectionAxe) {
										btnAxe.setVisible(true);
										btnSelectionAxe.setVisible(false);
										eventSelectData = 3;
									} else if(btn == btnSelectionGun) {
										btnAxe.setVisible(true);
										btnSelectionAxe.setVisible(false);
										eventSelectData = 3;
									} else eventSelectData = 3; // nEvent == 12
				
								} else if (nEvent == 13) {
									if(btn == btnCard) {
										btnCard.setVisible(false);
										btnSelectionCard.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnSelectionCard) {
										btnCard.setVisible(true);
										btnSelectionCard.setVisible(false);
										eventSelectData = 2;
									} else eventSelectData = 2; // nEvent == 13
									
								} else if (nEvent == 14) {
									if(btn == btnChessboard) {
										btnChessboard.setVisible(false);
										btnSelectionChessboard.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnPesticide) {
										btnPesticide.setVisible(false);
										btnSelectionPesticide.setVisible(true);
										eventSelectData = 2;
									} else if(btn == btnBook) {
										btnBook.setVisible(false);
										btnSelectionBook.setVisible(true);
										eventSelectData = 3;
									} else if(btn == btnSelectionChessboard) {
										btnChessboard.setVisible(true);
										btnSelectionChessboard.setVisible(false);
										eventSelectData = 4;
									} else if(btn == btnSelectionPesticide) {
										btnPesticide.setVisible(true);
										btnSelectionPesticide.setVisible(false);
										eventSelectData = 4;
									} else if(btn == btnSelectionBook) {
										btnBook.setVisible(true);
										btnSelectionBook.setVisible(false);
										eventSelectData = 4;
									} else eventSelectData = 4; // nEvent == 14
				 
								} else if (nEvent == 15) {
									if(btn == btnChessboard) {
										btnChessboard.setVisible(false);
										btnSelectionChessboard.setVisible(true);
										eventSelectData = 1;
									} else if(btn == btnBook) {
										btnBook.setVisible(false);
										btnSelectionBook.setVisible(true);
										eventSelectData = 2;
									} else if(btn == btnAidkit) {
										btnAidkit.setVisible(false);
										btnSelectionAidkit.setVisible(true);
										eventSelectData = 3;
									} else if(btn == btnSelectionChessboard) {
										btnChessboard.setVisible(true);
										btnSelectionChessboard.setVisible(false);
										eventSelectData = 4;
									} else if(btn == btnSelectionBook) {
										btnBook.setVisible(true);
										btnSelectionBook.setVisible(false);
										eventSelectData = 4;
									} else if(btn == btnSelectionAidkit) {
										btnAidkit.setVisible(true);
										btnSelectionAidkit.setVisible(false);
										eventSelectData = 4;
									} else eventSelectData = 4; // nEvent == 15
								} // if..else if => normalEvent
							
							if (nSurEvent == 1) { 
								if (btn == btnRadio) {
									btnRadio.setVisible(false);
									btnSelectionRadio.setVisible(true); 
									eventSelectData = 1;
									nSCount++;
								} else eventSelectData = 0; // nSurEvent == 1
							} else if (nSurEvent == 2) {
								if(btn == btnX) {
									btnX.setVisible(false);
									btnSelectionX.setVisible(true);
									eventSelectData = 1;
								} else if(btn == btnO) {
									btnO.setVisible(false);
									btnSelectionO.setVisible(true);
									eventSelectData = 2;
									nSCount++;
								}  else if(btn == btnSelectionX) {
									btnX.setVisible(true);
									btnSelectionX.setVisible(false);
									eventSelectData = 0;
								} else if(btn == btnSelectionO) {
									btnO.setVisible(true);
									btnSelectionO.setVisible(false);
									eventSelectData = 0; 
								} // nSurEvent == 2
							}else if (nSurEvent == 3) {
								if(btn == btnMap) {
									btnMap.setVisible(false);
									btnSelectionMap.setVisible(true);
									eventSelectData = 1;
									nSCount++;
								} else eventSelectData = 0; // nSurEvent == 3
							} else if (nSurEvent == 4) {
								if(btn == btnGun) {
									btnGun.setVisible(false);
									btnSelectionGun.setVisible(true);
									eventSelectData = 1;
									nSCount++;
								} else eventSelectData = 0; // nSurEvent == 4
							} // if..else if => serviveEvent
							
							// btnBackB�� ���� �ϱ����� �������� �����ִ� �ϱ��� ��ġ�� ����
							if(btn == btnBackB) {
								temp = DiaryPage.nDiaryPage;
								DiaryPage.nDiaryPage = 0;
								diaryPage.openDiary0();
							}	
							if(btn == btnLeftB) {
								DiaryPage.nDiaryPage--;
								if(DiaryPage.nDiaryPage == 0) {
									diaryPage.openDiary0();
								}else if(DiaryPage.nDiaryPage == 1) {
									diaryPage.openDiary1();
								} else if(DiaryPage.nDiaryPage == 2) {
									diaryPage.openDiary2();
								} else if(DiaryPage.nDiaryPage == 3) {
									diaryPage.openDiary3();
								} else if(DiaryPage.nDiaryPage == 4) {
									diaryPage.openDiary4();
								}else if(DiaryPage.nDiaryPage == 5) {
									diaryPage.openDiary0();
								}
							}
							if(btn == btnRightB) {
								DiaryPage.nDiaryPage++;
								if(DiaryPage.nDiaryPage == 0) {
									diaryPage.openDiary0();
								}else if(DiaryPage.nDiaryPage == 1) {
									diaryPage.openDiary1();
								} else if(DiaryPage.nDiaryPage == 2) {
									diaryPage.openDiary2();
								} else if(DiaryPage.nDiaryPage == 3) {
									diaryPage.openDiary3();
								} else if(DiaryPage.nDiaryPage == 4) {
									diaryPage.openDiary4();
								}else if(DiaryPage.nDiaryPage == 5) {
									diaryPage.openDiary0();
								}
							}
							if(btn == btnOpenDiary) {
								DiaryPage.nDiaryPage = temp;
								if(DiaryPage.nDiaryPage == 0) {
									diaryPage.openDiary0();
								}else if(DiaryPage.nDiaryPage == 1) {
									diaryPage.openDiary1();
								} else if(DiaryPage.nDiaryPage == 2) {
									diaryPage.openDiary2();
								} else if(DiaryPage.nDiaryPage == 3) {
									diaryPage.openDiary3();
								} else if(DiaryPage.nDiaryPage == 4) {
									diaryPage.openDiary4();
								}else if(DiaryPage.nDiaryPage == 5) {
									diaryPage.openDiary0();
								}
							}
							
							// �ķ���� ��ư
							if(btn==btnFWaterX && shelterWater>0) // ���� �ϳ��� ������ �۵� ����
							{
								btnFWaterX.setVisible(false);
								btnFWater.setVisible(true);
								selectWaterF = true; // �ƺ� �� ���̴ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionWater();
							} else if(btn==btnFWater)
							{
								btnFWater.setVisible(false); // �ƺ� ���̼��û������� �ٲٱ�
								btnFWaterX.setVisible(true);
								selectWaterF = false; // �ƺ� �� �ȸ��̴ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionWater();
							} // if..else if
							if(btn==btnFFoodX && shelterFood>0) // ���� ������ �۵� ���� 
							{
								btnFFoodX.setVisible(false); // �ƺ� ���Ĺ��û������� �ٲٱ�
								btnFFood.setVisible(true);
								selectFoodF = true; // �ƺ� ���� �Ծ��ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionFood();
							} else if(btn==btnFFood)
							{
								btnFFood.setVisible(false); // �ƺ� ���Ĺ̼��û������� �ٲٱ�
								btnFFoodX.setVisible(true);
								selectFoodF = false; // �ƺ� ���� �ȸԾ��ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionFood();
							} // if..else if
							
							if(btn==btnMWaterX && shelterWater>0) // ���� �ϳ��� ������ �۵� ����
							{
								btnMWaterX.setVisible(false);
								btnMWater.setVisible(true);
								selectWaterM = true; // ���� �� ���̴ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionWater();
							} else if(btn==btnMWater)
							{
								btnMWater.setVisible(false); // ���� ���̼��û������� �ٲٱ�
								btnMWaterX.setVisible(true);
								selectWaterM = false; // ���� �� �ȸ��̴ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionWater();
							} // if..else if
							if(btn==btnMFoodX && shelterFood>0) // ���� ������ �۵� ���� 
							{
								btnMFoodX.setVisible(false); // ���� ���Ĺ��û������� �ٲٱ�
								btnMFood.setVisible(true);
								selectFoodM = true; // ���� ���� �Ծ��ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionFood();
							} else if(btn==btnMFood)
							{
								btnMFood.setVisible(false); // ���� ���Ĺ̼��û������� �ٲٱ�
								btnMFoodX.setVisible(true);
								selectFoodM = false; // ���� ���� �ȸԾ��ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionFood();
							} // if..else if
							
							if(btn==btnDWaterX && shelterWater>0) // ���� �ϳ��� ������ �۵� ����
							{
								btnDWaterX.setVisible(false);
								btnDWater.setVisible(true);
								selectWaterD = true; // ���� �� ���̴ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionWater();
							} else if(btn==btnDWater)
							{
								btnDWater.setVisible(false); // ���� ���̼��û������� �ٲٱ�
								btnDWaterX.setVisible(true);
								selectWaterD = false; // ���� �� �ȸ��̴ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionWater();
							} // if..else if
							if(btn==btnDFoodX && shelterFood>0) // ���� ������ �۵� ���� 
							{
								btnDFoodX.setVisible(false); // ���� ���Ĺ��û������� �ٲٱ�
								btnDFood.setVisible(true);
								selectFoodD = true; // ���� ���� �Ծ��ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionFood();
							} else if(btn==btnDFood)
							{
								btnDFood.setVisible(false); // ���� ���Ĺ̼��û������� �ٲٱ�
								btnDFoodX.setVisible(true);
								selectFoodD = false; // ���� ���� �ȸԾ��ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionFood();
							} // if..else if
							
							if(btn==btnSWaterX && shelterWater>0) // ���� �ϳ��� ������ �۵� ����
							{
								btnSWaterX.setVisible(false);
								btnSWater.setVisible(true);
								selectWaterS = true; // ���� �� ���̴ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionWater();
							} else if(btn==btnSWater)
							{
								btnSWater.setVisible(false); // ���� ���̼��û������� �ٲٱ�
								btnSWaterX.setVisible(true);
								selectWaterS = false; // ���� �� �ȸ��̴ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionWater();
							} // // if..else if
							if(btn==btnSFoodX && shelterFood>0) // ���� ������ �۵� ���� 
							{
								btnSFoodX.setVisible(false); // ���� ���Ĺ��û������� �ٲٱ�
								btnSFood.setVisible(true);
								selectFoodS = true; // ���� ���� �Ծ��ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionFood();
							} else if(btn==btnSFood)
							{
								btnSFood.setVisible(false); // ���� ���Ĺ̼��û������� �ٲٱ�
								btnSFoodX.setVisible(true);
								selectFoodS = false; // ���� ���� �ȸԾ��ٰ� �������� Ŭ������ �ѱ�� ���� ����
								Diary2.distributionFood();
							} // if..else if
							
							
							// Ž��
							if(btn==btnAdvM) { 
								btnAdvM.setVisible(false);
								btnAdvSelectM.setVisible(true);				
								btnAdvF.setVisible(true);
								btnAdvSelectF.setVisible(false);										
								btnAdvD.setVisible(true);
								btnAdvSelectD.setVisible(false);										
								btnAdvS.setVisible(true);
								btnAdvSelectS.setVisible(false);
								currentSelected=1; // ���� ���û����� ��� ����
								isOutsideM=1; // ���� �����°ɷ� ����
								randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 �󸶳� Ž���� �� �������� ����
								eda = nDay+randomAdv; // estimated day of arrival (EDA) ���� ���� �ð��� ����
								leaveHomeDay=nDay+1; // ������ ��
							} // end if ���� Ž�� �̼��û��¸� ������ ���û��·� ����.  
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
								isOutsideM=0; // ���� �ȳ����°ɷ� ����
							} // end else if ���� Ž�� ���û��¸� ������ �̼��û��·� ����.
							
							else if(btn==btnAdvF) {
								btnAdvM.setVisible(true);
								btnAdvSelectM.setVisible(false);				
								btnAdvF.setVisible(false);
								btnAdvSelectF.setVisible(true);										
								btnAdvD.setVisible(true);
								btnAdvSelectD.setVisible(false);										
								btnAdvS.setVisible(true);
								btnAdvSelectS.setVisible(false);
								currentSelected=2; // ���� ���û����� ��� �ƺ�
								isOutsideF=1; // �ƺ� �����°ɷ� ����
								randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 �󸶳� Ž���� �� �������� ����
								eda = nDay+randomAdv; // estimated day of arrival (EDA) ���� ���� �ð��� ����
								leaveHomeDay=nDay+1; // ������ ��
							} // end if �ƺ� Ž�� �̼��û��¸� ������ ���û��·� ����.  
							
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
								isOutsideF=0; // �ƺ� �ȳ����°ɷ� ����
							} // end else if �ƺ� Ž�� ���û��¸� ������ �̼��û��·� ����.
							
							else if(btn==btnAdvS) {
								btnAdvM.setVisible(true);
								btnAdvSelectM.setVisible(false);				
								btnAdvF.setVisible(true);
								btnAdvSelectF.setVisible(false);										
								btnAdvD.setVisible(true);
								btnAdvSelectD.setVisible(false);										
								btnAdvS.setVisible(false);
								btnAdvSelectS.setVisible(true);
								currentSelected=3; // ���� ���û����� ��� �Ƶ�
								isOutsideS=1; // �Ƶ� �����°ɷ� ����
								randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 �󸶳� Ž���� �� �������� ����
								eda = nDay+randomAdv; // estimated day of arrival (EDA) ���� ���� �ð��� ����
								leaveHomeDay=nDay+1; // ������ ��
							} // end if �Ƶ� Ž�� �̼��û��¸� ������ ���û��·� ����.  
							
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
								isOutsideS=0; // �Ƶ� �ȳ����°ɷ� ����
							} // end else if �Ƶ� Ž�� ���û��¸� ������ �̼��û��·� ����.
							
							else if(btn==btnAdvD) {
								btnAdvM.setVisible(true);
								btnAdvSelectM.setVisible(false);				
								btnAdvF.setVisible(true);
								btnAdvSelectF.setVisible(false);										
								btnAdvD.setVisible(false);
								btnAdvSelectD.setVisible(true);										
								btnAdvS.setVisible(true);
								btnAdvSelectS.setVisible(false);
								isOutsideD=1; // �� �����°ɷ� ����
								currentSelected=4; // ���� ���û����� ��� ��
								randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 �󸶳� Ž���� �� �������� ����
								eda = nDay+randomAdv; // estimated day of arrival (EDA) ���� ���� �ð��� ����
								leaveHomeDay=nDay+1; // ������ ��
							} // end if �� Ž�� �̼��û��¸� ������ ���û��·� ����.  
							
							else if(btn==btnAdvSelectD) {
								btnAdvM.setVisible(true);
								btnAdvSelectM.setVisible(false);
								btnAdvF.setVisible(true); 
								btnAdvSelectF.setVisible(false);										
								btnAdvD.setVisible(true); 
								btnAdvSelectD.setVisible(false);		 							
								btnAdvS.setVisible(true); 
								btnAdvSelectS.setVisible(false);  
								isOutsideD=0; // �� �ȳ����°ɷ� ����
								currentSelected=0;
							} // end else if D Ž�� ���û��¸� ������ �̼��û��·� ����.
											
						}// actionPerformed()
					} // ActionListener()
*/					// Ž���� Ž�賯¥�� �������� �����ؼ� ���ƿ� Ȯ���� 70����
					
					/*public void setUnVisible(boolean n) {
						lblNormalDiary.setVisible(n);
						lblDiaryF.setVisible(n);
						lblDiaryFX.setVisible(n);
						lblDiaryM.setVisible(n);
						lblDiaryMX.setVisible(n);
						lblDiaryD.setVisible(n);
						lblDiaryDX.setVisible(n);
						lblDiaryS.setVisible(n);
						lblDiarySX.setVisible(n);
						lblFood0.setVisible(n);
						lblFood1.setVisible(n);
						lblFood2.setVisible(n);
						lblFood3.setVisible(n);
						lblFood4.setVisible(n);
						lblWater0.setVisible(n);
						lblWater1.setVisible(n);
						lblWater2.setVisible(n);
						lblWater3.setVisible(n);
						lblWater4.setVisible(n);
						btnFFoodX.setVisible(n);
						btnFFood.setVisible(n);
						btnFWaterX.setVisible(n);
						btnFWater.setVisible(n);
						btnMFoodX.setVisible(n);
						btnMFood.setVisible(n);
						btnMWaterX.setVisible(n);
						btnMWater.setVisible(n);
						btnDFoodX.setVisible(n);
						btnDFood.setVisible(n);
						btnDWaterX.setVisible(n);
						btnDWater.setVisible(n);
						btnSFoodX.setVisible(n);
						btnSFood.setVisible(n);
						btnSWaterX.setVisible(n);
						btnSWater.setVisible(n);
						lblDay.setVisible(n);
						btnBackB.setVisible(n);
						btnLeftB.setVisible(n);
						btnRightB.setVisible(n);
						btnSelectionRightB.setVisible(n);
						btnSelectionLeftB.setVisible(n);
						btnSelectionBackB.setVisible(n);
						lblFood.setVisible(n);
						lblWater.setVisible(n);
						lblDiary1.setVisible(n);
						lblDiary2.setVisible(n);
						lblDiary3.setVisible(n);
						lblDiary4.setVisible(n);
						lblDiary5.setVisible(n);
						lblDiary6.setVisible(n);
						lblDiary7.setVisible(n);
						lblDiary8.setVisible(n);
						lblDiary9.setVisible(n);
						lblDiary10.setVisible(n);
						lblDiary11.setVisible(n);
						lblDiary12.setVisible(n);
						lblDiary13.setVisible(n);
						lblDiary14.setVisible(n);
						lblDiary15.setVisible(n);
						btnGunX.setVisible(n);
						btnChessboardX.setVisible(n);
						btnGasmaskX.setVisible(n);
						btnFlashlightX.setVisible(n);
						btnAxeX.setVisible(n);
						btnAidkitX.setVisible(n);
						btnBookX.setVisible(n);
						btnPesticideX.setVisible(n);
						btnCardX.setVisible(n);
						btnMapX.setVisible(n);
						btnRadioX.setVisible(n);
						btnSelectionO.setVisible(n);
						btnSelectionX.setVisible(n);
						btnSelectionBackB.setVisible(n);
						btnSelectionRightB.setVisible(n);
						btnSelectionLeftB.setVisible(n);
						btnSelectionBullet.setVisible(n);
						btnSelectionGun.setVisible(n);
						btnSelectionChessboard.setVisible(n);
						btnSelectionGasmask.setVisible(n);
						btnSelectionFlashlight.setVisible(n);
						btnSelectionAxe.setVisible(n);
						btnSelectionAidkit.setVisible(n);
						btnSelectionBook.setVisible(n);
						btnSelectionPesticide.setVisible(n);
						btnSelectionCard.setVisible(n);
						btnSelectionRadio.setVisible(n);
						btnSelectionMap.setVisible(n);
						btnO.setVisible(n);
						btnX.setVisible(n);
						btnBackB.setVisible(n);
						btnRightB.setVisible(n);
						btnLeftB.setVisible(n);
						btnBullet.setVisible(n);
						btnGun.setVisible(n);
						btnChessboard.setVisible(n);
						btnGasmask.setVisible(n);
						btnFlashlight.setVisible(n);
						btnAxe.setVisible(n);
						btnAidkit.setVisible(n);
						btnBook .setVisible(n);
						btnPesticide.setVisible(n);
						btnCard.setVisible(n);
						btnRadio.setVisible(n);
						btnMap.setVisible(n);
						lblFoodFText.setVisible(n);
						lblWaterFText.setVisible(n);
						lblFoodMText.setVisible(n);
						lblWaterMText.setVisible(n);
						lblFoodSText.setVisible(n);
						lblWaterSText.setVisible(n);
						lblFoodDText.setVisible(n);
						lblWaterDText.setVisible(n);
						lblIsOutside.setVisible(n);
						lblComeBack.setVisible(n);
						lblTotalGotItem.setVisible(n);
					} // setUnVisible()
*/		
					// �׼Ǹ����ʷ� �ޱ� �Ʒ������� ��ư ����!!!
					/*public void diaryPage(int nDiaryPage) { // 0 = �ϱ����� ������  1~4 = �ϱ��������� 5 = �������� �Ѿ
						switch(nDiaryPage) {
						case 0: // Back��ư�� ������ �� �ϱ��忡�� �ڷΰ��� ��ư�� �����ű� ������ �ش��������� ���̴� ��, ��ư���� ���� setVisible(false)�� ����!
							//setUnVisible(false);
							btnOpenDiary.setVisible(true);
							break;
						case 1: // �� ���� ���� ��,�ķ��� �Ծ�����, �̺�Ʈ�� ���� � ����� ���Դ���, Ž���� �������� ������ ������ �� �����Դ���
							// ���� ��,�ķ� �Ծ����� Ȯ��
							setUnVisible(false); // 1������ �����ϱ� �� ��� �� �� ��ư �Ⱥ��̰�
							if(shelterF==1) { // �ƺ��� ���ȣ�� �ִ� ���¸�
								if(selectFoodF = true) { // �ƺ��� �ķ� �Ծ��� ���
									lblFoodFText.setText("�ƺ�  >> �ķ�  + 1");
								} else if(selectFoodF = false) { // �ƺ��� �ķ� �ȸԾ��� ���
									lblFoodFText.setText("");
								}
								if(selectWaterF == true ) { // �ƺ��� �� �Ծ��� ���
									lblWaterFText.setText("�ƺ�  >> ��  + 1");
								} else if(selectWaterF == false) { // �ƺ��� �� �ȸԾ��� ���
									lblWaterFText.setText("");
								}
							} else { // ���� ���ȣ�� ���� ���¸� 
								if(isOutsideF==1) { // �ƺ��� Ž�質�� �����̸�
									lblWaterFText.setText("Ž�� ���Դϴ�."); lblFoodFText.setText("Ž�����Դϴ�.");
									} else { // �ƺ��� ����� �����̸�
										lblWaterFText.setText("..."); lblFoodFText.setText("...");
									}
								}
							
							if(shelterM==1) { // ������ ���ȣ�� �ִ� ���¸�
								if(selectFoodM = true) { // ���� �ķ� �Ծ��� ���
									lblFoodMText.setText("����  >> �ķ�  + 1");
								} else if(selectFoodM = false) { // ������ �ķ� �ȸԾ��� ���
									lblFoodMText.setText("");
								}
								if(selectWaterM == true ) { // ������ �� �Ծ��� ���
									lblWaterMText.setText("����  >> ��  + 1");
								} else if(selectWaterM == false) { // ������ �� �ȸԾ��� ���
									lblWaterMText.setText("");
								}
							} else { // ������ ���ȣ�� ���� ���¸� 
								if(isOutsideM==1) { // ������ Ž�質�� �����̸�
									lblWaterMText.setText("Ž�� ���Դϴ�."); lblFoodMText.setText("Ž�����Դϴ�.");
									} else { // ������ ����� �����̸�
										lblWaterMText.setText("..."); lblFoodMText.setText("...");
									}
								}
							
							if(shelterD==1) { // ���� ���ȣ�� �ִ� ���¸�
								if(selectFoodD = true) { // ���� �ķ� �Ծ��� ���
									lblFoodDText.setText("��  >> �ķ�  + 1");
								} else if(selectFoodD = false) { // ���� �ķ� �ȸԾ��� ���
									lblFoodDText.setText("");
								}
								if(selectWaterD == true ) { // ���� �� �Ծ��� ���
									lblWaterDText.setText("��  >> ��  + 1");
								} else if(selectWaterD == false) { // ���� �� �ȸԾ��� ���
									lblWaterDText.setText("");
								}
							} else { // ���� ���ȣ�� ���� ���¸� 
								if(isOutsideD==1) { // ���� Ž�質�� �����̸�
									lblWaterDText.setText("Ž�� ���Դϴ�."); lblFoodDText.setText("Ž�����Դϴ�.");
									} else { // ���� ����� �����̸�
										lblWaterDText.setText("..."); lblFoodDText.setText("...");
									}
								}
							
							if(shelterS==1) { // �Ƶ��� ���ȣ�� �ִ� ���¸�
								if(selectFoodS = true) { // �Ƶ��� �ķ� �Ծ��� ���
									lblFoodSText.setText("�Ƶ�  >> �ķ�  + 1");
								} else if(selectFoodS = false) { // �Ƶ��� �ķ� �ȸԾ��� ���
									lblFoodSText.setText("");
								}
								if(selectWaterS == true ) { // �Ƶ��� �� �Ծ��� ���
									lblWaterSText.setText("�Ƶ�  >> ��  + 1");
								} else if(selectWaterS == false) { // �Ƶ��� �� �ȸԾ��� ���
									lblWaterSText.setText("");
								}
							} else { // �Ƶ��� ���ȣ�� ���� ���¸� 
								if(isOutsideS==1) { // �Ƶ��� Ž�質�� �����̸�
									lblWaterSText.setText("Ž�� ���Դϴ�."); lblFoodSText.setText("Ž�����Դϴ�.");
									} else { // �Ƶ��� ����� �����̸�
										lblWaterSText.setText("..."); lblFoodSText.setText("...");
									}
								}
							
							lblFoodFText.setVisible(true);
							lblWaterFText.setVisible(true);
							lblFoodMText.setVisible(true);
							lblWaterMText.setVisible(true);
							lblFoodSText.setVisible(true);
							lblWaterSText.setVisible(true);
							lblFoodDText.setVisible(true);
							lblWaterDText.setVisible(true);
							
							// �̺�Ʈ�� ���� ���
							
							// Ž�� �������� ���� ��������
							if(isOutsideM==1 && nDay==leaveHomeDay) { // ���� ������ ���� �������� ǥ��
								lblIsOutside.setText("������ Ž���� �������ϴ�.");  // lblIsOutside �����߰��ؾ���
								lblIsOutside.setVisible(true);
							} else if(isOutsideF==1 && nDay==leaveHomeDay) { // ���� ������ ���� �������� ǥ��
								lblIsOutside.setText("�ƺ��� Ž���� �������ϴ�.");
								lblIsOutside.setVisible(true);
							} else if(isOutsideS==1 && nDay==leaveHomeDay) { // ���� ������ ���� �������� ǥ��
								lblIsOutside.setText("�Ƶ��� Ž���� �������ϴ�.");
								lblIsOutside.setVisible(true);
							} else if(isOutsideD==1 && nDay==leaveHomeDay) { // ���� ������ ���� �������� ǥ��
								lblIsOutside.setText("���� Ž���� �������ϴ�.");
								lblIsOutside.setVisible(true);
							}
							
							// Ž�� ���ƿ����� ���� ���ƿԴ���
							if(nDay==eda) { // Ž�谣 ����� ���ƿ� ��¥
								if(backHomeM==true) {  // ������ Ž�質���ٰ� ���ƿ�
									if(mother.condition==3) {  // ��� ����
										lblComeBack.setText("������ Ž�� ���� ����Ͽ����ϴ�.");
										lblComeBack.setVisible(true);
									} 
									else {
										lblComeBack.setText("������ Ž�迡�� ���ƿԽ��ϴ�.");
										backHomeM=false; // �ٽ� �ʱ�ȭ
										lblComeBack.setVisible(true);
										}
								} else if(backHomeF==true) { // �ƺ��� Ž�質���ٰ� ���ƿ�
									if(father.condition==3) {  // ��� ����
										lblComeBack.setText("�ƺ��� Ž�� ���� ����Ͽ����ϴ�.");
										lblComeBack.setVisible(true);
									} 
									else {
										lblComeBack.setText("�ƺ��� Ž�迡�� ���ƿԽ��ϴ�.");
										backHomeF=false; // �ٽ� �ʱ�ȭ
										lblComeBack.setVisible(true);
										}
								} else if(backHomeS==true) { // �Ƶ��� Ž�質���ٰ� ���ƿ�
									if(son.condition==3) {  // ��� ����
										lblComeBack.setText("�Ƶ��� Ž�� ���� ����Ͽ����ϴ�.");
										lblComeBack.setVisible(true);
									} 
									else {
										lblComeBack.setText("�Ƶ��� Ž�迡�� ���ƿԽ��ϴ�.");
										backHomeS=false; // �ٽ� �ʱ�ȭ
										lblComeBack.setVisible(true);
										}
								} else if(backHomeD==true) { // ���� Ž�質���ٰ� ���ƿ�
									if(daughter.condition==3) {  // ��� ����
										lblComeBack.setText("���� Ž�� ���� ����Ͽ����ϴ�.");
										lblComeBack.setVisible(true);
									} 
									else {
										lblComeBack.setText("���� Ž�迡�� ���ƿԽ��ϴ�.");
										backHomeD=false; // �ٽ� �ʱ�ȭ
										lblComeBack.setVisible(true);
										}
								}
						
							} // end first if Ž�谣 ����� ���ƿ� ��¥
							
							
							// ������ ������ �������
							if(nDay==eda) {  // Ž�迡�� ���ƿ� ��¥
								if(ranRadio==1) { gotRadio="������ �ϳ� �����Խ��ϴ�.\n";}
								else if(ranRadio!=1) { gotRadio ="";}
								if(ranBullet==1) { gotBullet="�Ѿ��� �ϳ� �����Խ��ϴ�.\n";}
								else if(ranBullet!=1) { gotBullet=""; }
								if(ranGun==1) { gotGun="���� �ϳ� �����Խ��ϴ�.\n";}
								else if(ranGun!=1) { gotGun=""; }
								if(ranChessboard==1) { gotChessboard="ü������ �ϳ� �����Խ��ϴ�.\n ";}
								else if(ranChessboard!=1) { gotChessboard="";}
								if(ranBook==1) { gotBook="å�� �ϳ� �����Խ��ϴ�.\n";}
								else if(ranBook!=1) { gotBook="";}
								if(ranFlashlight==1) { gotFlashlight="�������� �ϳ� �����Խ��ϴ�.\n";}
								else if(ranFlashlight!=1) {gotFlashlight="";}
								if(ranPesticide==1) { gotPesticide="�������� �ϳ� �����Խ��ϴ�.\n";}
								else if(ranPesticide!=1) { gotPesticide="";}
								if(ranMap==1) { gotMap="������ �ϳ� �����Խ��ϴ�.\n";}
								else if(ranMap!=1) { gotMap="";}
								if(ranGasmask==1) { gotGasmask="�浶���� �ϳ� �����Խ��ϴ�.\n";}
								else if(ranGasmask!=1) { gotGasmask="";}
								if(ranAxe==1) { gotAxe="������ �ϳ� �����Խ��ϴ�.\n";}
								else if(ranAxe!=1) { gotAxe="";}
								if(ranAidkit==1) {gotAidkit="���޻��ڸ� �ϳ� �����Խ��ϴ�.\n";}
								else if(ranAidkit!=1) { gotAidkit="";}
								if(ranCard==1) { gotCard="ī�带 �ϳ� �����Խ��ϴ�.\n";}
								else if(ranCard!=1) { gotCard="";}
								if(ranWater==0) { gotWater="";}
								if(ranWater==1) { gotWater="���� �� �� �����Խ��ϴ�.\n";}
								if(ranWater==2) { gotWater="���� �� �� �����Խ��ϴ�.\n";}
								if(ranWater==3) { gotWater="���� �� �� �����Խ��ϴ�.\n";}
								if(ranWater==4) { gotWater="���� �� �� �����Խ��ϴ�.\n";}
								if(ranWater==5) { gotWater="���� �ټ� �� �����Խ��ϴ�.\n";}
								if(ranWater==6) { gotWater="���� ���� �� �����Խ��ϴ�.\n";}
								if(ranFood==0) { gotFood="";}
								if(ranFood==1) { gotFood="�ķ��� �� �� �����Խ��ϴ�.\n";}
								if(ranFood==2) { gotFood="�ķ��� �� �� �����Խ��ϴ�.\n";}
								if(ranFood==3) { gotFood="�ķ��� �� �� �����Խ��ϴ�.\n";}
								if(ranFood==4) { gotFood="�ķ��� �� �� �����Խ��ϴ�.\n";}
								if(ranFood==5) { gotFood="�ķ��� �ټ� �� �����Խ��ϴ�.\n";}
								if(ranFood==6) { gotFood="�ķ��� ���� �� �����Խ��ϴ�.\n";}
								
								lblTotalGotItem.setText(""+gotRadio+ gotBullet+ gotGun+ gotChessboard+ gotBook+ gotFlashlight+
										gotPesticide+ gotMap+ gotGasmask+ gotAxe+ gotAidkit+gotCard+ gotWater+ gotFood);
								lblTotalGotItem.setVisible(true);
							}
						
							
							break;
						case 2: // �ķ���� ������
							setUnVisible(false); // 2������ �����ϱ� �� ��� �� �� ��ư �Ⱥ��̰�
							lblNormalDiary.setVisible(true);
							if(shelterF == 1) {
								lblDiaryF.setVisible(true);
								btnFFoodX.setVisible(true);
								btnFWaterX.setVisible(true);
							} else if (shelterF ==0) {
								lblDiaryFX.setVisible(true);
							} // if..else if
							if(shelterM == 1) {
								lblDiaryM.setVisible(true);
								btnMFoodX.setVisible(true);
								btnMWaterX.setVisible(true);
							} else if (shelterM ==0) {
								lblDiaryMX.setVisible(true);
							} // if..else if
							if(shelterD == 1) {
								lblDiaryD.setVisible(true);
								btnDFoodX.setVisible(true);
								btnDWaterX.setVisible(true);
							} else if (shelterD ==0) {
								lblDiaryDX.setVisible(true);
							} // if..else if
							if(shelterS == 1) {
								lblDiaryS.setVisible(true);
								btnSFoodX.setVisible(true);
								btnSWaterX.setVisible(true);
							} else if (shelterS ==0) {
								lblDiarySX.setVisible(true);
							} // if..else if
							if(shelterFood%4 == 0 && shelterFood == 0) {lblFood0.setVisible(true);}
							else if(shelterFood%4 == 1 ) {lblFood1.setVisible(true);}
							else if(shelterFood%4 == 2 ) {lblFood2.setVisible(true);}
							else if(shelterFood%4 == 3 ) {lblFood3.setVisible(true);}
							else if(shelterFood%4 == 0 ) {lblFood4.setVisible(true);}
							if(shelterWater%4 == 0 && shelterWater == 0) {lblWater0.setVisible(true);}
							else if(shelterWater%4 == 1 ) {lblWater1.setVisible(true);}
							else if(shelterWater%4 == 2 ) {lblWater2.setVisible(true);}
							else if(shelterWater%4 == 3 ) {lblWater3.setVisible(true);}
							else if(shelterWater%4 == 0 ) {lblWater4.setVisible(true);}
							lblDay.setVisible(true);
							btnBackB.setVisible(true);
							btnLeftB.setVisible(true);
							btnRightB.setVisible(true);
							lblFood.setVisible(true);
							lblWater.setVisible(true);
							btnOpenDiary.setVisible(false); // ���̾ ���¹�ư
							break;
						case 3: // �����̺�Ʈ or Ż���̺�Ʈ �ߴ� ������
							setUnVisible(false); // 3������ �����ϱ� �� ��� �� �� ��ư �Ⱥ��̰�
							allEvent();
							break;
						case 4: // Ž�輱�� ������  
							setUnVisible(false); // 4������ �����ϱ� �� ��� �� �� ��ư �Ⱥ��̰�
							if(isOutsideM==1 || isOutsideF==1 || isOutsideD==1 || isOutsideS==1) { // �������� Ž�����̸� Ž�輱�� ���ϵ���
								lblAdvFX.setVisible(true);
								lblAdvDX.setVisible(true);
								lblAdvMX.setVisible(true);
								lblAdvSX.setVisible(true);
								// Ž�� �Ұ����� ���� �̹��� ����
								btnAdvF.setVisible(false); btnAdvSelectF.setVisible(false);
								btnAdvM.setVisible(false); btnAdvSelectM.setVisible(false); 
								btnAdvD.setVisible(false); btnAdvSelectD.setVisible(false);
								btnAdvS.setVisible(false); btnAdvSelectS.setVisible(false);
								// Ž�� ����/�̼��� ��ư �Ⱥ��̰�

							}else { // �ƹ��� Ž�� ���� �ƴ϶��
								fatherCondition(father);   // fatherCondition(ConPanel father)
								momCondition(mother);
								sonCondition(son);
								daughterCondition(daughter);

								
							} // Ž������ �ƴϸ� ������ �� �ֵ���
							break;
						case 5:
							setUnVisible(false); // 5������ �����ϱ� �� ��� �� �� ��ư �Ⱥ��̰�
							nDay++;
							lblBlack.setVisible(true);
							lblDay.setVisible(true);
							if(isOutsideM==1 || isOutsideF==1 || isOutsideD==1 || isOutsideS==1) { // �������� ������� �� ����
								if(nDay==eda) { // Ž�迡�� ���ƿ� ���� �Ǹ�
									if(isOutsideM==1) { // ������ Ž�����̾����Ŷ��
										randomGotItem(); // Ž�迡�� ������ ������ ���� �߰�
										isOutsideM=0; isOutsideF=0; isOutsideS=0; isOutsideD=0; // ���ƿ����� ����
									    Ž��ٳ���� ������ ���ȸ԰� ���� �ȸ԰��� ������ �ȹް� �ϱ����̺�Ʈ ���� �ȹ޴� �ڵ� �߰��ؾ���
									    * --> ���డ�������� �����temp���� ������ ���´�
										* Ž��ٳ���鼭 ���ϴ� ����ǻ���(���,����,���� ��)�� ���ϰ�  // randomCondition()
										* �� ������� �̹����� setVisible(true) �ؾ� ��
										
										randomConditionM(mother); // ���,����,�λ��� �Ǿ����� �ƴ��� ��ȯ 
										changeImageMom(mother); // ���� ���¿� ���� ���ȣ �̹��� ��ȯ
										backHomeM=true; // ������ Ž�谬�ٰ� ���ƿ� ���� ǥ���ϱ� ���� ����
									} else if(isOutsideF==1) { // �ƺ��� Ž�����̾����Ŷ��
										randomGotItem(); // Ž�迡�� ������ ������ ���� �߰�
										isOutsideM=0; isOutsideF=0; isOutsideS=0; isOutsideD=0; // ���ƿ����� ����
										randomConditionF(father); // ���,����,�λ��� �Ǿ����� �ƴ��� ��ȯ 
										changeImageDad(father); // ���� ���¿� ���� ���ȣ �̹��� ��ȯ
										backHomeF=true; // �ƺ��� Ž�谬�ٰ� ���ƿ� ���� ǥ���ϱ� ���� ����
									} else if(isOutsideS==1) { // �Ƶ��� Ž�����̾����Ŷ��
										randomGotItem(); // Ž�迡�� ������ ������ ���� �߰�
										isOutsideM=0; isOutsideF=0; isOutsideS=0; isOutsideD=0; // ���ƿ����� ����
										randomConditionS(son); // ���,����,�λ��� �Ǿ����� �ƴ��� ��ȯ 
										changeImageSon(son); // ���� ���¿� ���� ���ȣ �̹��� ��ȯ
										backHomeS=true; // �Ƶ��� Ž�谬�ٰ� ���ƿ� ���� ǥ���ϱ� ���� ����
									} else if(isOutsideD==1) { // ���� Ž�����̾����Ŷ��
										randomGotItem(); // Ž�迡�� ������ ������ ���� �߰�
										isOutsideM=0; isOutsideF=0; isOutsideS=0; isOutsideD=0; // ���ƿ����� ����
										randomConditionD(daughter); // ���,����,�λ��� �Ǿ����� �ƴ��� ��ȯ 
										changeImageDaughter(daughter); // ���� ���¿� ���� ���ȣ �̹��� ��ȯ
										backHomeD=true; // ���� Ž�谬�ٰ� ���ƿ� ���� ǥ���ϱ� ���� ����
									}
								}  
								
								else goAdventure(); // ���� ���ƿ� ���� �ƴϸ� Ž�質������� �̹��� �Ⱥ��̰� ����
							} // end first if �������� ������� �� ���¶�� 
							
							nDiaryPage = 0;
							Diary3.setEventResult();
							break;
						} // Switch_nDaiayPage : btnRightB, btnLeftB, btnBackB�� ������ �� �ϱ����� ������ ������ �ڵ�!
					} // DiaryPage()
*/					
///////////////////////////start changeImage()///////////////////////////////////////////
		public void changeImageMom(ConPanel mom) {
			mom=mother;
			if(mom.getCondition()==1) { //�Ƿλ���
				lblMTired.setVisible(true);
				lblMNormal.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
				lblMSick.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
			}
			if(mom.getCondition()==2) { //���ʻ���
				lblMExhausted.setVisible(true);
				lblMNormal.setVisible(false);
				lblMTired.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
				lblMSick.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
			}
			if(mom.getHealth()==2) { //��������
				lblMSick.setVisible(true);
				lblMNormal.setVisible(false);
				lblMExhausted.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMTired.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
			}
			if(mom.getMind()==11) { //��ħ����
				lblMCrazy.setVisible(true);
				lblMNormal.setVisible(false);
				lblMTired.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
				lblMSick.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
			}
			if(mom.getCondition()==2 && mom.getMind()==11) {//����+��ħ
				lblMExhaustedCrazy.setVisible(true);
				lblMNormal.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
			}
			if(mom.getCondition()==2 && mom.getHealth()==2) {//����+����
				lblMExhaustedSick.setVisible(true);
				lblMSickCrazyExhausted.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMNormal.setVisible(false);
				lblMExhausted.setVisible(false);
				lblMSick.setVisible(false);
			}
			if(mom.getCondition()==2 && mom.getHealth()==2 && mom.getHealth()==1) {//����+����+�λ�
				lblMExhaustedSickInjury.setVisible(true);
				lblMNormal.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
				lblMSick.setVisible(false);
			}
			if(mom.getCondition()==2 && mom.getHealth()==2 && mom.getMind()==11) {//����+��ħ+����
				lblMSickCrazyExhausted.setVisible(true);
				lblMNormal.setVisible(false);
				lblMSick.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
			}
			////�������
			if(mom.getWater()==4) { 
				lblMDead.setVisible(true);
				lblMNormal.setVisible(false);
				lblMTired.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
				lblMSick.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
			}
			if(mom.getFood()==6) { 
				lblMDead.setVisible(true);
				lblMNormal.setVisible(false);
				lblMTired.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
				lblMSick.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
			}
			if(mom.getHealth()==4) { 
				lblMDead.setVisible(true);
				lblMNormal.setVisible(false);
				lblMTired.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
				lblMSick.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
			}
			if(mom.getCondition()==3) { 
				lblMDead.setVisible(true);
				lblMNormal.setVisible(false);
				lblMTired.setVisible(false);
				lblMSickCrazyExhausted.setVisible(false);
				lblMSick.setVisible(false);
				lblMCrazy.setVisible(false);
				lblMExhaustedSickInjury.setVisible(false);
				lblMExhaustedSick.setVisible(false);
				lblMExhaustedCrazy.setVisible(false);
				lblMExhausted.setVisible(false);
			}
		}
		
		public void changeImageDad(ConPanel dad) {
			dad=father;
			if(dad.getCondition()==1) { //�Ƿλ���
				lblFTired.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false);
				lblFExhausted.setVisible(false);
				lblFSick.setVisible(false);
				lblFCrazy.setVisible(false);
				lblFInjury.setVisible(false);
			}
			if(dad.getCondition()==2) { //���ʻ���
				lblFExhausted.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false);
				lblFTired.setVisible(false);
				lblFSick.setVisible(false);
				lblFCrazy.setVisible(false);
				lblFInjury.setVisible(false);
			}
			if(dad.getHealth()==2) { //��������
				lblFSick.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false);
				lblFExhausted.setVisible(false);
				lblFCrazy.setVisible(false);
				lblFInjury.setVisible(false);
				lblFTired.setVisible(false);
			}
			if(dad.getMind()==11) { //��ħ����
				lblFCrazy.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false);
				lblFInjury.setVisible(false);
				lblFTired.setVisible(false);
				lblFSick.setVisible(false);
				lblFExhausted.setVisible(false);
			}
			if(dad.getHealth()==1) { //�λ����
				lblFInjury.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false); 
				lblFTired.setVisible(false);
				lblFSick.setVisible(false);
				lblFExhausted.setVisible(false);
				lblFCrazy.setVisible(false);
			}
			if(dad.getHealth()==2 && dad.getMind()==11) {//����+��ħ
				lblFSickCrazy.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFCrazy.setVisible(false);
				lblFSick.setVisible(false);
				lblFExhaustedSick.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFCrazyTired.setVisible(false);
				lblFSickTired.setVisible(false);
			}
			if(dad.getCondition()==2 && dad.getHealth()==2) {//����+����
				lblFExhaustedSick.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhausted.setVisible(false);
				lblFInjury.setVisible(false); 
				lblFExhaustedSickInjury.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFCrazyTired.setVisible(false);
				lblFSickTired.setVisible(false);
			}
			if(dad.getCondition()==2 && dad.getHealth()==1) {//����+�λ�
				lblFInjuryExhausted.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFExhausted.setVisible(false);
				lblFInjury.setVisible(false); 
				lblFSickCrazy.setVisible(false);
				lblFExhaustedSick.setVisible(false);
				lblFCrazyTired.setVisible(false);
				lblFSickTired.setVisible(false);
			}
			if(dad.getMind()==11 && dad.getCondition()==1) {//��ħ+�Ƿ�
				lblFCrazyTired.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFExhaustedSick.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false);
				lblFCrazy.setVisible(false);
				lblFTired.setVisible(false);
			}
			if(dad.getHealth()==2 && dad.getCondition()==1) {//����+�Ƿ�
				lblFSickTired.setVisible(true);
				lblFNormal.setVisible(false);
				lblFSick.setVisible(false);
				lblFTired.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false);
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFExhaustedSick.setVisible(false);
				lblFSickCrazy.setVisible(false);
				
			}
			
			if(dad.getCondition()==2 && dad.getHealth()==2 && dad.getHealth()==1) {//����+����+�λ�
				lblFExhaustedSickInjury.setVisible(true);
				lblFNormal.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFExhaustedSick.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFCrazyTired.setVisible(false);
				lblFSickTired.setVisible(false);
				lblFExhausted.setVisible(false);
				lblFInjury.setVisible(false); 
				lblFSick.setVisible(false);
				
			}
			
			////�������
			if(dad.getWater()==4) { 
				lblFDead.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false); 
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false); 
				lblFExhausted.setVisible(false);
				lblFCrazy.setVisible(false); 
				lblFInjury.setVisible(false); 
				lblFTired.setVisible(false); 
				lblFSick.setVisible(false); 
			}
			if(dad.getFood()==6) { 
				lblFDead.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false); 
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false); 
				lblFExhausted.setVisible(false);
				lblFCrazy.setVisible(false); 
				lblFInjury.setVisible(false); 
				lblFTired.setVisible(false); 
				lblFSick.setVisible(false); 
			}
			if(dad.getHealth()==4) { 
				lblFDead.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false); 
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false); 
				lblFExhausted.setVisible(false);
				lblFCrazy.setVisible(false); 
				lblFInjury.setVisible(false); 
				lblFTired.setVisible(false); 
				lblFSick.setVisible(false); 
			}
			if(dad.getCondition()==3) { 
				lblFDead.setVisible(true);
				lblFNormal.setVisible(false);
				lblFExhaustedSickInjury.setVisible(false); 
				lblFExhaustedSick.setVisible(false); 
				lblFCrazyTired.setVisible(false);
				lblFInjuryExhausted.setVisible(false);
				lblFSickCrazy.setVisible(false);
				lblFSickTired.setVisible(false); 
				lblFExhausted.setVisible(false);
				lblFCrazy.setVisible(false); 
				lblFInjury.setVisible(false); 
				lblFTired.setVisible(false); 
				lblFSick.setVisible(false); 
			}
		}
		
		public void changeImageDaughter(ConPanel daughter) {
			daughter=this.daughter;
			if(daughter.getCondition()==1) { //�Ƿλ���
				lblDTired.setVisible(true);
				lblDNormal.setVisible(false);
				lblDSickExhaustedInjury.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
				lblDSickExhausted.setVisible(false);
				lblDSick.setVisible(false);
				lblDExhausted.setVisible(false);
			}
			if(daughter.getCondition()==2) { //���ʻ���
				lblDExhausted.setVisible(true);
				lblDNormal.setVisible(false);
				lblDTired.setVisible(false);
				lblDSick.setVisible(false);
				lblDSickExhaustedInjury.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
				lblDSickExhausted.setVisible(false);
			}
			if(daughter.getHealth()==2) { //��������
				lblDSick.setVisible(true);
				lblDNormal.setVisible(false);
				lblDSickExhaustedInjury.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
				lblDSickExhausted.setVisible(false);
				lblDExhausted.setVisible(false);
				lblDTired.setVisible(false);
			}
			
			if(daughter.getCondition()==2 && daughter.getHealth()==2) {//����+����
				lblDSickExhausted.setVisible(true);
				lblDNormal.setVisible(false);
				lblDExhausted.setVisible(false);
				lblDTired.setVisible(false);
				lblDSick.setVisible(false);
				lblDSickExhaustedInjury.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
			}
			if(daughter.getCondition()==2 && daughter.getHealth()==1) {//����+�λ�
				lblDExhaustedInjury.setVisible(true);
				lblDNormal.setVisible(false);
				lblDSickExhaustedInjury.setVisible(false);
				lblDSickExhausted.setVisible(false);
				lblDExhausted.setVisible(false);
				lblDTired.setVisible(false);
				lblDSick.setVisible(false);
			}
			
			
			if(daughter.getCondition()==2 && daughter.getHealth()==2 && daughter.getHealth()==1) {//����+����+�λ�
				lblDSickExhaustedInjury.setVisible(true);
				lblDNormal.setVisible(false);
				lblDSickExhausted.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
				lblDTired.setVisible(false);
				lblDSick.setVisible(false);
				lblDExhausted.setVisible(false);
			}
			
			////�������
			if(daughter.getWater()==4) { 
				lblDTired.setVisible(false);  
				lblDSickExhaustedInjury.setVisible(false); 
				lblDSickExhaustedCrazy.setVisible(false); 
				lblDSickExhausted.setVisible(false); 
				lblDSick.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
				lblDExhausted.setVisible(false);
				lblDNormal.setVisible(false);
			}
			if(daughter.getFood()==6) { 
				lblDTired.setVisible(false);  
				lblDSickExhaustedInjury.setVisible(false); 
				lblDSickExhaustedCrazy.setVisible(false); 
				lblDSickExhausted.setVisible(false); 
				lblDSick.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
				lblDExhausted.setVisible(false);
				lblDNormal.setVisible(false);
			}
			if(daughter.getHealth()==4) { 
				lblDTired.setVisible(false);  
				lblDSickExhaustedInjury.setVisible(false); 
				lblDSickExhaustedCrazy.setVisible(false); 
				lblDSickExhausted.setVisible(false); 
				lblDSick.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
				lblDExhausted.setVisible(false);
				lblDNormal.setVisible(false);
			}
			if(daughter.getCondition()==3) { 
				lblDTired.setVisible(false);  
				lblDSickExhaustedInjury.setVisible(false); 
				lblDSickExhaustedCrazy.setVisible(false); 
				lblDSickExhausted.setVisible(false); 
				lblDSick.setVisible(false);
				lblDExhaustedInjury.setVisible(false);
				lblDExhausted.setVisible(false);
				lblDNormal.setVisible(false);
			}
		}
		
		public void changeImageSon(ConPanel son) {
			son=this.son;
			if(son.getCondition()==2) { //���ʻ���
				lblSExhausted.setVisible(true);
				lblSNormal.setVisible(false);
				lblSCrazyExhausted.setVisible(false);
				lblSExhaustedSick.setVisible(false);
				lblSCrazy.setVisible(false);
				lblSSick.setVisible(false);
			}
			if(son.getHealth()==2) { //��������
				lblSSick.setVisible(true);
				lblSNormal.setVisible(false);
				lblSExhausted.setVisible(false);
				lblSCrazy.setVisible(false);
				lblSCrazyExhausted.setVisible(false);
				lblSExhaustedSick.setVisible(false);
			}
			if(son.getMind()==11) { //��ħ����
				lblSCrazy.setVisible(true);
				lblSNormal.setVisible(false);
				lblSCrazyExhausted.setVisible(false);
				lblSExhaustedSick.setVisible(false);
				lblSSick.setVisible(false);
				lblSExhausted.setVisible(false);
			}
			
			if(son.getCondition()==2 && son.getHealth()==2) {//����+����
				lblSExhaustedSick.setVisible(true);
				lblSNormal.setVisible(false);
				lblSSick.setVisible(false);
				lblSCrazy.setVisible(false);
				lblSExhausted.setVisible(false);
				lblSCrazyExhausted.setVisible(false);
			}
			if(son.getCondition()==2 && son.getMind()==11) {//����+��ħ
				lblSCrazyExhausted.setVisible(true);
				lblSNormal.setVisible(false);
				lblSExhaustedSick.setVisible(false);
				lblSSick.setVisible(false);
				lblSCrazy.setVisible(false);
				lblSExhausted.setVisible(false);
			}
			
			////�������
			if(son.getWater()==4) { 
				lblSNormal.setVisible(false);
				lblSCrazyExhausted.setVisible(false);
				lblSSick.setVisible(false);
				lblSCrazy.setVisible(false);
				lblSExhaustedSick.setVisible(false);
				lblSExhausted.setVisible(false);
			}
			if(son.getFood()==6) { 
				lblSNormal.setVisible(false);
				lblSCrazyExhausted.setVisible(false);
				lblSSick.setVisible(false);
				lblSCrazy.setVisible(false);
				lblSExhaustedSick.setVisible(false);
				lblSExhausted.setVisible(false);
			}
			if(son.getHealth()==4) { 
				lblSNormal.setVisible(false);
				lblSCrazyExhausted.setVisible(false);
				lblSSick.setVisible(false);
				lblSCrazy.setVisible(false);
				lblSExhaustedSick.setVisible(false);
				lblSExhausted.setVisible(false);
			}
			if(son.getCondition()==3) { 
				lblSNormal.setVisible(false);
				lblSCrazyExhausted.setVisible(false);
				lblSSick.setVisible(false);
				lblSCrazy.setVisible(false);
				lblSExhaustedSick.setVisible(false);
				lblSExhausted.setVisible(false);
			}
		}
		///////////////////////////////End changeImage()/////////////////////////////////////////////////
		
		/* 
		public void distributionFood() {
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
					
					public void distributionWater() {
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
					 */
					
					// �������� Ȯ���ϴ� ���� ����� --> �ƺ���ư����--> isOutside+=1;
					 public void momCondition(ConPanel mom) {
						 mom=this.mother;
						   if(mom.getCondition()==3 || mom.getCondition()==2) { // ��� Ȥ�� ���ʻ��� --> Ž�� �Ұ��� ����
							   lblAdvMX.setVisible(true); // ���� Ž�� ������ ���� �̹��� ���̰�
							   btnAdvM.setVisible(false); // �������� �Ⱥ��̰�
							   btnAdvSelectM.setVisible(false);
							   if(mom.getCondition()==3) {
								   lblMConText.setText("..."); // ������� ��� ��Ÿ���� �ؽ�Ʈ
							   }
							   else lblMConText.setText("Mother is not in a condition she can go on an expedition."); // ������ ��� ��Ÿ���� �ؽ�Ʈ
						   } // end if ��� Ȥ�� ���ʻ��� --> Ž�� �Ұ��� ����
						   
						   else {
							   btnAdvM.setVisible(true); // Ž�� ���� �� �� ���� �̹��� ���̰�
							   btnAdvSelectM.setVisible(false);
							   lblAdvMX.setVisible(false);
							   
							   if(mom.getHealth()==1 || mom.getHealth()==3 || mom.getMind()==1) // Ž���� �����ϳ� ������ ����
								   lblMConText.setText("She is not sure if she can return safely."); 
							   else // Ž�� ������ ����
								   lblMConText.setText("Mother is okay to go on an expedition.");   
							   
						   } // end else --> Ž�� ������ ����
						   
					   } // MomCondition()
					   
					   
					   public void fatherCondition(ConPanel dad) {
						   dad=this.father;
						   if(dad.getCondition()==3 || dad.getCondition()==2) { // ��� Ȥ�� ���ʻ��� --> Ž�� �Ұ��� ����
							   lblAdvFX.setVisible(true); // �ƺ� Ž�� ������ ���� �̹��� ���̰�
							   btnAdvF.setVisible(false); // �������� �Ⱥ��̰�
							   btnAdvSelectF.setVisible(false);
							   if(dad.getCondition()==3) {
								   lblFConText.setText("..."); // ������� ��� ��Ÿ���� �ؽ�Ʈ
							   }
							   else lblFConText.setText("Father is not in a condition he can go on an expedition."); // ������ ��� ��Ÿ���� �ؽ�Ʈ
						   } // end if ��� Ȥ�� ���ʻ��� --> Ž�� �Ұ��� ����
						   
						   else {
							   btnAdvF.setVisible(true); // Ž�� ���� �� �� ���� �̹��� ���̰�
							   btnAdvSelectF.setVisible(false);
							   lblAdvFX.setVisible(false);
							   
							   if(dad.getHealth()==1 || dad.getHealth()==3 || dad.getMind()==1) // Ž���� �����ϳ� ������ ����
								   lblFConText.setText("He is not sure if he can return safely."); 
							   else // Ž�� ������ ����
								   lblFConText.setText("Father is okay to go on an expedition.");   
							   
						   } // end else --> Ž�� ������ ����
						   
					   } // FatherCondition()
					   
					   
					   public void daughterCondition(ConPanel daughter) {
						   daughter=this.daughter;
						   if(daughter.getCondition()==3 || daughter.getCondition()==2) { // ��� Ȥ�� ���ʻ��� --> Ž�� �Ұ��� ����
							   lblAdvDX.setVisible(true); // �� Ž�� ������ ���� �̹��� ���̰�
							   btnAdvD.setVisible(false); // �������� �Ⱥ��̰�
							   btnAdvSelectD.setVisible(false);
							   if(daughter.getCondition()==3) {
								   lblDConText.setText("..."); // ������� ��� ��Ÿ���� �ؽ�Ʈ
							   }
							   else lblDConText.setText("Daughter is not in a condition she can go on an expedition."); // ������ ��� ��Ÿ���� �ؽ�Ʈ
						   } // end if ��� Ȥ�� ���ʻ��� --> Ž�� �Ұ��� ����
						   
						   else {
							   btnAdvD.setVisible(true); // Ž�� ���� �� �� ���� �̹��� ���̰�
							   btnAdvSelectD.setVisible(false);
							   lblAdvDX.setVisible(false);
							   
							   if(daughter.getHealth()==1 || daughter.getHealth()==3 || daughter.getMind()==1) // Ž���� �����ϳ� ������ ����
								   lblDConText.setText("She is not sure if she can return safely."); 
							   else // Ž�� ������ ����
								   lblDConText.setText("Daughter is okay to go on an expedition.");   
							   
						   } // end else --> Ž�� ������ ����
						   
					   } // DaughterCondition()
					   
					   
					   public void sonCondition(ConPanel son) {
						   son=this.son;
						   if(son.getCondition()==3 || son.getCondition()==2) { // ��� Ȥ�� ���ʻ��� --> Ž�� �Ұ��� ����
							   lblAdvSX.setVisible(true); // �Ƶ� Ž�� ������ ���� �̹��� ���̰�
							   btnAdvS.setVisible(false); // �������� �Ⱥ��̰�
							   btnAdvSelectS.setVisible(false);
							   if(son.getCondition()==3) {
								   lblSConText.setText("..."); // ������� ��� ��Ÿ���� �ؽ�Ʈ
							   }
							   else lblSConText.setText("Son is not in a condition he can go on an expedition."); // ������ ��� ��Ÿ���� �ؽ�Ʈ
						   } // end if ��� Ȥ�� ���ʻ��� --> Ž�� �Ұ��� ����
						   
						   else {
							   btnAdvS.setVisible(true); // Ž�� ���� �� �� ���� �̹��� ���̰�
							   btnAdvSelectS.setVisible(false);
							   lblAdvSX.setVisible(false);
							   
							   if(son.getHealth()==1 || son.getHealth()==3 || son.getMind()==1) // Ž���� �����ϳ� ������ ����
								   lblSConText.setText("He is not sure if he can return safely."); 
							   else // Ž�� ������ ����
								   lblSConText.setText("Son is okay to go on an expedition.");   
							   
						   } // end else --> Ž�� ������ ����
						   
					   } // SonCondition()
					   
					   
   public void goAdventure() { // ��ư �����ʿ� �ֱ� --> �������� �Ѿ�� ��ư ������ �����ٰ� �����ؾ���
	/*			   randomAdv = (int)(Math.random()*3) + 4; //  event 4~7 �󸶳� Ž���� �� �������� ����
				   eda = nDay+randomAdv; // estimated day of arrival (EDA) ���� ���� �ð��� ����
				    Ž�輱�� Ŭ���� ���� �߻��ϵ��� �̰��� ����Ž�輱�ù�ư �����ʿ� �ֱ�
	*/
				   if(isOutsideM==1) { // ������ Ž�質������
					   lblMExhaustedSickInjury.setVisible(false);
					   lblMExhaustedSick.setVisible(false);
					   lblMExhaustedCrazy.setVisible(false);
					   lblMExhausted.setVisible(false);
					   lblMNormal.setVisible(false);
					   lblMClear.setVisible(false);
					   lblMTired.setVisible(false); 
					   lblMSickCrazyExhausted.setVisible(false);
					   lblMSick.setVisible(false);
					   lblMDead.setVisible(false);
					   lblMCrazy.setVisible(false);
					   // ���� ���ȣ �ȿ� ����
					   shelterM=0; // ���� �������� ����
				   } else if(isOutsideF==1) { // �ƺ� ���ȣ �ȿ� ����
					   lblFClear.setVisible(false);
					   lblFDead.setVisible(false); 
					   lblFExhaustedSickInjury.setVisible(false);
					   lblFExhaustedSick.setVisible(false);
					   lblFCrazyTired.setVisible(false);
					   lblFInjuryExhausted.setVisible(false);
					   lblFSickCrazy.setVisible(false);
					   lblFSickTired.setVisible(false);
					   lblFExhausted.setVisible(false);
					   lblFCrazy.setVisible(false);
					   lblFInjury.setVisible(false);
					   lblFTired.setVisible(false);
					   lblFSick.setVisible(false);
					   lblFNormal.setVisible(false);
				     	// �ƺ� ���ȣ �ȿ� ����
					   shelterF=0; // �ƺ� �������� ����
				   } else if(isOutsideS==1) { // �Ƶ� ���ȣ �ȿ� ���� 
					   lblSNormal.setVisible(false);
					   lblSCrazyExhausted.setVisible(false);
					   lblSSick.setVisible(false);
					   lblSCrazy.setVisible(false);
					   lblSExhaustedSick.setVisible(false);
					   lblSExhausted.setVisible(false);
					   lblSClear.setVisible(false);
					   // �Ƶ� ���ȣ �ȿ� ����
					   shelterS=0; // �Ƶ� �������� ����
				   } else if(isOutsideD==1) { // �� ���ȣ �ȿ� ����
					   lblDClear.setVisible(false);
					   lblDTired.setVisible(false);
					   lblDNormal.setVisible(false);
					   lblDSickExhaustedInjury.setVisible(false);
					   lblDSickExhaustedCrazy.setVisible(false);
					   lblDSickExhausted.setVisible(false);
					   lblDSick.setVisible(false);
					   lblDExhaustedInjury.setVisible(false);
					   lblDExhausted.setVisible(false);
					   // �� ���ȣ �ȿ� ����
					   shelterD=0; // �� �������� ����
				   } 
				   	 		   
			   } // adventure()
			   
			   public void randomGotItem() { // ���ƿ��³� �����ؾ� ��
				   int randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranRadio=randomGotItem;
				   if(ranRadio==1) {
					   if(shelterRadio==1) {
						   ranRadio=2;
					   } else {
						   shelterRadio=1;
					   }
				   } // ���� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranBullet=randomGotItem;
				   if(ranBullet==1) {
					   if(shelterBullet==1) {
						   ranBullet=2;
					   } else {
						   shelterBullet=1;
					   }
				   } // �Ѿ� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranGun=randomGotItem;
				   if(ranGun==1) {
					   if(shelterGun==1) {
						   ranGun=2;
					   } else {
						   shelterGun=1;
					   }
				   } // �� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranChessboard=randomGotItem;
				   if(ranChessboard==1) {
					   if(shelterChessboard==1) {
						   ranChessboard=2;
					   } else {
						   shelterChessboard=1;
					   }
				   } // ü���� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranBook=randomGotItem;
				   if(ranBook==1) {
					   if(shelterBook==1) {
						   ranBook=2;
					   } else {
						   shelterBook=1;
					   }
				   } // å ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranFlashlight=randomGotItem;
				   if(ranFlashlight==1) {
					   if(shelterFlashlight==1) {
						   ranFlashlight=2;
					   } else {
						   shelterFlashlight=1;
					   }
				   } // ������ ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranPesticide=randomGotItem;
				   if(ranPesticide==1) {
					   if(shelterPesticide==1) {
						   ranPesticide=2;
					   } else {
						   shelterPesticide=1;
					   }
				   } // ������ ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranMap=randomGotItem;
				   if(ranMap==1) {
					   if(shelterMap==1) {
						   ranMap=2;
					   } else {
						   shelterMap=1;
					   }
				   } // ���� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranGasmask=randomGotItem;
				   if(ranGasmask==1) {
					   if(shelterGasmask==1) {
						   ranGasmask=2;
					   } else {
						   shelterGasmask=1;
					   }
				   } // �浶�� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranAxe=randomGotItem;
				   if(ranAxe==1) {
					   if(shelterAxe==1) {
						   ranAxe=2;
					   } else {
						   shelterAxe=1;
					   }
				   } // ���� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranAidkit=randomGotItem;
				   if(ranAidkit==1) {
					   if(shelterAidkit==1) {
						   ranAidkit=2;
					   } else {
						   shelterAidkit=1;
					   }
				   } // ���޻��� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*8) + 1; //  event 1~8 1/8�� Ȯ���� ������ ȹ��(��,���� ����)
				   ranCard=randomGotItem;
				   if(ranCard==1) {
					   if(shelterCard==1) {
						   ranCard=2;
					   } else {
						   shelterCard=1;
					   }
				   } // ���޻��� ȹ�� Ȥ�� �̹� �����־ ȹ�����
				   
				   randomGotItem = (int)(Math.random()*20) + 1; //  event 1~25  ��,���Ŀ� ����
				   //ranWater=randomGotItem;
				   switch(randomGotItem) {
				   case 1 : shelterWater+=0; ranWater=0; break;  case 2: shelterWater+=0; ranWater=0; break; 
				   case 3 : shelterWater+=0; ranWater=0; break;  case 4: shelterWater+=0; ranWater=0; break; // 4/20�� Ȯ���� �� 0�� ������
				   case 5 : shelterWater+=4; ranWater=1; break;// 1/20Ȯ���� �� 1�� ������'
				   case 6 : shelterWater+=8; ranWater=2; break; case 7 : shelterWater+=8;ranWater=2;  break; 
				   case 8 : shelterWater+=8; ranWater=2; break; case 9: shelterWater+=8; ranWater=2; break; 
				   case 10 :shelterWater+=8; ranWater=2; break; // 5/20�� Ȯ���� �� 2�� ������
				   case 11 : shelterWater+=12; ranWater=3; break; case 12 : shelterWater+=12; ranWater=3; break; 
				   case 13 : shelterWater+=12; ranWater=3; break; case 14 : shelterWater+=12; ranWater=3; break; // 4/20Ȯ���� �� 3�� ������
				   case 15 :shelterWater+=16; ranWater=4; break; case 16 : shelterWater+=16; ranWater=4; break; 
				   case 17 : shelterWater+=16; ranWater=4; break; // 3/20 Ȯ���� �� 4�� ������ 
				   case 18 : shelterWater+=20; ranWater=5; break; case 19 : shelterWater+=20; ranWater=5; break; // 2/20 Ȯ���� �� 5�� ������
				   case 20 : shelterWater+=24; ranWater=6; break;  // 1/20 Ȯ��� �� 6�� ������
				   } // ranWater
				   
				   randomGotItem = (int)(Math.random()*20) + 1; //  event 1~25  ��,���Ŀ� ����
				   switch(randomGotItem) {
				   case 1 : shelterFood+=0; ranFood=0; break;  case 2: shelterFood+=0; ranFood=0; break;
				   case 3 : shelterFood+=0; ranFood=0; break;  case 4 : shelterFood+=0; ranFood=0; break; // 4/20�� Ȯ���� �ķ� 0�� ������
				   case 5 : shelterFood+=4; ranFood=1; break;// 1/20Ȯ���� �ķ� 1�� ������'
				   case 6 : shelterFood+=8; ranFood=2; break; case 7 : shelterFood+=8; ranFood=2; break; 
				   case 8 : shelterFood+=8; ranFood=2; break; case 9: shelterFood+=8; ranFood=2; break; 
				   case 10 :shelterFood+=8; ranFood=2; break; // 5/20�� Ȯ���� �ķ� 2�� ������
				   case 11 : shelterFood+=12; ranFood=3; break; case 12 : shelterFood+=12; ranFood=3; break; 
				   case 13 : shelterFood+=12; ranFood=3; break; case 14 : shelterFood+=12; ranFood=3; break; // 4/20Ȯ���� �ķ� 3�� ������
				   case 15 :shelterFood+=16; ranFood=4; break; case 16 : shelterFood+=16; ranFood=4; break; 
				   case 17 : shelterFood+=16; ranFood=4; break; // 3/20 Ȯ���� �ķ� 4�� ������ 
				   case 18 : shelterFood+=20; ranFood=5; break; case 19 : shelterFood+=20; ranFood=5; break; // 2/20 Ȯ���� �ķ� 5�� ������
				   case 20 :shelterFood+=24; ranFood=6; break;  // 1/20 Ȯ��� �ķ� 6�� ������
				   } // ranFood
				 	   
			   } // randomGotItem()
			   
			   
			   
			   public void randomConditionM(ConPanel mother) {
				   // ���� Ž�谡���� ���� ����� ���¸� �����ұ��
				   if(isOutsideM==1) { // ������ ������� ����������
					   tempConditionM = mother.getCondition();
					   tempHealthM = mother.getHealth();	
				   } 
				   
				   int dangerConditionM=0; 
				    // ���������� �ƴ϶� randomConditionM�� ������ ������ ����������¸� ������� �ʱ�ȭ��
					// ����, �λ�, ��ħ ������ �� 1����    30�� ���� �� 1 ����
					// �̰��� ���ڰ� ������ ���� randomCondtion()���� ����Ȯ�� ����
				   
				   if(tempMindM==1) { dangerConditionM++; }// Ž�� ������ ���� ��ħ ������ ��
				   if(tempHealthM==1) { dangerConditionM++; } // Ž�� ������ ���� �λ� ������ ��
				   if(tempHealthM==2) { dangerConditionM++; } // Ž�� ������ ���� ���� ������ ��
				   if(DiaryPage.nDay>30) { dangerConditionM++; }  // 30�� ������ ���� --> ������ Ž��Ƚ���� ������ �����ϴ°� ������ �ϴ��� 30�� ������ �����ϴ� ������..
				   
				   if(dangerConditionM==0) { // ������ ȯ���� 0���� ��
					   int ranDead = (int)(Math.random()*25) + 1;  // 1 to 25
					   if(ranDead==1) { 
						   tempConditionM=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionM==1) { // ������ ȯ���� 1���� ��
					   int ranDead = (int)(Math.random()*8) + 1;  // 1 to 8
					   if(ranDead==1) {
						   tempConditionM=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionM==2) { // ������ ȯ���� 2���� ��
					   int ranDead = (int)(Math.random()*6) + 1;  // 1 to 6
					   if(ranDead==1) {
						   tempConditionM=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionM==3) { // ������ ȯ���� 3���� ��
					   int ranDead = (int)(Math.random()*4) + 1;  // 1 to 4
					   if(ranDead==1) {
						   tempConditionM=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionM==4) { // ������ ȯ���� 4���� ��
					   int ranDead = (int)(Math.random()*2) + 1;  // 1 to 2
					   if(ranDead==1) {
						   tempConditionM=3; // ��� ���·� ����.
					   }
				   } // if.. else if �״� Ȯ�� ����

				   int ranInjured = (int)(Math.random()*12) + 1; //  12 to 8
				   if( ranInjured == 1) {
					   tempHealthM=1; // �λ� ���·� ���ƿ�
				   }
				   
				   int ranDiseased = (int)(Math.random()*8) + 1; //  1 to 8
				   if( ranDiseased == 1) {
					   tempHealthM=2; // ���� ���·� ���ƿ�
				   }
				   

				   mother.water=3;  // Ž�� ���ٿ� ���� Ż�����·� ����
				   mother.food=2;  // Ž�� ���ٿ� ���� ����� ���·� ����
				   mother.mind= tempMindM; // Ž�� ���� ������ ���ε� ���¸� ����
				   mother.condition=2; // ���ʷ� ����
				   mother.health=tempHealthM; // Ž�� ���� ������ �ǰ����³� Ž�� ���ķ� �ٲ� �ǰ����¸� ����		   
				   
			   } // randomConditionM() ���� Ž�� ���ٿ��� �������� �����̻� �ɸ��ų� ���ʸ�
			   
			   
			   public void randomConditionF(ConPanel father) {
				   // ���� Ž�谡���� �ƺ� ����� ���¸� �����ұ��
				   if(isOutsideF==1) { // �ƺ��� ������� ����������
					   tempMindF = father.getMind();
					   tempConditionF = father.getCondition();
					   tempHealthF = father.getHealth();	
				   } 
				   
				   int dangerConditionF=0; 
				    // ���������� �ƴ϶� randomConditionM�� ������ ������ ����ƺ����¸� ������� �ʱ�ȭ��
					// ����, �λ�, ��ħ ������ �� 1����    30�� ���� �� 1 ����
					// �̰��� ���ڰ� ������ ���� randomCondtion()���� ����Ȯ�� ����
				   
				   if(tempMindF==1) { dangerConditionF++; }// Ž�� ������ ���� ��ħ ������ ��
				   if(tempHealthF==1) { dangerConditionF++; } // Ž�� ������ ���� �λ� ������ ��
				   if(tempHealthF==2) { dangerConditionF++; } // Ž�� ������ ���� ���� ������ ��
				   if(DiaryPage.nDay>30) { dangerConditionF++; }  // 30�� ������ ���� --> ������ Ž��Ƚ���� ������ �����ϴ°� ������ �ϴ��� 30�� ������ �����ϴ� ������..
				   
				   if(dangerConditionF==0) { // ������ ȯ���� 0���� ��
					   int ranDead = (int)(Math.random()*25) + 1;  // 1 to 25
					   if(ranDead==1) { 
						   tempConditionF=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionF==1) { // ������ ȯ���� 1���� ��
					   int ranDead = (int)(Math.random()*8) + 1;  // 1 to 8
					   if(ranDead==1) {
						   tempConditionF=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionF==2) { // ������ ȯ���� 2���� ��
					   int ranDead = (int)(Math.random()*6) + 1;  // 1 to 6
					   if(ranDead==1) {
						   tempConditionF=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionF==3) { // ������ ȯ���� 3���� ��
					   int ranDead = (int)(Math.random()*4) + 1;  // 1 to 4
					   if(ranDead==1) {
						   tempConditionF=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionF==4) { // ������ ȯ���� 4���� ��
					   int ranDead = (int)(Math.random()*2) + 1;  // 1 to 2
					   if(ranDead==1) {
						   tempConditionF=3; // ��� ���·� ����.
					   }
				   } // if.. else if �״� Ȯ�� ����

				   int ranInjured = (int)(Math.random()*12) + 1; //  12 to 8
				   if( ranInjured == 1) {
					   tempHealthF=1; // �λ� ���·� ���ƿ�
				   }
				   
				   int ranDiseased = (int)(Math.random()*8) + 1; //  1 to 8
				   if( ranDiseased == 1) {
					   tempHealthF=2; // ���� ���·� ���ƿ�
				   }
				   

				   father.water=3;  // Ž�� ���ٿ� ���� Ż�����·� ����
				   father.food=2;  // Ž�� ���ٿ� ���� ����� ���·� ����
				   father.mind= tempMindF; // Ž�� ���� ������ ���ε� ���¸� ����
				   father.condition=2; // ���ʷ� ����
				   father.health=tempHealthF; // Ž�� ���� ������ �ǰ����³� Ž�� ���ķ� �ٲ� �ǰ����¸� ����		   
				   
			   } // randomConditionF() �ƺ� Ž�� ���ٿ��� �������� �����̻� �ɸ��ų� ���ʸ�
			   

			   
			   public void randomConditionS(ConPanel son) {
				   // ���� Ž�谡���� �Ƶ� ����� ���¸� �����ұ��
				   if(isOutsideS==1) { // �Ƶ��� ������� ����������
					   tempMindS = son.getMind();
					   tempHealthS = son.getHealth();	
				   } 
				   
				   int dangerConditionS=0; 
				    // ���������� �ƴ϶� randomConditionM�� ������ ������ ����Ƶ���¸� ������� �ʱ�ȭ��
					// ����, �λ�, ��ħ ������ �� 1����    30�� ���� �� 1 ����
					// �̰��� ���ڰ� ������ ���� randomCondtion()���� ����Ȯ�� ����
				   
				   if(tempMindS==1) { dangerConditionS++; }// Ž�� ������ ���� ��ħ ������ ��
				   if(tempHealthS==1) { dangerConditionS++; } // Ž�� ������ ���� �λ� ������ ��
				   if(tempHealthS==2) { dangerConditionS++; } // Ž�� ������ ���� ���� ������ ��
				   if(DiaryPage.nDay>30) { dangerConditionS++; }  // 30�� ������ ���� --> ������ Ž��Ƚ���� ������ �����ϴ°� ������ �ϴ��� 30�� ������ �����ϴ� ������..
				   
				   if(dangerConditionS==0) { // ������ ȯ���� 0���� ��
					   int ranDead = (int)(Math.random()*25) + 1;  // 1 to 25
					   if(ranDead==1) { 
						   tempConditionS=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionS==1) { // ������ ȯ���� 1���� ��
					   int ranDead = (int)(Math.random()*8) + 1;  // 1 to 8
					   if(ranDead==1) {
						   tempConditionS=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionS==2) { // ������ ȯ���� 2���� ��
					   int ranDead = (int)(Math.random()*6) + 1;  // 1 to 6
					   if(ranDead==1) {
						   tempConditionS=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionS==3) { // ������ ȯ���� 3���� ��
					   int ranDead = (int)(Math.random()*4) + 1;  // 1 to 4
					   if(ranDead==1) {
						   tempConditionS=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionS==4) { // ������ ȯ���� 4���� ��
					   int ranDead = (int)(Math.random()*2) + 1;  // 1 to 2
					   if(ranDead==1) {
						   tempConditionS=3; // ��� ���·� ����.
					   }
				   } // if.. else if �״� Ȯ�� ����

				   int ranInjured = (int)(Math.random()*12) + 1; //  12 to 8
				   if( ranInjured == 1) {
					   tempHealthS=1; // �λ� ���·� ���ƿ�
				   }
				   
				   int ranDiseased = (int)(Math.random()*8) + 1; //  1 to 8
				   if( ranDiseased == 1) {
					   tempHealthS=2; // ���� ���·� ���ƿ�
				   }
				   

				   son.water=3;  // Ž�� ���ٿ� ���� Ż�����·� ����
				   son.food=2;  // Ž�� ���ٿ� ���� ����� ���·� ����
				   son.mind= tempMindS; // Ž�� ���� ������ ���ε� ���¸� ����
				   son.condition=2; // ���� ���·� ����
				   son.health=tempHealthS; // Ž�� ���� ������ �ǰ����³� Ž�� ���ķ� �ٲ� �ǰ����¸� ����		   
				   
			   } // randomConditionS() �Ƶ� Ž�� ���ٿ��� �������� �����̻� �ɸ��ų� ���ʸ�									   
			   
			   
			   
			   
			   public void randomConditionD(ConPanel daughter) {
				   // ���� Ž�谡���� �� ����� ���¸� �����ұ��
				   if(isOutsideD==1) { // ���� ������� ����������
					   tempMindD = daughter.getMind();
					   tempHealthD = daughter.getHealth();	
				   } 
				   
				   int dangerConditionD=0; 
				    // ���������� �ƴ϶� randomConditionD�� ������ ������ ����Ƶ���¸� ������� �ʱ�ȭ��
					// ����, �λ�, ��ħ ������ �� 1����    30�� ���� �� 1 ����
					// �̰��� ���ڰ� ������ ���� randomCondtion()���� ����Ȯ�� ����
				   
				   if(tempMindD==1) { dangerConditionD++; }// Ž�� ������ ���� ��ħ ������ ��
				   if(tempHealthD==1) { dangerConditionD++; } // Ž�� ������ ���� �λ� ������ ��
				   if(tempHealthD==2) { dangerConditionD++; } // Ž�� ������ ���� ���� ������ ��
				   if(DiaryPage.nDay>30) { dangerConditionD++; }  // 30�� ������ ���� --> ������ Ž��Ƚ���� ������ �����ϴ°� ������ �ϴ��� 30�� ������ �����ϴ� ������..
				   
				   if(dangerConditionD==0) { // ������ ȯ���� 0���� ��
					   int ranDead = (int)(Math.random()*25) + 1;  // 1 to 25
					   if(ranDead==1) { 
						   tempConditionD=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionD==1) { // ������ ȯ���� 1���� ��
					   int ranDead = (int)(Math.random()*8) + 1;  // 1 to 8
					   if(ranDead==1) {
						   tempConditionD=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionD==2) { // ������ ȯ���� 2���� ��
					   int ranDead = (int)(Math.random()*6) + 1;  // 1 to 6
					   if(ranDead==1) {
						   tempConditionD=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionD==3) { // ������ ȯ���� 3���� ��
					   int ranDead = (int)(Math.random()*4) + 1;  // 1 to 4
					   if(ranDead==1) {
						   tempConditionD=3; // ��� ���·� ����.
					   }
				   } else if(dangerConditionD==4) { // ������ ȯ���� 4���� ��
					   int ranDead = (int)(Math.random()*2) + 1;  // 1 to 2
					   if(ranDead==1) {
						   tempConditionD=3; // ��� ���·� ����.
					   }
				   } // if.. else if �״� Ȯ�� ����

				   int ranInjured = (int)(Math.random()*12) + 1; //  12 to 8
				   if( ranInjured == 1) {
					   tempHealthD=1; // �λ� ���·� ���ƿ�
				   }
				   
				   int ranDiseased = (int)(Math.random()*8) + 1; //  1 to 8
				   if( ranDiseased == 1) {
					   tempHealthD=2; // ���� ���·� ���ƿ�
				   }
				   

				   daughter.water=3;  // Ž�� ���ٿ� ���� Ż�����·� ����
				   daughter.food=2;  // Ž�� ���ٿ� ���� ����� ���·� ����
				   daughter.mind= tempMindD; // Ž�� ���� ������ ���ε� ���¸� ����
				   daughter.condition=2; // ���� ���·� ����
				   daughter.health=tempHealthD; // Ž�� ���� ������ �ǰ����³� Ž�� ���ķ� �ٲ� �ǰ����¸� ����		   
				   
			   } // randomConditionD() �� Ž�� ���ٿ��� �������� �����̻� �ɸ��ų� ���ʸ�		
			   
			   /*
			    *  ������ ������ (shelterM==0) �̸� �ķ��̳� Ž������������ ����������ĥ�� ������� �ٲ����
			    */
					   
					   public boolean getSelectFoodF() { return selectFoodF;}
					   public boolean getSelectFoodM() { return selectFoodM;}
					   public boolean getSelectFoodD() { return selectFoodD;}
					   public boolean getSelectFoodS() { return selectFoodS;}
					   
					   public boolean getSelectWaterF() { return selectWaterF;}
					   public boolean getSelectWaterM() { return selectWaterM;}
					   public boolean getSelectWaterD() { return selectWaterD;}
					   public boolean getSelectWaterS() { return selectWaterS;}
					   
					
} // Game class
