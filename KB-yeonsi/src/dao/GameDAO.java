package dao;

import exception.DMLException;

public interface GameDAO {
	
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
	
}
