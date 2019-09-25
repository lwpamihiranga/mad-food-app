package lk.my.sliit.it18106398.foodapp;

public class FoodTable {
 String name;
      String ItemNo;
     String Price;
     String Description;


    public FoodTable(String name, String itemNo, String price, String description) {
        this.name = name;
        this.ItemNo = itemNo;
        this.Price = price;
        Description = description;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemNo() {
        return ItemNo;
    }

    public void setItemNo(String itemNo) {
        ItemNo = itemNo;
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
}
