package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.SystemController;
import dto.AcademyEventDTO;
import dto.AcademyOptionDTO;

public class SystemView {
	public SystemView() {
		menuChoice();
	}
	static Scanner sc =new Scanner(System.in);
	
	/** 
	 * System 메뉴 선택
	 */
	public void menuChoice() {
		while(true) {
       	 System.out.println("\n----------------------------------------");
       	 System.out.print("1. 아카데미 이벤트 전체 검색   ");
       	 System.out.print("2. 대화 이벤트 전체 검색   ");
         	System.out.print("3. 메뉴 전체 검색   ");
        	System.out.println("4. 선물 전체 검색   ");
        	
        	System.out.print("5. 아카데미 이벤트 추가   ");
        	System.out.print("6. 대화 이벤트 추가   ");
        	System.out.print("7. 메뉴 추가   ");
        	System.out.println("8. 선물 추가  ");
        	
        	System.out.print("8. 아카데미 이벤트 수정  ");
        	System.out.print("9. 대화 이벤트 수정  ");
        	System.out.print("10. 메뉴 수정  ");
        	System.out.println("11. 선물 수정  ");
        	
        	System.out.print("12. 아카데미 이벤트 삭제  ");
        	System.out.print("13. 대화 이벤트 삭제  ");
        	System.out.print("14. 메뉴 삭제  ");
        	System.out.println("15. 선물 삭제  ");
        	
        	System.out.print("16. 종료 ");

             System.out.println("\n--------------------------------------------");
             System.out.println("선택메뉴는?");
             try {
	              int menu = Integer.parseInt(sc.nextLine());//
	              switch (menu) {
				  case 1:
					  // 아카데미 이벤트 전체 검색
					  SystemController.selectAcademyEventAll();
					break;
	               case 2:
					break;
	               case 3:
	 				break;
	               case 4:;
	 				break;
	               case 5: // 아카데미 이벤트 추가
	            	   inputInsertAcademyEvent();
	    				break;
	               case 6:
	    				break;
	               case 7: 
	    				break;
	               case 8:
	    				break;	
	               case 9:
	    				break;	
	               case 10:
	    				break;	
	               case 11:
	    				break;	
	               case 12:
	    				break;	
	               case 13:
	    				break;	
	               case 14:
	    				break;	
	               case 15:
	    				break;	
	    		
	               case 16:
	            	   // 현재는 종료로 되어 있는데 나중에는 홈으로 가는 걸로 바꾸는 게 나을듯
	            	  System.out.println("종료합니다.");
	    			 System.exit(0);	
	    			break;
				default:
					System.out.println("잘못되었습니다. 다시 입력해주세요.");
				}
	        	 
             }catch (NumberFormatException e) {
				System.out.println("메뉴는 숫자만 가능합니다.");
			}
        }//while문
	}
	
	/**
	 *  5. 아카데미 이벤트 추가
	 * @param args
	 */
	public static void inputInsertAcademyEvent() {
		AcademyEventDTO dto = new AcademyEventDTO();
		System.out.println("스크립트?");
	   	 dto.setScript(sc.nextLine());
	   	 
	   	 System.out.println("선택지 개수?");
	   	 int selCnt = Integer.parseInt(sc.nextLine());
	   	 
	   	 List<AcademyOptionDTO> list = new ArrayList<>();
	   	 for(int i = 0; i<selCnt; i++) {
	   		AcademyOptionDTO option = new AcademyOptionDTO();
	   		System.out.println("선택지 내용은?");
	   		option.setSelName(sc.nextLine());
		   	System.out.println("누구의 호감도 올릴 지?");
		   	option.setCharacterName(sc.nextLine());
		   	System.out.println("호감도 얼마나 오를 지?");
		   	option.setLikePoint(Integer.parseInt(sc.nextLine())); ;
		   	System.out.println("결과 스크립트는?");
		   	option.setResultScript(sc.nextLine());
		   	list.add(option);
	   	 }
	   	 SystemController.insertAcademyEvent(dto);
	}
	
	public static void main(String [] args) {
		SystemView sv = new SystemView();
	}
}
