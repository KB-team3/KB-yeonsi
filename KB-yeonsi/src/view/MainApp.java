package view;

import java.util.Scanner;

import controller.GameController;

public class MainApp {
	static String userName = "";
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		// MenuView.menuChoice();
		// EndingView.checkEnding();
		// EndingView.viewResult();
		
		System.out.println("KB아카데미에 오신걸 환영합니다 (●'◡'●')");
		System.out.println("두근두근 당신의 짝꿍을 찾아볼까요?!");
		System.out.println("당신의 이름을 입력해주세요!");
		
		userName = sc.nextLine();
		
		
	
		// ~~ 유저 인서트 ~~
		
		GameController.userInsert(MainApp.userName);
		GameController.likeAbilityInsert(userName);
		System.out.println("안녕하세요, " + userName + "!");
		
		// ~~ 유저 입력한 후
		MenuView.menuChoice();
		
	}

}
