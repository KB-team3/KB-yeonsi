package controller;

import java.util.List;

import dto.AcademyOptionDTO;
import service.GameService;
import service.GameServiceImpl;

public class GameController {
	private static GameService gameService = GameServiceImpl.getInstance();
	
	public static void optionSelectByEventId(int eventId) {
		try {
		  List<AcademyOptionDTO> list = gameService.optionSelectByEventId(eventId);
		  
		  for(int i = 0; i < list.size(); i++) {
			  System.out.println(list.get(i));
		  }
		  
		} finally {
			
		}	
	}
}
