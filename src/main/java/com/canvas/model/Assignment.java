package com.canvas.Model;

public class Assignment {
    public static final long NANOSECONDS_IN_A_DAY = 86400000000000l;
    private String task;
    private long deadline;
    private boolean submitted = false;
    private double marks;
    private String feedback;

    public Assignment(String task, int days) {
        this.task = task;
        deadline = System.nanoTime() + days * NANOSECONDS_IN_A_DAY;
        submitted = false;
    }
}
