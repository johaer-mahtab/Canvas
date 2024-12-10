package com.canvas.model;

import java.util.ArrayList;

public class Course {
    private String subject;
    private int section;
    private String room; // make new classes to have methods that avoid double booking?
    private String timing;
    private Faculty faculty;
    private ArrayList<Student> students;
}
