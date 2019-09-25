package lk.my.sliit.it18106398.foodapp;

import com.google.firebase.database.Exclude;

public class OrderBag1 {
    private Integer qty;
    private String description;

    public OrderBag1() {
    }

    public OrderBag1(Integer qty, String description) {
        this.qty = qty;
        this.description = description;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
