package com.alexandre.alexandrialibrary.util;

public class Address {

    private String street;
    private String neighborhood;
    private String zipCode;

    public Address() {
    }

    public Address(String street, String neighborhood, String zipCode) {
        this.street = street;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
