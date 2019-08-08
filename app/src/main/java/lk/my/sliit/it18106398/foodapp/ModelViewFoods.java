package lk.my.sliit.it18106398.foodapp;

import android.widget.Button;

public class ModelViewFoods {

    private int promoImage;
    private String promoName;
    //    private Button btnDelete;
    private Button btnUpdate;

    public ModelViewFoods(int promoImage, String promoName) {
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
}
