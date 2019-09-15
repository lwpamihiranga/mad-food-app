package lk.my.sliit.it18106398.foodapp;

public class ModelPromotions {
    private int promoImage;
    private String promoName;

    public ModelPromotions() {
    }

    public ModelPromotions(int promoImage, String promoName) {
        this.promoImage = promoImage;
        this.promoName = promoName;
    }

    public int getPromoImage() {
        return promoImage;
    }

    public String getPromoName() {
        return promoName;
    }

    public void setPromoImage(int promoImage) {
        this.promoImage = promoImage;
    }

    public void setPromoName(String promoName) {
        this.promoName = promoName;
    }
}
