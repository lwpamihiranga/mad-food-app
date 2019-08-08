package lk.my.sliit.it18106398.foodapp;

public class ModelDeliverPerson {
    private int personImage;
    private String personName;

    public ModelDeliverPerson(int personImage, String personName) {
        this.personImage = personImage;
        this.personName = personName;
    }

    public int getPersonImage() {
        return personImage;
    }

    public String getPersonName() {
        return personName;
    }
}
