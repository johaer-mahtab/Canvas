package com.canvas.Model;

public class Submission {
    private Student student;
    private boolean submitted;
    private double marks;
    private String feedback;

    public Submission(Student student) {
        this.student = student;
    }
}
