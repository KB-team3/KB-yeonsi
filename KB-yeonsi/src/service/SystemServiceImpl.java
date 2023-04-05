package service;

import java.util.List;

import dao.AcademyEventDAO;
import dao.AcademyEventDAOImpl;
import dto.AcademyEventDTO;

public class SystemServiceImpl implements SystemService {
	public static AcademyEventDAO academyEventDAO = AcademyEventDAOImpl.getInstance(); 
	
	public static SystemServiceImpl instance = new SystemServiceImpl();
	private SystemServiceImpl() {}
	
	public static SystemServiceImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<AcademyEventDTO> selectAcademyEventAll() {
		List<AcademyEventDTO> list = null; 
		list = academyEventDAO.selectAcademyEventAll();
		//if (list.size()==0) throw new 
		return list;
	}

	@Override
	public int insertAcademyEvent(AcademyEventDTO dto){
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAcademyEvent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAcademyEvent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
