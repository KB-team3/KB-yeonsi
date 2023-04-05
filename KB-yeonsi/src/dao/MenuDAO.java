package mvc.dao;

import java.util.List;

import mvc.dto.LikeDTO;

public interface MenuDAO {

	List<LikeDTO> viewRanking(String charName);
	
	
	
}
