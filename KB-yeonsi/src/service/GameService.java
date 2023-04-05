package service;

import java.util.List;
import exception.DMLException;
import exception.SearchWrongException;
import dto.AcademyOptionDTO;

public interface GameService {
	
	void foodUpdate(String userName, String selectCharacter, int foodCode) throws DMLException;
	void giftUpdate(String userName, String selectCharacter, int giftNum) throws DMLException;
	List<AcademyOptionDTO> optionSelectByEventId(int eventId);
	AcademyEventDTO academyEventSelectByRandom(int eventId);
	int academyUpdate(AcademyOptionDTO dto);
}
