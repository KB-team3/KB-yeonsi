package service;

import exception.DMLException;
import exception.SearchWrongException;

public interface GameService {
	
	void foodUpdate(String userName, String selectCharacter, int foodCode) throws DMLException;
	void giftUpdate(String userName, String selectCharacter, int giftNum) throws DMLException;

}
