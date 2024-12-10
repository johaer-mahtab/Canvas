package com.canvas.Model;

public class Submission {
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
        return "StudentID: " + studentID + "\nMarks: " + marks + "\nFeedback: "
                + feedback;
    }
    public String toStudentString() {
        return "Marks: " + marks + "\nFeedback: "
                + feedback;
    }

}
