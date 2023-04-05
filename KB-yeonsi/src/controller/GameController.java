package controller;

import java.util.List;
import exception.DMLException;
import exception.SearchWrongException;
import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;
import service.GameService;
import service.GameServiceImpl;
import service.SystemService;
import service.SystemServiceImpl;

public class GameController {
	private static GameService gameService = GameServiceImpl.getInstance();
	
	public static List<AcademyOptionDTO> optionSelectByEventId(int eventId) {
		List<AcademyOptionDTO> list = null;
		try {
		  list = service.optionSelectByEventId(eventId);
		  
		  for(int i = 0; i < list.size(); i++) {
			  System.out.print(i+1 + ". ");
			  System.out.println(list.get(i));
		  }
		  
		} finally {
			
		}	
		return list;
	}
	
	public static void academyEventSelectByRandom() {
		SystemService s = SystemServiceImpl.getInstance();
		int size = s.selectAcademyEventAll().size();
		int ran = (int)(Math.random() * size) + 1;
		List<AcademyOptionDTO> list = null;
		try {
			AcademyEventDTO dto = service.academyEventSelectByRandom(ran);
			System.out.println(dto);
			list = optionSelectByEventId(ran);
		} catch(SearchWrongException e) {
			System.out.println("실패");
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("******고르세요*********");
		int select = Integer.parseInt(scanner.nextLine());
		System.out.println(list.get(select-1).getResultScript());
		service.academyUpdate(list.get(select-1));
//		AcademyOptionDTO selectedDto = service.optionSelectByOptionId
	}


	public static void foodUpdate(String userName, String selectCharacter, int foodCode) {
		try {
			GameService service = new GameServiceImpl();
			service.foodUpdate(userName, selectCharacter, foodCode);
			System.out.println("성공");
		}catch(DMLException e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}
	
	public static void giftUpdate(String userName, String selectCharacter, int giftNum) {
        try {
    		GameService service = new GameServiceImpl();
    		service.giftUpdate(userName, selectCharacter, giftNum);
            System.out.println("선물로 당신의 마음 전송 성공! ><♡");
        } catch (DMLException e) {
        	System.out.println("실패");
        }
    }
}
