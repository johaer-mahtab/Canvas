package com.canvas.Model;

import java.util.ArrayList;

public class Student extends User {

    private double cGPA;
    private int creditPassed;
    private int totalCredit;
    private ArrayList<String> courseUIDList;

    public Student(String id, String password, String fullName, double cGPA, int creditPassed, int totalCredit) {
        super(id, password, fullName);
        //change
        this.cGPA = cGPA;
        this.creditPassed = creditPassed;
        this.totalCredit = totalCredit;
    }

    public void enroll(Course course){
        courseUIDList.add(course.getUID());
        course.addStudent(getId());
    }

    @Override
    public void displayInfo() {
    }

}
