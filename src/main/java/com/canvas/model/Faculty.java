package com.canvas.model;

import java.util.ArrayList;

public class Faculty extends User {
    private String initial;
    private String officeRoom;
    private String officeHour;
    private String department;
    private ArrayList<Course> courses;
    public Faculty(String id, String password, String fullName, String initial, String officeRoom, String department) {
        super(id, password, fullName);
        this.initial = initial;
        this.officeRoom = officeRoom;
        this.department = department;
    }
    @Override
    public void displayInfo() {
    }
}

