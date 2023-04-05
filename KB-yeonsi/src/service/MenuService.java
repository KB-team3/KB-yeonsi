package service;

import java.util.List;

import dto.LikeDTO;

public interface MenuService {
	List<LikeDTO> viewRanking(String charName);
	

}
