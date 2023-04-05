package dao;

import java.util.List;
import dto.LikeDTO;

public interface MenuDAO {

	List<LikeDTO> viewRanking(int charName);
	
	
	
}
