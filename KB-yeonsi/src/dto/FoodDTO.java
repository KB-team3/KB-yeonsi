package dto;

public class FoodDTO {
	private int foodCode;
	private String foodName;
	private String likeCharacter;
	private int likePoint;
	private String hateCharacter;
	private int hatePoint;
	
	public FoodDTO() {}
	public FoodDTO(int foodCode, String foodName, String likeCharacter, int likePoint, String hateCharacter,
			int hatePoint) {
		super();
		this.foodCode = foodCode;
		this.foodName = foodName;
		this.likeCharacter = likeCharacter;
		this.likePoint = likePoint;
		this.hateCharacter = hateCharacter;
		this.hatePoint = hatePoint;
	}

	public int getFoodCode() {
		return foodCode;
	}

	public void setFoodCode(int foodCode) {
		this.foodCode = foodCode;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getLikeCharacter() {
		return likeCharacter;
	}

	public void setLikeCharacter(String likeCharacter) {
		this.likeCharacter = likeCharacter;
	}

	public int getLikePoint() {
		return likePoint;
	}

	public void setLikePoint(int likePoint) {
		this.likePoint = likePoint;
	}
	
	@Override
	public String toString() {
		return "FoodDTO [foodCode=" + foodCode + ", foodName=" + foodName + ", likeCharacter=" + likeCharacter
				+ ", likePoint=" + likePoint + ", hateCharacter=" + hateCharacter + ", hatePoint=" + hatePoint + "]";
	}

}
