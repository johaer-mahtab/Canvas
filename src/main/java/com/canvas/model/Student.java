package com.canvas.Model;

import java.util.ArrayList;

import com.canvas.Main;

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

    @Override
    public String toString() {
        return super.toString() + "\nCGPA: " + cGPA + "\nCredit Passed: " + creditPassed + "\nTotal Credit: " + totalCredit
                + "\nCourses: " + Main.joinWithComma(courseUIDList);
    }

}
