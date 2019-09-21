package lk.my.sliit.it18106398.foodapp;

import android.widget.Button;

public class ModelViewPromotion {
    private int promoImage;
    private String promoName;
//    private Button btnDelete;
//    private Button btnUpdate;

    public ModelViewPromotion(int promoImage, String promoName) {
        this.promoImage = promoImage;
        this.promoName = promoName;
//        this.btnDelete = btndelete;
//        this.btnUpdate = btnupdate;
    }

    public int getPromoImage() {
        return promoImage;
    }

    public String getPromoName() {
        return promoName;
    }

   // public int getBtnUpdate(){return btnUpdate;}


}
