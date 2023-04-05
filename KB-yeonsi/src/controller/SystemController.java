package controller;

import java.util.List;

import dto.AcademyEventDTO;
import dto.TalkEventDTO;
import exception.DMLException;
import exception.SearchWrongException;
import service.SystemService;
import service.SystemServiceImpl;
import view.FailView;
import view.SuccessView;

public class SystemController {
	public static SystemService systemService = SystemServiceImpl.getInstance();
	
	// 전체 조회
	public static void selectAcademyEventAll() {
		List<AcademyEventDTO> list = null;
		try{
			list = systemService.selectAcademyEventAll();
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.printSelectAcademyEventAll(list);
	}
	public static void selectTalkEventAll() {
		List<TalkEventDTO> list = null;
		try{
			list = systemService.selectTalkEventAll();
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.printSelectTalkEventAll(list);
	}
	
	
	// 등록
	public static void insertAcademyEvent(AcademyEventDTO dto) {
		try {
			systemService.insertAcademyEvent(dto);
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.messagePrint("등록 완료");
	}
	public static void insertTalkEvent(TalkEventDTO dto) {
		try {
			systemService.insertTalkEvent(dto);
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.messagePrint("등록 완료");
	}
	

	public static void deleteAcademyEvent(int no) {
		try {
			systemService.deleteAcademyEvent(no);
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.messagePrint("삭제 완료");
	}
	public static void deleteTalkEvent(int no) {
		try {
			systemService.deleteTalkEvent(no);
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.messagePrint("삭제 완료");
	}
}
