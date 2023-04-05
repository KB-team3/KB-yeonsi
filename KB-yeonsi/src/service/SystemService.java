package service;

import java.util.List;

import dto.AcademyEventDTO;
import dto.TalkEventDTO;

public interface SystemService {

	public List<AcademyEventDTO> selectAcademyEventAll();
	public int insertAcademyEvent(AcademyEventDTO dto) ;
	public int deleteAcademyEvent(int no);
	
	public List<TalkEventDTO> selectTalkEventAll();
	public int insertTalkEvent(TalkEventDTO dto) ;
	public int deleteTalkEvent(int no);
}
