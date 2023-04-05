package test;

import java.util.Scanner;

import controller.GameController;

public class TestMainApp {

	public static void main(String[] args) {
		System.out.println("***프로그램 시작합니다.***************");
		Scanner scanner = new Scanner(System.in);
		int evId = Integer.parseInt(scanner.nextLine());
		GameController.optionSelectByEventId(evId);
	}

}
