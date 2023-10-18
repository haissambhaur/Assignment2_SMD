package com.example.assignment_1;

public class User {
    private String country;
    private String city;
    private String name;
    private String phone;

    public User() {
        // Default constructor required for DataSnapshot.getValue(User.class)
    }

    public User(String country, String city, String phone,String name) {
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.name=name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }
    public String getName() {
        return name;
    }
}
