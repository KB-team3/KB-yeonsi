package service;

import java.util.List;
import dao.GameDAO;
import dao.GameDAOImpl;
import dto.LikeDTO;
import exception.DMLException;
import exception.SearchWrongException;
import dto.AcademyEventDTO;
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

	@Override
	public AcademyEventDTO academyEventSelectByRandom(int eventId) {
		AcademyEventDTO dto = gameDAO.academyEventSelectByRandom(eventId);
		return dto;
	}
	
	@Override
	public void foodUpdate(String userName, String selectCharacter, int foodCode) throws SearchWrongException {
		GameDAO gameDAO = new GameDAOImpl();
		int result = gameDAO.foodUpdate(userName, selectCharacter, foodCode);
		
		if(result == 0) throw new DMLException("수정되지 않았습니다.");
		
	}

	@Override
    public void giftUpdate(String userName, String selectCharacter, int giftNum) throws DMLException {
		GameDAO gameDAO = new GameDAOImpl();
		int result = gameDAO.giftUpdate(userName, selectCharacter, giftNum);
        if (result == 0) {
            throw new DMLException("선물 주기 오류 발생!");
        }
    }
}
