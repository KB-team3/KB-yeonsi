package dao;

import java.util.List;

import dto.AcademyEventDTO;

public interface AcademyEventDAO {
	// 전체 검색
	List<AcademyEventDTO> selectAcademyEventAll();
	
	// 추가
	int insertAcademyEvent(AcademyEventDTO dto);
	
	// 수정
	int updateAcademyEvent(AcademyEventDTO dto);
	
	// 삭제
	int deleteAcademyEvent(int eventId);
}
