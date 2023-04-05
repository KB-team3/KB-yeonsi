package service;

import java.util.List;

import dto.LikeDTO;

public interface MenuService {
	List<LikeDTO> viewRanking(int charNum);
	

}
