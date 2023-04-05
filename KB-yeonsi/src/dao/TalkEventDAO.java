package dao;

import java.util.List;

import dto.TalkEventDTO;

public interface TalkEventDAO {
	// 전체 검색
	List<TalkEventDTO> selectTalkEventAll();
	
	// 추가
	int insertTalkEvent(TalkEventDTO dto);
	
	// 삭제
	int deleteTalkEvent(int eventId);
}
