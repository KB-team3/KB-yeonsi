package view;

import java.util.Scanner;

import controller.EndingController;
import controller.MenuController;

public class EndingView {
	static Scanner sc =new Scanner(System.in);

	
	public EndingView() {}
	
	public static void checkEnding( ) {
		
		EndingController.checkEnding(MainApp.userName);
	}

}
