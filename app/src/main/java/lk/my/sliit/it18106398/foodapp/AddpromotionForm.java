package lk.my.sliit.it18106398.foodapp;

public class AddpromotionForm {
    private String promoNo;
    private String itemNo;
    private String foodName;
    private String Qty;
    private String description;
    private date_picker_fragment deadlineDate;

    public AddpromotionForm() {
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

    public String getQty() {
        return Qty;
    }

    public String getDescription() {
        return description;
    }

    public date_picker_fragment getDeadlineDate() {
        return deadlineDate;
    }

    public void setPromoNo(String promoNo) {
        this.promoNo = promoNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadlineDate(date_picker_fragment deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}

