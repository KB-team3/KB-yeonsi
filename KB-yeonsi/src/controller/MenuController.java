package controller;

import java.util.List;

import dto.LikeDTO;
import exception.SearchWrongException;
import service.MenuService;
import service.MenuServiceImpl;
import view.FailView;
import view.SuccessView;

public class MenuController {

	private static MenuService menuService = MenuServiceImpl.getInstance();

	/**
	 * @author 이채림
	 * 번호에 해당하는 캐릭터의 호감도 랭킹 조회하기
	 * 조회한 결과 list가 비어있지 않으면 list와 그 때의 사용자 이름을 인수로 보낸다.
	 * 
	 * @param : 조회한 list, 캐릭터이름
	 * 
	 * */
	public static void viewRanking(int charNum) {
		try {
			List<LikeDTO> list = menuService.viewRanking(charNum);

			SuccessView.rankingPrint(list, charNum);

		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}

	}

}
