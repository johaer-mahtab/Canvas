package com.canvas.Model;

import java.util.ArrayList;

public class Faculty extends User {
    private String initial;
    private String officeRoom;
    private String officeHour;
    private String department;
    private ArrayList<Course> courses;

    public void addNewCourse(Course course) {
        courses.add(course);
    }

    public Faculty(String id, String password, String fullName, String initial, String officeRoom, String department) {
        super(id, password, fullName);
        this.initial = initial;
        this.officeRoom = officeRoom;
        this.department = department;
    }

    @Override
    public void displayInfo() {
    }

    @Override
    public String toString() {
        return super.toString() + "\ninitial: " + initial + "\nOffice Room: " + officeRoom + "\nOffice Hours: "
                + officeHour
                + "\nDepartment: " + department + "\nCourses:" + courses;
    }
}
