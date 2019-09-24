package lk.my.sliit.it18106398.foodapp;

public class Food_Items {
    private int foodImage;
    private String fName;

    public Food_Items(int foodImage, String fName) {
        this.foodImage = foodImage;
        this.fName = fName;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public String getfName() {
        return fName;
    }
}
