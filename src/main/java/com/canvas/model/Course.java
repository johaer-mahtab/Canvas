package com.canvas.Model;

import java.io.Serializable;
import java.util.ArrayList;

import com.canvas.Main;
import com.canvas.Model.DB.Current;

public class Course implements Serializable {
    private String subject;
    private int section;
    private int credit;
    private String room; // make new classes to have methods that avoid double booking?
    private String timing;
    private String facultyInitials;
    private ArrayList<String> enrolledStudentsID = new ArrayList<>();
    private ArrayList<Gradeable> grades = new ArrayList<>();

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
                + "\nFaculty Initials: " + facultyInitials + "\nEnrolled Students: " + Main.joinWithComma(enrolledStudentsID);
    }

    public void finishGrading(){
        for (String studentID : enrolledStudentsID) {
            // Current.getUserDB().getStudent(studentID).updateCGPA();
        }
    }
    public void getGP(){
        
    }

    public void displayInfo() {
        System.out.println(toString());
    }

    
}
