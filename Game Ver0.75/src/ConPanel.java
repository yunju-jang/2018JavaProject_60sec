import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


	public class ConPanel extends JPanel {
	    	
	    	 

	    	private Game game;
	    	
	    	public static int  water; 
	    	//�񸶸�ǥ��  Game Ŭ���� �� randomCondition�޼ҵ忡�� ����ϱ� ���Ͽ� static ����
	    	// water�� ���������� �����ϱ� ���� ���
			public static int food; 
			//�����ǥ��  Game Ŭ���� �� randomCondition�޼ҵ忡�� ����ϱ� ���Ͽ� static ����
	    	// food�� ���������� �����ϱ� ���� ���
			public static int mind; 
			//���Ż��� ǥ��  Game Ŭ���� �� randomCondition�޼ҵ忡�� ����ϱ� ���Ͽ� static ����
			// mind�� ���������� �����ϱ� ���� ���
			public static int condition; 
			//��ü���� ����ǥ�� Game Ŭ���� �� randomCondition�޼ҵ忡�� ����ϱ� ���Ͽ� static ����
			// condition�� ���������� �����ϱ� ���� ���
			public static int health;
			//�ǰ�����ǥ�� Game Ŭ���� �� randomCondition�޼ҵ忡�� ����ϱ� ���Ͽ� static ����
			// health�� ���������� �����ϱ� ���� ���
			public boolean IsAdventure; //Ž�� ������ �˷��ִ� ����
			public boolean adv=false; //��ħ���¸� ǥ���ϴµ� ���̴� ����
				
				//Ž���� ���ٿ��� water, food, mind, stamina�� ������ �������ش�.
					
				private int nRandom; //Ž�� �� ���� ���¸� �������� �����ϱ� ���� ����
				
				
				public JLabel lbl_water, lbl_food, lbl_health, lbl_mind, lbl_condition; 
				                                                       //���¸� ��Ÿ���� ��
				
			    public JLabel lblSClear, lblDClear, lblFClear, lblMClear; //���콺 �̺�Ʈ���� �� ������ ������ �� 
		    	
		    	public boolean selectFoodF, selectFoodM, selectFoodD, selectFoodS,
		    	               selectWaterF,selectWaterM, selectWaterD, selectWaterS; 
		    	
	     
		    	public void setWater(int water) {this.water+=water;}
				public void setFood(int food) {this.food+=food;}
				public void setMind(int mind) {this.mind+=mind;}
				public void setCondition(int condition) {this.condition=condition;}
				public void setHealth(int health) {this.health=health;}
				
				public int getWater() {return water;}
				public int getFood() {return food;}
				public int getMind() {return mind;}
          		public int getCondition() {return condition;}
          		public int getHealth() {return health;}	
	    		
	    	public ConPanel(Game g) {
	    		setPreferredSize(new Dimension(1920, 1080));
	    		setLayout(null);
	    		
	    		game = g;
	    		
	    		water=1;
				food=1;
				mind=0;
				health=0; 
				condition=0;
				
				//�⺻����
				
	    		
	    		
	    		lbl_water= new JLabel("");
	    		
	    		add(lbl_water);
	    		
	    		lbl_food= new JLabel(""); 
	    		
	    		add(lbl_food);
	    		
	    		lbl_health= new JLabel(""); 
	    		
	    		add(lbl_health);
	    		
	    		lbl_mind= new JLabel(""); 
	    		
	    		add(lbl_mind);
	    
	    		lbl_condition= new JLabel("");
	    		
	    		add(lbl_condition);
	    		
	    	} //DiConFrame()	

	    	public void adventure() {
				if(IsAdventure==true) {//Ž���� ���ٿ��� ���
					
					food=food+2;
					water=water+2;
					condition=condition+2;
					
					adv=true; //��ħ���� �����ϱ� ����
					
				}else if(IsAdventure==false) {//Ž���� �Ȱ��� ���
					food=food+1;
					water=water+1;
					condition=condition+1;
					
			    }
				
			}
			public void select() { //�ķ� �Ǵ� ���� �Ծ��� ��� ���¿� �߰����ִ� �޼ҵ�
				if(game.getSelectFoodF() == true) 
				   food=food-1;
				
				if(game.getSelectWaterF() == true) 
					water=water-1;
				
				if(game.getSelectFoodM() == true) 
					food=food-1;
				
				if(game.getSelectWaterM() == true) 
					water=water-1;	
				
				if(game.getSelectFoodD() == true) 
					food=food-1;
					
				if(game.getSelectWaterD() == true) 
					water=water-1; 
					
				if(game.getSelectFoodS() == true) 
					food=food-1;
					
				if(game.getSelectWaterS() == true) 
					water=water-1;
				
			}

			public void water() {
				
				if(1<=water || water<=2)
					lbl_water.setText("�񸶸�");
				if(water==3)
					lbl_water.setText("Ż��");
				if(water==4)
					lbl_water.setText("���");
			}
			public void food() {
				if(1<=food || food<=3)
					lbl_food.setText("�����");
				if(4<=food || food<6)
					lbl_food.setText("���ָ�");
				if(food==6)
					lbl_food.setText("���");
			}
			public void health() {
				if(adv==true)
					nRandom=(int)(Math.random()*1); 
				    	if(nRandom==1)
				    		lbl_health.setText("����");
				 if(health==0)
					 lbl_health.setText("����"); 
				 if(health==1)
					 lbl_health.setText("�λ�");
				 if(health==2)
					 lbl_health.setText("����");
				 if(health==3)
					 lbl_health.setText("���� �λ�");
				 if(health==4)
					 lbl_health.setText("���");
			}
			public void mind() {
				if(mind==0)
					lbl_mind.setText("����");
				if(mind==11)
					lbl_mind.setText("��ħ");
			}
			public void condition() {
				if(condition==0)
					lbl_condition.setText("����");
				if(condition==1)
					lbl_condition.setText("�Ƿ�");
				if(adv==true || condition==2)
					lbl_condition.setText("����");
				    IsAdventure=false;
				if(condition==3)
					lbl_condition.setText("���");
					
			}
	    	
			
	    	public void down() {
	    		if(DiaryPage.nDay==1)
	    			food=food+1;
	    			water=water+1;
	    			mind=mind+1;
	    			health=health+1;
	    			condition=condition+1;
	    	}
			
			public void tired() {
				if(DiaryPage.nDay==10 && adv==true)
				  if(condition<2) 
					  setCondition(1);
			}
	}