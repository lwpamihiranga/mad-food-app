package lk.my.sliit.it18106398.foodapp;

public class ModelFood {
    private int foodImage;
    private String fName;

    public ModelFood(int foodImage, String fName) {
        this.foodImage = foodImage;
        this.fName = fName;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public String getfName() {
        return fName;
    }
}
