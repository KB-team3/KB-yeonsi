package dao;
import java.util.List;

import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;
import dto.UserDTO;
import exception.DMLException;
import exception.SearchWrongException;

public interface GameDAO {

	List<AcademyOptionDTO> optionSelectByEventId(int eventId);
	AcademyEventDTO academyEventSelectByRandom(int eventId);
	
	int academyUpdate(AcademyOptionDTO dto);
	
	/**
	 * @param
	 * 선택한 foodCode
	 * @return
	 * 성공하면 1, 실패하면 0
	 * */
	int foodUpdate(String userName, String selectCharacter, int foodCode) throws DMLException;
	/**
	 * @param
	 * 선택한 giftCode
	 * @return
	 * 성공하면 1, 실패하면 0
	 * */
	int giftUpdate(String userName, String selectCharacter, int giftCode) throws DMLException;
	
	/**
	 * 
	 * @param userName
	 * @return 성공하면 1, 실패하면 0
	 * @throws DMLException
	 */
	int userInsert(String userName) throws DMLException;
	
	/**
	 * 
	 * @param userName
	 * @return 성공하면 1, 실패하면 0
	 * @throws DMLException
	 */
	int likeAbilityInsert(String userName) throws DMLException;
	
	/**
	 * 
	 * @param userName
	 * @return userName인 userDTO 객체
	 * @throws SearchWrongException
	 */
	UserDTO userGet(String userName) throws SearchWrongException;
	
}
