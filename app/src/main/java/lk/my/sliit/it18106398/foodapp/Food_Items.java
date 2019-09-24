package lk.my.sliit.it18106398.foodapp;

public class Food_Items {
    private String foodImage;
    private String fName;

    public Food_Items(String foodImage, String fName) {
        this.foodImage = foodImage;
        this.fName = fName;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public String getfName() {
        return fName;
    }
}
