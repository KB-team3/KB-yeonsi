package service;

import java.util.List;

import dao.AcademyEventDAO;
import dao.AcademyEventDAOImpl;
import dao.TalkEventDAO;
import dao.TalkEventDAOImpl;
import dto.AcademyEventDTO;
import dto.TalkEventDTO;
import exception.DMLException;
import exception.SearchWrongException;

public class SystemServiceImpl implements SystemService {
	public static AcademyEventDAO academyEventDAO = AcademyEventDAOImpl.getInstance(); 
	public static TalkEventDAO talkEventDAO = TalkEventDAOImpl.getInstance(); 
	
	public static SystemServiceImpl instance = new SystemServiceImpl();
	private SystemServiceImpl() {}
	
	public static SystemServiceImpl getInstance() {
		return instance;
	}
	
	////////////////// Academy
	@Override
	public List<AcademyEventDTO> selectAcademyEventAll() throws SearchWrongException{
		List<AcademyEventDTO> list = null; 
		list = academyEventDAO.selectAcademyEventAll();
		if (list.size()==0) throw new SearchWrongException("이벤트를 조회하지 못 했습니다.");
		return list;
	}

	@Override
	public int insertAcademyEvent(AcademyEventDTO dto) throws DMLException {
		int result = 0;
		result = academyEventDAO.insertAcademyEvent(dto);
		if (result<=0) throw new DMLException("이벤트를 추가하지 못 했습니다.");
		return result;
	}

	@Override
	public int deleteAcademyEvent(int no) throws DMLException {
		int result = 0;
		result = academyEventDAO.deleteAcademyEvent(no);
		if (result<=0) throw new DMLException("이벤트를 삭제하지 못 했습니다.");
		return result;
	}

	/////////////////// Talk
	@Override
	public List<TalkEventDTO> selectTalkEventAll() {
		List<TalkEventDTO> list = null; 
		list = talkEventDAO.selectTalkEventAll();
		if (list.size()==0) throw new SearchWrongException("이벤트를 조회하지 못 했습니다.");
		return list;
	}

	@Override
	public int insertTalkEvent(TalkEventDTO dto) {
		int result = 0;
		result = talkEventDAO.insertTalkEvent(dto);
		if (result<=0) throw new DMLException("이벤트를 추가하지 못 했습니다.");
		return result;
	}

	@Override
	public int deleteTalkEvent(int no) {
		int result = 0;
		result = talkEventDAO.deleteTalkEvent(no);
		if (result<=0) throw new DMLException("이벤트를 삭제하지 못 했습니다.");
		return result;
	}

}
