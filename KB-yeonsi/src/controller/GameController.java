package controller;

import java.util.List;

import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;
import exception.DMLException;
import exception.SearchWrongException;
import service.GameService;
import service.GameServiceImpl;
import service.SystemService;
import service.SystemServiceImpl;

public class GameController {
	private static GameService service = GameServiceImpl.getInstance();
	
	public static void optionSelectByEventId(int eventId) {
		try {
		  List<AcademyOptionDTO> list = service.optionSelectByEventId(eventId);
		  
		  for(int i = 0; i < list.size(); i++) {
			  System.out.println(list.get(i));
		  }
		  
		} finally {
			
		}	
	}
	
	public static void academyEventSelectByRandom() {
		SystemService s = SystemServiceImpl.getInstance();
		int size = s.selectAcademyEventAll().size();
		int ran = (int)(Math.random() * size) + 1;
		try {
			AcademyEventDTO dto = service.academyEventSelectByRandom(ran);
			System.out.println(dto);
		} catch(SearchWrongException e) {
			System.out.println("실패");
		}
	}


	public static void foodUpdate(String userName, String selectCharacter, int foodCode) {
		try {
//			GameService service = new GameServiceImpl();
			service.foodUpdate(userName, selectCharacter, foodCode);
			System.out.println("성공");
		}catch(DMLException e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}
	
	public static void giftUpdate(String userName, String selectCharacter, int giftNum) {
        try {
//    		GameService service = new GameServiceImpl();
    		service.giftUpdate(userName, selectCharacter, giftNum);
            System.out.println("선물로 당신의 마음 전송 성공! ><♡");
        } catch (DMLException e) {
        	System.out.println("실패");
        }
    }
}
