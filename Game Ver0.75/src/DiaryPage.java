import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DiaryPage extends JPanel{
	
	public JButton btnSelectionRightB, btnSelectionLeftB, btnSelectionBackB, btnBackB, btnRightB, btnLeftB;
	public Diary0 diary0;
	public Diary1 diary1;
	public Diary2 diary2;
	public Diary3 diary3;
	public Diary4 diary4;
	public static int nDiaryPage = 0; //nDiaryPage�� �� 0~4���� ����
	public DiaryL diaryL; // ActionListener
	public MouseL mouseL; // MouseListener
	public static int nDay = 1;
	public int temp = 1;
	public JButton btnOpenDiary;
	public JLabel lblIsOutside, lblComeBack, lblBlack; // diaryPage 1�ʿ��� ���� ��������, Ȥ�� ���� ���ƿԴ��� ��Ÿ���� �ؽ�Ʈ ��
	private JLabel lblDay;
	public JLabel lblIsOutsideM, lblIsOutsideF, lblIsOutsideD, lblIsOutsideS;
	private int isOutsideM, isOutsideF, isOutsideS, isOutsideD; // �� ������ Ž�������� �ƴ���
	public ImageIcon diarybackground;
	public JPanel diaryPanel;
	
	public DiaryPage() {
		setPreferredSize(new Dimension(1902, 1033));
		setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		diarybackground = new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png");	//����̹���
		   
		   diaryPanel=new JPanel() {	//��� �г� ����
			   public void paintComponent(Graphics g) {		//����� �׷���
				   Dimension d =getSize();
				   g.drawImage(diarybackground.getImage(), 0, 0, 1920, 1080, null);
				   setOpaque(false);
				   super.paintComponent(g);
			   }//paintComponent()
		   }; //background1
		   diaryPanel.setBounds(0,0,1920,1080);
		   diaryPanel.setLayout(null);
		   add(diaryPanel);
		
		diary0 = new Diary0(this);
		diary1 = new Diary1(this);
		diary2 = new Diary2(this);
		diary3 = new Diary3(this);
		diary4 = new Diary4(this);
		diaryL = new DiaryL();
		mouseL = new MouseL();
		
		lblBlack = new JLabel();
		lblBlack.setIcon(new ImageIcon("img/StuffSrc/Black.png"));
		lblBlack.setSize(1902, 1033);
		lblBlack.setVisible(false);
		lblBlack.addMouseListener(mouseL);
		lblBlack.setVisible(false);
		diaryPanel.add(lblBlack);
		
		btnOpenDiary = new JButton();
	    btnOpenDiary.setIcon(new ImageIcon("img/StuffSrc/Shelter_DiarySelection.png"));
	    btnOpenDiary.setLocation(1592, 746);
	    btnOpenDiary.setSize(201, 197);
	    btnOpenDiary.addActionListener(diaryL);
	    diaryPanel.add(btnOpenDiary);
		
		
		JButton btnSelectionBackB = new JButton();
		btnSelectionBackB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/�ڷΰ���ȭ��ǥ_Selection.png"));
		btnSelectionBackB.setBounds(1262, 121, 91, 73);
		btnSelectionBackB.addActionListener(diaryL);
		btnSelectionBackB.addMouseListener(mouseL);
		diaryPanel.add(btnSelectionBackB);
		btnSelectionBackB.setVisible(false);
		
		JButton btnSelectionRightB = new JButton();
		btnSelectionRightB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/������ȭ��ǥ_Selection.png"));
		btnSelectionRightB.setBounds(1110, 817, 209, 115);
		btnSelectionRightB.addActionListener(diaryL);
		btnSelectionRightB.addMouseListener(mouseL);
		diaryPanel.add(btnSelectionRightB);
		btnSelectionRightB.setVisible(false);
		
		JButton btnSelectionLeftB = new JButton();
		btnSelectionLeftB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuff/����ȭ��ǥ_Selection.png"));
		btnSelectionLeftB.setBounds(753, 817, 218, 127);
		btnSelectionLeftB.addActionListener(diaryL);
		btnSelectionLeftB.addMouseListener(mouseL);
		diaryPanel.add(btnSelectionLeftB);
		btnSelectionLeftB.setVisible(false);
	    
		JButton btnBackB = new JButton();
		btnBackB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/�ڷΰ���ȭ��ǥ_SelectionX.png"));
		btnBackB.setBounds(1279, 138, 74, 42);
		btnBackB.addActionListener(diaryL);
		btnBackB.addMouseListener(mouseL);
		diaryPanel.add(btnBackB);
		
		JButton btnRightB = new JButton();
		btnRightB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/������ȭ��ǥ_SelectionX.png"));
		btnRightB.setBounds(1112, 816, 176, 94);
		btnRightB.addActionListener(diaryL);
		btnRightB.addMouseListener(mouseL);
		diaryPanel.add(btnRightB);
		
		JButton btnLeftB = new JButton();
		btnLeftB.setIcon(new ImageIcon("img/DiarySrc/ChoiceStuffX/����ȭ��ǥ_SelectionX.png"));
		btnLeftB.setBounds(801, 850, 172, 67);
		btnLeftB.addActionListener(diaryL);
		btnLeftB.addMouseListener(mouseL);
		diaryPanel.add(btnLeftB);
		
		// Day
		lblDay = new JLabel();
		lblDay.setLocation(1000, 128);
		lblDay.setFont(new Font("������� ExtraBold", Font.BOLD, 38));
		lblDay.setSize(129, 72);
		lblDay.setText(nDay+"��"); // ������ nDay�� �ؽ�Ʈ�� ��ȯ
		lblDay.setVisible(false);
		diaryPanel.add(lblDay);
		diaryPanel.add(diary0);
		diaryPanel.add(diary1);
		diaryPanel.add(diary2);
		diaryPanel.add(diary3);
		diaryPanel.add(diary4);
		diary0.setVisible(false);
		diary1.setVisible(false);
		diary2.setVisible(false);
		diary3.setVisible(false);
		diary4.setVisible(false);
		btnBackB.setVisible(false);
		btnRightB.setVisible(false);
		btnLeftB.setVisible(false);

		
		if(nDiaryPage == 0) {
			diary0.setVisible(true);
			diary1.setVisible(false);
			diary2.setVisible(false);
			diary3.setVisible(false);
			diary4.setVisible(false);
			btnBackB.setVisible(false);
			btnRightB.setVisible(false);
			btnLeftB.setVisible(false);
			diaryPanel.add(diary0);
		} else if(nDiaryPage == 1) {
			diary1.setVisible(true);
			diary2.setVisible(false);
			diary3.setVisible(false);
			diary4.setVisible(false);
			btnBackB.setVisible(true);
			btnRightB.setVisible(true);
			btnLeftB.setVisible(true);
			diaryPanel.add(diary1);
		}else if(nDiaryPage == 2) {
			diary1.setVisible(false);
			diary2.setVisible(true);
			diary3.setVisible(false);
			diary4.setVisible(false);
			btnBackB.setVisible(true);
			btnRightB.setVisible(true);
			btnLeftB.setVisible(true);
			diaryPanel.add(diary2);
		}else if(nDiaryPage == 3) {
			diary1.setVisible(false);
			diary2.setVisible(false);
			diary3.setVisible(true);
			diary4.setVisible(false);
			btnBackB.setVisible(true);
			btnRightB.setVisible(true);
			btnLeftB.setVisible(true);
			diaryPanel.add(diary3);
		}else if(nDiaryPage == 4) {
			diary1.setVisible(false);
			diary2.setVisible(false);
			diary3.setVisible(false);
			diary4.setVisible(true);
			btnBackB.setVisible(true);
			btnRightB.setVisible(true);
			btnLeftB.setVisible(true);
			diaryPanel.add(diary4);
		}
	}
	
	public void openDiary(int nDiaryPage) {
		if(nDiaryPage == 0) {
			diary0.setVisible(true);
			diary1.setVisible(false);
			diary2.setVisible(false);
			diary3.setVisible(false);
			diary4.setVisible(false);
			btnBackB.setVisible(false);
			btnRightB.setVisible(false);
			btnLeftB.setVisible(false);
		} else if(nDiaryPage == 1) {
			diary1.setVisible(true);
			diary2.setVisible(false);
			diary3.setVisible(false);
			diary4.setVisible(false);
			btnBackB.setVisible(true);
			btnRightB.setVisible(true);
			btnLeftB.setVisible(true);
		}else if(nDiaryPage == 2) {
			diary1.setVisible(false);
			diary2.setVisible(true);
			diary3.setVisible(false);
			diary4.setVisible(false);
			btnBackB.setVisible(true);
			btnRightB.setVisible(true);
			btnLeftB.setVisible(true);
		}else if(nDiaryPage == 3) {
			diary1.setVisible(false);
			diary2.setVisible(false);
			diary3.setVisible(true);
			diary4.setVisible(false);
			btnBackB.setVisible(true);
			btnRightB.setVisible(true);
			btnLeftB.setVisible(true);
		}else if(nDiaryPage == 4) {
			diary1.setVisible(false);
			diary2.setVisible(false);
			diary3.setVisible(false);
			diary4.setVisible(true);
			btnBackB.setVisible(true);
			btnRightB.setVisible(true);
			btnLeftB.setVisible(true);
		} else if(nDiaryPage == 5) {
			nDay++;
			lblBlack.setVisible(true);
			lblDay.setVisible(true);
			btnBackB.setVisible(false);
			btnRightB.setVisible(false);
			btnLeftB.setVisible(false);
			/*if(isOutsideM==1 || isOutsideF==1 || isOutsideD==1 || isOutsideS==1) { // �������� ������� �� ����
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
*/			
			nDiaryPage = 0;
		} // Switch_nDaiayPage : btnRightB, btnLeftB, btnBackB�� ������ �� �ϱ����� ������ ������ �ڵ�!
	}
	public void openDiary1() {
		diary1.setVisible(true);
		diary2.setVisible(false);
		diary3.setVisible(false);
		diary4.setVisible(false);
	}
	
	public void openDiary2() {
		diary1.setVisible(false);
		diary2.setVisible(true);
		diary3.setVisible(false);
		diary4.setVisible(false);
	}
	
	public void openDiary3() {
		diary1.setVisible(false);
		diary2.setVisible(false);
		diary3.setVisible(true);
		diary4.setVisible(false);
	}
	
	public void openDiary4() {
		diary1.setVisible(false);
		diary2.setVisible(false);
		diary3.setVisible(false);
		diary4.setVisible(true);
	}
	
	public void openDiary0() {
		diary0.setVisible(true);
		diary1.setVisible(false);
		diary2.setVisible(false);
		diary3.setVisible(false);
		diary4.setVisible(false);
	}
	
	public class DiaryL implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton btn = (JButton)event.getSource();
			
			// btnBackB�� ���� �ϱ����� �������� �����ִ� �ϱ��� ��ġ�� ����
			if(btn == btnBackB) {
				temp = DiaryPage.nDiaryPage;
				nDiaryPage = 0;
				openDiary(nDiaryPage);
			}	
			if(btn == btnLeftB) {
				nDiaryPage--;
				openDiary(nDiaryPage);
			}
			if(btn == btnRightB) {
				nDiaryPage++;
				openDiary(nDiaryPage);
			}
			if(btn == btnOpenDiary) {
				nDiaryPage = temp;
				openDiary1();
				diary1.setVisible(false);
			}
			
			
			
							
		}// actionPerformed()
	} // ActionListener()
	
	public class MouseL implements MouseListener {
		public void mouseEntered(MouseEvent e) {} // mouse Entered
		public void mouseExited(MouseEvent e) {} // mouseExited()
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			JButton btn = (JButton)e.getSource();
			if(btn == btnSelectionBackB) {
				btnBackB.setVisible(false);
				btnSelectionBackB.setVisible(true);
				} else if(btn == btnSelectionLeftB) {
					btnLeftB.setVisible(false);
					btnSelectionLeftB.setVisible(true);
			} else if(btn == btnSelectionRightB) {
				btnRightB.setVisible(false);
				btnSelectionRightB.setVisible(true);
			}
		} // mousePressed()
		public void mouseReleased(MouseEvent e) {
			JButton btn = (JButton)e.getSource();
			JLabel lbl = (JLabel)e.getSource();
			if(btn == btnSelectionBackB) {
				btnBackB.setVisible(true);
				btnSelectionBackB.setVisible(false);
				} else if(btn == btnSelectionLeftB) {
					btnLeftB.setVisible(true);
					btnSelectionLeftB.setVisible(false);
			} else if(btn == btnSelectionRightB) {
				btnRightB.setVisible(true);
				btnSelectionRightB.setVisible(false);
			} // if..if else
			if(lbl == lblBlack) {
				openDiary(nDiaryPage);
			} // if
		} // mouseReleased
	
	} // MenuListener class
	
}
