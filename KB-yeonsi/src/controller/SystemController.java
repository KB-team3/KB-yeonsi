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
	private static SystemService systemService = SystemServiceImpl.getInstance();
	
	/**
	 * @author 길민지
	 * AcademyEvent를 전체 조회하는 컨트롤러이다.
	 * 예외가 없을 경우 SuccessView에서 출력하고, 예외가 있을 경우 처리해서 FailView로 보여준다.
	 */
	public static void selectAcademyEventAll() {
		List<AcademyEventDTO> list = null;
		try{
			list = systemService.selectAcademyEventAll();
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.printSelectAcademyEventAll(list);
	}
	/**
	 * @author 길민지
	 * TalkEvent를 전체 조회하는 컨트롤러이다. 
	 * 예외가 없을 경우 SuccessView에서 출력하고, 예외가 있을 경우 처리해서 FailView로 보여준다.
	 */
	public static void selectTalkEventAll() {
		List<TalkEventDTO> list = null;
		try{
			list = systemService.selectTalkEventAll();
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.printSelectTalkEventAll(list);
	}
	
	
	/**
	 * @author 길민지
	 * AcademyEvent를 등록하는 컨트롤러이다.
	 * 등록 과정에서 예외가 있다면 처리해서 FailView로 보여준다.
	 * @param dto : 등록할 AcademyEventDTO를 인수로 받는다.
	 */
	public static void insertAcademyEvent(AcademyEventDTO dto) {
		try {
			systemService.insertAcademyEvent(dto);
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.messagePrint("등록 완료");
	}
	/**
	 * @author 길민지
	 * TalkEvent를 등록하는 컨트롤러이다.
	 * 등록 과정에서 예외가 있다면 처리해서 FailView로 보여준다.
	 * @param dto : 등록할 TalkEventDTO를 인수로 받는다.
	 */
	public static void insertTalkEvent(TalkEventDTO dto) {
		try {
			systemService.insertTalkEvent(dto);
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.messagePrint("등록 완료");
	}
	
	/**
	 * @author 길민지
	 * AcademyEvent를 삭제하는 컨트롤러이다.
	 * 삭제 과정에서 예외가 있다면 처리해서 FailView로 보여준다.
	 * @param no : 등록할 AcademyEvent의 id를 인수로 받는다.
	 */
	public static void deleteAcademyEvent(int no) {
		try {
			systemService.deleteAcademyEvent(no);
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.messagePrint("삭제 완료");
	}
	/**
	 * @author 길민지
	 * TalkEvent를 삭제하는 컨트롤러이다.
	 * 삭제 과정에서 예외가 있다면 처리해서 FailView로 보여준다.
	 * @param no : 등록할 TalkEvent의 id를 인수로 받는다.
	 */
	public static void deleteTalkEvent(int no) {
		try {
			systemService.deleteTalkEvent(no);
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
		SuccessView.messagePrint("삭제 완료");
	}
}
