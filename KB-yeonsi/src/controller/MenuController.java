package mvc.controller;

import java.util.List;

import mvc.dto.LikeDTO;
import mvc.exception.SearchWrongException;
import mvc.service.MenuService;
import mvc.service.MenuServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

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
