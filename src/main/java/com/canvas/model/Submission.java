package com.canvas.Model;

public class Submission {
    private String studentID;
    private boolean submitted;
    private double marks;
    private String feedback;

    public Submission(String student) {
        this.studentID = student;
    }

    @Override
    public String toString() {
        return "\nStudentID: " + studentID + "\nSubmitted: " + submitted + "\nMarks: " + marks + "\nFeedback: "
                + feedback;
    }

    
}
