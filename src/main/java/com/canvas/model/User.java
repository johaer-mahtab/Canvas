package com.canvas.Model;

import java.io.Serializable;

public abstract class User implements Serializable {

    private String fullName;

    private String id;

    private String password;

    public User(String id, String password, String fullName) {
        this.id = id;
        this.password = password;
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean matchPassword(String givenPassword) {
        return password.matches(givenPassword);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void displayInfo();

    @Override
    public String toString() {
        return "Full Name: " + fullName + "\nID: " + id;
    }
}
