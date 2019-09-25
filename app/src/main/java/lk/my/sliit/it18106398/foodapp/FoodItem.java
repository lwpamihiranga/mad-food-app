package lk.my.sliit.it18106398.foodapp;

public class FoodItem {


    private String Name;
    private String Image;

    public FoodItem() {
    }

    public FoodItem(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
