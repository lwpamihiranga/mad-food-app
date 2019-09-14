package lk.my.sliit.it18106398.foodapp;

public class Delivery {
    private String orderId;
    private String orderStatus;
    private String deliveryDriverUsername;
    private String deliveryId;

    public Delivery () {}

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryDriverUsername() {
        return deliveryDriverUsername;
    }

    public void setDeliveryDriverUsername(String deliveryDriverUsername) {
        this.deliveryDriverUsername = deliveryDriverUsername;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }
}
