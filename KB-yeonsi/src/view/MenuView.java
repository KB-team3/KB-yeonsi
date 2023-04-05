package view;

import java.util.Scanner;

import controller.MenuController;
import exception.RangeWrongException;


public class MenuView {
	static Scanner sc =new Scanner(System.in);
	static int date = 1;
	
	public MenuView() {
		System.out.println("menuView");
	}
	
	public static void menuChoice() {
		while (date < 7) {
			// 평일
			if (date < 5) {
				System.out.println("아카데미에서의 " + date + "일차 하루가 시작되었습니다!");
				date++;
				
			}
			
			// 주말
			else if (date < 7) {
				System.out.println(date);
				System.out.println("오늘은 주말입니다!");
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
	} // while 끝
		System.out.println("끝!!");
		System.exit(0);
	}
	
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
	
	public static void gameStart() {}
	
	public static void viewRanking() {
		System.out.println("랭킹을 확인하고 싶은 캐릭터를 입력하세요.");
		System.out.println("1. 우엽 | 2. 상우 | 3. 선영 | 4. 민지 | 5. 채림");
		int charNum = sc.nextInt();
		
		try {
		if(charNum <1 || charNum >5) 
			throw new RangeWrongException("1부터 5사이의 숫자를 입력해주세요.");
		}
		catch(RangeWrongException e)
		{
			e.printStackTrace();
			viewRanking();
		}
		
		MenuController.viewRanking(charNum);
		
	}
	
	public static void viewIntroduction() {
		System.out.println("야~~ 호~~~~");
		System.out.println("평일에는 아카데미에 출근해서 캐릭터들과 친분을 쌓고 ");
		System.out.println("주말에는 원하는 캐릭터를 골라 신나는 하루를 즐겨보세요!");
		
		System.out.println("\n캐릭터들의 정보가 궁금하신가요?");
		System.out.println("1 : yes | 2 : no");
		int yn = sc.nextInt();
		if(yn == 1) {
			System.out.println("우엽이는 캔디를 좋아하구요 ...누구와도 금방 친해질 수 있는 친화력 '갑'이랍니다 ... ^^");
			System.out.println("상우는 키가 매우 크고요... 밥을 엄청엄청 빨리 먹는답니다... ^^");
			System.out.println("선영이는 ༼ つ ◕_◕ ༽つ와 같은 (심지어 닮음) 귀여운 것들을 좋아한답니다... ^^");
			System.out.println("민지는 카리스마 있고 시크해보이지만 제법 말도 많고 귀엽답니다... ^^");
			System.out.println("채림이는 자주 배가 고프고 먹을 걸 매우 좋아한답니다... ^^");
			
			System.out.println("\n마음에 드는 캐릭터를 공략해서 캐릭터의 호감도를 올려보세요 >.<");
		
		}else if(yn == 2) {
			return;
			
		}else System.out.println("1과 2로만 입력해주세요.");

	}
	
	
}
