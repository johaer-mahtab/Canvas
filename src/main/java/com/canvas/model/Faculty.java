package com.canvas.Model;

import java.util.ArrayList;

import com.canvas.Custom;
import com.canvas.Exception.NoSuchCourse;
import com.canvas.Model.DB.Current;

public class Faculty extends User {
    private String initial;
    private String officeRoom;
    private String officeHour;
    private String department;
    private ArrayList<String> courseUIDList = new ArrayList<>();

    public ArrayList<String> getCourseUIDList() {
        return courseUIDList;
    }

    public Course getCourse(int index) throws NoSuchCourse {
        return Current.getCourseDB().getCourse(courseUIDList.get(index));
    }

    public void createNewCourse(String subject, int section, int credit, String room, String timing) {
        Course course = new Course(subject, section, credit, room, timing, initial);
        courseUIDList.add(course.getUID());
        Current.getCourseDB().addNewCourse(course);
    }

    public Faculty(String id, String password, String fullName, String initial, String officeRoom, String officeHour,
            String department) {
        super(id, password, fullName);
        this.initial = initial;
        this.officeRoom = officeRoom;
        this.officeHour = officeHour;
        this.department = department;
    }

    @Override
    public void displayInfo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + "\nInitial: " + initial + "\nOffice Room: " + officeRoom + "\nOffice Hours: "
                + officeHour
                + "\nDepartment: " + department + "\nCourses: " + Custom.joinWithComma(courseUIDList);
    }
}
