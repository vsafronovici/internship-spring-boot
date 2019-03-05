package com.endava.training.spring.demo.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by vsafronovici on 3/15/2017.
 */
public class Address {

    private static int _id;

    private final int id;
    private String country;
    private String state;
    @Value("${default.city}")
    private String city;
    private String zip;

    public Address() {
        this.id = ++_id;
    }

    public Address(String country, String state, String city, String zip) {
        this();
        this.country = country;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
