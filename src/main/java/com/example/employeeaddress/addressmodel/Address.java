package com.example.employeeaddress.addressmodel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String city;
    private String zipCode;
    public Address(){

    }
    public Address(String city,String zipCode){
        this.city=city;
        this.zipCode=zipCode;
    }
    public int getId() {
        return id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
