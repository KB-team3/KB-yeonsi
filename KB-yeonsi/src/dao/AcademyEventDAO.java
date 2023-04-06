package dao;

import java.util.List;

import dto.AcademyEventDTO;

public interface AcademyEventDAO {
	/**
	 * @author 길민지
	 * DB에서 AcademyEvent를 전체 조회한다. 
	 * @return : 조회한 AcademyEvent를 담은 리스트
	 */
	List<AcademyEventDTO> selectAcademyEventAll();
	
	/**
	 * @author 길민지
	 * DB에 AcademyEvent를 추가한다. 
	 * @param : 추가할 AcademyEvent
	 * @return : 추가된 AcademyEvent의 개수
	 */
	int insertAcademyEvent(AcademyEventDTO dto);
	
	/**
	 * @author 길민지
	 * DB에서 AcademyEvent를 삭제한다. 
	 * @param : 삭제할 AcademyEvent의 ID
	 * @return : 삭제된 AcademyEvent의 개수
	 */
	int deleteAcademyEvent(int eventId);
}
