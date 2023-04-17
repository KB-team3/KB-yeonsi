package dto;


/**
 * @author 신선영
 * 각 캐릭터가 선물에 가지고 있는 호감도 관리 (양수, 음수로 현재 호감도에서 계산하여 업데이트한다)
 */
public class GiftDTO {
	private int giftCode;
	private String giftName;
	private int wooyeop;
	private int sangwoo;
	private int sunyeong;
	private int minji;
	private int chaelim;
	
	public GiftDTO(int giftCode, String giftName, int wooyeop, int sangwoo, int sunyeong, int minji, int chaelim) {
		super();
		this.giftCode = giftCode;
		this.giftName = giftName;
		this.wooyeop = wooyeop;
		this.sangwoo = sangwoo;
		this.sunyeong = sunyeong;
		this.minji = minji;
		this.chaelim = chaelim;
	}
	
	public int getGiftCode() {
		return giftCode;
	}
	public void setGiftCode(int giftCode) {
		this.giftCode = giftCode;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public int getWooyeop() {
		return wooyeop;
	}
	public void setWooyeop(int wooyeop) {
		this.wooyeop = wooyeop;
	}
	public int getSangwoo() {
		return sangwoo;
	}
	public void setSangwoo(int sangwoo) {
		this.sangwoo = sangwoo;
	}
	public int getSunyeong() {
		return sunyeong;
	}
	public void setSunyeong(int sunyeong) {
		this.sunyeong = sunyeong;
	}
	public int getMinji() {
		return minji;
	}
	public void setMinji(int minji) {
		this.minji = minji;
	}
	public int getChaelim() {
		return chaelim;
	}
	public void setChaelim(int chaelim) {
		this.chaelim = chaelim;
	}
	@Override
	public String toString() {
		return "GiftDTO [giftCode=" + giftCode + ", giftName=" + giftName + ", wooyeop=" + wooyeop + ", sangwoo="
				+ sangwoo + ", sunyeong=" + sunyeong + ", minji=" + minji + ", chaelim=" + chaelim + "]";
	}
	
	
	
}
