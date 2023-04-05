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

	public static void viewRanking(int charNum) {
		try {
			List<LikeDTO> list = menuService.viewRanking(charNum);

			SuccessView.rankingPrint(list, charNum);

		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}

	}

}
