package service;

import java.util.List;

import dto.AcademyEventDTO;
import dto.TalkEventDTO;

public interface SystemService {
	/**
	 * @author 길민지
	 * AcademyEvent를 전체 조회하는 서비스
	 * @return DAO에서 조회된 AcademyEvent 리스트. 사이즈가 0일 경우 조회된 결과가 없으므로 예외 처리
	 */
	public List<AcademyEventDTO> selectAcademyEventAll();
	/**
	 * @author 길민지
	 * @param dto : 추가할 AcademyEvent
	 * @return : DAO에서 추가된 AcademyEvent의 개수. 0일 경우 추가된 정보가 없으므로 예외 처리
	 */
	public int insertAcademyEvent(AcademyEventDTO dto) ;
	/**
	 * @author 길민지
	 * @param dto : 삭제할 AcademyEvent
	 * @return : DAO에서 삭제된 AcademyEvent의 개수. 0일 경우 삭제된 정보가 없으므로 예외 처리
	 */
	public int deleteAcademyEvent(int no);
	
	/**
	 * @author 길민지
	 * TalkEvent를 전체 조회하는 서비스
	 * @return DAO에서 조회된 TalkEvent 리스트. 사이즈가 0일 경우 조회된 결과가 없으므로 예외 처리
	 */
	public List<TalkEventDTO> selectTalkEventAll();
	/**
	 * @author 길민지
	 * @param dto : 추가할 TalkEvent
	 * @return : DAO에서 추가된 TalkEvent의 개수. 0일 경우 추가된 정보가 없으므로 예외 처리
	 */
	public int insertTalkEvent(TalkEventDTO dto) ;
	/**
	 * @author 길민지
	 * @param dto : 삭제할 TalkEvent
	 * @return : DAO에서 삭제된 TalkEvent의 개수. 0일 경우 삭제된 정보가 없으므로 예외 처리
	 */
	public int deleteTalkEvent(int no);
}
