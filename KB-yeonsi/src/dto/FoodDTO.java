package dto;

public class FoodDTO {
	private String foodName;
	private String likeCharacter;
	private int likePoint;
	
	public FoodDTO() {}
	
	public FoodDTO(String foodName, String likeCharacter, int likePoint) {
		this.foodName = foodName;
		this.likeCharacter = likeCharacter;
		this.likePoint = likePoint;
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
		return "FoodDTO [foodName=" + foodName + ", likeCharacter=" + likeCharacter + ", likePoint=" + likePoint + "]";
	}
	
	
}
