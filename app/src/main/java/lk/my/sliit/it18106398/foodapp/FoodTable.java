package lk.my.sliit.it18106398.foodapp;

public class FoodTable {

    private String name;
    private String ItemNo;
    private String Price;
    private String Description;


    public FoodTable() {

    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {return name;}

    public String getItemNo() { return ItemNo;}

    public void setName(String name) { this.name = name; }

    public void setItemNo(String itemNo) { ItemNo = itemNo;}
}
