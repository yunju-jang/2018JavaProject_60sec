import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Diary3 extends JPanel {
	private DiaryPage diaryPage;
	private JPanel diary3Panel;
	public ImageIcon diary3background;
	public JLabel lblFood0,lblFood1, lblFood2, lblFood3, lblFood4;
	public JLabel lblWater0, lblWater1, lblWater2, lblWater3, lblWater4;
	public JLabel lblDiary15, lblDiary14, lblDiary13, lblDiary12;
	public JLabel lblDiary11, lblDiary10, lblDiary9, lblDiary8, lblDiary7;
	public JLabel lblDiary6, lblDiary5, lblDiary4, lblDiary3;
	public JLabel lblDiary2, lblDiary1, lblNormalDiary, lblTestDiary;
	public JLabel lblDiaryF, lblDiaryFX, lblDiaryM, lblDiaryMX, lblDiaryD;
	public JLabel lblDiaryDX, lblDiaryS, lblDiarySX, lblDay, lblFood, lblWater;
	public JLabel lblSDiary1, lblSDiary2, lblSDiary3, lblSDiary4, lblSurvive, lblDie;
	
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
	
	public int nSurEvent, aEvent;
	public int nSCount = 0;
	public int nRandomResult = (int)(Math.random()*3); // 0~3
	
	public Game game;
	
	
	public Diary3(DiaryPage d) {
		diaryPage = d;
		setPreferredSize(new Dimension(1902, 1033));
		setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		diary3background = new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png");	//����̹���
		   
		   diary3Panel=new JPanel() {	//��� �г� ����
			   public void paintComponent(Graphics g) {		//����� �׷���
				   Dimension d =getSize();
				   g.drawImage(diary3background.getImage(), 0, 0, 1920, 1080, null);
				   setOpaque(false);
				   super.paintComponent(g);
			   }//paintComponent()
		   }; //background1
		   diary3Panel.setBounds(0,0,1920,1080);
		   diary3Panel.setLayout(null);
		   add(diary3Panel);
		
		
		
	} // Diary3()
	
	public void btnDiaryAidkit() {
		if(Game.shelterAidkit == 1) {
			btnAidkit.setVisible(true);
			Game.lblAidkit.setVisible(true);
		} else {
			btnAidkitX.setVisible(true);
			
		} // if..else
	}
	public void btnDiaryAxe() {
		if(Game.shelterAxe == 1) {
			btnAxe.setVisible(true);
			Game.lblAxe.setVisible(true);
		} else {
			btnAxeX.setVisible(true);
		} // if..else
	}
	public void btnDiaryRadio() {
		if(Game.shelterRadio == 1) {
			btnRadio.setVisible(true);
			Game.lblRadio.setVisible(true);
		} else {
			btnRadioX.setVisible(true);
		} // if..else
	}
	public void btnDiaryGasmask() {
		if(Game.shelterGasmask == 1) {
			btnGasmask.setVisible(true);
			Game.lblGasmask.setVisible(true);
		} else {
			btnGasmaskX.setVisible(true);
		} // if..else
	}
	public void btnDiaryPesticide() {
		if(Game.shelterPesticide == 1) {
			btnPesticide.setVisible(true);
			Game.lblPesticide.setVisible(true);
		} else {
			btnPesticideX.setVisible(true);
		} // if..else
	}
	public void btnDiaryFlashlight() {
		if(Game.shelterFlashlight == 1) {
			btnFlashlight.setVisible(true);
			Game.lblFlashlight.setVisible(true);
		} else {
			btnFlashlightX.setVisible(true);
		} // if..else
	}
	public void btnDiaryMap() {
		if(Game.shelterMap == 1) {
			btnMap.setVisible(true);
			Game.lblMap.setVisible(true);
		} else {
			btnMapX.setVisible(true);
		} // if..else
	}
	public void btnDiaryBook() {
		if(Game.shelterBook == 1) {
			btnBook.setVisible(true);
			Game.lblBook.setVisible(true);
		} else {
			btnBookX.setVisible(true);
		} // if..else
	}
	public void btnDiaryChessboard() {
		if(Game.shelterChessboard == 1) {
			btnChessboard.setVisible(true);
			Game.lblChessboard.setVisible(true);
		} else {
			btnChessboardX.setVisible(true);
		} // if..else
	}
	public void btnDiaryGun() {
		if(Game.shelterGun == 1) {
			btnGun.setVisible(true);
			Game.lblGun.setVisible(true);
		} else {
			btnGunX.setVisible(true);
		} // if..else
	}
	public void btnDiaryBullet() {
		if(Game.shelterBullet == 1) {
			btnBullet.setVisible(true);
			Game.lblBullet.setVisible(true);
		} // if
	}
	public void btnDiaryCard() {
		if(Game.shelterCard == 1) {
			btnCard.setVisible(true);
			Game.lblCard.setVisible(true);
		} else {
			btnCardX.setVisible(true);
		} // if..else
	}
	
	public void normalEvent() {
		Game.nEvent = (int)(Math.random()*15) + 1; //  event 1~15
		switch (Game.nEvent) {
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
	} /* �󺧹迭�����ؼ� �������� �ϳ� �����ޱ� - �Ϸ簡 ���� ������.. 
	= ȭ��ǥ ������ ���������� +1 �ؼ� �ķ���� �������� �Ǹ� ��Ÿ������ �̰� ������ ������*/
	
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
	
	public  void allEvent() {
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
	
	/*public void setEventResult() {
	      switch (Game.nEvent) {
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
	      } // switch_Game.nEvent
	} // setEventResult()
*/	
	public class DiaryL implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JButton btn = (JButton)event.getSource();
			// if�� switch�� �ٲٱ�...
			if (Game.nEvent == 1) {
				if(btn == btnMap) { // btn == btnMap 
					btnMap.setVisible(false);
	                btnSelectionMap.setVisible(true);
	                Game.eventSelectData = 1;
	                game.setEventResult();
				} else if(btn == btnCard) { // btn == btnCard
					btnCard.setVisible(false);
	                btnSelectionCard.setVisible(true);
	                Game.eventSelectData = 2;
	                game.setEventResult();
				} else if(btn == btnRadio) { // btn == btnRadio
					btnRadio.setVisible(false);
	                btnSelectionRadio.setVisible(true); 
	                Game.eventSelectData = 3;
	                game.setEventResult();
				}  else if(btn == btnSelectionMap) {
	                  btnMap.setVisible(true);
	                  btnSelectionMap.setVisible(false);
	                  Game.eventSelectData = 4;
		                game.setEventResult();
	               } else if(btn == btnSelectionCard) {
	                  btnCard.setVisible(true);
	                  btnSelectionCard.setVisible(false);
	                  Game.eventSelectData = 4;
		                game.setEventResult();
	               } else if(btn == btnSelectionRadio) {
	                  btnRadio.setVisible(true);
	                  btnSelectionRadio.setVisible(false); 
	                  Game.eventSelectData = 4;
		                game.setEventResult();
	               } else {Game.eventSelectData = 4; 
	                game.setEventResult();} // Game.nEvent == 1	
				
				} else if (Game.nEvent == 2) {
					if(btn == btnPesticide) { // btn == btnPesticide
						btnPesticide.setVisible(false);
						btnSelectionPesticide.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnBook) { // btn == btnBook
						btnBook.setVisible(false);
						btnSelectionBook.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else if(btn == btnAidkit) { // btn == btnAidkit
						btnAidkit.setVisible(false);
						btnSelectionAidkit.setVisible(true);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionPesticide){
						btnPesticide.setVisible(true);
						btnSelectionPesticide.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else if(btn == btnSelectionBook) {
						btnBook.setVisible(true);
						btnSelectionBook.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else if(btn == btnSelectionAidkit) {
						btnAidkit.setVisible(true);
						btnSelectionAidkit.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else {Game.eventSelectData = 4; 
	                game.setEventResult();}// Game.nEvent == 2 
					
				} else if (Game.nEvent == 3) {
					if(btn == btnCard) { // btn == btnCard
						btnCard.setVisible(false);
						btnSelectionCard.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnChessboard) {
						btnChessboard.setVisible(false);
						btnSelectionChessboard.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else if(btn == btnSelectionCard) {
						btnCard.setVisible(true);
						btnSelectionCard.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionChessboard) {
						btnChessboard.setVisible(true);
						btnSelectionChessboard.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else {Game.eventSelectData = 3; 
	                game.setEventResult();}// Game.nEvent == 3
				
				} else if (Game.nEvent == 4) {
					if (btn == btnRadio) {
						btnRadio.setVisible(false);
						btnSelectionRadio.setVisible(true); 
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnSelectionRadio) {
						btnRadio.setVisible(true);
						btnSelectionRadio.setVisible(false);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else {Game.eventSelectData = 2; }// Game.nEvent == 4
				
				
				} else if (Game.nEvent == 5) {
					if(btn == btnAxe) {
						btnAxe.setVisible(false);
						btnSelectionAxe.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnAidkit) {
						btnAidkit.setVisible(false);
						btnSelectionAidkit.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else if(btn == btnSelectionAxe) {
						btnAxe.setVisible(true);
						btnSelectionAxe.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionAidkit) {
						btnAidkit.setVisible(true);
						btnSelectionAidkit.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else {Game.eventSelectData = 3; 
	                game.setEventResult();}// Game.nEvent == 5
				
				} else if (Game.nEvent == 6) {
					if(btn == btnPesticide) {
						btnPesticide.setVisible(false);
						btnSelectionPesticide.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnAxe) {
						btnAxe.setVisible(false);
						btnSelectionAxe.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else if(btn == btnGun) {
						btnGun.setVisible(false);
						btnSelectionGun.setVisible(true);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionPesticide) {
						btnPesticide.setVisible(true);
						btnSelectionPesticide.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else if(btn == btnSelectionAxe) {
						btnAxe.setVisible(true);
						btnSelectionAxe.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else if(btn == btnSelectionGun) {
						btnGun.setVisible(true);
						btnSelectionGun.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else { Game.eventSelectData = 4; 
	                game.setEventResult();}// Game.nEvent == 6
				
				} else if (Game.nEvent == 7) {
					if(btn == btnX) {
						btnX.setVisible(false);
						btnSelectionX.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnO) {
						btnO.setVisible(false);
						btnSelectionO.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					}  else if(btn == btnSelectionX) {
						btnX.setVisible(true);
						btnSelectionX.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionO) {
						btnO.setVisible(true);
						btnSelectionO.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else {Game.eventSelectData = 3; 
	                game.setEventResult();}// Game.nEvent == 7
				
				} else if (Game.nEvent == 8) {
					if(btn == btnAidkit) {
						btnAidkit.setVisible(false);
						btnSelectionAidkit.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					}  else if (btn == btnSelectionAidkit) {
						btnAidkit.setVisible(true);
						btnSelectionAidkit.setVisible(false);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else {Game.eventSelectData = 2; 
	                game.setEventResult();}// Game.nEvent== 8
				
				} else if (Game.nEvent == 9) {
					if(btn == btnGun) {
						btnGun.setVisible(false);
						btnSelectionGun.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnFlashlight) {
						btnFlashlight.setVisible(false);
						btnSelectionFlashlight.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					}  else if(btn == btnSelectionGun) {
						btnGun.setVisible(true);
						btnSelectionGun.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionFlashlight) {
						btnFlashlight.setVisible(true);
						btnSelectionFlashlight.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else {Game.eventSelectData = 3; 
	                game.setEventResult();}// Game.nEvent == 9

				} else if (Game.nEvent == 10) {
					if(btn == btnBook) {
						 btnBook.setVisible(false);
						 btnSelectionBook.setVisible(true);
						 Game.eventSelectData = 1;
			                game.setEventResult();
					}  else if (btn == btnSelectionBook) {
						 btnBook.setVisible(true);
						 btnSelectionBook.setVisible(false);
						 Game.eventSelectData = 2;
			                game.setEventResult();
					} else {Game.eventSelectData = 2; 
	                game.setEventResult();}// Game.nEvent == 10

				} else if (Game.nEvent == 11) {
					if(btn == btnGun) {
						btnGun.setVisible(false);
						btnSelectionGun.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnGasmask) {
						btnGasmask.setVisible(false);
						btnSelectionGasmask.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else if(btn == btnCard) {
						btnCard.setVisible(false);
						btnSelectionCard.setVisible(true);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnChessboard) {
						btnChessboard.setVisible(false);
						btnSelectionChessboard.setVisible(true);
						Game.eventSelectData = 4;
		                game.setEventResult();
					}  else if(btn == btnSelectionGun) {
						btnGun.setVisible(true);
						btnSelectionGun.setVisible(false);
						Game.eventSelectData = 5;
		                game.setEventResult();
					} else if(btn == btnSelectionGasmask) {
						btnGasmask.setVisible(true);
						btnSelectionGasmask.setVisible(false);
						Game.eventSelectData = 5;
		                game.setEventResult();
					} else if(btn == btnSelectionCard) {
						btnCard.setVisible(true);
						btnSelectionCard.setVisible(false);
						Game.eventSelectData = 5;
		                game.setEventResult();
					} else if(btn == btnSelectionChessboard) {
						btnChessboard.setVisible(true);
						btnSelectionChessboard.setVisible(false);
						Game.eventSelectData = 5;
		                game.setEventResult();
					} else {Game.eventSelectData = 5; 
	                game.setEventResult();}// Game.nEvent == 11
					
				} else if (Game.nEvent == 12) {
					if(btn == btnAxe) {
						btnAxe.setVisible(false);
						btnSelectionAxe.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnGun) {
						btnGun.setVisible(false);
						btnSelectionGun.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else if(btn == btnSelectionAxe) {
						btnAxe.setVisible(true);
						btnSelectionAxe.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionGun) {
						btnAxe.setVisible(true);
						btnSelectionAxe.setVisible(false);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else {Game.eventSelectData = 3; 
	                game.setEventResult();}// Game.nEvent == 12

				} else if (Game.nEvent == 13) {
					if(btn == btnCard) {
						btnCard.setVisible(false);
						btnSelectionCard.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnSelectionCard) {
						btnCard.setVisible(true);
						btnSelectionCard.setVisible(false);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else {Game.eventSelectData = 2; 
	                game.setEventResult();}// Game.nEvent == 13
					
				} else if (Game.nEvent == 14) {
					if(btn == btnChessboard) {
						btnChessboard.setVisible(false);
						btnSelectionChessboard.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnPesticide) {
						btnPesticide.setVisible(false);
						btnSelectionPesticide.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else if(btn == btnBook) {
						btnBook.setVisible(false);
						btnSelectionBook.setVisible(true);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionChessboard) {
						btnChessboard.setVisible(true);
						btnSelectionChessboard.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else if(btn == btnSelectionPesticide) {
						btnPesticide.setVisible(true);
						btnSelectionPesticide.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else if(btn == btnSelectionBook) {
						btnBook.setVisible(true);
						btnSelectionBook.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else {Game.eventSelectData = 4; 
	                game.setEventResult();}// Game.nEvent == 14
 
				} else if (Game.nEvent == 15) {
					if(btn == btnChessboard) {
						btnChessboard.setVisible(false);
						btnSelectionChessboard.setVisible(true);
						Game.eventSelectData = 1;
		                game.setEventResult();
					} else if(btn == btnBook) {
						btnBook.setVisible(false);
						btnSelectionBook.setVisible(true);
						Game.eventSelectData = 2;
		                game.setEventResult();
					} else if(btn == btnAidkit) {
						btnAidkit.setVisible(false);
						btnSelectionAidkit.setVisible(true);
						Game.eventSelectData = 3;
		                game.setEventResult();
					} else if(btn == btnSelectionChessboard) {
						btnChessboard.setVisible(true);
						btnSelectionChessboard.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else if(btn == btnSelectionBook) {
						btnBook.setVisible(true);
						btnSelectionBook.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else if(btn == btnSelectionAidkit) {
						btnAidkit.setVisible(true);
						btnSelectionAidkit.setVisible(false);
						Game.eventSelectData = 4;
		                game.setEventResult();
					} else {Game.eventSelectData = 4; 
	                game.setEventResult();}// Game.nEvent == 15
				} // if..else if => normalEvent
			
			if (nSurEvent == 1) { 
				if (btn == btnRadio) {
					btnRadio.setVisible(false);
					btnSelectionRadio.setVisible(true); 
					Game.eventSelectData = 1;
	                game.setEventResult();
					nSCount++;
				} else {Game.eventSelectData = 0; 
                game.setEventResult();}// nSurEvent == 1
			} else if (nSurEvent == 2) {
				if(btn == btnX) {
					btnX.setVisible(false);
					btnSelectionX.setVisible(true);
					Game.eventSelectData = 1;
	                game.setEventResult();
				} else if(btn == btnO) {
					btnO.setVisible(false);
					btnSelectionO.setVisible(true);
					Game.eventSelectData = 2;
	                game.setEventResult();
					nSCount++;
				}  else if(btn == btnSelectionX) {
					btnX.setVisible(true);
					btnSelectionX.setVisible(false);
					Game.eventSelectData = 0;
	                game.setEventResult();
				} else if(btn == btnSelectionO) {
					btnO.setVisible(true);
					btnSelectionO.setVisible(false);
					Game.eventSelectData = 0; 
	                game.setEventResult();
				} // nSurEvent == 2
			}else if (nSurEvent == 3) {
				if(btn == btnMap) {
					btnMap.setVisible(false);
					btnSelectionMap.setVisible(true);
					Game.eventSelectData = 1;
	                game.setEventResult();
					nSCount++;
				} else Game.eventSelectData = 0; // nSurEvent == 3
			} else if (nSurEvent == 4) {
				if(btn == btnGun) {
					btnGun.setVisible(false);
					btnSelectionGun.setVisible(true);
					Game.eventSelectData = 1;
	                game.setEventResult();
					nSCount++;
				} else {Game.eventSelectData = 0; 
                game.setEventResult();}// nSurEvent == 4
			} // if..else if => serviveEvent
		}
	}
}
