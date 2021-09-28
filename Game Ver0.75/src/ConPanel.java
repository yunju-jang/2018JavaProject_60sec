import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


	public class ConPanel extends JPanel {
	    	
	    	 

	    	private Game game;
	    	
	    	public static int  water; 
	    	//목마름표시  Game 클래스 내 randomCondition메소드에서 사용하기 위하여 static 선언
	    	// water를 직접적으로 변경하기 위해 사용
			public static int food; 
			//배고픔표시  Game 클래스 내 randomCondition메소드에서 사용하기 위하여 static 선언
	    	// food를 직접적으로 변경하기 위해 사용
			public static int mind; 
			//정신상태 표시  Game 클래스 내 randomCondition메소드에서 사용하기 위하여 static 선언
			// mind를 직접적으로 변경하기 위해 사용
			public static int condition; 
			//전체적인 상태표시 Game 클래스 내 randomCondition메소드에서 사용하기 위하여 static 선언
			// condition을 직접적으로 변경하기 위해 사용
			public static int health;
			//건강상태표시 Game 클래스 내 randomCondition메소드에서 사용하기 위하여 static 선언
			// health를 직접적으로 변경하기 위해 사용
			public boolean IsAdventure; //탐험 유무를 알려주는 변수
			public boolean adv=false; //미침상태를 표시하는데 쓰이는 변수
				
				//탐험을 갔다오면 water, food, mind, stamina를 적절히 조절해준다.
					
				private int nRandom; //탐험 후 아픈 상태를 랜덤으로 설정하기 위한 변수
				
				
				public JLabel lbl_water, lbl_food, lbl_health, lbl_mind, lbl_condition; 
				                                                       //상태를 나타내는 라벨
				
			    public JLabel lblSClear, lblDClear, lblFClear, lblMClear; //마우스 이벤트에서 쓸 가족들 각각의 라벨 
		    	
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
				
				//기본설정
				
	    		
	    		
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
				if(IsAdventure==true) {//탐험을 갔다왔을 경우
					
					food=food+2;
					water=water+2;
					condition=condition+2;
					
					adv=true; //미침상태 설정하기 위함
					
				}else if(IsAdventure==false) {//탐험을 안갔을 경우
					food=food+1;
					water=water+1;
					condition=condition+1;
					
			    }
				
			}
			public void select() { //식량 또는 물을 먹었을 경우 상태에 추가해주는 메소드
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
					lbl_water.setText("목마름");
				if(water==3)
					lbl_water.setText("탈수");
				if(water==4)
					lbl_water.setText("사망");
			}
			public void food() {
				if(1<=food || food<=3)
					lbl_food.setText("배고픔");
				if(4<=food || food<6)
					lbl_food.setText("굶주림");
				if(food==6)
					lbl_food.setText("사망");
			}
			public void health() {
				if(adv==true)
					nRandom=(int)(Math.random()*1); 
				    	if(nRandom==1)
				    		lbl_health.setText("질병");
				 if(health==0)
					 lbl_health.setText("정상"); 
				 if(health==1)
					 lbl_health.setText("부상");
				 if(health==2)
					 lbl_health.setText("질병");
				 if(health==3)
					 lbl_health.setText("질병 부상");
				 if(health==4)
					 lbl_health.setText("사망");
			}
			public void mind() {
				if(mind==0)
					lbl_mind.setText("정상");
				if(mind==11)
					lbl_mind.setText("미침");
			}
			public void condition() {
				if(condition==0)
					lbl_condition.setText("정상");
				if(condition==1)
					lbl_condition.setText("피로");
				if(adv==true || condition==2)
					lbl_condition.setText("녹초");
				    IsAdventure=false;
				if(condition==3)
					lbl_condition.setText("사망");
					
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