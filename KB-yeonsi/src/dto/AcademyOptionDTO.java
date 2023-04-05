package dto;

public class AcademyOptionDTO {
	private int optionId;
	private int eventId;
	private String selName;
	private String characterName;
	private int likePoint;
	private String resultScript;
	
	public AcademyOptionDTO(){}

	public AcademyOptionDTO(int optionId, int eventId, String selName, String characterName, int likePoint,
			String resultScript) {
		super();
		this.optionId = optionId;
		this.eventId = eventId;
		this.selName = selName;
		this.characterName = characterName;
		this.likePoint = likePoint;
		this.resultScript = resultScript;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getSelName() {
		return selName;
	}

	public void setSelName(String selName) {
		this.selName = selName;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public int getLikePoint() {
		return likePoint;
	}

	public void setLikePoint(int likePoint) {
		this.likePoint = likePoint;
	}

	public String getResultScript() {
		return resultScript;
	}

	public void setResultScript(String resultScript) {
		this.resultScript = resultScript;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AcademyOptionDTO [optionId=");
		builder.append(optionId);
		builder.append(", eventId=");
		builder.append(eventId);
		builder.append(", selName=");
		builder.append(selName);
		builder.append(", characterName=");
		builder.append(characterName);
		builder.append(", likePoint=");
		builder.append(likePoint);
		builder.append(", resultScript=");
		builder.append(resultScript);
		builder.append("]");
		return builder.toString();
	}
}
