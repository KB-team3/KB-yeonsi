package dto;

public class UserDTO {
	private String userName;
	private String date;
	private int fagibility;
	private LikeDTO likeability;
	
	public UserDTO() {}
	public UserDTO(String userName, String date, int fagibility, LikeDTO likeability) {
		super();
		this.userName = userName;
		this.date = date;
		this.fagibility = fagibility;
		this.likeability = likeability;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getFagibility() {
		return fagibility;
	}
	public void setFagibility(int fagibility) {
		this.fagibility = fagibility;
	}
	public LikeDTO getLikeability() {
		return likeability;
	}
	public void setLikeability(LikeDTO likeability) {
		this.likeability = likeability;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", date=" + date + ", fagibility=" + fagibility + ", likeability="
				+ likeability + "]";
	}
}
