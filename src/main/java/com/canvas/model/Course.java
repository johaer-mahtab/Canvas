package com.canvas.Model;

import java.io.Serializable;
import java.util.ArrayList;

import com.canvas.Custom;
import com.canvas.Exception.NoSuchStudent;
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

    public ArrayList<Gradeable> getGrades() {
        return grades;
    }

    public ArrayList<String> getStudentIDs() {
        return enrolledStudentsID;
    }

    public void addStudent(String studentID) {
        enrolledStudentsID.add(studentID);
    }

    public Course(String subject, int section, int credit, String room, String timing, String facultyInitials) {
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
                + "\nFaculty Initials: " + facultyInitials + "\nEnrolled Students: "
                + Custom.joinWithComma(enrolledStudentsID);
    }

    public void finishGrading() {
        for (String studentID : enrolledStudentsID) {
            try {
                Current.getUserDB().getStudent(studentID).updateCGPA(getGP(studentID), credit);
            } catch (NoSuchStudent e) {
                System.out.println("Couldn't find student " + studentID);
            }
        }
    }

    public double getTotalMarks() {
        double x = 0;
        for (Gradeable grade : grades)
            x += grade.getTotalMark();
        return x;
    }

    public boolean isEnrolled(String studentID) {
        for (String string : enrolledStudentsID)
            if (string.matches(studentID))
                return true;
        return false;
    }

    public double getMarksOf(String studentID) {
        double x = 0;
        for (Gradeable grade : grades)
            for (Submission s : grade.getSubmissions())
                if (s.getStudentID().equals(studentID))
                    x += s.getMarks();
        return x;
    }

    public double getGP(String studentID) {
        double total = getTotalMarks();
        for (String string : enrolledStudentsID) {
            if (string.equals(studentID))
                return 4 * credit * getMarksOf(string) / total;
        }
        return 0;
    }

    public void displayInfo() {
        System.out.println(toString());
    }

}
