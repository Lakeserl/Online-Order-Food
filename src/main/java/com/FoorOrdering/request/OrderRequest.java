package com.FoorOrdering.request;

import com.FoorOrdering.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    public Long restaurantId;
    private Address deliveryAddress;

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
