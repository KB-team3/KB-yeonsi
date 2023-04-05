package service;

import java.util.List;

import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;
import exception.DMLException;

public interface GameService {
	
	void foodUpdate(String userName, String selectCharacter, int foodCode) throws DMLException;
	void giftUpdate(String userName, String selectCharacter, int giftNum) throws DMLException;
	List<AcademyOptionDTO> optionSelectByEventId(int eventId);
	AcademyEventDTO academyEventSelectByRandom(int eventId);
}
