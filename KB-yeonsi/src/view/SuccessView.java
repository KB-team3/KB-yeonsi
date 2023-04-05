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
}
