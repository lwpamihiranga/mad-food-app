package lk.my.sliit.it18106398.foodapp;

public class FoodTable {
    private String itemNo;
    private String Foodname;
    private String Discription;

    public FoodTable() {
    }

    public String getItemNo() {
        return itemNo;
    }

    public String getFoodname() {
        return Foodname;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public void setFoodname(String foodname) {
        Foodname = foodname;
    }

    public void setDiscription(String discription) {
        Discription = discription;
    }
}
