package dao;

import dto.LikeDTO;

public interface EndingDAO {
	
	/**
	 * @author 이채림
	 * 게임이 모두 끝난 후 사용자가 쌓은 캐릭터의 호감도 출력
	 * 
	 * @param 사용자이름
	 * 
	 * */
	public LikeDTO checkEnding(String userName);
}
