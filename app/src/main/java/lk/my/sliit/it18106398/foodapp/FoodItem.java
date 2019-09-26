package lk.my.sliit.it18106398.foodapp;

public class FoodItem {


    private String name;
   // private String image;
    private  String ItemNo;
    private String Price;
    private String Description;

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

    public FoodItem() {

    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

   // public String getImage() {
    //    return image;
   // }

   // public void setImage(String image) {
     //   this.image = image;
    //}
}