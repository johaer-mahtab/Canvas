package com.canvas.Model;

import java.io.Serializable;
import java.util.ArrayList;

import com.canvas.Main;

public class Gradeable implements Serializable {
    public static final long NANOSECONDS_IN_A_DAY = 86400000000000l;

    private String type;
    private long deadline;
    private double totalMarks;
    private ArrayList<Submission> submissions = new ArrayList<>();

    public Gradeable(String task, int days, double totalMark, Course currentCourse) {
        this.type = task;
        this.totalMarks = totalMark;
        deadline = System.nanoTime() + days * NANOSECONDS_IN_A_DAY;
        for (String studentID : currentCourse.getStudentIDs()) {
            submissions.add(new Submission(studentID));
        }
    }

    @Override
    public String toString() {
        String s = "Type: " + type + "\nDeadline: " + deadline + "\nTotal Marks: " + totalMarks + "\nSubmissions: ";
        for (int i = 0; i < submissions.size(); i++) {
            if (i > 0)
                s += "\n";
            s += submissions.get(i).toString();
        }
        return s;
    }

}
