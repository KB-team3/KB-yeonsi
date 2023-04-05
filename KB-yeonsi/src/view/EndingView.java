package view;

import java.util.Scanner;

import controller.EndingController;
import controller.MenuController;

public class EndingView {
	static Scanner sc =new Scanner(System.in);

	
	public EndingView() {}
	
	public static void checkEnding( ) {
		System.out.println("엔딩을 확인할 유저의 이름을 입력하세요.");
		String userName = sc.nextLine();
		EndingController.checkEnding(userName);
	}
	
	public static void viewResult() {
		System.out.println("호감도를 확인할 유저의 이름을 입력하세요.");
		String userName = sc.nextLine();
		MenuController.viewRanking(userName); //전체 호감도 보여주고 끝
	}

}
