package mvc.controller;

import java.sql.SQLException;
import java.util.List;

import mvc.dto.LikeDTO;
import mvc.service.MenuService;
import mvc.service.MenuServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

public class MenuController {
	
	private static MenuService menuService = MenuServiceImpl.getInstance();
	
	
	public static void viewRanking(String charName) {
	//	try {
		List<LikeDTO> list = menuService.viewRanking(charName);
		SuccessView.rankingPrint(list);
		
//		}catch()) {
//			FailView.errorMessage(e.getmessage());
//		}
//		

	
	}

}
