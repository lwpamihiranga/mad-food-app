package lk.my.sliit.it18106398.foodapp;

import android.widget.Button;

public class ModelViewPromotion {
    private int promoImage;
    private String promoNumber;
    private String foodName;
    private String Description;
//    private Button btnDelete;
//    private Button btnUpdate;

    public ModelViewPromotion(int promoImage, String promoNumber, String foodName, String Description) {
        this.promoImage = promoImage;
        this.promoNumber = promoNumber;
        this.foodName = foodName;
        this.Description = Description;
//        this.btnDelete = btndelete;
//        this.btnUpdate = btnupdate;
    }

    public int getPromoImage() {
        return promoImage;
    }

    public String getPromoNumber() {
        return promoNumber;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getDescription() {
        return Description;
    }

    // public int getBtnUpdate(){return btnUpdate;}


}
