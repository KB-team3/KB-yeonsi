package view;

import java.util.List;

import dto.AcademyEventDTO;


public class SuccessView {
	public static void printSelectAcademyEventAll(List<AcademyEventDTO> list) {
		System.out.println("----AcademyEvent LIST ("+list.size()+") 개 ------------------");
		for(AcademyEventDTO dto : list) {
			System.out.println(dto);//board.toString()호출
		}
		
	}
	
	public static void messagePrint(String message) {
		System.out.println(message);
		
	}
	public static void rankingPrint(List<LikeDTO> list) {
		for(LikeDTO dto : list)
			System.out.println(dto);
	
	}
	
	public static void goodEnding(String charName) {
			System.out.println(charName + "님과 매칭되었습니다.");
		
	}
	public static void badEnding() {
		System.out.println("배드엔딩");
	}
}
