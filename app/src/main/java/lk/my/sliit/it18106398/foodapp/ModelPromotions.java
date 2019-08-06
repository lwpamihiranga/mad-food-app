package lk.my.sliit.it18106398.foodapp;

public class ModelPromotions {
    private int promoImage;
    private String promoName;

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
}
