package dto;

public class UserDTO {
	private String userName;
	private int date;
	private int fagibility;
	private LikeDTO likeability;
	
	public UserDTO() {}
	public UserDTO(String userName) {
		this.userName = userName;
	}
	public UserDTO(String userName, int date, int fagibility) {
		this(userName);
		this.date = date;
		this.fagibility = fagibility;
	}
	public UserDTO(String userName, int date, int fagibility, LikeDTO likeability) {
		this(userName, date, fagibility);
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
