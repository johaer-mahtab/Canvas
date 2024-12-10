package com.canvas;

import com.canvas.Model.DB.CourseDB;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static void initialize () {
        // CourseDB.loadData();

        
    }

    public static void exit(String message) {
        System.out.println(message);
        System.exit(0);

    }
}
