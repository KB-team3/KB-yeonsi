package dto;

import java.util.ArrayList;
import java.util.List;

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
