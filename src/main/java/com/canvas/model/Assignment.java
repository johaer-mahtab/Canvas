package com.canvas.Model;

import java.util.ArrayList;

public class Assignment {
    public static final long NANOSECONDS_IN_A_DAY = 86400000000000l;
    private String task;
    private long deadline;
    private ArrayList<Boolean> submitted;
    private double marks;
    private String feedback;

    public Assignment(String task, int days) {
        this.task = task;
        deadline = System.nanoTime() + days * NANOSECONDS_IN_A_DAY;
    }
}
