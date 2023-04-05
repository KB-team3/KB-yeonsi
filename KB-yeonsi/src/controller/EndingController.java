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
			
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}

	}

}
