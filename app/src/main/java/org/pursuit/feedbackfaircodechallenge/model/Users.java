package org.pursuit.feedbackfaircodechallenge.model;

import android.location.Address;

import java.util.List;

public class Users {

    private String name;
    private String email;
    private Address address;
    private String phone;

//    public Users(){}
//
//    public Users(String name, String email, Address address, String phone) {
//        this.name = name;
//        this.email = email;
//        this.address = address;
//        this.phone = phone;
//    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
