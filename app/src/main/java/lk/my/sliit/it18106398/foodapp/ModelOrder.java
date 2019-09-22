package lk.my.sliit.it18106398.foodapp;

public class ModelOrder {
    private int image;
    private String name;
    private int quantity;

    public ModelOrder(int image, String name, int quantity) {
        this.image = image;
        this.name = name;
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
