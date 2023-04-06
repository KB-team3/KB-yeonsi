package dto;
/**
 * 
 * @author 길민지
 * 평일에 아카데미에서 일어나는 이벤트의 선택지 대한 DTO
 * PK인 아이디와 FK인 이벤트 아이디, 선택지의 이름, 호감도를 올릴 캐릭터, 변경할 호감도 포인트, 결과(대답) 스크립트가 담겨있다.
 *
 */
public class AcademyOptionDTO {
	private int optionId;
	private int eventId;
	private String selName;
	private String characterName;
	private int likePoint;
	private String resultScript;
	
	
	public AcademyOptionDTO() {}

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
		return selName;
	}	
	
	
}
