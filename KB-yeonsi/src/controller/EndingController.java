package controller;

import dto.LikeDTO;
import exception.SearchWrongException;
import service.EndingService;
import service.EndingServiceImpl;
import view.FailView;
import view.SuccessView;

public class EndingController {

	static boolean flag = false;
	static int limit = 50;
	
	private static EndingService endingService = EndingServiceImpl.getInstance();

	
	/**
	 * @author 이채림
	 * 게임이 모두 끝난 후 사용자가 쌓은 캐릭터의 호감도 출력
	 * 호감도 임계값을 정해 캐릭터별로 임계값 이상이면 success, 이하면 fail
	 * 
	 * */
	public static void checkEnding(String userName) {
		try {
			LikeDTO likeDto = endingService.checkEnding(userName);

			if (likeDto.getWooyeop() >= limit) {
				SuccessView.goodEnding("우엽");
				flag = true;
			}
			if (likeDto.getSangwoo() >= limit) {
				SuccessView.goodEnding("상우");
				flag = true;
			}
			
			if (likeDto.getSunyeong() >= limit) {
				SuccessView.goodEnding("선영");
				flag = true;
			}
			
			if (likeDto.getMinji() >= limit) {
				SuccessView.goodEnding("민지");
				flag = true;
			}
			
			if (likeDto.getChaelim() >= limit) {
				SuccessView.goodEnding("채림");
				flag = true;
			}
				
			if(flag ==  false)
				SuccessView.badEnding();
			
			SuccessView.gameResultPrint(likeDto);
			
			
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}

	}
	
}
