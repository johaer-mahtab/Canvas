package com.canvas.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Gradeable implements Serializable {
    public static final long NANOSECONDS_IN_A_DAY = 86400000000000l;

    private String task;
    private long deadline;
    private ArrayList<Submission> submissions;


    public Gradeable(String task, int days, Course currentCourse) {
        this.task = task;
        deadline = System.nanoTime() + days * NANOSECONDS_IN_A_DAY;
        for (Student student : currentCourse.getStudents()) {
            submissions.add(new Submission(student));
        }
    }
}
