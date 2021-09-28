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
		
		diary1background = new ImageIcon("img/StuffSrc/Shelter_DiaryClear.png");	//배경이미지
		   
		   diary1Panel=new JPanel() {	//배경 패널 생성
			   public void paintComponent(Graphics g) {		//배경을 그려줌
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
		// 그 전날 누가 물,식량을 먹었는지, 이벤트에 의해 어떤 결과가 나왔는지, 탐험은 나갔는지 나갔다 왔으면 뭘 가져왔는지
			// 전날 물,식량 먹었는지 확인
			setUnVisible(false); // 1페이지 시작하기 전 모든 라벨 및 버튼 안보이게
			if(Game.shelterF==1) { // 아빠가 방공호에 있는 상태면
				if(Game.selectFoodF = true) { // 아빠가 식량 먹었을 경우
					Game.lblFoodFText.setText("아빠  >> 식량  + 1");
				} else if(Game.selectFoodF = false) { // 아빠가 식량 안먹었을 경우
					Game.lblFoodFText.setText("");
				}
				if(Game.selectWaterF == true ) { // 아빠가 물 먹었을 경우
					Game.lblWaterFText.setText("아빠  >> 물  + 1");
				} else if(Game.selectWaterF == false) { // 아빠가 물 안먹었을 경우
					Game.lblWaterFText.setText("");
				}
			} else { // 딸이 방공호에 없는 상태면 
				if(Game.isOutsideF==1) { // 아빠가 탐험나간 상태이면
					Game.lblWaterFText.setText("탐험 중입니다."); Game.lblFoodFText.setText("탐험중입니다.");
					} else { // 아빠가 사망한 상태이면
						Game.lblWaterFText.setText("..."); Game.lblFoodFText.setText("...");
					}
				}
			
			if(Game.shelterM==1) { // 엄마가 방공호에 있는 상태면
				if(Game.selectFoodM = true) { // 딸이 식량 먹었을 경우
					Game.lblFoodMText.setText("엄마  >> 식량  + 1");
				} else if(Game.selectFoodM = false) { // 엄마가 식량 안먹었을 경우
					Game.lblFoodMText.setText("");
				}
				if(Game.selectWaterM == true ) { // 엄마가 물 먹었을 경우
					Game.lblWaterMText.setText("엄마  >> 물  + 1");
				} else if(Game.selectWaterM == false) { // 엄마가 물 안먹었을 경우
					Game.lblWaterMText.setText("");
				}
			} else { // 엄마가 방공호에 없는 상태면 
				if(isOutsideM==1) { // 엄마가 탐험나간 상태이면
					lblWaterMText.setText("탐험 중입니다."); lblFoodMText.setText("탐험중입니다.");
					} else { // 엄마가 사망한 상태이면
						lblWaterMText.setText("..."); lblFoodMText.setText("...");
					}
				}
			
			if(shelterD==1) { // 딸이 방공호에 있는 상태면
				if(selectFoodD = true) { // 딸이 식량 먹었을 경우
					lblFoodDText.setText("딸  >> 식량  + 1");
				} else if(selectFoodD = false) { // 딸이 식량 안먹었을 경우
					lblFoodDText.setText("");
				}
				if(selectWaterD == true ) { // 딸이 물 먹었을 경우
					lblWaterDText.setText("딸  >> 물  + 1");
				} else if(selectWaterD == false) { // 딸이 물 안먹었을 경우
					lblWaterDText.setText("");
				}
			} else { // 딸이 방공호에 없는 상태면 
				if(isOutsideD==1) { // 딸이 탐험나간 상태이면
					lblWaterDText.setText("탐험 중입니다."); lblFoodDText.setText("탐험중입니다.");
					} else { // 딸이 사망한 상태이면
						lblWaterDText.setText("..."); lblFoodDText.setText("...");
					}
				}
			
			if(shelterS==1) { // 아들이 방공호에 있는 상태면
				if(selectFoodS = true) { // 아들이 식량 먹었을 경우
					lblFoodSText.setText("아들  >> 식량  + 1");
				} else if(selectFoodS = false) { // 아들이 식량 안먹었을 경우
					lblFoodSText.setText("");
				}
				if(selectWaterS == true ) { // 아들이 물 먹었을 경우
					lblWaterSText.setText("아들  >> 물  + 1");
				} else if(selectWaterS == false) { // 아들이 물 안먹었을 경우
					lblWaterSText.setText("");
				}
			} else { // 아들이 방공호에 없는 상태면 
				if(isOutsideS==1) { // 아들이 탐험나간 상태이면
					lblWaterSText.setText("탐험 중입니다."); lblFoodSText.setText("탐험중입니다.");
					} else { // 아들이 사망한 상태이면
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
			
			// 이벤트에 의한 결과
			
			// 탐험 나갔으면 누가 나갔는지
			if(isOutsideM==1 && nDay==leaveHomeDay) { // 떠난 날에만 누가 나갔는지 표시
				lblIsOutside.setText("엄마가 탐험을 나갔습니다.");  // lblIsOutside 생성추가해야함
				lblIsOutside.setVisible(true);
			} else if(isOutsideF==1 && nDay==leaveHomeDay) { // 떠난 날에만 누가 나갔는지 표시
				lblIsOutside.setText("아빠가 탐험을 나갔습니다.");
				lblIsOutside.setVisible(true);
			} else if(isOutsideS==1 && nDay==leaveHomeDay) { // 떠난 날에만 누가 나갔는지 표시
				lblIsOutside.setText("아들이 탐험을 나갔습니다.");
				lblIsOutside.setVisible(true);
			} else if(isOutsideD==1 && nDay==leaveHomeDay) { // 떠난 날에만 누가 나갔는지 표시
				lblIsOutside.setText("딸이 탐험을 나갔습니다.");
				lblIsOutside.setVisible(true);
			}
			
			// 탐험 돌아왔으면 누가 돌아왔는지
			if(nDay==eda) { // 탐험간 사람이 돌아올 날짜
				if(backHomeM==true) {  // 엄마가 탐험나갔다가 돌아옴
					if(mother.condition==3) {  // 사망 상태
						lblComeBack.setText("엄마는 탐험 도중 사망하였습니다.");
						lblComeBack.setVisible(true);
					} 
					else {
						lblComeBack.setText("엄마가 탐험에서 돌아왔습니다.");
						backHomeM=false; // 다시 초기화
						lblComeBack.setVisible(true);
						}
				} else if(backHomeF==true) { // 아빠가 탐험나갔다가 돌아옴
					if(father.condition==3) {  // 사망 상태
						lblComeBack.setText("아빠는 탐험 도중 사망하였습니다.");
						lblComeBack.setVisible(true);
					} 
					else {
						lblComeBack.setText("아빠가 탐험에서 돌아왔습니다.");
						backHomeF=false; // 다시 초기화
						lblComeBack.setVisible(true);
						}
				} else if(backHomeS==true) { // 아들이 탐험나갔다가 돌아옴
					if(son.condition==3) {  // 사망 상태
						lblComeBack.setText("아들은 탐험 도중 사망하였습니다.");
						lblComeBack.setVisible(true);
					} 
					else {
						lblComeBack.setText("아들이 탐험에서 돌아왔습니다.");
						backHomeS=false; // 다시 초기화
						lblComeBack.setVisible(true);
						}
				} else if(backHomeD==true) { // 딸이 탐험나갔다가 돌아옴
					if(daughter.condition==3) {  // 사망 상태
						lblComeBack.setText("딸은 탐험 도중 사망하였습니다.");
						lblComeBack.setVisible(true);
					} 
					else {
						lblComeBack.setText("딸이 탐험에서 돌아왔습니다.");
						backHomeD=false; // 다시 초기화
						lblComeBack.setVisible(true);
						}
				}
		
			} // end first if 탐험간 사람이 돌아온 날짜
			
			
			// 아이템 무엇을 얻었는지
			if(nDay==eda) {  // 탐험에서 돌아올 날짜
				if(ranRadio==1) { gotRadio="라디오를 하나 가져왔습니다.\n";}
				else if(ranRadio!=1) { gotRadio ="";}
				if(ranBullet==1) { gotBullet="총알을 하나 가져왔습니다.\n";}
				else if(ranBullet!=1) { gotBullet=""; }
				if(ranGun==1) { gotGun="총을 하나 가져왔습니다.\n";}
				else if(ranGun!=1) { gotGun=""; }
				if(ranChessboard==1) { gotChessboard="체스판을 하나 가져왔습니다.\n ";}
				else if(ranChessboard!=1) { gotChessboard="";}
				if(ranBook==1) { gotBook="책을 하나 가져왔습니다.\n";}
				else if(ranBook!=1) { gotBook="";}
				if(ranFlashlight==1) { gotFlashlight="손전등을 하나 가져왔습니다.\n";}
				else if(ranFlashlight!=1) {gotFlashlight="";}
				if(ranPesticide==1) { gotPesticide="살충제를 하나 가져왔습니다.\n";}
				else if(ranPesticide!=1) { gotPesticide="";}
				if(ranMap==1) { gotMap="지도를 하나 가져왔습니다.\n";}
				else if(ranMap!=1) { gotMap="";}
				if(ranGasmask==1) { gotGasmask="방독면을 하나 가져왔습니다.\n";}
				else if(ranGasmask!=1) { gotGasmask="";}
				if(ranAxe==1) { gotAxe="도끼를 하나 가져왔습니다.\n";}
				else if(ranAxe!=1) { gotAxe="";}
				if(ranAidkit==1) {gotAidkit="구급상자를 하나 가져왔습니다.\n";}
				else if(ranAidkit!=1) { gotAidkit="";}
				if(ranCard==1) { gotCard="카드를 하나 가져왔습니다.\n";}
				else if(ranCard!=1) { gotCard="";}
				if(ranWater==0) { gotWater="";}
				if(ranWater==1) { gotWater="물을 한 개 가져왔습니다.\n";}
				if(ranWater==2) { gotWater="물을 두 개 가져왔습니다.\n";}
				if(ranWater==3) { gotWater="물을 세 개 가져왔습니다.\n";}
				if(ranWater==4) { gotWater="물을 네 개 가져왔습니다.\n";}
				if(ranWater==5) { gotWater="물을 다섯 개 가져왔습니다.\n";}
				if(ranWater==6) { gotWater="물을 여섯 개 가져왔습니다.\n";}
				if(ranFood==0) { gotFood="";}
				if(ranFood==1) { gotFood="식량을 한 개 가져왔습니다.\n";}
				if(ranFood==2) { gotFood="식량을 두 개 가져왔습니다.\n";}
				if(ranFood==3) { gotFood="식량을 세 개 가져왔습니다.\n";}
				if(ranFood==4) { gotFood="식량을 네 개 가져왔습니다.\n";}
				if(ranFood==5) { gotFood="식량을 다섯 개 가져왔습니다.\n";}
				if(ranFood==6) { gotFood="식량을 여섯 개 가져왔습니다.\n";}
				
				lblTotalGotItem.setText(""+gotRadio+ gotBullet+ gotGun+ gotChessboard+ gotBook+ gotFlashlight+
						gotPesticide+ gotMap+ gotGasmask+ gotAxe+ gotAidkit+gotCard+ gotWater+ gotFood);
				lblTotalGotItem.setVisible(true);
			}
		
		
	} // Diary1()
	
}
