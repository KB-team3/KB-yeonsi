package controller;

import java.util.List;
import java.util.Scanner;

import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;
import dto.UserDTO;
import exception.DMLException;
import exception.SearchWrongException;
import service.GameService;
import service.GameServiceImpl;
import service.SystemService;
import service.SystemServiceImpl;
import view.FailView;
import view.SuccessView;

public class GameController {
	private static GameService gameService = GameServiceImpl.getInstance();
	private static boolean[] isSelected  = new boolean[6]; ;
	
	/**
	 * 작성자: 이우엽
	 * Academy Event(평일 이벤트) ID로 해당 선택지 모두 가져오기
	 */
	public static List<AcademyOptionDTO> optionSelectByEventId(int eventId) {
		List<AcademyOptionDTO> list = null;
		try {
		  list = gameService.optionSelectByEventId(eventId);
		  
		  for(int i = 0; i < list.size(); i++) {
			  System.out.print(i+1 + ". ");
			  System.out.println(list.get(i));
		  }
		  
		} finally {
			
		}	
		return list;
	}
	
	public static boolean checkValid(int eventId) {
        if(isSelected[eventId]) return false;
        isSelected[eventId] = true;
        return true;
    }
	
	/**
	 * 작성자: 이우엽
	 * 랜덤으로 생성된 Academy Event ID에 따른 평일 이벤트 객체 가져오기
	 * 사용자에게 입력받은 선택지 번호에 따른 응답과 호감도 업데이트
	 */
	public static void academyEventSelectByRandom() {
		SystemService s = SystemServiceImpl.getInstance();
		int size = s.selectAcademyEventAll().size();

        int ran = (int)(Math.random() * size) + 1;
        while(!checkValid(ran)) {
            ran = (int)(Math.random() * size) + 1;
        }
		
		List<AcademyOptionDTO> list = null;
		try {
			// 이벤트 중 하나 불러오기
			AcademyEventDTO dto = gameService.academyEventSelectByRandom(ran);
			// 질문 출력
			System.out.println(dto);
			list = optionSelectByEventId(ran);
		} catch(SearchWrongException e) {
			System.out.println("실패");
		}
		
		// 선택지 입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("당신의 선택은? ");
		int select = Integer.parseInt(scanner.nextLine());
		
		// 대답 출력
		System.out.println(list.get(select-1).getResultScript()+"\n");
		gameService.academyUpdate(list.get(select-1));
	}

	/**
	 * @author 윤상우
	 * 사용자가 선택한 food에 대한 캐릭터 호감도 업데이트 (food 테이블)
	 * 모든 과정이 성공하면 successView, 실패하면 failView 출력
	 * @param userName
	 * @param selectCharacter
	 * @param foodCode
	 */
	public static void foodUpdate(String userName, String selectCharacter, int foodCode) {
		try {
			gameService.foodUpdate(userName, selectCharacter, foodCode);
			SuccessView.messagePrint("맛있는 음식을 대접하니 기분이 좋아! ><♡");
		}catch(DMLException e) {
			FailView.errorMessage("실패 ㅠㅠ");
		}
	}
<<<<<<< HEAD
=======
	
>>>>>>> 9a7b2f635fc32b912057121f35ca6baaa7c3773a
	/**
	 * @author 신선영
	 * 사용자가 선택한 선물에 해당하는 캐릭터 호감도 업데이트 (gift 테이블)
	 * 모든 과정이 성공하면 successView, 실패하면 failView에 메시지 출력 출력
	 * @param userName
	 * @param selectCharacter
	 * @param giftNum
	 */
	public static void giftUpdate(String userName, String selectCharacter, int giftNum) {
        try {
    		gameService.giftUpdate(userName, selectCharacter, giftNum);
    		SuccessView.messagePrint("선물로 당신의 마음 전송 성공! ><♡");
        } catch (DMLException e) {
        	FailView.errorMessage("실패 ㅠㅠ");
        }
    }
	
	/**
	 * @author 윤상우
	 * 게임을 시작할 사용자의 정보 레코드 생성 (Users 테이블)
	 * 모든 과정이 성공하면 successView, 실패하면 failView 출력
	 * @param userName
	 */
	public static void userInsert(String userName) {
        try {
            gameService.userInsert(userName);
            SuccessView.messagePrint(userName + "(코린이): 드디어 내가 IT's Your Life에 입과하다니!!");
        } catch (DMLException e) {
        	FailView.errorMessage("실패 ㅠㅠ");
        }
    }

	/**
	 * @author 윤상우
	 * 게임을 시작할 사용자의 호감도 레코드 생성 (likeability 테이블)
	 * 모든 과정이 성공하면 successView, 실패하면 failView 출력
	 * @param userName
	 */
    public static void likeAbilityInsert(String userName) {
        try {
            gameService.likeAbilityInsert(userName);
            //SuccessView.messagePrint("호감도 설정이 성공하였습니다.");
        } catch (DMLException e) {
        	FailView.errorMessage("실패 ㅠㅠ");
        }
    }

    /**
     * @author 윤상우
	 * 게임 사용자의 정보를 받아옴 (Users 테이블, likeability 테이블)
	 * 모든 과정이 성공하면 successView, 실패하면 failView 출력
     * @param userName
     */
    public static void userGet(String userName) {
		try {
			UserDTO user = gameService.userGet(userName);
			SuccessView.infoPrint(user);
		} catch (SearchWrongException e) {
        	FailView.errorMessage("실패 ㅠㅠ");
		}
	}


}
