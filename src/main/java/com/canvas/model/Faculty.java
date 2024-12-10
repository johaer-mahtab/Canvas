package com.canvas.Model;

import java.util.ArrayList;

public class Faculty extends User {
    private String initial;
    private String officeRoom;
    private String officeHour;
    private String department;
    private ArrayList<String> courseUIDList;

    public void createNewCourse(String subject, int section, String room, String timing, String facultyInitials) {
        Course course = new Course(subject, section, room, timing, facultyInitials);
        courseUIDList.add(course.getUID());
    }

    public Faculty(String id, String password, String fullName, String initial, String officeRoom, String department) {
        super(id, password, fullName);
        this.initial = initial;
        this.officeRoom = officeRoom;
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + "\ninitial: " + initial + "\nOffice Room: " + officeRoom + "\nOffice Hours: "
                + officeHour
                + "\nDepartment: " + department + "\nCourses: " + courseUIDList;
    }
}
