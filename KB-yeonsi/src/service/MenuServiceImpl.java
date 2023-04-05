package mvc.service;

import java.util.List;

import mvc.dao.MenuDAO;
import mvc.dao.MenuDAOImpl;
import mvc.dto.LikeDTO;
import mvc.exception.SearchWrongException;

public class MenuServiceImpl implements MenuService {

	private static MenuService instance = new MenuServiceImpl();
	
	private MenuDAO menuDAO  = MenuDAOImpl.getInstance();
	
	private MenuServiceImpl() {}
	
	public static MenuService getInstance() {
		
		return instance;
	}

	@Override
	public List<LikeDTO> viewRanking(String charName) throws SearchWrongException{
		List<LikeDTO> rankingList = menuDAO.viewRanking(charName);
		if(rankingList.size() == 0)
			throw new SearchWrongException("랭킹이 존재하지 않습니다.");		
		return rankingList;
	}
}
