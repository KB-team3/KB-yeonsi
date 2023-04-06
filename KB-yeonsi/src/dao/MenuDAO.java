package dao;

import java.util.List;
import dto.LikeDTO;

public interface MenuDAO {

	/**
	 * @author 이채림
	 * 번호에 해당하는 캐릭터의 호감도 랭킹 조회하기
	 * @param 캐릭터이름
	 * 
	 * */
	List<LikeDTO> viewRanking(int charName);
	
	
	
}
