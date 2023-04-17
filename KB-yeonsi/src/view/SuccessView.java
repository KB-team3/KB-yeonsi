package view;

import java.util.List;

import dto.AcademyEventDTO;
import dto.LikeDTO;
import dto.TalkEventDTO;
import dto.UserDTO;


public class SuccessView {
	
	/**
	 * @author 길민지
	 * 조회된 전체 AcademyEvent 리스트를 출력한다.
	 * @param list : 출력할 AcademyEvent 리스트
	 */
	public static void printSelectAcademyEventAll(List<AcademyEventDTO> list) {
		System.out.println("----AcademyEvent LIST ("+list.size()+") 개 ------------------");
		for(AcademyEventDTO dto : list) {
			System.out.println(dto);
		}
	}
	/**
	 * @author 길민지
	 * 조회된 전체 TalkEvent 리스트를 출력한다.
	 * @param list : 출력할 TalkEvent 리스트
	 */
	public static void printSelectTalkEventAll(List<TalkEventDTO> list) {
		System.out.println("----TalkEvent LIST ("+list.size()+") 개 ------------------");
		for(TalkEventDTO dto : list) {
			System.out.println(dto);
		}
	}
	/**
	 * 메세지를 출력한다.
	 * @param message : 출력할 메세지
	 */
	public static void messagePrint(String message) {
		System.out.println(message);
	}
	
	/**
	 * @author 윤상우
	 * @param user
	 * 사용자의 정보 탐색에 성공시 정보를 출력한다.
	 */
	public static void infoPrint(UserDTO user) {
		System.out.println(user.getUserName() + "의 정보입니다!");
		System.out.println(user.getUserName() + "의 진행상황 : " + user.getDate() + "일차♡");
		System.out.println(user.getUserName() + "의 호감도♡");
		System.out.println(user.getLikeability());
	}
	/**
	 * @author 이채림
	 * charNum의 번호에 해당하는 캐릭터별로 그 랭킹을 출력한다.
	 * @param 랭킹list, 캐릭터별 번호
	 * 메소드를 돌 때마다 cnt를 초기화해서 조회할 때마다 1위부터 랭킹을 조회한다.
	 * 
	 * */
	public static void rankingPrint(List<LikeDTO> list, int charNum) {
		int cnt = 1;
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
	/**
	 * @author 이채림
	 * 게임이 끝나면 유저의 누적된 캐릭터별 호감도를 출력
	 * @param 유저별 호감도 리스트
	 * 
	 * */
	public static void gameResultPrint(LikeDTO likeDto) {
		System.out.println("\n<최종 호감도>");
		System.out.println("우엽의 호감도는 "+likeDto.getWooyeop()+"입니다.");
		System.out.println("상우의 호감도는 "+likeDto.getSangwoo()+"입니다.");
		System.out.println("선영의 호감도는 "+likeDto.getSunyeong()+"입니다.");
		System.out.println("민지의 호감도는 "+likeDto.getMinji()+"입니다.");
		System.out.println("채림의 호감도는 "+likeDto.getChaelim()+"입니다.");
		
	}
	
	/**
	 * @author 이채림
	 * 게임이 끝나고 해당 유저의 캐릭터별 호감도를 조회하여
	 * 임계값 이상이면 goodEnding
	 * @param 캐릭터 이름
	 * */
	public static void goodEnding(String charName) {
		System.out.println(charName + "님과 매칭되었습니다.");

	}
	/**
	 * @author 이채림
	 * 게임이 끝나고 해당 유저의 캐릭터별 호감도를 조회하여
	 * 임계값 이상이면 badEnding
	 * @param 캐릭터 이름
	 * */
	public static void badEnding() {
		System.out.println("ㅜㅜ 누구와도 매칭되지 않았어요.");
	}
}
