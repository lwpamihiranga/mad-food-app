package lk.my.sliit.it18106398.foodapp;

import android.widget.Button;

public class ModelViewFoods {

    private int foodImage;
    private String foodName;
    //    private Button btnDelete;
    private Button btnUpdate;

    public ModelViewFoods(int foodImage, String foodName) {
        this.foodImage = foodImage;
        this.foodName = foodName;
    }

    public int getPromoImage() {
        return foodImage;
    }

    public String getPromoName() {
        return foodName;
    }
}
