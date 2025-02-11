package com.FoorOrdering.request;

import com.FoorOrdering.model.Address;
import com.FoorOrdering.model.ContractInfor;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurant {
    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContractInfor contractInfor;
    private String openingHours;
    private List<String> images;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContractInfor getContractInfor() {
        return contractInfor;
    }

    public void setContractInfor(ContractInfor contractInfor) {
        this.contractInfor = contractInfor;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
