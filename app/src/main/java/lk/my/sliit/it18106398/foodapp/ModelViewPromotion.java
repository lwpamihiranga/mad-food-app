package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.widget.Button;

public class ModelViewPromotion {
    private int promoImage;
    private String promoNumber;
    private String foodName;
    private String Description;
    private String itemNumber;
    private Integer quantity;
//    private Button btnDelete;
//    private Button btnUpdate;
    private String key;


    public ModelViewPromotion() {
    }

    public ModelViewPromotion(int promoImage, String promoNumber, String foodName, String Description, String itemNumber,Integer quantity) {
        this.promoImage = promoImage;
        this.promoNumber = promoNumber;
        this.foodName = foodName;
        this.Description = Description;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setPromoImage(int promoImage) {
        this.promoImage = promoImage;
    }

    public void setPromoNumber(String promoNumber) {
        this.promoNumber = promoNumber;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setItemNumber(String itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
// public int getBtnUpdate(){return btnUpdate;}


}
