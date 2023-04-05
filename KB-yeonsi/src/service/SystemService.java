package service;

import java.util.List;

import dto.AcademyEventDTO;

public interface SystemService {

	public List<AcademyEventDTO> selectAcademyEventAll();
	public int insertAcademyEvent(AcademyEventDTO dto) ;
	public int updateAcademyEvent() ;
	public int deleteAcademyEvent();
}
