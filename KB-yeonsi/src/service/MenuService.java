package mvc.service;

import java.util.List;

import mvc.dto.LikeDTO;

public interface MenuService {
	List<LikeDTO> viewRanking(String charName);
	

}
