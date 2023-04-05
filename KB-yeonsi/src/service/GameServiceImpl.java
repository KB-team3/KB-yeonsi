package service;

import dao.GameDAO;
import dao.GameDAOImpl;
import dto.LikeDTO;
import exception.DMLException;
import exception.SearchWrongException;

public class GameServiceImpl implements GameService {

	public GameServiceImpl () {}
	
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
