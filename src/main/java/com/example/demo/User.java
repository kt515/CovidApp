package com.example.demo;


public class User {
    private String id; //NRIC or other forms of identification
    private String name;
    private String userType;

    // constructors

    public User() {

    }

    public User(String id, String name, String userType) {
        this.id = id;
        this.name = name;
        this.userType = userType;
    }

    // getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    //toString()

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}

