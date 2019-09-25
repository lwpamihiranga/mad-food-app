package lk.my.sliit.it18106398.foodapp;

import java.util.ArrayList;

public class ModelRestaurant extends ArrayList<ModelRestaurant> {
    private int image;
    private String name;

    public ModelRestaurant(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
