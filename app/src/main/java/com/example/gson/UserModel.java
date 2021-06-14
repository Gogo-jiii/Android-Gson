package com.example.gson;

public class UserModel {

    private String name;

    public UserModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
