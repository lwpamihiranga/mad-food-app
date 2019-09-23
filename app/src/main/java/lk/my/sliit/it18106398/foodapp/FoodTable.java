package lk.my.sliit.it18106398.foodapp;

public class FoodTable {

    public String name;
    public String ItemNo;


    public FoodTable(String name, String itemNo) {
        this.name = name;
        ItemNo = itemNo;
    }

    public FoodTable() {


    }

    public String getName() {
        return name;
    }

    public String getItemNo() {
        return ItemNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItemNo(String itemNo) {
        ItemNo = itemNo;
    }
}
