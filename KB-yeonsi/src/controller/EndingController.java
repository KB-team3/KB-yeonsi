package mvc.controller;

import mvc.dto.LikeDTO;
import mvc.exception.SearchWrongException;
import mvc.service.EndingService;
import mvc.service.EndingServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;

public class EndingController {

	static boolean flag = false;
	
	private static EndingService endingService = EndingServiceImpl.getInstance();

	public static void checkEnding(String userName) {
		try {
			LikeDTO likeDto = endingService.checkEnding(userName);
			
			if (likeDto.getWooyeop() >= 50) {
				SuccessView.goodEnding("우엽");
				flag = true;
			}
			if (likeDto.getSangwoo() >= 50) {
				SuccessView.goodEnding("상우");
				flag = true;
			}
			
			if (likeDto.getSunyeong() >= 50) {
				SuccessView.goodEnding("선영");
				flag = true;
			}
			
			if (likeDto.getMinji() >= 50) {
				SuccessView.goodEnding("민지");
				flag = true;
			}
			
			if (likeDto.getChaelim() >= 50) {
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
