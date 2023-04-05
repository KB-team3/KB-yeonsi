package mvc.service;

import mvc.dao.EndingDAO;
import mvc.dao.EndingDAOImpl;
import mvc.dto.LikeDTO;
import mvc.exception.SearchWrongException;

public class EndingServiceImpl implements EndingService {

	private static EndingService instance = new EndingServiceImpl();
	
	private EndingDAO endingDAO = EndingDAOImpl.getInstance();
	
	private EndingServiceImpl() {}
	
	public static EndingService getInstance() {
		
		return instance;
	}
	
	public LikeDTO checkEnding(String userName) throws SearchWrongException{
		LikeDTO likeDto  = endingDAO.checkEnding(userName);
		if(likeDto == null) 
			throw new SearchWrongException("엔딩이 존재하지 않습니다.");

			return likeDto;
			
		}
	
		
	
	
	
}

