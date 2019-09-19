package lk.my.sliit.it18106398.foodapp;

public class ModelPromotions {
    private int promoImage;
    private String foodName;

    public ModelPromotions() {
    }

    public ModelPromotions(int promoImage, String promoName) {
        this.promoImage = promoImage;
        this.foodName = promoName;
    }

    public int getPromoImage() {
        return promoImage;
    }

    public String getPromoName() {
        return foodName;
    }

    public void setPromoImage(int promoImage) {
        this.promoImage = promoImage;
    }

    public void setPromoName(String promoName) {
        this.foodName = promoName;
    }
}
