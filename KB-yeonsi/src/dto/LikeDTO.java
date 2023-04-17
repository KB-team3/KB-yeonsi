package dto;

/**
 * 
 * @author 윤상우
 * 호감도를 담는 객체 생성
 * UserDTO와 userName을 공유한다.
 *
 */
public class LikeDTO {
	private String userName;
	private int wooyeop;
	private int sangwoo;
	private int sunyeong;
	private int minji;
	private int chaelim;
	
	public LikeDTO() {};
	public LikeDTO(String userName, int wooyeop, int sangwoo, int sunyeong, int minji, int chaelim) {
		this.userName = userName;
		this.wooyeop = wooyeop;
		this.sangwoo = sangwoo;
		this.sunyeong = sunyeong;
		this.minji = minji;
		this.chaelim = chaelim;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getWooyeop() {
		return wooyeop;
	}
	public void setWooyeop(int wooyeop) {
		this.wooyeop = wooyeop;
	}
	public int getSangwoo() {
		return sangwoo;
	}
	public void setSangwoo(int sangwoo) {
		this.sangwoo = sangwoo;
	}
	public int getSunyeong() {
		return sunyeong;
	}
	public void setSunyeong(int sunyeong) {
		this.sunyeong = sunyeong;
	}
	public int getMinji() {
		return minji;
	}
	public void setMinji(int minji) {
		this.minji = minji;
	}
	public int getChaelim() {
		return chaelim;
	}
	public void setChaelim(int chaelim) {
		this.chaelim = chaelim;
	}
	
	@Override
	public String toString() {
		return  "우엽 = " + wooyeop + "\n" + "상우 = " + sangwoo + "\n"+ "선영 = "
				+ sunyeong + "\n" + "민지 = " + minji + "\n" + "채림 = " + chaelim;
	}
}
