package view;

import java.util.Scanner;

import controller.GameController;

public class MainApp {
	public static String userName = "";
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("KB아카데미에 오신걸 환영합니다 (●'◡'●')");
		System.out.println("두근두근 당신의 짝꿍을 찾아볼까요?!");
		System.out.println("당신의 이름을 입력해주세요!");
		
		// 유저 이름 입력 받음
		userName = sc.next();
		
		if (userName.equals("system")) new SystemView();
	
		// 유저 이름 입력 받은 후 DB에 user, 연관된 likeability insert
		
		GameController.userInsert(MainApp.userName);
		GameController.likeAbilityInsert(userName);
		System.out.println("안녕하세요, " + userName + "!");
		
		// 유저 입력한 후 menuView로 이동
		new MenuView();
		
	}

}
