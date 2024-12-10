package com.canvas.Model;

import java.io.Serializable;
import java.util.ArrayList;

import com.canvas.Custom;

public class Gradeable implements Serializable {
    public static final long NANOSECONDS_IN_A_DAY = 86400000000000l;

    private String type;
    private long deadline;
    private double totalMark;
    private ArrayList<Submission> submissions = new ArrayList<>();

    public ArrayList<Submission> getSubmissions() {
        return submissions;
    }

    public void addNewSubmission(String studentID, double marks, String feedback) {
        submissions.add(new Submission(studentID, marks, feedback));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMarks) {
        this.totalMark = totalMarks;
    }

    public Gradeable(String task, int days, double totalMark, Course currentCourse) {
        this.type = task;
        this.totalMark = totalMark;
        deadline = System.nanoTime() + days * NANOSECONDS_IN_A_DAY;
    }

    @Override
    public String toString() {
        return "Type: " + type + "\nDeadline: " + deadline + "\nTotal Marks: " + totalMark;
    }
    public String toFacultyString() {
        String s = toString() + "\nSubmissions: ";
        for (int i = 0; i < submissions.size(); i++) {
            if (i > 0)
                s += "\n";
            s += submissions.get(i).toFacultyString();
        }
        return s;
    }

}
