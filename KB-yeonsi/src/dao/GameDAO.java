package dao;
import java.util.List;

import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;
import dto.UserDTO;
import exception.DMLException;
import exception.SearchWrongException;

public interface GameDAO {

	/**
	 * 작성자: 이우엽
	 * Academy Event(평일 이벤트) ID로 해당 선택지 모두 가져오기
	 * @param
	 * 선택한 Event ID
	 * @return
	 * 성공하면 선택지 list 객체, 
	 */
	List<AcademyOptionDTO> optionSelectByEventId(int eventId);
	
	/**
	 * 작성자: 이우엽
	 * 랜덤으로 생성된 Academy Event ID에 따른 평일 이벤트 객체 가져오기
	 * @param
	 * 랜덤으로 생성된 Event ID
	 * @return
	 * 성공하면 평일 이벤트 객체 중 1
	 */
	AcademyEventDTO academyEventSelectByRandom(int eventId);
	
	/**
	 * 작성자: 이우엽
	 * 사용자가 고른 선택지에 따른 캐릭터 호감도 업데이트
	 * @param
	 * 사용자가 고른 선택지 객체
	 * @return
	 * 성공하면 1, 실패하면 0
	 */
	int academyUpdate(AcademyOptionDTO dto);
	
	/**
	 * @author 윤상우
	 * 사용자가 선택한 food에 대한 캐릭터 호감도 업데이트 (gift 테이블)
	 * @param
	 * 사용자이름, 선택한 캐릭터, 선택한 foodCode 
	 * @return
	 * 성공하면 1, 실패하면 0
	 * @throws DMLEception
	 * */
	int foodUpdate(String userName, String selectCharacter, int foodCode) throws DMLException;
	
	/**
	 * @param
	 * 사용자이름, 선택한 캐릭터, 선택한 giftCode
	 * @return
	 * 성공하면 1, 실패하면 0
	 * @throws DMLEception
	 * */
	int giftUpdate(String userName, String selectCharacter, int giftCode) throws DMLException;
	
	/**
	 * @author 윤상우
	 * 게임을 시작할 사용자의 정보 레코드 생성 (Users 테이블)
	 * @param 
	 * 사용자이름
	 * @return 
	 * 성공하면 1, 실패하면 0
	 * @throws DMLException
	 */
	int userInsert(String userName) throws DMLException;
	
	/**
	 * @author 윤상우
	 * 게임을 시작할 사용자의 호감도 레코드 생성 (likeability 테이블)
	 * @param
	 * 사용자이름
	 * @return 
	 * 성공하면 1, 실패하면 0
	 * @throws DMLException
	 */
	int likeAbilityInsert(String userName) throws DMLException;
	
	/**
	 * @author 윤상우
	 * 게임 사용자의 정보를 받아옴 (Users 테이블, likeability 테이블)
	 * @param 
	 * 사용자이름
	 * @return 
	 * userName인 userDTO 객체
	 * @throws SearchWrongException
	 */
	UserDTO userGet(String userName) throws SearchWrongException;
	
}
