package view;

import java.util.Scanner;

import controller.GameController;
import controller.MenuController;
import exception.RangeWrongException;


public class MenuView {
	
	public MenuView() {
		gameStart();
	}
	
	static Scanner sc =new Scanner(System.in);
	
	/**
	 * @author 윤상우
	 * 게임 시작시 메뉴를 출력하는 메소드
	 */
	public void gameStart() {
		while(true) {
			System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------");
	       	System.out.print("1. 게임 시작 ");
	       	System.out.print("2. 3조 공략집 ");
        	System.out.print("3. 유저 정보 보기 ");
        	System.out.print("4. 랭킹 보기 ");
        	System.out.print("5. 종료 ");

            System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("선택메뉴는?");
            try {
	              int menu = Integer.parseInt(sc.next());//
	              switch (menu) {
				  case 1: // 7일간의 게임 시작
						GameView.menuChoice();
						break;
	               case 2: // 공략 정보 제공
	            	    viewIntroduction();
	            	    break;
	               case 3: // 유저 정보 제공
	            	    viewUserInfo();
	    				break;
	               case 4: // 랭킹 보기
	            	    viewRanking();
	    				break;
	               case 5: // 종료하기
	            	  System.out.println("종료합니다.");
	    			  System.exit(0);	
	    			break;
				default:
					System.out.println("잘못되었습니다. 다시 입력해주세요.");
				}
	        	 
             }catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
        }//while문
	}
	
	/**
	 * @author 이채림
	 * 4 입력 시 선택한 캐릭터의 현재까지의 랭킹을 출력한다.
	 * 입력값이 선택지의 범위를 넘을 경우 사용자 예외를 발생시킨다.
	 * */
	public static void viewRanking() {
		try {
			System.out.println("랭킹을 확인하고 싶은 캐릭터를 입력하세요.");
			System.out.println("1. 우엽 | 2. 상우 | 3. 선영 | 4. 민지 | 5. 채림");
			int charNum = sc.nextInt();
			
			if (charNum < 1 || charNum > 5)
				throw new RangeWrongException("1부터 5사이의 숫자를 입력해주세요.");
			
			MenuController.viewRanking(charNum);
			
		} catch (RangeWrongException e) {
			//e.printStackTrace();
			System.out.println("1부터 5사이의 숫자를 입력해주세요.");
			viewRanking();
		}

	}
	/**
	 * @author 이채림
	 * 2 입력 시 게임 소개 및 캐릭터 정보 소개
	 * 
	 * */
	public static void viewIntroduction() {
        System.out.println("게임 소개 !! 두둥.. !\n");
        System.out.println("평일에는 아카데미에 출근해서 캐릭터들과 친분을 쌓고 ");
        System.out.println("주말에는 원하는 캐릭터를 골라 신나는 하루를 즐겨보세요!");

	    System.out.println("\n캐릭터 공략법 !!\\n");
	
	    System.out.println("우엽이는 캔디를 좋아하구요 ...누구와도 금방 친해질 수 있는 친화력 '갑'이랍니다 ... ^^");
	    System.out.println("상우는 키가 매우 크고요... 밥을 엄청엄청 빨리 먹는답니다... ^^");
	    System.out.println("선영이는 ()༼ つ ◕_◕ ༽つ와 같은 (심지어 닮음) 귀여운 것들을 좋아한답니다... ^^");
	    System.out.println("민지는 카리스마 있고 시크해보이지만 제법 말도 많고 귀엽답니다... ^^");
	    System.out.println("채림이는 자주 배가 고프고 먹을 걸 매우 좋아한답니다... ^^");
	
	    System.out.println("\n마음에 드는 캐릭터를 공략해서 캐릭터의 호감도를 올려보세요 >.<");
	}
	
	/**
	 * @author 윤상우
	 * 3 입력시 user의 정보를 보여주는 메소드
	 */
	public void viewUserInfo() {
		System.out.println("유저 이름을 입력해주세요!");
		String userName = sc.next();
		GameController.userGet(userName);
	}
	
	
}
