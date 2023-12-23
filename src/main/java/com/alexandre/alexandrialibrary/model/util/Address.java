package com.alexandre.alexandrialibrary.model.util;

public class Address {

    private String street;
    private String Neighborhood;
    private String zipCode;

    public Address(String street, String neighborhood, String zipCode) {
        this.street = street;
        Neighborhood = neighborhood;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return Neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        Neighborhood = neighborhood;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
