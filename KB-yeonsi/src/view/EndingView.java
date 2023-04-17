package view;

import java.util.Scanner;

import controller.EndingController;
import controller.MenuController;

/**
 * 모든 게임이 끝나면 매칭 결과와 전체 호감도를 출력한다.
 * @author 이채림
 *
 */
public class EndingView {
	static Scanner sc =new Scanner(System.in);

	
	public EndingView() {}
	
	public static void checkEnding( ) {
		
		EndingController.checkEnding(MainApp.userName);
	}

}
