package com.canvas.Model;

import java.util.ArrayList;

public class Student extends User {

    private double cGPA;
    private int creditPassed;
    private int totalCredit;
    private ArrayList<Course> courses;

    public Student(String id, String password, String fullName, double cGPA, int creditPassed, int totalCredit) {
        super(id, password, fullName);
        //change
        this.cGPA = cGPA;
        this.creditPassed = creditPassed;
        this.totalCredit = totalCredit;
    }

    @Override
    public void displayInfo() {
    }

}
