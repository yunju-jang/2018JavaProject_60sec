import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

public class Diary1 extends JPanel{
	
	private DiaryPage diaryPage;
	private ImageIcon diary1background;
	private JPanel diary1Panel;
	private JLabel lblTotalGotItem;
	
	public Diary1(DiaryPage d) {
		diaryPage = d;
		setPreferredSize(new Dimension(1902, 1033));
		setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		diary1background = new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png");	//����̹���
		   
		   diary1Panel=new JPanel() {	//��� �г� ����
			   public void paintComponent(Graphics g) {		//����� �׷���
				   Dimension d =getSize();
				   g.drawImage(diary1background.getImage(), 0, 0, 1920, 1080, null);
				   setOpaque(false);
				   super.paintComponent(g);
			   }//paintComponent()
		   }; //background1
		   diary1Panel.setBounds(0,0,1920,1080);
		   diary1Panel.setLayout(null);
		   add(diary1Panel);
		   
		   lblTotalGotItem = new JLabel();
		   lblTotalGotItem.setVisible(false);
		   diary1Panel.add(lblTotalGotItem);
		// �� ���� ���� ��,�ķ��� �Ծ�����, �̺�Ʈ�� ���� � ����� ���Դ���, Ž���� �������� ������ ������ �� �����Դ���
			// ���� ��,�ķ� �Ծ����� Ȯ��
			setUnVisible(false); // 1������ �����ϱ� �� ��� �� �� ��ư �Ⱥ��̰�
			if(Game.shelterF==1) { // �ƺ��� ���ȣ�� �ִ� ���¸�
				if(Game.selectFoodF = true) { // �ƺ��� �ķ� �Ծ��� ���
					Game.lblFoodFText.setText("�ƺ�  >> �ķ�  + 1");
				} else if(Game.selectFoodF = false) { // �ƺ��� �ķ� �ȸԾ��� ���
					Game.lblFoodFText.setText("");
				}
				if(Game.selectWaterF == true ) { // �ƺ��� �� �Ծ��� ���
					Game.lblWaterFText.setText("�ƺ�  >> ��  + 1");
				} else if(Game.selectWaterF == false) { // �ƺ��� �� �ȸԾ��� ���
					Game.lblWaterFText.setText("");
				}
			} else { // ���� ���ȣ�� ���� ���¸� 
				if(Game.isOutsideF==1) { // �ƺ��� Ž�質�� �����̸�
					Game.lblWaterFText.setText("Ž�� ���Դϴ�."); Game.lblFoodFText.setText("Ž�����Դϴ�.");
					} else { // �ƺ��� ����� �����̸�
						Game.lblWaterFText.setText("..."); Game.lblFoodFText.setText("...");
					}
				}
			
			if(Game.shelterM==1) { // ������ ���ȣ�� �ִ� ���¸�
				if(Game.selectFoodM = true) { // ���� �ķ� �Ծ��� ���
					Game.lblFoodMText.setText("����  >> �ķ�  + 1");
				} else if(Game.selectFoodM = false) { // ������ �ķ� �ȸԾ��� ���
					Game.lblFoodMText.setText("");
				}
				if(Game.selectWaterM == true ) { // ������ �� �Ծ��� ���
					Game.lblWaterMText.setText("����  >> ��  + 1");
				} else if(Game.selectWaterM == false) { // ������ �� �ȸԾ��� ���
					Game.lblWaterMText.setText("");
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
		
		
	} // Diary1()
	
}
