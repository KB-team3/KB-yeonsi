package view;

import controller.GameController;
import java.util.Scanner;
import controller.MenuController;
import controller.SystemController;

public class GameView {
	
	static int date = 1;
	static Scanner sc =new Scanner(System.in);
	
	public GameView() {
		menuChoice();
	}
	
	/**
	 * @author 신선영+a
	 * 일주일간의 이벤트 관리 (평일과 주말 이벤트 구분하여 발생)
	 */
	public static void menuChoice() {
		while (date < 8) {
			// 평일
			if (date < 6) {
				System.out.println("아카데미에서의 " + date + "일차 하루가 시작되었습니다!\n");
				GameController.academyEventSelectByRandom();
				date++;
				
			}
			
			// 주말
			else if (date < 8) {
				System.out.println(date + "일차 하루가 시작되었습니다!\n");
				if(date == 6) {
                    System.out.println("즐거운 토요일입니다!");
                } else {
                    System.out.println("오늘은 마지막 날이다!");
                    System.out.println("특별한 추억을 만들고 싶다.. 마지막이니 신중히 선택하자");
                }
				System.out.println("뭘 할지 선택해볼까요? (⌐■_■)	");
				System.out.println("1. 선물 주기");
				System.out.println("2. 맛집 가기");
				
				try {
					int menu = Integer.parseInt(sc.nextLine());
					switch (menu) {
						case 1:	// 선물주기
							inputGiftUpdate();
							date++;
							break;
							
						case 2:	// 맛집가기
							inputFoodUpdate();
							date++;
							break;
					}
				} catch (NumberFormatException e) {
					System.out.println("숫자로만 선택하세요.");
				}
			}
	} 
		EndingView.checkEnding();
		System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⡴⠒⠚⣻⠇⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠓⠒⠒⠒⠒⢤⣤⠴⠚⠉⠀⡸⠁⣠⠞⠁⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⣠⠖⠋⠀⠀⠀⠀⢀⡧⠞⠣⠤⣀⡀⠀⠀⠀⠀\r\n"
				+ "⢀⣤⠔⠒⠚⣏⠉⠉⠉⠉⠉⠉⠉⠒⠒⠲⠤⠒⠋⠉⠉⠉⠉⠉⠒⠒⠻⢴⠋⠀⠀⠀⠀⠀⣠⠔⠋⠀⠀⠀⠀⠀⠉⠑⠲⢤⡀\r\n"
				+ "⠈⠙⠒⠤⢄⣘⣦⡀⠀⠀⠀⠀⠀⠀⡔⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⠤⠖⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠈⢉⣿⣗⡒⠒⠒⡾⠁⣠⣶⠒⡆⠀⠀⠀⠀⠀⠀⠀⣀⣄⡀⠀⢳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠞⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⢠⡎⠀⠀⠙⢦⣀⠇⠀⠻⣼⡿⠁⠀⠀⢠⡄⠀⠀⠸⣷⣼⣷⠀⢸⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠋⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠈⣏⠀⠀⠀⠀⡿⠖⠲⣄⠀⠀⣤⡀⢀⣤⣀⠀⠀⢀⠈⠋⠁⠀⢸⣿⡉⠓⠦⣀⡀⠀⠀⠀⠀⢀⡴⠁⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⢹⡀⠀⠀⠀⡇⠀⠀⣸⠀⠀⢸⣯⠟⠛⠛⢿⣿⠋⠀⢰⠟⠉⠹⡇⢷⠀⠀⠀⠉⠓⠦⣄⣠⠎⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⠹⡦⠴⠋⠀⠀⠀⢹⡄⠀⢀⡼⠁⠀⠀⣇⠀⠀⢠⡇⣀⣧⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠸⡄⠀⠀⠀⠙⢆⠀⠀⠀⠀⠀⠹⠤⠋⠀⠀⠀⠀⠈⠓⡶⠋⠙⠳⠤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡄⠀⠀⠀⠀⠑⠶⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⠖⠋⠀⠀⠀⠀⠀⠀⠉⠲⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣶⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡀⠀⠀⠀⠀⠀⠀⢀⣷⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⠤⣤⠤⠴⠒⠒⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢧⡰⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⡆⢀⣠⠤⠒⠒⠒⠂⠀⠀⠐⠒⠒⠒⠒⠲⢦⡀⠀⠳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⣿⡟⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠑⠒⠾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		System.out.println("끝!!!");
		System.exit(0);
	}
	
	/**
	 * @author 신선영
	 * 주말 이벤트 - 선물 주기 발생 시 선물을 줄 대상과 선물을 선택하여 연결
	 */
	public static void inputGiftUpdate() {
		try {
			System.out.println("누구에게 선물을 주고싶나요? (•ө•)♡");
			System.out.println("1. 우엽 2. 상우 3. 선영 4.민지 5. 채림 (번호로 입력해주세요!)");
			int targetNo = Integer.parseInt(sc.nextLine());
			System.out.println("무엇을 주고 싶나요? ʕ•ﻌ•ʔ ♡" );
			System.out.println("1. 향수 2. 티비 3. 신발 4. 케이크 (번호로 입력해주세요!)");
			int giftNo = Integer.parseInt(sc.nextLine());
			
			String[] names = new String[] {"xo", "wooyeop", "sangwoo", "sunyeong", "minji", "chaelim"};
			String target = names[targetNo];
			
			GameController.giftUpdate(MainApp.userName, target, giftNo);
			
		} catch (NumberFormatException var2) {
            System.out.println("글번호는 숫자만 입력해주세요.");

        }
	}
	
	/**
	 * @author 신선영
	 * 주말 이벤트 - 맛집 가기 발생 시 함께 갈 대상과 메뉴를 선택하여 연결
	 */
	public static void inputFoodUpdate() {
		try {
			System.out.println("누구와 맛집을 가고싶나요? (•ө•)♡");
			System.out.println("1. 우엽 2. 상우 3. 선영 4.민지 5. 채림 (번호로 입력해주세요!)");
			int targetNo = Integer.parseInt(sc.nextLine());
			System.out.println("무엇을 먹고 싶나요? ʕ•ﻌ•ʔ ♡ ");
			System.out.println("1. 떡볶이 2. 피자 3. 카레 4.치킨 (번호로 입력해주세요!)");
			int foodNo = Integer.parseInt(sc.nextLine());
			
			String[] names = new String[] {"xo", "wooyeop", "sangwoo", "sunyeong", "minji", "chaelim"};
			String target = names[targetNo];
			
			GameController.foodUpdate(MainApp.userName, target, foodNo);
			
		} catch (NumberFormatException var2) {
            System.out.println("글번호는 숫자만 입력해주세요.");

        }
	}
	
	
}

