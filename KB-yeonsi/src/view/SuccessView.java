package view;

import java.util.List;

import dto.AcademyEventDTO;
import dto.LikeDTO;
import dto.TalkEventDTO;


public class SuccessView {
	static int cnt = 1;
	
	public static void printSelectAcademyEventAll(List<AcademyEventDTO> list) {
		System.out.println("----AcademyEvent LIST ("+list.size()+") 개 ------------------");
		for(AcademyEventDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	public static void printSelectTalkEventAll(List<TalkEventDTO> list) {
		System.out.println("----TalkEvent LIST ("+list.size()+") 개 ------------------");
		for(TalkEventDTO dto : list) {
			System.out.println(dto);
		}
	}
	
	public static void messagePrint(String message) {
		System.out.println(message);
		
	}
	public static void rankingPrint(List<LikeDTO> list, int charNum) {
		System.out.println(list.size());

		switch (charNum) {
		case 1:
			System.out.println("우엽이의 랭킹을 출력합니다.");
			for (LikeDTO dto : list) {
				System.out.print((cnt++) + "위 |  ");
				System.out.print(dto.getUserName() + "님에 대한 호감도는 ");
				System.out.println(dto.getWooyeop());
			}
			break;

		case 2:
			System.out.println("상우의 랭킹을 출력합니다.");
			for (LikeDTO dto : list) {
				System.out.print((cnt++) + "위 |  ");
				System.out.print(dto.getUserName() + "님에 대한 호감도는 ");
				System.out.println(dto.getSangwoo());
			}
			break;
		case 3:
			System.out.println("선영이의 랭킹을 출력합니다.");
			for (LikeDTO dto : list) {
				System.out.print((cnt++) + "위 |  ");
				System.out.print(dto.getUserName() + "님에 대한 호감도는 ");
				System.out.println(dto.getSunyeong());
			}
			break;
		case 4:
			System.out.println("민지의 랭킹을 출력합니다.");
			for (LikeDTO dto : list) {
				System.out.print((cnt++) + "위 |  ");
				System.out.print(dto.getUserName() + "님에 대한 호감도는 ");
				System.out.println(dto.getMinji());
			}
			break;
		case 5:
			System.out.println("채림이의 랭킹을 출력합니다.");
			for (LikeDTO dto : list) {
				System.out.print((cnt++) + "위 |  ");
				System.out.print(dto.getUserName() + "님에 대한 호감도는 ");
				System.out.println(dto.getChaelim());
			}
			break;

		}

	}
	
	public static void goodEnding(String charName) {
		System.out.println(charName + "님과 매칭되었습니다.");

	}

	public static void badEnding() {
		System.out.println("ㅜㅜ 누구와도 매칭되지 않았어요.");
	}
}
