package controller;

import java.util.List;

import dto.AcademyEventDTO;
import service.SystemService;
import service.SystemServiceImpl;
import view.SuccessView;

public class SystemController {
	public static SystemService systemService = SystemServiceImpl.getInstance();
	
	public static void selectAcademyEventAll() {
		List<AcademyEventDTO> list = null;
		try{
			list = systemService.selectAcademyEventAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		SuccessView.printSelectAcademyEventAll(list);
	}
	
	public static void insertAcademyEvent(AcademyEventDTO dto) {
		try {
			systemService.insertAcademyEvent(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("등록 완료");
	}
}
