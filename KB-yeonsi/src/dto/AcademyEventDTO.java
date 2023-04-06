package dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 길민지
 * 평일에 아카데미에서 일어나는 이벤트에 대한 DTO
 * PK인 아이디와 출력될 스크립트, 가지고 있는 선택지에 대한 정보가 담겨있다.
 *
 */
public class AcademyEventDTO {
	private int eventId;
	private String script;
	private List<AcademyOptionDTO> optionList = new ArrayList<>();
	
	public AcademyEventDTO() {}

	public AcademyEventDTO(int eventId, String script) {
		super();
		this.eventId = eventId;
		this.script = script;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public List<AcademyOptionDTO> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<AcademyOptionDTO> optionList) {
		this.optionList = optionList;
	}

	@Override
	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("AcademyEventDTO [eventId=");
//		builder.append(eventId);
//		builder.append("\nscript");
//		builder.append(script);
//		builder.append("\noptionList");
//		for (AcademyOptionDTO option : optionList) {
//			builder.append(option.getOptionId() + "." + option.getSelName()+" ");
//		}
//		builder.append("]");
//		return builder.toString();
		return script;
	}
	
}
