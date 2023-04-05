package dao;

import java.util.List;

import dto.AcademyOptionDTO;

public interface GameDAO {
	
	List<AcademyOptionDTO> optionSelectByEventId(int eventId);
	
}
