package service;

import java.util.List;

import dto.AcademyOptionDTO;

public interface GameService {
	List<AcademyOptionDTO> optionSelectByEventId(int eventId);
}
