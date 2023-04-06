package dto;

/**
 * 
 * @author 윤상우
 * 각 음식에 해당하는 캐릭터의 호감도 관리 객체
 *
 */
public class FoodDTO {
    private int foodCode;
    private String foodName;
    private int wooyeop;
    private int sangwoo;
    private int sunyeong;
    private int minji;
    private int chaelim;

    public FoodDTO() {}

public FoodDTO(int foodCode, String foodName, int wooyeop, int sangwoo, int sunyeong, int minji, int chaelim) {
    super();
    this.foodCode = foodCode;
    this.foodName = foodName;
    this.wooyeop = wooyeop;
    this.sangwoo = sangwoo;
    this.sunyeong = sunyeong;
    this.minji = minji;
    this.chaelim = chaelim;
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
    return "FoodDTO [foodCode=" + foodCode + ", foodName=" + foodName + ", wooyeop=" + wooyeop + ", sangwoo="
            + sangwoo + ", sunyeong=" + sunyeong + ", minji=" + minji + ", chaelim=" + chaelim + "]";
}
}