package dao;

import java.util.List;

import dto.TalkEventDTO;

public interface TalkEventDAO {
	/**
	 * @author 길민지
	 * DB에서 TalkEvent를 전체 조회한다. 
	 * @return : 조회한 TalkEvent를 담은 리스트
	 */
	List<TalkEventDTO> selectTalkEventAll();
	
	/**
	 * @author 길민지
	 * DB에 TalkEvent를 추가한다. 
	 * @param : 추가할 TalkEvent
	 * @return : 추가된 TalkEvent의 개수
	 */
	int insertTalkEvent(TalkEventDTO dto);
	
	/**
	 * @author 길민지
	 * DB에서 TalkEvent를 삭제한다. 
	 * @param : 삭제할 TalkEvent의 ID
	 * @return : 삭제된 TalkEvent의 개수
	 */
	int deleteTalkEvent(int eventId);
}
