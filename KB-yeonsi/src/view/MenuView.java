package mvc.view;

import java.util.Scanner;

import mvc.controller.MenuController;


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
		System.out.println("확인하고 싶은 유저의 이름을 입력하세요.");
		String charName = sc.nextLine();
		MenuController.viewRanking(charName);
		
	}
	
	public static void viewIntroduction() {
		//successview.messageprint
	}
	
	
}
