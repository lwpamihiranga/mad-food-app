package lk.my.sliit.it18106398.foodapp;

import java.util.Date;

public class PromotionTable {
    private String promoNo;
    private String itemNo;
    private String foodName;
    private Integer Qty;
    private String description;
    private int deadlineDate;
    private int image;


    public PromotionTable() {
    }

    public String getPromoNo() {
        return promoNo;
    }

    public String getItemNo() {
        return itemNo;
    }

    public String getFoodName() {
        return foodName;
    }

    public Integer getQty() {
        return Qty;
    }

    public String getDescription() {
        return description;
    }

   public int getDeadlineDate() {
        return deadlineDate;
    }

    public int getImage() { return image; }

    public void setPromoNo(String promoNo) {
        this.promoNo = promoNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadlineDate(int deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public void setImage(int image) { this.image = image; }
}

