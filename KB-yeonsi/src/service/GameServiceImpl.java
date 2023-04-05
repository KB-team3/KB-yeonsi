package service;

import java.util.List;

import dao.GameDAO;
import dao.GameDAOImpl;
import dto.AcademyOptionDTO;

public class GameServiceImpl implements GameService {
	private static GameService instance = new GameServiceImpl();
	
	private GameDAO gameDAO = GameDAOImpl.getInstance();
	
	private GameServiceImpl() {}
	public static GameService getInstance() {
		return instance;
	}
	
	public List<AcademyOptionDTO> optionSelectByEventId(int eventId) {
		List<AcademyOptionDTO> list = gameDAO.optionSelectByEventId(eventId);
		return list;		
	}
}
