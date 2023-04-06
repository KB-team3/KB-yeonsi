package dto;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author 길민지
 * 주말에 일어나는 대화 이벤트에 대한 DTO
 * PK인 아이디와 출력될 스크립트, 가지고 있는 선택지에 대한 정보가 담겨있다.
 *
 */
public class TalkEventDTO {
	private int eventId;
	private String script;
	private List<TalkOptionDTO> optionList = new ArrayList<>();
	
	public TalkEventDTO() {}

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

	public List<TalkOptionDTO> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<TalkOptionDTO> optionList) {
		this.optionList = optionList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TalkEventDTO [eventId=");
		builder.append(eventId);
		builder.append("\nscript\n:");
		builder.append(script);
		builder.append("\noptionList\n");
		for (TalkOptionDTO option : optionList) {
			builder.append(option.getOptionId() + "." + option.getSelName()+" ");
		}
		builder.append("]");
		return builder.toString();
	}
}
