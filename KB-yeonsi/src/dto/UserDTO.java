package dto;

/**
 * 
 * @author 윤상우
 * 게임 사용자를 담는 객체
 * 메소드별 필요한 생성자를 선언
 */
public class UserDTO {
	private String userName;
	private int date;
	private LikeDTO likeability;
	
	public UserDTO() {}
	public UserDTO(String userName) {
		this.userName = userName;
	}
	public UserDTO(String userName, int date) {
		this(userName);
		this.date = date;
	}
	public UserDTO(String userName, int date, LikeDTO likeability) {
		this(userName, date);
		this.likeability = likeability;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public LikeDTO getLikeability() {
		return likeability;
	}
	public void setLikeability(LikeDTO likeability) {
		this.likeability = likeability;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", date=" + date  + ", likeability="
				+ likeability + "]";
	}
}
