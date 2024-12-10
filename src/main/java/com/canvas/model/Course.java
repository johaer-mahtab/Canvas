package com.canvas.Model;

import java.io.Serializable;
import java.util.ArrayList;

import com.canvas.Main;

public class Course implements Serializable {
    private String subject;
    private int section;
    private String room; // make new classes to have methods that avoid double booking?
    private String timing;
    private String facultyInitials;
    private ArrayList<String> enrolledStudentsID;

    public ArrayList<String> getStudentIDs() {
        return enrolledStudentsID;
    }

    public void addStudent(String studentID) {
        enrolledStudentsID.add(studentID);
    }

    public Course(String subject, int section, String room, String timing, String facultyInitials) {
        this.subject = subject;
        this.section = section;
        this.room = room;
        this.timing = timing;
        this.facultyInitials = facultyInitials;
    }

    public String getUID() {
        return subject + '.' + section;
    }

    @Override
    public String toString() {
        return "Subject: " + subject + "\nSection: " + section + "\nRoom: " + room + "\nTiming: " + timing
                + "\nFaculty Initials: " + facultyInitials + "\nEnrolled Students: " + Main.parseIds(enrolledStudentsID);
    }

    
}
