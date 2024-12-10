package com.canvas.Model;

import java.io.Serializable;

public class Submission implements Serializable {
    private String studentID;
    private double marks;
    private String feedback;

    public Submission(String studentID, double marks, String feedback) {
        this.studentID = studentID;
        this.marks = marks;
        this.feedback = feedback;
    }

    public double getMarks() {
        return marks;
    }

    public String getStudentID() {
        return studentID;
    }

    public String toFacultyString() {
        return "[StudentID: " + studentID + ", Marks: " + marks + ", Feedback: " + feedback + "]";
    }

    public String toStudentString() {
        return "Marks: " + marks + "\nFeedback: " + feedback;
    }

}
