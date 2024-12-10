package com.canvas.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    private String subject;
    private int section;
    private String room; // make new classes to have methods that avoid double booking?
    private String timing;
    private Faculty faculty;
    private ArrayList<Student> enrolledStudents;

    public ArrayList<Student> getStudents() {
        return enrolledStudents;
    }

    public Course(String subject, int section, String room, String timing, Faculty faculty) {
        this.subject = subject;
        this.section = section;
        this.room = room;
        this.timing = timing;
        this.faculty = faculty;
    }
}
