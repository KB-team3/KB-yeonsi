package view;

import java.util.Scanner;

import controller.MenuController;


public class MenuView {
		static Scanner sc =new Scanner(System.in);
	
	public MenuView() {
		System.out.println("menuView");
	}
	
	public static void menuChoice() {
		viewRanking();
		

	}
	
	public static void gameStart() {}
	
	public static void viewRanking() {
		System.out.println("랭킹을 확인하고 싶은 캐릭터를 입력하세요.");
		System.out.println("1. 우엽 | 2. 상우 | 3. 선영 | 4. 민지 | 5. 채림");
		int charNum = sc.nextInt();
		
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
			System.out.println("선영이는 ()༼ つ ◕_◕ ༽つ와 같은 (심지어 닮음) 귀여운 것들을 좋아한답니다... ^^");
			System.out.println("민지는 카리스마 있고 시크해보이지만 제법 말도 많고 귀엽답니다... ^^");
			System.out.println("채림이는 자주 배가 고프고 먹을 걸 매우 좋아한답니다... ^^");
			
			System.out.println("\n마음에 드는 캐릭터를 공략해서 캐릭터의 호감도를 올려보세요 >.<");
		
		}else if(yn == 2) {
			return;
			
		}else System.out.println("1과 2로만 입력해주세요.");

	}
	
	
}
