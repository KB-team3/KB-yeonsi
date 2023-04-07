package service;

import java.util.List;

import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;
import dto.UserDTO;
import exception.DMLException;
import exception.SearchWrongException;

public interface GameService {
	/**
	 * 작성자: 이우엽
	 * Academy Event(평일 이벤트) ID로 해당 선택지 모두 가져오기
	 */
	List<AcademyOptionDTO> optionSelectByEventId(int eventId);
	
	/**
	 * 작성자: 이우엽
	 * 랜덤으로 생성된 Academy Event ID에 따른 평일 이벤트 객체 가져오기
	 */
	AcademyEventDTO academyEventSelectByRandom(int eventId);
	
	/**
	 * 작성자: 이우엽
	 * 사용자가 고른 선택지에 따른 캐릭터 호감도 업데이트
	 */
	int academyUpdate(AcademyOptionDTO dto);
	/**
	 * @author 윤상우
	 * 사용자가 선택한 food에 대한 캐릭터 호감도 업데이트 (food 테이블)
	 * @param userName
	 * @param selectCharacter
	 * @param foodCode
	 * @throws DMLException
	 */
	void foodUpdate(String userName, String selectCharacter, int foodCode) throws DMLException;
<<<<<<< HEAD
=======
	
>>>>>>> 9a7b2f635fc32b912057121f35ca6baaa7c3773a
	/**
	 * @author 신선영
	 * 사용자가 선택한 선물에 해당하는 캐릭터 호감도 업데이트 (gift 테이블 참고, likeablility 테이블 업데이트)
	 * @param userName
	 * @param selectCharacter
	 * @param foodCode
	 * @throws DMLException
	 */
	void giftUpdate(String userName, String selectCharacter, int giftNum) throws DMLException;
	/**
	 * @author 윤상우
	 * 게임을 시작할 사용자의 정보 레코드 생성 (Users 테이블)
	 * @param userName
	 * @throws DMLException
	 */
	void userInsert(String userName) throws DMLException;
	/**
	 * @author 윤상우
	 * 게임을 시작할 사용자의 호감도 레코드 생성 (likeability 테이블)
	 * @param userName
	 * @throws DMLException
	 */
	void likeAbilityInsert(String userName) throws DMLException;
	/**
	 * @author 윤상우
	 * 게임 사용자의 정보를 받아옴 (Users 테이블, likeability 테이블)
	 * @param userName
	 * @return
	 * @throws SearchWrongException
	 */
	UserDTO userGet(String userName) throws SearchWrongException;
	
	
}
